package pack.patitas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import coil.load

class FormularioActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_formulario)

        val petName = intent.getStringExtra("petName")
        val petImage = intent.getStringExtra("petImage")

        val imageView : ImageView = findViewById(R.id.image_detail_2)

        val toolbar: Toolbar = findViewById(R.id.toolbar3)
        setSupportActionBar(toolbar)

        supportActionBar?.title = petName

        imageView.load(petImage) {
            placeholder(R.mipmap.placeholder_image_foreground)
        }
        val adoptButton: Button = findViewById(R.id.adopme_2)
        adoptButton.setOnClickListener {
            /*val intent = Intent(this, FormularioActivity::class.java).apply {
                putExtra("petName", petName)
                putExtra("petImage", petImage)
            }
            startActivity(intent)*/
            mostrarDialogoAceptar()
        }
    }

    private fun mostrarDialogoAceptar() {
        // Crear un constructor de AlertDialog
        val builder = AlertDialog.Builder(this)

        // Configurar el mensaje y el botón de aceptar
        builder.setMessage(R.string.formularioIn)
            .setPositiveButton(R.string.aceptIn) { dialog, _ ->
                dialog.dismiss()
            }

        // Crear y mostrar el cuadro de diálogo
        val dialog = builder.create()
        dialog.show()
    }
}