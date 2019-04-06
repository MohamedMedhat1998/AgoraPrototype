package com.andalus.agora.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.andalus.agora.Objects.ElectionCategory
import com.andalus.agora.R
import kotlinx.android.synthetic.main.item_election_category_card.view.*

class ElectionsCategoriesAdapter(private val data: List<ElectionCategory>) :
    RecyclerView.Adapter<ElectionsCategoriesAdapter.ElectionsCategoriesHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ElectionsCategoriesHolder {
        val layoutInflater = LayoutInflater.from(viewGroup.context)
        val view = layoutInflater.inflate(R.layout.item_election_category_card, viewGroup, false)
        return ElectionsCategoriesHolder(view)
    }

    override fun onBindViewHolder(item: ElectionsCategoriesHolder, position: Int) {
        item.tvElectionCategoryName.text = data[position].name
        item.tvElectionCategoryCount.text = data[position].count.toString()
        item.ivElectionCategoryImage.setImageResource(data[position].imageId)
        item.tvElectionCategoryDescription.text = data[position].description
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ElectionsCategoriesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvElectionCategoryName: TextView = itemView.tvElectionCategoryName
        val tvElectionCategoryCount: TextView = itemView.tvElectionCategoryCount
        val ivElectionCategoryImage: ImageView = itemView.ivElectionCategoryImage
        val tvElectionCategoryDescription: TextView = itemView.tvElectionCategoryDescription
    }
}