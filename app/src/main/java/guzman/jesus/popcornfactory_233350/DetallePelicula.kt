package guzman.jesus.popcornfactory_233350

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class DetallePelicula : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detalle_pelicula)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val bundle = intent.extras
        var ns = 0
        var id = -1

        if (bundle != null) {
            ns = bundle.getInt("numberSeats")
            id = bundle.getInt("pos")

            findViewById<ImageView>(R.id.iv_pelicula_imagen).setImageResource(bundle.getInt("header"))
            findViewById<TextView>(R.id.tv_nombre_pelicula).text = bundle.getString("nombre")
            findViewById<TextView>(R.id.tv_pelicula_desc).text = bundle.getString("sinopsis")
            findViewById<TextView>(R.id.seats_left).text = "${ns} seats available"
        }

        if(ns == 0) {
            findViewById<Button>(R.id.btn_tickets).isEnabled = false
        }else {
            findViewById<Button>(R.id.btn_tickets).isEnabled = true
            findViewById<Button>(R.id.btn_tickets).setOnClickListener {
                val intent = Intent(this, SeatSelection::class.java)

                intent.putExtra("movie", id)
                intent.putExtra("name", findViewById<TextView>(R.id.tv_nombre_pelicula).text)

                this.startActivity(intent)
            }
        }
    }
}