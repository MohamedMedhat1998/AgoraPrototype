package com.andalus.agora.UI.Activities

import android.os.Bundle
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.andalus.agora.R
import com.andalus.agora.UI.Fragments.DetailsActivityFragments.BallotsFragment
import com.andalus.agora.UI.Fragments.DetailsActivityFragments.BasicFragment
import com.andalus.agora.UI.Fragments.DetailsActivityFragments.ResultsFragment
import com.andalus.agora.UI.Fragments.DetailsActivityFragments.VotersFragment
import kotlinx.android.synthetic.main.activity_election_details.*

const val FRAGMENT_BASIC_KEY = "fragment-basic-key"
const val FRAGMENT_VOTERS_KEY = "fragment-voters-key"
const val FRAGMENT_BALLOTS_KEY = "fragment-ballots-key"
const val FRAGMENT_RESULTS_KEY = "fragment-results-key"

class ElectionDetailsActivity : AppCompatActivity() {

    private var fragmentManager : FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_election_details)

        fragmentManager = supportFragmentManager

        loadBasicFragment()

        val btnBasic = btnBasicDetailsActivity
        val btnVoters = btnVotersDetailsActivity
        val btnBallots = btnBallotsDetailsActivity
        val btnResults = btnResultsDetailsActivity

        btnBasic.setOnClickListener {
            loadBasicFragment()
        }

        btnVoters.setOnClickListener {
            loadVotersFragment()
        }

        btnBallots.setOnClickListener {
            loadBallotsFragment()
        }

        btnResults.setOnClickListener {
            loadResultsFragment()
        }

    }

    private fun loadBasicFragment() {
        fragmentManager?.beginTransaction()
            ?.replace(
                R.id.detailsActivityContainer, BasicFragment.newInstance(),
                FRAGMENT_BASIC_KEY
            )?.commit()
    }

    private fun loadVotersFragment() {
        fragmentManager?.beginTransaction()
            ?.replace(
                R.id.detailsActivityContainer, VotersFragment.newInstance(),
                FRAGMENT_VOTERS_KEY
            )?.commit()
    }

    private fun loadBallotsFragment() {
        fragmentManager?.beginTransaction()
            ?.replace(
                R.id.detailsActivityContainer, BallotsFragment.newInstance(),
                FRAGMENT_BALLOTS_KEY
            )?.commit()
    }

    private fun loadResultsFragment() {
        fragmentManager?.beginTransaction()
            ?.replace(
                R.id.detailsActivityContainer, ResultsFragment.newInstance(),
                FRAGMENT_RESULTS_KEY
            )?.commit()
    }

}
