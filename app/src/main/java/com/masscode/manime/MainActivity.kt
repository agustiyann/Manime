package com.masscode.manime

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.masscode.manime.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navCtrl: NavController

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setSupportActionBar(main_toolbar)
        main_toolbar.setTitleTextAppearance(this, R.style.ElectroHarmonixFont)
        navCtrl = this.findNavController(R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navCtrl, drawer_layout)
        NavigationUI.setupWithNavController(nav_view, navCtrl)
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navCtrl, drawer_layout)
    }
}