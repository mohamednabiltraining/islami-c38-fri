package com.route.IslamiC38Fri.ui.home.fragments.hadeth

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.IslamiC38Fri.databinding.ItemHadethBinding
import com.route.IslamiC38Fri.ui.model.Hadeth

class HadethAdapter(var items: List<Hadeth>?) : RecyclerView.Adapter<HadethAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemHadethBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemBinding.title.text = items!![position].title
//        onItemClickListener?.let {
//
//        }
        if (onItemClickListener != null) {
            holder.itemView.setOnClickListener {
                onItemClickListener?.onItemClick(position, items!![position])
            }
        }
    }

    override fun getItemCount(): Int = items?.size ?: 0

    fun bindItems(newItems: List<Hadeth>) {
        items = newItems
        notifyDataSetChanged()
    }

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, item: Hadeth)
    }

    class ViewHolder(val itemBinding: ItemHadethBinding) :
        RecyclerView.ViewHolder(itemBinding.root);
}