package com.example.culinarya.bottom_fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.culinarya.DraftFragment
import com.example.culinarya.FragmentPageAdapter
import com.example.culinarya.PublishFragment
import com.example.culinarya.R
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class AddResepFragment : Fragment() {

    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager2: ViewPager2

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add_resep, container, false)

        tabLayout = view.findViewById(R.id.tabLayout)
        viewPager2 = view.findViewById(R.id.viewPager2)

        // Buat daftar fragment Anda
        val fragmentList = listOf(DraftFragment(), PublishFragment())

        // Buat adapter untuk ViewPager
        val adapter = FragmentPageAdapter(this, fragmentList)

        viewPager2.adapter = adapter



        tabLayout.addTab(tabLayout.newTab().setText("Draft"))
        tabLayout.addTab(tabLayout.newTab().setText("Publish"))


        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    viewPager2.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })


        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                tabLayout.selectTab(tabLayout.getTabAt(position))
            }
        })

        return view


    }

}