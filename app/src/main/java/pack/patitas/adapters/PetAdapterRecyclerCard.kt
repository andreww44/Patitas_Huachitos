package pack.patitas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import pack.patitas.R
import pack.patitas.identies.Pet


class PetAdapterRecyclerCard (private val pets: MutableList<Pet>): RecyclerView.Adapter<PetAdapterRecyclerCard.PetViewHolder>(){

    inner class PetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val nameTextView: TextView = itemView.findViewById(R.id.name)
        val ageTextView: TextView = itemView.findViewById(R.id.age)
        val regionTextView: TextView = itemView.findViewById(R.id.region)
        val typeTextView: TextView = itemView.findViewById(R.id.type)
        val imageImageview: ImageView = itemView.findViewById(R.id.imageView)
        // You can also define click listeners here
        init {
            itemView.setOnClickListener {
                // Handle item click
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val selectedPatient = pets[position]
                    // Perform the desired action with the selected patient
                    Toast.makeText(itemView.context, selectedPatient.name, Toast.LENGTH_LONG).show()
                }
            }

            itemView.setOnLongClickListener {
                // Handle item long press
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val selectedPatient = pets[position]
                    // Perform the desired action with the selected patient
                    //
                }
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_element, parent, false)
        return PetViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        val currentPet = pets[position]
        holder.nameTextView.text = "Nombre: ${currentPet.name}"
        holder.ageTextView.text = "Edad: ${currentPet.age}"
        holder.regionTextView.text = "Region: ${currentPet.region}"
        holder.typeTextView.text = "Tipo: ${currentPet.types}"
        // Cargar imagen desde la URL usando Glide

    }

    override fun getItemCount(): Int {
        return pets.size
    }

    fun clearAndAddNewList(newList: List<Pet>) {
        pets.clear()
        pets.addAll(newList)
        notifyDataSetChanged()
    }



}