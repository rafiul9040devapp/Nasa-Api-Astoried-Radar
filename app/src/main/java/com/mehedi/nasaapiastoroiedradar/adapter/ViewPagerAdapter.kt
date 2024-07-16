package com.mehedi.nasaapiastoroiedradar.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mehedi.nasaapiastoroiedradar.R
import com.mehedi.nasaapiastoroiedradar.data.local.ImageOfTheDayEntity
import com.mehedi.nasaapiastoroiedradar.databinding.ItemImageHolderBinding

class ViewPagerAdapter(private val items: List<ImageOfTheDayEntity>) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val binding: ItemImageHolderBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.item_image_holder,
            parent,
            false
        )
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    class ViewPagerViewHolder(private val binding: ItemImageHolderBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImageOfTheDayEntity) {
            binding.apply {
                response = item
            }
        }
    }
}