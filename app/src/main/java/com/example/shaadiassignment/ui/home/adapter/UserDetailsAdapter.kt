package com.example.shaadiassignment.ui.home.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.RecyclerView
import com.example.shaadiassignment.R
import com.example.shaadiassignment.data.model.userdetailmodels.Result
import com.example.shaadiassignment.databinding.UserDetailRowLayoutBinding
import com.example.shaadiassignment.ui.home.`interface`.UserActionClickListener
import com.example.shaadiassignment.ui.home.diffutil.UserDiffUtil
import com.example.shaadiassignment.ui.home.utils.UserDetailsUtils
import com.example.shaadiassignment.util.loadImage

class UserDetailsAdapter(val userActionClickListener: UserActionClickListener) : RecyclerView.Adapter<UserDetailsAdapter.UserViewHolder>() {

    lateinit var context: Context
    private val mDiffer = AsyncListDiffer(this, UserDiffUtil())
    lateinit var userDetailRowLayoutBinding: UserDetailRowLayoutBinding

    inner class UserViewHolder(private val userDetailRowLayoutBinding: UserDetailRowLayoutBinding) : RecyclerView.ViewHolder(userDetailRowLayoutBinding.root) {
        init {
            userDetailRowLayoutBinding.connectActionTextview.setOnClickListener(View.OnClickListener { userActionClickListener.onAcceptButtonClick() })
            userDetailRowLayoutBinding.ignoreActionTextview.setOnClickListener(View.OnClickListener { userActionClickListener.onIgnoreButtonClick() })
        }
        fun bind(result: Result) {
            userDetailRowLayoutBinding.usernameTextview.setText(UserDetailsUtils.getUserName(result.name))
            userDetailRowLayoutBinding.userDpImageview.loadImage(context, result.picture.medium, R.color.placeholder_color)
            userDetailRowLayoutBinding.userDetailTextview.setText(UserDetailsUtils.getUserDetailForDashboard(result))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        userDetailRowLayoutBinding = UserDetailRowLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return UserViewHolder(userDetailRowLayoutBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(mDiffer.currentList.get(position))
    }

    override fun getItemCount(): Int {
        return mDiffer.currentList.size
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        context = recyclerView.context
    }

    fun setData(userDetails: List<Result>) {
        mDiffer.submitList(userDetails)
    }
}