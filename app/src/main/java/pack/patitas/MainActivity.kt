package pack.patitas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import pl.droidsonroids.gif.GifImageView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gifImageView=findViewById<GifImageView>(R.id.gifImageView)
        gifImageView.setImageResource(R.drawable.gifadopta)
        val Adopta = findViewById<Button>(R.id.bttnMain)
        Adopta.setOnClickListener {
            val intent = Intent(this, ListPets::class.java)
            startActivity(intent)
            finish()
        }
    }
}