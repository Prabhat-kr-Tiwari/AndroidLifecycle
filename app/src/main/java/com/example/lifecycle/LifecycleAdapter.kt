package com.example.lifecycle

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

/*class LifecycleAdapter {
}*/
class LifecycleAdapter(private val eventsList: List<LifecycleEvent>) :
    RecyclerView.Adapter<LifecycleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_lifecycle_event, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val event = eventsList[position]
        holder.bind(event)
    }

    override fun getItemCount(): Int {
        return eventsList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val eventNameTextView: TextView = itemView.findViewById(R.id.textEventName)
        private val eventDescriptionTextView: TextView = itemView.findViewById(R.id.textEventDescription)

        private val cardView:CardView=itemView.findViewById(R.id.card_view)
        fun bind(event: LifecycleEvent) {
            eventNameTextView.text = event.eventName
            eventDescriptionTextView.text = event.eventDescription

            // Generate a random color
            val randomColor = getRandomColor()
            cardView.setCardBackgroundColor(randomColor)
        }
        private fun getRandomColor(): Int {
            val random = Random
            val hue = random.nextFloat() * 360
            val saturation = 0.5f // You can adjust this value as desired
            val value = 0.9f // You can adjust this value as desired
            return Color.HSVToColor(floatArrayOf(hue, saturation, value))
        }
    }
}

