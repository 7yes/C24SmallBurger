package com.jesse.smallcch.presentation.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jesse.smallcch.core.load
import com.jesse.smallcch.data.model.SmallResponseItem
import com.jesse.smallcch.databinding.ItemSmallBinding

class SmallVH(view: View):RecyclerView.ViewHolder(view) {

    private val binding = ItemSmallBinding.bind(view)

    fun bind(smallResponseItem: SmallResponseItem, onClickLis: (SmallResponseItem) -> Unit, ) {
        binding.name.text = smallResponseItem.name
        binding.image.load(smallResponseItem.image)
        binding.root.setOnClickListener {
            onClickLis(smallResponseItem)
        }
    }
}