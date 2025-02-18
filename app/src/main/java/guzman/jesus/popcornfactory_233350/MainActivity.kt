package guzman.jesus.popcornfactory_233350

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import guzman.jesus.popcornfactory_233350.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val peliculas = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // Usar View Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar películas
        cargarPeliculas()

        // Configurar RecyclerView
        binding.recyclerPeliculas.layoutManager = LinearLayoutManager(this)
        binding.recyclerPeliculas.adapter = PeliculaAdapter(peliculas) { pelicula ->
            abrirDetallePelicula(pelicula)
        }
    }

    private fun cargarPeliculas() {
        peliculas.add(Pelicula("Bones",R.drawable.bones,R.drawable.bonesheader,"Dr. Temperance BrenMan is a brilliant , but lonely"))
        peliculas.add(Pelicula("Dr house ", R.drawable.drhouse,R.drawable.drwhoheader,"The series follws the life of anti-Social"))
        peliculas.add(Pelicula("Big Hero 6", R.drawable.bighero6,R.drawable.headerbighero6,"When a devastating event befalls the city"))
        peliculas.add(Pelicula("Dr. Who", R.drawable.drwho ,R.drawable.drwhoheader,"Traveling across time and space , the immortal time"))
        peliculas.add(Pelicula("Friends",R.drawable.friends,R.drawable.friendsheader,"Rachel Green , Ross Geller , Monica Geller "))
        peliculas.add(Pelicula("Inception ",R.drawable.inception,R.drawable.inceptionheader,"Dom cobb is a skilled thief"))
        peliculas.add(Pelicula("Leap Year ", R.drawable.leapyear,R.drawable.leapyearheader,"A woman who has an elaborate scheme to pr"))
        peliculas.add(Pelicula("Toy Story ", R.drawable.toystory,R.drawable.toystoryheader,"Toy story is about the secret life of toys"))
        peliculas.add(Pelicula("SmallVielle ", R.drawable.smallville,R.drawable.smallvilleheader,"The numerous miraculous "))}

    private fun abrirDetallePelicula(pelicula: Pelicula) {
        val intent = Intent(this, DetallePelicula::class.java)
        intent.putExtra("nombre", pelicula.titulo)
        intent.putExtra("header", pelicula.header)
        intent.putExtra("sinopsis", pelicula.sinopsis)
        startActivity(intent)
    }
}
