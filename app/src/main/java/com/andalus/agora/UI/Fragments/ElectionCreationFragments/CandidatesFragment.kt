package com.andalus.agora.UI.Fragments.ElectionCreationFragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.CardView
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andalus.agora.Adapters.CandidatesAdapter

import com.andalus.agora.R
import kotlinx.android.synthetic.main.fragment_candidates.*
import kotlinx.android.synthetic.main.fragment_candidates.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CandidatesFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class CandidatesFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_candidates, container, false)
        val adapter = CandidatesAdapter()
        val rvCandidates = view.rvCandidates
        rvCandidates.adapter = adapter
        rvCandidates.layoutManager = LinearLayoutManager(context)
        rvCandidates.setHasFixedSize(false)
        rvCandidates.addItemDecoration(DividerItemDecoration(context,LinearLayoutManager(context).orientation))
        val etCandidateName = view.etCandidateName
        val btnAddCandidate = view.btnAddCandidate
        btnAddCandidate.setOnClickListener {
            adapter.data.add(etCandidateName.text.toString())
            adapter.notifyDataSetChanged()
        }
        return view
    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CandidatesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String = "", param2: String = "") =
            CandidatesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
