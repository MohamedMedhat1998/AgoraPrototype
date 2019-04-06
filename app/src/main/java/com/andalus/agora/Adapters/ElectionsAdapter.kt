package com.andalus.agora.Adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import com.andalus.agora.Objects.Election
import com.andalus.agora.R
import kotlinx.android.synthetic.main.item_election.view.*

class ElectionsAdapter(var data: MutableList<Election> = mutableListOf()) : RecyclerView.Adapter<ElectionsAdapter.ElectionHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ElectionHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.item_election, viewGroup, false)
        return ElectionHolder(view)
    }

    override fun onBindViewHolder(item: ElectionHolder, position: Int) {
        item.tvName.text = "Elections: ${data[position].name}"
        item.tvDescription.text = data[position].description
        item.tvCandidates.text = ""
        for (i in data[position].candidates) {
            item.tvCandidates.text = "${item.tvCandidates.text}\n$i"
        }
        item.tvStart.text = data[position].startDate
        item.tvFinish.text = data[position].finishDate
        item.tvStatus.text = data[position].status
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ElectionHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.tvElectionNameItem
        val tvDescription: TextView = itemView.tvElectionDescriptionItem
        val tvCandidates: TextView = itemView.tvElectionCandidatesItem
        val tvStart: TextView = itemView.tvElectionStartItem
        val tvFinish: TextView = itemView.tvElectionFinishItem
        val tvStatus: TextView = itemView.tvElectionStatusItem
        val ibSettings: ImageButton = itemView.ibElectionSettingsItem
        val ibView: ImageButton = itemView.ibElectionViewItem
        val ibRemove: ImageButton = itemView.ibElectionRemoveItem
    }
}