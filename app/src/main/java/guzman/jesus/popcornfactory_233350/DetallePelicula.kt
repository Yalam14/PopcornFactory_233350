package guzman.jesus.popcornfactory_233350

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import guzman.jesus.popcornfactory_233350.databinding.ActivityDetallePeliculaBinding

class DetallePelicula : AppCompatActivity() {

    private lateinit var binding: ActivityDetallePeliculaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Inflar el layout con View Binding
        binding = ActivityDetallePeliculaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtener datos del intent
        val bundle = intent.extras
        if (bundle != null) {
            binding.ivPeliculaImagen.setImageResource(bundle.getInt("header", 0))
            binding.tvNombrePelicula.text = bundle.getString("nombre", "Sin título")
            binding.tvPeliculaDesc.text = bundle.getString("sinopsis", "Sin descripción")
        }

        // Ajustar insets para gestos de navegación
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
