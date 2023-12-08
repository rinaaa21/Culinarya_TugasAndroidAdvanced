package com.example.culinarya.bottom_fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.culinarya.DetailResepActivity
import com.example.culinarya.Resep
import com.example.culinarya.ResepAdapter
import com.example.culinarya.R
import java.util.ArrayList

class ResepFragment : Fragment() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var adapter: ResepAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var resepArrayList: ArrayList<Resep>

    lateinit var image: Array<Int>
    lateinit var title: Array<String>
    lateinit var descriptions: Array<String>
    lateinit var detail: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_resep, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.rv_resep)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = ResepAdapter(resepArrayList){
            val intent = Intent(context, DetailResepActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }

    }
    private fun dataInitialize() {
        resepArrayList = arrayListOf<Resep>()

        image = arrayOf(
            R.drawable.cocktails,
            R.drawable.boba,
            R.drawable.iced_coffe,
            R.drawable.milk_jelly,
            R.drawable.cendol_durian,
            R.drawable.soto_ayam,
            R.drawable.nasi_jagung,
            R.drawable.ayam_taliwang,
            R.drawable.waffle,
            R.drawable.pancake,
            R.drawable.ice_cream,
            R.drawable.italian_paste,

            )
        title = arrayOf(
            getString(R.string.arsenal),
            getString(R.string.brighton),
            getString(R.string.brentford),
            getString(R.string.chelsea),
            getString(R.string.palace),
            getString(R.string.everton),
            getString(R.string.liverpool),
            getString(R.string.united),
            getString(R.string.city),
            getString(R.string.newcastle),
            getString(R.string.forest),
            getString(R.string.stanley),
        )
        descriptions = arrayOf(
            getString(R.string.look),
            getString(R.string.look),
            getString(R.string.look),
            getString(R.string.look),
            getString(R.string.look),
            getString(R.string.look),
            getString(R.string.look),
            getString(R.string.look),
            getString(R.string.look),
            getString(R.string.look),
            getString(R.string.look),
            getString(R.string.look),
        )
        detail = arrayOf(
            getString(R.string.desc),
            getString(R.string.desc),
            getString(R.string.desc),
            getString(R.string.desc),
            getString(R.string.desc),
            getString(R.string.desc),
            getString(R.string.desc),
            getString(R.string.desc),
            getString(R.string.desc),
            getString(R.string.desc),
            getString(R.string.desc),
            getString(R.string.desc),
        )
        for (i in image.indices) {

            val resep = Resep(image[i],title[i], descriptions[i],detail[i])
            resepArrayList.add(resep)
        }
    }

}