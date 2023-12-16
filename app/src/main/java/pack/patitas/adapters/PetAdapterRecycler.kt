package pack.patitas.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class PetAdapterRecycler {


    /*inner class PatientViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewName)
        val emailTextView: TextView = itemView.findViewById(R.id.textViewEmail)
        val roomTextView: TextView = itemView.findViewById(R.id.textViewRoom)
        val ageTextView: TextView = itemView.findViewById(R.id.textViewAge)
        // You can also define click listeners here
        init {
            itemView.setOnClickListener {
                // Handle item click
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val selectedPatient = patients[position]
                    // Perform the desired action with the selected patient
                    Toast.makeText(itemView.context,selectedPatient.name, Toast.LENGTH_LONG).show()
                }
            }

            itemView.setOnLongClickListener {
                // Handle item long press
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val selectedPatient = patients[position]
                    // Perform the desired action with the selected patient
                    //
                }
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PatientViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item_patient, parent, false)
        return PatientViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PatientViewHolder, position: Int) {
        val currentPatient = patients[position]
        holder.nameTextView.text = "Name: ${currentPatient.name}"
        holder.emailTextView.text = "Email: ${currentPatient.email}"
        holder.roomTextView.text = "Room: ${currentPatient.room}"
        holder.ageTextView.text = "Age: ${currentPatient.age}"
    }

    override fun getItemCount(): Int {
        return patients.size
    }*/
}