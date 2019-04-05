package com.andalus.agora.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.andalus.agora.R
import kotlinx.android.synthetic.main.item_candidate.view.*

class CandidatesAdapter(val data: MutableList<String> = mutableListOf()) :
    RecyclerView.Adapter<CandidatesAdapter.CandidatesHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): CandidatesHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.item_candidate, viewGroup, false)
        return CandidatesHolder(view)
    }

    override fun onBindViewHolder(item: CandidatesHolder, position: Int) {
        item.tvCandidateNameItem.text = data[position]
        item.ibRemoveCandidate.setOnClickListener {
            data.removeAt(position)
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }


    class CandidatesHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvCandidateNameItem: TextView = itemView.tvCandidateNameItem
        val ibRemoveCandidate: ImageButton = itemView.ibRemoveCandidate
    }
}