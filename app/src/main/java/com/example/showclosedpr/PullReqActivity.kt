package com.example.showclosedpr

import android.content.Intent
import androidx.activity.viewModels
import com.example.com.example.showclosedpr.BaseActivity
import com.example.domain.ClientResult
import com.example.showclosedpr.com.example.showclosedpr.viewModels.PullReqViewModel
import com.example.showclosedpr.databinding.ActivityPullReqBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class PullReqActivity : BaseActivity<ActivityPullReqBinding>(R.layout.activity_pull_req) {

    private val viewModel: PullReqViewModel by viewModels()


    override fun readArguments(extras: Intent) {

    }

    override fun setupUi() {

    }

    override fun observeData() {

        collectEvent(viewModel.closePrsList) {
            when (it) {
                is ClientResult.Success -> {
                    binding.listSizeTV.text = it.data.size.toString()
                }
            }
        }
    }

    override fun setListener() {

    }
}