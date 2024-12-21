package com.example.saloncomunal

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class CatalogoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_catalogo)

        val gridView: GridView = findViewById(R.id.gridViewCatalogo)

        // Iconos de servicios
        val icons = arrayOf(
            android.R.drawable.ic_menu_add,        // Alquiler de salón
            android.R.drawable.ic_menu_help,       // Asistencia
            android.R.drawable.ic_menu_manage,     // Catering
            android.R.drawable.ic_menu_slideshow  // Entretenimiento
        )

        // Nombres para los iconos
        val serviceNames = arrayOf(
            "Alquiler de Salón",
            "Asistencia",
            "Catering",
            "Entretenimiento"
        )

        // Adaptador para el GridView
        val adapter = CatalogoAdapter(this, icons, serviceNames)
        gridView.adapter = adapter
    }
}

class CatalogoAdapter(private val context: Context, private val icons: Array<Int>, private val serviceNames: Array<String>) : BaseAdapter() {

    override fun getCount(): Int {
        return icons.size
    }

    override fun getItem(position: Int): Any {
        return icons[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            val inflater = LayoutInflater.from(context)
            view = inflater.inflate(R.layout.activity_catalogo, parent, false)
        }

        val imageView = view?.findViewById<ImageView>(R.id.serviceIcon)
        val textView = view?.findViewById<TextView>(R.id.serviceName)

        imageView?.setImageResource(icons[position])
        textView?.text = serviceNames[position]

        return view!!
    }
}