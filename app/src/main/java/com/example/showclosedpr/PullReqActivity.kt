package com.example.showclosedpr

import android.content.Intent
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.com.example.showclosedpr.BaseActivity
import com.example.domain.ClientResult
import com.example.showclosedpr.com.example.showclosedpr.viewModels.PullReqViewModel
import com.example.showclosedpr.databinding.ActivityPullReqBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class PullReqActivity : BaseActivity<ActivityPullReqBinding>(R.layout.activity_pull_req) {

    private val viewModel: PullReqViewModel by viewModels()

    private val pullReqListAdapter: PullReqListAdapter by lazy {
        PullReqListAdapter(itemClickListener = { view, closedPullRequests, i, any ->

            Toast.makeText(
                this, "this$closedPullRequests+ $i", Toast.LENGTH_SHORT
            ).show()

        }, context = this)
    }

    override fun readArguments(extras: Intent) {

    }

    override fun setupUi() {
        binding.pullReqListRV.layoutManager =
            LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        binding.pullReqListRV.adapter = pullReqListAdapter
    }

    override fun observeData() {

        collectEvent(viewModel.closePrsList) {
            when (it) {
                is ClientResult.Success -> {
                    pullReqListAdapter.submitList(it.data)
                }
            }
        }
    }

    override fun setListener() {

    }
}