package com.route.IslamiC38Fri.ui.home.fragments.quran

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.route.IslamiC38Fri.databinding.ItemChapterBinding

class ChapterRecyclerAdapter(val items: List<String>) :
    RecyclerView.Adapter<ChapterRecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemChapterBinding = ItemChapterBinding
            .inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        return ViewHolder(itemChapterBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.viewbinding.title.text = items[position]
        if (onItemClickListener != null) {
            holder.viewbinding
                .root.setOnClickListener {
                    onItemClickListener?.onItemClick(position, items[position])
                }
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

    var onItemClickListener: OnItemClickListener? = null

    fun interface OnItemClickListener {
        fun onItemClick(position: Int, item: String)
    }

    class ViewHolder(val viewbinding: ItemChapterBinding) :
        RecyclerView.ViewHolder(viewbinding.root)
}