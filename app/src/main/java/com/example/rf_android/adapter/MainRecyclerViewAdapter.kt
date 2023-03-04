package com.example.rf_android.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.rf_android.databinding.ItemEntityBinding
import com.example.rf_android.entity.EntityEntropi

class MainRecyclerViewAdapter(
    private var dataList: List<EntityEntropi>
): RecyclerView.Adapter<MainRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(val binding : ItemEntityBinding)
        : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
       return ViewHolder(
           ItemEntityBinding.inflate(
               LayoutInflater.from(parent.context),
               parent,
               false
           )
       )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item = dataList[position]
        holder.binding.apply {
            tvInformationGain.text = item.informationGain
            TvCondition.text = item.name
        }
    }


    override fun getItemCount(): Int = dataList.size
}