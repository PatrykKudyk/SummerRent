package com.partos.summerrent

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.partos.summerrent.db.DataBaseHelper
import com.partos.summerrent.fragments.CurrentFragment
import com.partos.summerrent.fragments.MainMenuFragment
import com.partos.summerrent.fragments.PastFragment

class MainActivity : AppCompatActivity(),
    MainMenuFragment.OnFragmentInteractionListener,
    PastFragment.OnFragmentInteractionListener,
    CurrentFragment.OnFragmentInteractionListener {

    private lateinit var mainMenuFragment: MainMenuFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = DataBaseHelper(this)
        val check = db.getSmallMonth(1, 2020)
        if (check.size == 0) {
            db.initDatabase()
        }

        mainMenuFragment = MainMenuFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.enter_bottom_to_top, R.anim.exit_top_to_bottom,
                R.anim.enter_top_to_bottom, R.anim.exit_bottom_to_top
            )
            .add(R.id.main_frame_layout, mainMenuFragment)
            .commit()
    }

    override fun onFragmentInteraction(uri: Uri) {

    }
}