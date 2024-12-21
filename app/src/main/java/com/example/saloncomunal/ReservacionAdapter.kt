package com.example.saloncomunal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class ReservacionAdapter(reservaciones: ArrayList<Reservacion>) :
    RecyclerView.Adapter<ReservacionAdapter.ReservacionViewHolder>() {
    // Lista de reservaciones
    private val reservaciones: ArrayList<Reservacion> = reservaciones

    // Crear las vistas para cada ítem (inflar `item_reservacion.xml`)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservacionViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_reservacion, parent, false)
        return ReservacionViewHolder(view)
    }

    // Vincular los datos con las vistas
    override fun onBindViewHolder(holder: ReservacionViewHolder, position: Int) {
        val reservacion: Reservacion = reservaciones[position]

        // Mostrar la información de la reservación
        holder.tvFecha.text = "Fecha: " + reservacion.fecha
        holder.tvHora.text = "Hora: " + reservacion.hora
        holder.tvEstado.text = "Estado: " + reservacion.estado

        // Configurar el botón de cancelar (simulación)
        holder.btnCancelar.setOnClickListener { v: View? ->
            reservaciones.removeAt(position) // Elimina la reservación de la lista
            notifyItemRemoved(position) // Notifica al adaptador
        }
    }

    // Número de ítems en la lista
    override fun getItemCount(): Int {
        return reservaciones.size
    }

    // Clase interna para las vistas de cada ítem
    class ReservacionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvFecha: TextView = itemView.findViewById<TextView>(R.id.tv_fecha)
        var tvHora: TextView = itemView.findViewById<TextView>(R.id.tv_hora)
        var tvEstado: TextView = itemView.findViewById<TextView>(R.id.tv_estado)
        var btnCancelar: Button = itemView.findViewById<Button>(R.id.btn_cancelar)
    }
}