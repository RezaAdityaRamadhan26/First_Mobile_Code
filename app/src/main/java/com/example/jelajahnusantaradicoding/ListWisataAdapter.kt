package com.example.jelajahnusantaradicoding

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.jelajahnusantaradicoding.databinding.ItemRowWisataBinding

class ListWisataAdapter(private val listWisata: ArrayList<Wisata>) : RecyclerView.Adapter<ListWisataAdapter.ListViewHolder>() {

    class ListViewHolder(var binding: ItemRowWisataBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowWisataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listWisata.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val wisata = listWisata[position]
        holder.binding.imgItemPhoto.setImageResource(wisata.foto)
        holder.binding.tvItemName.text = wisata.nama
        holder.binding.tvItemDescription.text = wisata.deskripsiSingkat

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra(DetailActivity.EXTRA_WISATA, wisata)
            holder.itemView.context.startActivity(intentDetail)
        }
    }
}