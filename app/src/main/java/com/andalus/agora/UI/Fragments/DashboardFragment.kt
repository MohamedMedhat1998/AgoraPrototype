package com.andalus.agora.UI.Fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andalus.agora.Adapters.ElectionsAdapter
import com.andalus.agora.Adapters.ElectionsCategoriesAdapter
import com.andalus.agora.Objects.Election
import com.andalus.agora.Objects.ElectionCategory
import com.andalus.agora.R
import com.andalus.agora.UI.Activities.CreateElectionActivity
import kotlinx.android.synthetic.main.fragment_dashboard.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class DashboardFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val pendingElections = mutableListOf<Election>()
        pendingElections.apply {
            add(
                Election(
                    "Demo Election Name",
                    "Demo Election Description",
                    "4/4/2019, 5:24",
                    "20/4/2019, 12:00",
                    "Oklahoma",
                    false,
                    false,
                    "only me",
                    "anyone",
                    "Pending",
                    mutableListOf("First Candidate", "Second Candidate")
                )
            )
            add(
                Election(
                    "Demo Election Name",
                    "Demo Election Description",
                    "4/4/2019, 5:24",
                    "20/4/2019, 12:00",
                    "Oklahoma",
                    false,
                    false,
                    "only me",
                    "anyone",
                    "Pending",
                    mutableListOf("First Candidate", "Second Candidate")
                )
            )
            add(
                Election(
                    "Demo Election Name",
                    "Demo Election Description",
                    "4/4/2019, 5:24",
                    "20/4/2019, 12:00",
                    "Oklahoma",
                    false,
                    false,
                    "only me",
                    "anyone",
                    "Pending",
                    mutableListOf("First Candidate", "Second Candidate")
                )
            )

        }
        val activeElections = mutableListOf<Election>()

        activeElections.apply {
            add(
                Election(
                    "Demo Election Name",
                    "Demo Election Description",
                    "4/4/2019, 5:24",
                    "20/4/2019, 12:00",
                    "Oklahoma",
                    false,
                    false,
                    "only me",
                    "anyone",
                    "Active",
                    mutableListOf("First Candidate", "Second Candidate")
                )
            )
            add(
                Election(
                    "Demo Election Name",
                    "Demo Election Description",
                    "4/4/2019, 5:24",
                    "20/4/2019, 12:00",
                    "Oklahoma",
                    false,
                    false,
                    "only me",
                    "anyone",
                    "Active",
                    mutableListOf("First Candidate", "Second Candidate")
                )
            )
            add(
                Election(
                    "Demo Election Name",
                    "Demo Election Description",
                    "4/4/2019, 5:24",
                    "20/4/2019, 12:00",
                    "Oklahoma",
                    false,
                    false,
                    "only me",
                    "anyone",
                    "Active",
                    mutableListOf("First Candidate", "Second Candidate")
                )
            )
        }

        val finishedElections = mutableListOf<Election>()

        finishedElections.apply {
            add(
                Election(
                    "Demo Election Name",
                    "Demo Election Description",
                    "4/4/2019, 5:24",
                    "20/4/2019, 12:00",
                    "Oklahoma",
                    false,
                    false,
                    "only me",
                    "anyone",
                    "Finished",
                    mutableListOf("First Candidate", "Second Candidate")
                )
            )
            add(
                Election(
                    "Demo Election Name",
                    "Demo Election Description",
                    "4/4/2019, 5:24",
                    "20/4/2019, 12:00",
                    "Oklahoma",
                    false,
                    false,
                    "only me",
                    "anyone",
                    "Finished",
                    mutableListOf("First Candidate", "Second Candidate")
                )
            )
            add(
                Election(
                    "Demo Election Name",
                    "Demo Election Description",
                    "4/4/2019, 5:24",
                    "20/4/2019, 12:00",
                    "Oklahoma",
                    false,
                    false,
                    "only me",
                    "anyone",
                    "Finished",
                    mutableListOf("First Candidate", "Second Candidate")
                )
            )
        }

        val totalElections = mutableListOf<Election>()
        totalElections.apply {
            addAll(pendingElections)
            addAll(activeElections)
            addAll(finishedElections)
        }

        val categories = listOf(
            ElectionCategory("Total Elections", totalElections.size, "Total election", R.color.OrangeA700),
            ElectionCategory("Pending", pendingElections.size, "Total pending elections", R.color.Green700),
            ElectionCategory("Active", activeElections.size, "Total active elections", R.color.Red700),
            ElectionCategory("Finished", finishedElections.size, "Total finished election", R.color.LightBlueA400)
        )

        val rvElectionCategories = view.rvElectionsCategories
        rvElectionCategories.apply {
            layoutManager = LinearLayoutManager(view.context)
            setHasFixedSize(false)
            isNestedScrollingEnabled = true
            adapter = ElectionsCategoriesAdapter(categories)
        }

        val electionsAdapter = ElectionsAdapter(totalElections)

        val rvElections = view.rvElectionsList
        rvElections.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = electionsAdapter
        }

        val btnCreateElection = view.btnCreateElection
        btnCreateElection.setOnClickListener {
            startActivity(Intent(activity, CreateElectionActivity::class.java))
        }

        val btnAllElections = view.btnAllCategories
        btnAllElections.setOnClickListener {
            electionsAdapter.data = totalElections
            electionsAdapter.notifyDataSetChanged()
        }

        val btnPendingElections = view.btnPendingCategories
        btnPendingElections.setOnClickListener {
            electionsAdapter.data = pendingElections
            electionsAdapter.notifyDataSetChanged()
        }

        val btnActiveElections = view.btnActiveCategories
        btnActiveElections.setOnClickListener {
            electionsAdapter.data = activeElections
            electionsAdapter.notifyDataSetChanged()
        }

        val btnFinishedElections = view.btnFinishedCategories
        btnFinishedElections.setOnClickListener {
            electionsAdapter.data = finishedElections
            electionsAdapter.notifyDataSetChanged()
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
         * @return A new instance of fragment DashboardFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String = "", param2: String = "") =
            DashboardFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
