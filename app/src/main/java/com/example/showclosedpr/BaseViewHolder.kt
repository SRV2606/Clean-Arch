package com.example.com.example.showclosedpr

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(viewBinding: ViewDataBinding) :
    RecyclerView.ViewHolder(viewBinding.root) {
    abstract fun setItem(
        data: T?,
        itemClickListener: (View, T?, Int, Any?) -> Unit
    )
}