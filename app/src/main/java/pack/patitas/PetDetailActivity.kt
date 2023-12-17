package pack.patitas

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
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
        val petSter = intent.getStringExtra("petSter")
        val petVac = intent.getStringExtra("petVac")
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

        val toolbar: Toolbar = findViewById(R.id.toolbar2)
        setSupportActionBar(toolbar)

        supportActionBar?.title = petName

        imageView.load(petImage) {
            placeholder(R.mipmap.placeholder_image_foreground)
        }
        val button: Button = findViewById(R.id.link_2)
        button.setOnClickListener(){
            openUrl(petUrl)
        }
        val adoptButton: Button = findViewById(R.id.adopme)
        adoptButton.setOnClickListener {
            val intent = Intent(this, FormularioActivity::class.java)
            startActivity(intent)
        }

    }

    private fun openUrl(link: String?) {
        val uri = Uri.parse(link)
        val inten = Intent(Intent.ACTION_VIEW, uri)
        startActivity(inten)
    }
}