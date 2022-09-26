package com.example.showclosedpr

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.com.example.showclosedpr.BaseViewHolder
import com.example.domain.models.ClosedPullRequests
import com.example.showclosedpr.databinding.ItemPullreqListBinding

class PullReqListAdapter(
    private val itemClickListener: (View, ClosedPullRequests?, Int, Any?) -> Unit,
    private val context: Context
) : ListAdapter<ClosedPullRequests, BaseViewHolder<*>>(DIFF_CALLBACK) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ClosedPullRequests>() {
            override fun areItemsTheSame(
                oldItem: ClosedPullRequests,
                newItem: ClosedPullRequests
            ): Boolean {
                return oldItem.user?.id == newItem.user?.id
            }

            override fun areContentsTheSame(
                oldItem: ClosedPullRequests,
                newItem: ClosedPullRequests
            ): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return PullReqListViewHolder(
            ItemPullreqListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), context
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        (holder as PullReqListViewHolder).setItem(
            currentList[position],
            itemClickListener
        )
    }


}