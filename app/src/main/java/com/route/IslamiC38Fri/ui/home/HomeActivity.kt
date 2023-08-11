package com.route.IslamiC38Fri.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.IslamiC38Fri.R
import com.route.IslamiC38Fri.databinding.ActivityHomeBinding
import com.route.IslamiC38Fri.ui.home.fragments.hadeth.HadethFragment
import com.route.IslamiC38Fri.ui.home.fragments.quran.QuranFragment
import com.route.IslamiC38Fri.ui.home.fragments.radio.RadioFragment
import com.route.IslamiC38Fri.ui.home.fragments.tasbeh.TasbehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.content.bottomNav
            .setOnItemSelectedListener { item ->
                val id = item.itemId
                when (id) {
                    R.id.naviagtion_quran -> {
                        showFragment(QuranFragment())
                    }

                    R.id.naviagtion_hadeth -> {
                        showFragment(HadethFragment())

                    }

                    R.id.naviagtion_radio -> {
                        showFragment(RadioFragment())

                    }

                    R.id.naviagtion_sebha -> {
                        showFragment(TasbehFragment())
                    }
                }
                true
            }

        viewBinding.content.bottomNav.selectedItemId = R.id.naviagtion_quran


    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()

    }
}