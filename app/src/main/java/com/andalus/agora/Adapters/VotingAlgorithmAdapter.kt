package com.andalus.agora.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import com.andalus.agora.Objects.VotingAlgorithm
import com.andalus.agora.R
import kotlinx.android.synthetic.main.item_voting_algoritm.view.*

class VotingAlgorithmAdapter(val data: MutableList<VotingAlgorithm> = mutableListOf()) :
    RecyclerView.Adapter<VotingAlgorithmAdapter.VotingAlgorithmHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): VotingAlgorithmHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.item_voting_algoritm, viewGroup, false)
        return VotingAlgorithmHolder(view)
    }

    override fun onBindViewHolder(item: VotingAlgorithmHolder, position: Int) {
        item.rbAlgorithmItem.text = data[position].algorithmName
        item.rbAlgorithmItem.setOnClickListener {
            data.forEach {
                it.isSelected = false
            }
            data[position].isSelected = true
            notifyDataSetChanged()
        }
        item.rbAlgorithmItem.isChecked = data[position].isSelected
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class VotingAlgorithmHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rbAlgorithmItem: RadioButton = itemView.rbAlgorithmItem
    }
}