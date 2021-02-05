package com.example.shaadiassignment.data.local.dao

import androidx.room.*
import com.example.shaadiassignment.data.model.userdetailmodels.Result
import org.intellij.lang.annotations.Flow


@Dao
interface UserDetailDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllUserDetails(results: List<Result>)

    @Transaction
    open suspend fun updateUsersData(users: List<Result>) {
        deleteAllUserDetails()
        insertAllUserDetails(users)
    }

    @Query("SELECT * FROM RESULT")
    suspend fun getAllUserDetails():List<Result>

    @Query("DELETE FROM Result")
    suspend fun deleteAllUserDetails()

}