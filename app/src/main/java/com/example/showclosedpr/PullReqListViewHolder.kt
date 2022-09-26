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
            binding.userName.text = it.user?.login
            Glide.with(context).load(it.user?.avatarUrl).into(binding.userImageIV)
            binding.commitTitleTV.text = it.title
            binding.createdAtTV.text = it.createdAt?.toHumanReadableTime()
            binding.closedAtTV.text = it.closedAt?.toHumanReadableTime()

        }
    }
}



