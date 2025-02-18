package guzman.jesus.popcornfactory_233350

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PeliculaAdapter(
    private val peliculas: List<Pelicula>, // Lista de películas
    private val onItemClick: (Pelicula) -> Unit // Acción al hacer clic en un ítem
) : RecyclerView.Adapter<PeliculaAdapter.PeliculaViewHolder>() {

    // ViewHolder que representa cada ítem de la lista
    inner class PeliculaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imagen: ImageView = itemView.findViewById(R.id.iv_pelicula) // Imagen de la película
        val nombre: TextView = itemView.findViewById(R.id.tv_nombre) // Nombre de la película

        init {
            // Configurar el listener para manejar el clic en el ítem
            itemView.setOnClickListener {
                onItemClick(peliculas[adapterPosition]) // Llamar a la acción con la película correspondiente
            }
        }
    }

    // Inflar el layout de cada ítem
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeliculaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_pelicula, parent, false)
        return PeliculaViewHolder(view)
    }

    // Vincular los datos de la película con el ViewHolder
    override fun onBindViewHolder(holder: PeliculaViewHolder, position: Int) {
        val pelicula = peliculas[position]
        holder.imagen.setImageResource(pelicula.image) // Establecer la imagen
        holder.nombre.text = pelicula.titulo // Establecer el nombre
    }

    // Retornar el número de elementos en la lista
    override fun getItemCount(): Int {
        return peliculas.size
    }
}
