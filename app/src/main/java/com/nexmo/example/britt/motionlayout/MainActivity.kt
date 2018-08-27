package com.nexmo.example.britt.motionlayout

import android.os.Bundle
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        toolbar.title = ""
        setSupportActionBar(toolbar)

        toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
        drawerLayout.openDrawer(GravityCompat.START)

    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        var layoutId = 0
        var fragment: Fragment? = null

        when (item.itemId) {
            R.id.phone_call_1 -> {

                layoutId = R.layout.layout_phone_call_step_1

            }
            R.id.phone_call_2 -> {
                layoutId = R.layout.layout_phone_call_step_2

            }

            R.id.phone_call_3 -> {
                layoutId = R.layout.layout_phone_call_step_3

            }
            R.id.phone_call_4 -> {
                layoutId = R.layout.layout_phone_call_step_4

            }

            R.id.phone_call_5 -> {
                layoutId = R.layout.layout_phone_call_step_5

            }

//            R.id.phone_call_6 -> {
//                layoutId = R.layout.layout_phone_call_step_6
//
//            }
//
//            R.id.phone_call_7 -> {
//                layoutId = R.layout.layout_phone_call_step_4
//
//            }

            R.id.incoming_call_1 -> {
                layoutId = R.layout.incoming_call
            }

            R.id.play_one_star -> {
                layoutId = R.layout.layout_play_one_star
            }
            R.id.play_three_stars -> {
                layoutId = R.layout.layout_play_three_stars
            }

            R.id.tabs_1 -> {
                fragment = PagerNavFragment.newInstance(R.layout.fragment_bottom_nav2_step0)

            }

            R.id.tabs_2 -> {
                fragment = PagerNavFragment.newInstance(R.layout.fragment_bottom_nav2)

            }

            R.id.tabs_3 -> {
                fragment = PagerNavFragment.newInstance(R.layout.fragment_bottom_nav2_step2)

            }

            R.id.tabs_4 -> {
                fragment = PagerNavFragment.newInstance(R.layout.fragment_viewpager)

            }

//            R.id.recyclerview_1 -> {
//                fragment = RecyclerViewFragment.newInstance(R.layout.fragment_recyclerview)
//
//            }

            R.id.play_cycle -> {
                layoutId = R.layout.layout_cycle

            }
        }

        if (fragment == null) {
            if (layoutId > 0) {
                fragment = SimpleFragment.newInstance(layoutId);
            }

        }
        fragment?.let {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, it).commit()
        };
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }
}
