package com.example.submission_dicoding.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mysubmission_dicoding.Bike
import com.example.submission_dicoding.MainActivity
import com.example.submission_dicoding.R

class AdapterRowBIke(val listBike: ArrayList<Bike>, var clickListener: OnBikeItemClickListner) : RecyclerView.Adapter<AdapterRowBIke.RowBikeHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): RowBikeHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_bike, parent,false)
        return RowBikeHolder(view)
    }

    override fun getItemCount(): Int {
        return listBike.size
    }

    override fun onBindViewHolder(holder: RowBikeHolder, position: Int) {
        val bike = listBike[position]
        Glide.with(holder.itemView.context)
            .load(bike.photo)
            .apply(RequestOptions().override(200,110))
            .into(holder.imgPhoto)
        holder.tvName.text = bike.frame_name
        holder.tvDetail.text = bike.detail
//        holder.btnshare.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "Share" + listBike[holder.adapterPosition].frame_name, Toast.LENGTH_SHORT).show()
//        }
//        holder.btnbasket.setOnClickListener {
//            Toast.makeText(holder.itemView.context, "Item Ditambahkan" + listBike[holder.adapterPosition].frame_name, Toast.LENGTH_SHORT).show()
//        }

        holder.initial(listBike.get(position), clickListener as MainActivity)

    }

   inner class RowBikeHolder(itemView: View) :  RecyclerView.ViewHolder(itemView){
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
//        var btnshare: Button = itemView.findViewById(R.id.btn_share)
//        var btnbasket: Button = itemView.findViewById(R.id.btn_keranjang)

        fun initial(bike: Bike, action: OnBikeItemClickListner){
            itemView.setOnClickListener { action.onItemClick(bike,adapterPosition) }
        }
    }

    interface OnBikeItemClickListner {
         fun onItemClick(bike: Bike, Position: Int)

    }
}
