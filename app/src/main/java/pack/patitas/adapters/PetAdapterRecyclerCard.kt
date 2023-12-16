package pack.patitas.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import coil.load
import pack.patitas.PetDetailActivity
import pack.patitas.R
import pack.patitas.identies.Pet


class PetAdapterRecyclerCard (private val pets: MutableList<Pet>): RecyclerView.Adapter<PetAdapterRecyclerCard.PetViewHolder>(){



    inner class PetViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val nameTextView: TextView = itemView.findViewById(R.id.name)
        val ageTextView: TextView = itemView.findViewById(R.id.age)
        val regionTextView: TextView = itemView.findViewById(R.id.region)
        val communeTextView: TextView = itemView.findViewById(R.id.comuna)
        val typeTextView: TextView = itemView.findViewById(R.id.type)
        val imageImageview: ImageView = itemView.findViewById(R.id.imageView)
        // You can also define click listeners here
        init {
            itemView.setOnClickListener {
                // Handle item click
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val selectedPet = pets[position]
                    // Perform the desired action with the selected patient
                    val intent = Intent(itemView.context, PetDetailActivity::class.java).apply {

                        putExtra("petName", selectedPet.name)
                        putExtra("petType", selectedPet.types)
                        putExtra("petAge", selectedPet.age)
                        putExtra("petState", selectedPet.state)
                        putExtra("petGender", selectedPet.gender)
                        putExtra("petDesF", selectedPet.desF)
                        putExtra("petDesP", selectedPet.desP)
                        putExtra("petDesA", selectedPet.desA)
                        putExtra("petImage", selectedPet.urlImage)
                        putExtra("petTeam", selectedPet.team)
                        putExtra("petRegion", selectedPet.region)
                        putExtra("petCommune", selectedPet.commune)
                        putExtra("petUrl", selectedPet.url)

                        if(selectedPet.vaccines == 1){
                            putExtra("petVac", "SI")
                        }else{
                            putExtra("petVac", "NO")
                        }
                        if(selectedPet.sterilized == 1){
                            putExtra("petSter", "SI")
                        }else{
                            putExtra("petSter", "NO")
                        }


                    }


                    itemView.context.startActivity(intent)
                    Toast.makeText(itemView.context, selectedPet.name, Toast.LENGTH_LONG).show()
                }
            }

            itemView.setOnLongClickListener {
                // Handle item long press
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val selectedPet = pets[position]

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
        holder.nameTextView.text = "${currentPet.name}"
        holder.ageTextView.text = "${currentPet.age}"
        holder.regionTextView.text = "${currentPet.region}"
        holder.communeTextView.text = "${currentPet.commune}"
        holder.typeTextView.text = "${currentPet.types}"
        holder.imageImageview.load(currentPet.urlImage){
            placeholder(R.mipmap.placeholder_image_foreground)

        }

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