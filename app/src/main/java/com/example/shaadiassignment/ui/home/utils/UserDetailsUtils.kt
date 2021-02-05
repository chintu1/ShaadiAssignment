package com.example.shaadiassignment.ui.home.utils

import com.example.shaadiassignment.data.model.userdetailmodels.Name
import com.example.shaadiassignment.data.model.userdetailmodels.Result

object UserDetailsUtils {

    fun getUserName(name:Name):String{
        return name.first+" "+name.last
    }

    fun getUserDetailForDashboard(result: Result):String{
        return result.location.city+", "+result.location.state+", "+result.location.country
    }
}