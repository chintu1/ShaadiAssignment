package com.example.shaadiassignment.ui.home.diffutil

import androidx.recyclerview.widget.DiffUtil
import com.example.shaadiassignment.data.model.userdetailmodels.Result

class UserDiffUtil : DiffUtil.ItemCallback<Result>() {
    override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean {
       return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean {
        return oldItem==newItem
    }
}