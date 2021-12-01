package com.thaariq.MusicPlayerApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.thaariq.MusicPlayerApp.ListMusicAdapter.ListViewHolder
import com.thaariq.MusicPlayerApp.data.Music
import com.thaariq.musicplayerapp.R
import com.thaariq.musicplayerapp.databinding.ListItemBinding

class ListMusicAdapter(private val listmusic : ArrayList<Music>) :
    RecyclerView.Adapter<ListViewHolder>() {

    inner  class ListViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root)



    override fun onCreateViewHolder(parent: ViewGroup, i: Int) = ListViewHolder(
        ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )


    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.binding.apply {
            with(listmusic[position]){
                tvItemName.text = name
                tvItemDetail.text = album

                Glide.with(imgItemPhoto.context).load(cover).into(imgItemPhoto)
                holder.itemView.setOnClickListener{
                    // ISI INTENT
                }
            }
        }
    }

    override fun getItemCount(): Int = listmusic.size
}