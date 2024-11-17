package com.jesse.smallcch.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jesse.smallcch.R
import com.jesse.smallcch.data.model.SmallResponseItem

class SmallAdapter(
    val lista: List<SmallResponseItem>,
    val onClickLis: (SmallResponseItem) -> Unit
) : RecyclerView.Adapter<SmallVH>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SmallVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SmallVH(layoutInflater.inflate(R.layout.item_small, parent, false))
    }

    override fun getItemCount(): Int = lista.size

    override fun onBindViewHolder(holder: SmallVH, position: Int) {
        holder.bind(lista[position], onClickLis)
    }

}