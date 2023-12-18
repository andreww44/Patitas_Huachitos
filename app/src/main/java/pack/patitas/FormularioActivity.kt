package pack.patitas

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
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

        if (isConnectedToInternet()) {
            builder.setMessage(R.string.formularioIn)
                .setPositiveButton(R.string.aceptIn) { dialog, _ ->
                    dialog.dismiss()
                }
            val dialog = builder.create()
            dialog.show()
        } else {
            builder.setMessage(R.string.noIn)
                .setPositiveButton(R.string.aceptIn) { dialog, _ ->
                    dialog.dismiss()
                }
            val dialog = builder.create()
            dialog.show()
        }

    }

    private fun isConnectedToInternet(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork
            val capabilities =
                connectivityManager.getNetworkCapabilities(network)

            return capabilities?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                ?: false
        } else {
            // Versiones anteriores a Android 6.0
            val networkInfo = connectivityManager.activeNetworkInfo
            return networkInfo?.isConnected ?: false
        }
    }
}