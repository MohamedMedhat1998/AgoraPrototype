package com.andalus.agora.UI.Fragments.ElectionCreationFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andalus.agora.Adapters.VotingAlgorithmAdapter
import com.andalus.agora.Objects.VotingAlgorithm

import com.andalus.agora.R
import kotlinx.android.synthetic.main.fragment_voting_algorithm.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [VotingAlgorithmFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class VotingAlgorithmFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_voting_algorithm, container, false)
        val rvVotingAlgorithm = view.rvVotingAlgorithm
        val data = mutableListOf(VotingAlgorithm("Oklahoma"))
        data.apply {
            add(VotingAlgorithm("RangeVoting"))
            add(VotingAlgorithm("RankedParis"))
            add(VotingAlgorithm("Satisfaction Approval Voting"))
            add(VotingAlgorithm("Sequential Proportional Approval Voting"))
            add(VotingAlgorithm("SmithSet"))
            add(VotingAlgorithm("Approval"))
            add(VotingAlgorithm("Exhaustive ballot"))
            add(VotingAlgorithm("Baldwin"))
            add(VotingAlgorithm("Exhaustive ballot With dropoff"))
            add(VotingAlgorithm("Uncovered Set"))
            add(VotingAlgorithm("Copeland"))
            add(VotingAlgorithm("Minimax Condorcet"))
            add(VotingAlgorithm("Random Ballot"))
            add(VotingAlgorithm("Borda"))
            add(VotingAlgorithm("Kemeny Young"))
            add(VotingAlgorithm("Nanson"))
            add(VotingAlgorithm("Instant Runoff 2-round"))
            add(VotingAlgorithm("Contingent Method"))
        }
        rvVotingAlgorithm.adapter = VotingAlgorithmAdapter(data)
        rvVotingAlgorithm.setHasFixedSize(false)
        rvVotingAlgorithm.layoutManager = LinearLayoutManager(context)
        rvVotingAlgorithm.addItemDecoration(DividerItemDecoration(context,LinearLayoutManager(context).orientation))
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment VotingAlgorithmFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String = "", param2: String = "") =
            VotingAlgorithmFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
