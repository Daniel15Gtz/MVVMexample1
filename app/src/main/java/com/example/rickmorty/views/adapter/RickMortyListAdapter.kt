package com.example.rickmorty.views.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rickmorty.R
import com.example.rickmorty.utils.dto.RickMortyModel
import kotlinx.android.synthetic.main.item_rickmorty_list.view.*

class RickMortyListAdapter(val character : List<RickMortyModel>, val listener : OnItemClickListener) : RecyclerView.Adapter<RickMortyListAdapter.ViewHolder>(){
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RickMortyListAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_rickmorty_list,parent,false))
    }

    override fun onBindViewHolder(holder: RickMortyListAdapter.ViewHolder, position: Int) {
        holder.setViewItem(position, character[position], listener)
    }

    override fun getItemCount(): Int {
        return character.size
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view){

        fun setViewItem(position: Int, rickmortyModel: RickMortyModel, listener: OnItemClickListener) {
            view.tv_item_rickmorty_list_number.text = "$position.-"
            view.tv_item_rickmorty_list_name.text = rickmortyModel.name
            view.cv_item_rickmorty_list_container.setOnClickListener{
                listener.onItemClick(position)
            }
        }
    }
}