package com.example.showclosedpr.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.domain.models.ClosedPrs
import com.example.showclosedpr.base.BaseViewHolder
import com.example.showclosedpr.databinding.ItemPullreqListBinding

class PullReqListAdapter(
    private val itemClickListener: (ClosedPrs) -> Unit,
    private val context: Context
) : ListAdapter<ClosedPrs, BaseViewHolder<*>>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ClosedPrs>() {
            override fun areItemsTheSame(
                oldItem: ClosedPrs,
                newItem: ClosedPrs
            ): Boolean {
                return oldItem.user?.id == newItem.user?.id
            }

            override fun areContentsTheSame(
                oldItem: ClosedPrs,
                newItem: ClosedPrs
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return PullReqViewHolder(
            ItemPullreqListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), context
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        (holder as PullReqViewHolder).setItem(
            currentList[position],
            itemClickListener
        )
    }


}