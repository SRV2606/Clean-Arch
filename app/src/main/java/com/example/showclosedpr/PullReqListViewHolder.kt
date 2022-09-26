package com.example.showclosedpr

import android.content.Context
import android.view.View
import com.bumptech.glide.Glide
import com.example.com.example.showclosedpr.BaseViewHolder
import com.example.domain.models.ClosedPullRequests
import com.example.showclosedpr.databinding.ItemPullreqListBinding

class PullReqListViewHolder(
    private val binding: ItemPullreqListBinding,
    private val context: Context,
) : BaseViewHolder<ClosedPullRequests>(binding) {
    override fun setItem(
        data: ClosedPullRequests?,
        itemClickListener: (View, ClosedPullRequests?, Int, Any?) -> Unit
    ) {
        data?.let {
            binding.user.text = it.user?.id.toString()
            Glide.with(context).load(it.user?.avatarUrl).into(binding.imageView)
            binding.title.text = it.title
            binding.createdDate.text = it.createdAt

        }
    }
}