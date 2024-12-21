package com.example.saloncomunal

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MisReservasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_misreservas) //
        // Configurar el RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.rv_reservaciones)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Simulación de datos de reservaciones
        val reservaciones: ArrayList<Reservacion> = ArrayList<Reservacion>()
        reservaciones.add(Reservacion("2024-12-20", "18:00 - 22:00", "Confirmado"))
        reservaciones.add(Reservacion("2024-12-21", "14:00 - 18:00", "Pendiente"))
        reservaciones.add(Reservacion("2024-12-22", "10:00 - 14:00", "Cancelado"))

        // Configurar el adaptador con los datos
        val adapter: ReservacionAdapter = ReservacionAdapter(reservaciones)
        recyclerView.adapter = adapter
    }
}
