package com.example.submission_dicoding

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mysubmission_dicoding.Bike
import com.example.mysubmission_dicoding.BikesData
import com.example.submission_dicoding.adapter.AdapterAboutMe
import com.example.submission_dicoding.adapter.AdapterDetailBike
import com.example.submission_dicoding.adapter.AdapterRowBIke
import com.example.submission_dicoding.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), AdapterRowBIke.OnBikeItemClickListner{

     lateinit var binding: ActivityMainBinding
     private lateinit var rvBikes: RecyclerView
     private var list: ArrayList<Bike> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        rvBikes = findViewById(R.id.rv_bikes)
        rvBikes.setHasFixedSize(true)

        list.addAll(BikesData.listBike)
        showHomeBike()

        //titlebar
        val actionBar = supportActionBar
        actionBar!!.title = "Tokopeda"
    }
    //TODO HOMEBIKE
    private fun showHomeBike(){
        rvBikes.layoutManager = LinearLayoutManager(this)
        rvBikes.addItemDecoration(DividerItemDecoration(this,1))
        rvBikes.adapter =
            AdapterRowBIke(list, this)
    }

    //TODO AboutMe
    private fun showAboutMe(){
       val Aboutme = Intent(this, AdapterAboutMe::class.java)
        Aboutme.putExtra(AdapterAboutMe.EXTRA_NAMA, "Dwiki Rivan Ananta")
        Aboutme.putExtra(AdapterAboutMe.EXTRA_EMAIL,"dwikirivan@gmail.com")
        Aboutme.putExtra(AdapterAboutMe.EXTRA_JOIN,"Bergabung sejak 05 April 2020")
        startActivity(Aboutme)
    }

    //TODO DETAIL
    override fun onItemClick(bike: Bike, Position: Int) {
        val intent = Intent(this, AdapterDetailBike::class.java)
            intent.putExtra("image",bike.photo.toString())
            intent.putExtra("name",bike.frame_name)
            intent.putExtra("detail",bike.detail)
            intent.putExtra("size",bike.frame_size)
            intent.putExtra("fork",bike.fork)
            intent.putExtra("shock",bike.shock)
            intent.putExtra("grupset",bike.grupset)
            intent.putExtra("brake",bike.brakes)
            intent.putExtra("weight",bike.weight)
            intent.putExtra("color",bike.color)
            intent.putExtra("price",bike.price)
        startActivity(intent)
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
