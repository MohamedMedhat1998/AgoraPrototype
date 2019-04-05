package com.andalus.agora.UI.Activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.andalus.agora.R
import com.andalus.agora.UI.Fragments.ElectionCreationFragments.*
import kotlinx.android.synthetic.main.activity_create_election.*

class CreateElectionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_election)

        val pager = viewPagerCreateElection
        val adapter = ElectionCreationPagerAdapter(supportFragmentManager)
        pager.adapter = adapter
        val tabLayout = tabLayoutCreateElection
        tabLayout.setupWithViewPager(pager, true)
    }


    class ElectionCreationPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> NameDescriptionFragment.newInstance()
                1 -> DateFragment.newInstance()
                2 -> CandidatesFragment.newInstance()
                3 -> VotingAlgorithmFragment.newInstance()
                4 -> LastFragment.newInstance()
                else -> NameDescriptionFragment.newInstance()
            }
        }

        override fun getCount(): Int {
            return 5
        }

    }

}

