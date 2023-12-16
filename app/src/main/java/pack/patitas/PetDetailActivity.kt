package pack.patitas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import coil.load


class PetDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pet_detail)

        val petName = intent.getStringExtra("petName")
        val petType = intent.getStringExtra("petType")
        val petAge = intent.getStringExtra("petAge")
        val petState = intent.getStringExtra("petState")
        val petDesf = intent.getStringExtra("petDesF")
        val petDesp = intent.getStringExtra("petDesP")
        val petDesa = intent.getStringExtra("petDesA")
        var petSter = intent.getStringExtra("petRegion")
        if (petSter == "1"){
            petSter = "SI"
        }
        else{
            petSter = "NO"
        }
        var petVac = intent.getStringExtra("petSter")
        if (petVac == "1"){
            petVac = "SI"
        }
        else{
            petVac = "NO"
        }
        val petImage = intent.getStringExtra("petImage")
        val petTeam = intent.getStringExtra("petTeam")
        val petRegion = intent.getStringExtra("petRegion")
        val petCommune = intent.getStringExtra("petCommune")
        val petUrl = intent.getStringExtra("petUrl")


        val nametext = findViewById<TextView>(R.id.name_detail)
        val tipotext = findViewById<TextView>(R.id.type_detail)
        val agetext = findViewById<TextView>(R.id.age_detail)
        val estadonametext = findViewById<TextView>(R.id.state_detail)
        val stertext = findViewById<TextView>(R.id.ster_detail)
        val vactext = findViewById<TextView>(R.id.vac_detail)
        val teamtext = findViewById<TextView>(R.id.team_detail)
        val regtext = findViewById<TextView>(R.id.region_detail)
        val cometext = findViewById<TextView>(R.id.commune_detail)
        val ftext = findViewById<TextView>(R.id.desf_detail2)
        val ptext = findViewById<TextView>(R.id.desp_detail)
        val atext = findViewById<TextView>(R.id.desa_detail)
        val imageView :ImageView = findViewById(R.id.image_detail)

        nametext.text = petName
        tipotext.text = petType
        agetext.text = petAge
        estadonametext.text = petState
        stertext.text = petSter
        vactext.text = petVac
        teamtext.text = petTeam
        regtext.text = petRegion
        cometext.text = petCommune
        ftext.text = petDesf
        ptext.text = petDesp
        atext.text = petDesa

        // Cargar la imagen usando Coil
        imageView.load(petImage) {
            placeholder(R.mipmap.placeholder_image_foreground) // Drawable de marcador de posición
            //error(R.drawable.error) // Drawable a mostrar en caso de error
        }

    }
}