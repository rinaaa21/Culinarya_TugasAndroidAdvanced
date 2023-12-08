package com.example.culinarya

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentPageAdapter(fragment: Fragment, private val fragmentList: List<Fragment>) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment = fragmentList[position]
}


//class FragmentPageAdapter (
//    fragmentManager: FragmentManager,
//    lifecycle: Lifecycle
//) : FragmentStateAdapter(fragmentManager, lifecycle){
//    override fun getItemCount(): Int {
//        return 2
//    }
//
//    override fun createFragment(position: Int): Fragment {
//        return if(position == 0)
//            DraftFragment()
//        else
//            PublishFragment()
//    }
//
//}