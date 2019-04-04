package com.andalus.agora.UserInterface.Fragments


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.andalus.agora.Adapters.ElectionsCategoriesAdapter
import com.andalus.agora.Objects.ElectionCategory
import com.andalus.agora.R
import com.andalus.agora.UserInterface.ElectionsListActivity
import kotlinx.android.synthetic.main.fragment_elections_categories.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ElectionsCategoriesFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class ElectionsCategoriesFragment : Fragment() {
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
        val view = inflater.inflate(R.layout.fragment_elections_categories, container, false)
        val categories = listOf(
            ElectionCategory("Total Elections", 52, "Total election", R.color.OrangeA700),
            ElectionCategory("Pending", 7, "Total pending elections", R.color.Green700),
            ElectionCategory("Active", 22, "Total active elections", R.color.Red700),
            ElectionCategory("Finished", 12, "Total finished election", R.color.LightBlueA400)
        )

        val rvElectionCategories = view.rvElectionsCategories
        rvElectionCategories.layoutManager = LinearLayoutManager(view.context)
        rvElectionCategories.adapter = ElectionsCategoriesAdapter(categories){
            startActivity(Intent(activity,ElectionsListActivity::class.java))
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
         * @return A new instance of fragment ElectionsCategoriesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String = "", param2: String = "") =
            ElectionsCategoriesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
