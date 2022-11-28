package com.example.myapplication

import com.example.myapplication.DB.CochesDBHelper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.myapplication.fragments.FormFragment
import com.example.myapplication.fragments.HomeFragment
import com.example.myapplication.fragments.ListFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavigation : AppCompatActivity() {
    companion object{
        lateinit var dbHelper: CochesDBHelper;
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_navigation)

        dbHelper = CochesDBHelper(this)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottom_navigation);


        bottomNav.setOnItemSelectedListener { item: MenuItem ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.nav_form->{
                    loadFragment(FormFragment(dbHelper))
                    true
                }
                R.id.nav_list->{
                    loadFragment(ListFragment(dbHelper))
                    true
                }
                else -> {false}
            }
        }

    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }
}