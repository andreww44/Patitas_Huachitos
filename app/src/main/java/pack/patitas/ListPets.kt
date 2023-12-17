package pack.patitas

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONException
import org.json.JSONObject
import pack.patitas.APIRequest.APICallback
import pack.patitas.APIRequest.ApiTask
import pack.patitas.adapters.PetAdapterRecyclerCard
import pack.patitas.adapters.RecyplerPetInterface
import pack.patitas.database.AppDatabase
import pack.patitas.identies.Pet
import pack.patitas.identies.toEntity
import pack.patitas.identies.toPet
import java.io.IOException

class ListPets : AppCompatActivity(), APICallback, RecyplerPetInterface {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : PetAdapterRecyclerCard
    private lateinit var listaDeMascotas : MutableList<Pet>
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pets)

        listaDeMascotas = mutableListOf(
        )

        recyclerView = findViewById(R.id.listRecycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = PetAdapterRecyclerCard(listaDeMascotas)
        recyclerView.adapter = adapter

        listaDeMascotas
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "mascotasDB"
        ).build()
        fetchPetsFromAPI()
    }
    private fun fetchPetsFromAPI() {
        val apiUrl = "https://huachitos.cl/api/animales"
        try {
            val apiRequestTask = ApiTask(this)
            apiRequestTask.execute(apiUrl)
        } catch (e: IOException) {

            loadPetsFromDatabase()
        }
    }
    private fun loadPetsFromDatabase() {
        CoroutineScope(Dispatchers.IO).launch {
            val petsFromDb = db.mascotaDao().getAllPets().map { it.toPet() }
            if (petsFromDb.isNotEmpty()) {
                updateRecyclerView(petsFromDb)
            } else {
                CoroutineScope(Dispatchers.Main).launch {
                    Toast.makeText(this@ListPets, "No hay datos locales para mostrar", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    override fun onSuccess(data: String) {
        listaDeMascotas = processingData(data)
        Log.i("APIRestActivity", listaDeMascotas.toString())
        insertPetsInDatabase(listaDeMascotas)
    }
    private fun insertPetsInDatabase(petsList: List<Pet>) {
        CoroutineScope(Dispatchers.IO).launch {
            petsList.forEach { pet ->
                val existingPet = db.mascotaDao().findMascotaByIdAndName(pet.id, pet.name ?: "")
                if (existingPet == null) {
                    val newEntity = pet.toEntity()
                    db.mascotaDao().insertAll(newEntity)
                } else {
                    // La mascota con el mismo ID y nombre ya existe en la base de datos
                    // Aquí puedes decidir si actualizarla o dejarla como está
                }
            }
            val petsFromDb = db.mascotaDao().getAllPets().map { it.toPet() }
            updateRecyclerView(petsFromDb)
        }
    }
    private fun updateRecyclerView(petsList: List<Pet>) {
        CoroutineScope(Dispatchers.Main).launch {
            adapter.clearAndAddNewList(petsList)
        }
    }
    private fun processingData(result: String) : MutableList<Pet> {
        var list : MutableList<Pet> = mutableListOf()
        try {
            // Parse the JSON string into a JSONObject
            val jsonObject = JSONObject(result)

            val dataObject = jsonObject.getJSONArray("data")


            // Access the "data" array
            val dataArray = jsonObject.getJSONArray("data")

            // Iterate through the array and access individual objects
            for (i in 0 until dataArray.length()) {

                val itemObject = dataObject.getJSONObject(i)
                val id = itemObject.getInt("id")
                val name = itemObject.getString("nombre")
                val types = itemObject.getString("tipo")
                val age = itemObject.getString("edad")
                val state = itemObject.getString("estado")
                val gender = itemObject.getString("genero")
                val des1 = itemObject.getString("desc_fisica")
                val des2 = itemObject.getString("desc_personalidad")
                val des3 = itemObject.getString("desc_adicional")
                val sterilized = itemObject.getInt("esterilizado")
                val vaccine = itemObject.getInt("vacunas")
                val urlImage = itemObject.getString("imagen")
                val team = itemObject.getString("equipo")
                val region = itemObject.getString("region")
                val commune = itemObject.getString("comuna")
                val url = itemObject.getString("url")

                val newpet = Pet(id, name, types, age, state, gender, des1, des2, des3,
                                 sterilized, vaccine, urlImage, team, region, commune, url)
                list.add(newpet)
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
    override fun onItemClick(position: Int) {

    }
}