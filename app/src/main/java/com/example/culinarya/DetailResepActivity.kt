package com.example.culinarya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.culinarya.bottom_fragment.ResepFragment

class DetailResepActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_resep)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val Resep = intent.getParcelableExtra<Resep>(ResepFragment.INTENT_PARCELABLE)

        val imageResep = findViewById<ImageView>(R.id.img_item_photo)
        val titleResep= findViewById<TextView>(R.id.tv_item_name)
        val detailResep = findViewById<TextView>(R.id.tv_item_description)

        imageResep.setImageResource(Resep?.imageResep!!)
        titleResep.text = Resep.titleResep
        detailResep.text = Resep.detResep

    }
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}