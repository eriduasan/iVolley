package com.example.volleyball

import android.content.res.Resources
import android.content.res.Resources.Theme
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.volleyball.clases.Faq
import com.example.volleyball.databinding.ActivityDashboardBinding
import com.example.volleyball.fragments.DetailFaqFragment
import com.example.volleyball.fragments.FaqFragment
import com.example.volleyball.fragments.RulesFragment
import com.google.android.material.navigation.NavigationBarView

class DashboardActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener, FaqFragment.onFaqFragmentItemClicked {

    lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDashboardBinding.inflate(layoutInflater)

        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setTitle(R.string.dashboard_toolbar_name)

        binding.dashboardBottomNavview.setOnItemSelectedListener(this)


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.dashboard_menu, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.menu_btn_rules -> {
                changeFragment(RulesFragment(), false)
                true
            }
            R.id.menu_btn_faq -> {
                changeFragment(FaqFragment(), false)
                true
            }
            else -> false
        }
    }

    fun changeFragment(fragmentToShow: Fragment, add: Boolean) {

        val fragmentContainerView = binding.dashboardFragmentContainerView.id

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(fragmentContainerView, fragmentToShow)
            if (add) addToBackStack(null)
        }
    }

    override fun clickFaqItem(faq: Faq) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)

            replace<DetailFaqFragment>(
                binding.dashboardFragmentContainerView.id,
                args = bundleOf(
                    DetailFaqFragment.DETAIL_FAQ_TITLE to faq.title,
                    DetailFaqFragment.DETAIL_FAQ_BODY to faq.body
                ))

            addToBackStack(null)
        }
    }
}