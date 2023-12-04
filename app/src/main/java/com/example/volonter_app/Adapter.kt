package com.example.volonter_app

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.volonter_app.databinding.EventRecyclerItemBinding

class Adapter(private val clickListener: ClickListener): ListAdapter<Event, Adapter.ViewHolder>(DiffCallback()) {
    class ViewHolder(val binding: EventRecyclerItemBinding): RecyclerView.ViewHolder(binding.root){
        fun bindTo(item: Event, clickListener: ClickListener){
            with(binding){
                imageView9.setImageResource(item.imageId)
                textView11.text = item.name
                textView13.text = item.time
                textView14.text = item.cost.toString()
                root.setOnClickListener { clickListener.goToEventDescription(item) }
            }
        }
    }

    class DiffCallback: DiffUtil.ItemCallback<Event>(){
        override fun areItemsTheSame(oldItem: Event, newItem: Event): Boolean = oldItem == newItem

        override fun areContentsTheSame(oldItem: Event, newItem: Event): Boolean = oldItem.name == newItem.name

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
        EventRecyclerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindTo(
            getItem(position), clickListener
        )
    }
}