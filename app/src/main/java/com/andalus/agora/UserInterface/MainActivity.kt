package com.andalus.agora.UserInterface

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import com.andalus.agora.R
import com.andalus.agora.UserInterface.Fragments.AboutFragment
import com.andalus.agora.UserInterface.Fragments.ElectionsCategoriesFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.nav_header_main.*

private const val FRAGMENT_CATEGORIES_KEY = "fragment-categories-key"
private const val FRAGMENT_ABOUT_KEY = "fragment-about-key"

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    var fragmentManager: FragmentManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

        //------------
        fragmentManager = supportFragmentManager
        loadHomeFragment()

        val navigationView = nav_view
        val view = navigationView.getHeaderView(0)
        val ivProfilePicture: ImageView = view.findViewById(R.id.ivProfileNavHeader)

        ivProfilePicture.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                loadHomeFragment()
            }
            R.id.nav_about -> {
                loadAboutFragment()
            }
            R.id.nav_help -> {
                //TODO create and implement help fragment
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun loadHomeFragment() {
        fragmentManager?.beginTransaction()
            ?.replace(
                R.id.mainActivityContainer, ElectionsCategoriesFragment.newInstance(),
                FRAGMENT_CATEGORIES_KEY
            )?.commit()
    }

    private fun loadAboutFragment() {
        fragmentManager?.beginTransaction()
            ?.replace(
                R.id.mainActivityContainer, AboutFragment.newInstance(),
                FRAGMENT_ABOUT_KEY
            )?.commit()
    }
}
