package com.example.submission_dicoding.adapter

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.submission_dicoding.R
import com.example.submission_dicoding.databinding.ActivityDetailBikeBinding
import kotlinx.android.synthetic.main.activity_detail_bike.*
import kotlinx.android.synthetic.main.item_row_bike.img_item_photo
import kotlinx.android.synthetic.main.item_row_bike.tv_item_detail
import kotlinx.android.synthetic.main.item_row_bike.tv_item_name

class AdapterDetailBike : AppCompatActivity() {

    lateinit var binding: ActivityDetailBikeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_detail_bike
        )

        img_item_photo.setImageResource(getIntent().getStringExtra("image").toInt())
        tv_item_name.text = getIntent().getStringExtra("name")
        tv_item_detail.text = getIntent().getStringExtra("detail")
        tv_item_size.text = getIntent().getStringExtra("size")
        tv_item_fork.text = getIntent().getStringExtra("fork")
        tv_item_shock.text = getIntent().getStringExtra("shock")
        tv_item_grupset.text = getIntent().getStringExtra("grupset")
        tv_item_brake.text = getIntent().getStringExtra("brake")
        tv_item_weight.text = getIntent().getStringExtra("weight")
        tv_item_color.text = getIntent().getStringExtra("color")
        tv_item_price.text = getIntent().getStringExtra("price")

        //titlebar
        val actionBar = supportActionBar
        actionBar!!.title = "Detail bike"
    }
    //TODO AboutMe
    private fun showAboutMe(){
        val Aboutme = Intent(this, AdapterAboutMe::class.java)
        Aboutme.putExtra(AdapterAboutMe.EXTRA_NAMA, "Dwiki Rivan Ananta")
        Aboutme.putExtra(AdapterAboutMe.EXTRA_EMAIL,"dwikirivan@gmail.com")
        Aboutme.putExtra(AdapterAboutMe.EXTRA_JOIN,"Bergabung sejak 05 April 2020")
        startActivity(Aboutme)
    }
    //TODO Menu
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {

            R.id.action_about -> {
                title = "About Me"
                showAboutMe()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
