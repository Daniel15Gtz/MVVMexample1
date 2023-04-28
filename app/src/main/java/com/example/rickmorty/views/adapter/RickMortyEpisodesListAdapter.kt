package com.example.rickmorty.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickmorty.R
import com.example.rickmorty.utils.dto.RickMortyModel
import kotlinx.android.synthetic.main.item_rickmorty_list.view.*

class RickMortyEpisodesListAdapter (val episodes : List<RickMortyModel>) : RecyclerView.Adapter<RickMortyEpisodesListAdapter.ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RickMortyEpisodesListAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rickmorty_list,parent,false))
    }

    override fun onBindViewHolder(holder: RickMortyEpisodesListAdapter.ViewHolder, position: Int) {
        holder.setViewItem(position, episodes[position])
    }

    override fun getItemCount(): Int {
        return episodes.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){

        fun setViewItem(position: Int, rickmortyModel: RickMortyModel) {
            view.tv_item_rickmorty_list_number.text = "$position.-"
            view.tv_item_rickmorty_list_name.text = rickmortyModel.name
        }
    }
}