package pack.patitas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONException
import org.json.JSONObject
import pack.patitas.APIRequest.APICallback
import pack.patitas.APIRequest.ApiTask
import pack.patitas.adapters.PetAdapterRecyclerCard
import pack.patitas.identies.Pet
import java.io.IOException

class ListPets : AppCompatActivity(), APICallback {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : PetAdapterRecyclerCard
    private lateinit var listaDeMascotas : MutableList<Pet>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_pets)

        val apiUrl = "https://huachitos.cl/api/animales"

        listaDeMascotas = mutableListOf(

        )


        //Adaptor de lista de mascotas
        //val listaDeMascotas = obtenerListaDeMascotas()
        recyclerView = findViewById(R.id.listRecycler)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        adapter = PetAdapterRecyclerCard(listaDeMascotas)
        recyclerView.adapter = adapter

        try {
            val apiRequestTask = ApiTask(this)
            apiRequestTask.execute(apiUrl)

        } catch (e: IOException) {
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show()

        }
    }

    override fun onSuccess(data: String) {
        listaDeMascotas = processingData(data)
        Log.i("APIRestActivity",listaDeMascotas.toString())
        adapter.clearAndAddNewList(listaDeMascotas)
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
                val name = itemObject.getString("nombre")
                val region= itemObject.getString("comuna")
                val age = itemObject.getString("edad")
                val types = itemObject.getString("tipo")
                val state = itemObject.getString("estado")
                val gender = itemObject.getString("genero")
                val description = itemObject.getString("desc_fisica")
                val urlImage = itemObject.getString("url")

                val newpet = Pet(name, region, age, types, state, gender, description, urlImage)
                list.add(newpet)
            }



        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return list
    }
}