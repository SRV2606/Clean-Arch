package com.example.showclosedpr.ui

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.ClientResult
import com.example.domain.models.ClosedPrs
import com.example.showclosedpr.R
import com.example.showclosedpr.base.BaseActivity
import com.example.showclosedpr.collectEvent
import com.example.showclosedpr.com.example.showclosedpr.viewModels.PullReqViewModel
import com.example.showclosedpr.databinding.ActivityPullReqBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PullReqActivity : BaseActivity<ActivityPullReqBinding>(R.layout.activity_pull_req) {

    private val viewModel: PullReqViewModel by viewModels()

    private val pullReqListAdapter: PullReqListAdapter by lazy {
        PullReqListAdapter(itemClickListener = { closedPullRequests ->
            Toast.makeText(
                this, "this${closedPullRequests.user?.id}", Toast.LENGTH_SHORT
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
        viewModel.isLoadingMLD.observe(this) {
            renderLoadingScreen(it)
        }

        collectEvent(viewModel.closePrsList) {
            when (it) {
                is ClientResult.Success -> {
                    renderSuccessScreenWithData(it)

                }
                //FYI : currently cache is not enabled so its easy to check the error screen handling
                is ClientResult.Error -> {
                    renderErrorScreenWithRetry(it)
                }
                else -> {}
            }
        }
    }

    private fun renderSuccessScreenWithData(clientResult: ClientResult.Success<List<ClosedPrs>>) {
        if (binding.retryLayoutHolder.retryLayoutCL.visibility == View.VISIBLE) {
            binding.retryLayoutHolder.retryLayoutCL.visibility = View.GONE
        }
        if (binding.pullReqListRV.visibility == View.GONE) {
            binding.pullReqListRV.visibility = View.VISIBLE
        }
        pullReqListAdapter.submitList(clientResult.data)
    }


    private fun renderLoadingScreen(isLoading: Boolean) {
        if (isLoading) {
            binding.circularProgressView.visibility = View.VISIBLE
        } else {
            binding.circularProgressView.visibility = View.GONE
        }
    }

    private fun renderErrorScreenWithRetry(clientResult: ClientResult.Error) {
        binding.pullReqListRV.visibility = View.GONE
        binding.retryLayoutHolder.retryLayoutCL.visibility = View.VISIBLE
        binding.retryLayoutHolder.retryMessageTV.text = clientResult.error.message
        binding.retryLayoutHolder.retryCTA.setOnClickListener {
            viewModel.getClosedPrsList()
        }
    }

    override fun setListener() {

    }
}