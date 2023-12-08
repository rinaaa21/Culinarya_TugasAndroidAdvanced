package com.example.culinarya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.culinarya.bottom_fragment.AddResepFragment
import com.example.culinarya.bottom_fragment.HomeFragment
import com.example.culinarya.bottom_fragment.ResepFragment
import com.example.culinarya.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(HomeFragment())

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val imageViewInToolbar = findViewById<ImageView>(R.id.imageViewInToolbar)

        supportActionBar?.setDisplayShowTitleEnabled(false)

        val titleTextView: TextView = toolbar.findViewById(R.id.titleToolbar)
        titleTextView.text = "Culinarya"


        val bottomFragment = findViewById<FrameLayout>(R.id.bottomFragment)


        binding.bottomNavigation.setOnItemSelectedListener {

            when(it.itemId){

                R.id.bottom_home -> replaceFragment(HomeFragment())
                R.id.bottom_add -> replaceFragment(AddResepFragment())
                R.id.bottom_resep -> replaceFragment(ResepFragment())

                else ->{

                }

            }

            true

        }

    }


    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.bottomFragment,fragment)
        fragmentTransaction.commit()


    }
}