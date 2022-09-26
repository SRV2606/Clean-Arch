package com.example.showclosedpr.ui

import android.content.Context
import com.bumptech.glide.Glide
import com.example.domain.models.ClosedPrs
import com.example.showclosedpr.base.BaseViewHolder
import com.example.showclosedpr.databinding.ItemPullreqListBinding
import com.example.showclosedpr.toHumanReadableTime

class PullReqViewHolder(
    private val binding: ItemPullreqListBinding,
    private val context: Context,
) : BaseViewHolder<ClosedPrs>(binding) {
    override fun setItem(
        data: ClosedPrs?,
        itemClickListener: (ClosedPrs) -> Unit
    ) {
        data?.let {
            binding.userName.text = it.user?.login
            Glide.with(context).load(it.user?.avatarUrl).into(binding.userImageIV)
            binding.commitTitleTV.text = it.title
            binding.createdAtTV.text = it.createdAt?.toHumanReadableTime()
            binding.closedAtTV.text = it.closedAt?.toHumanReadableTime()
            binding.parentHolderCL.setOnClickListener { v ->
                itemClickListener(it)
            }
        }
    }


}



