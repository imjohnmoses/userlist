package com.john.shadi.data.source.db

import androidx.room.*
import com.john.shadi.domain.model.UserData
import com.john.shadi.domain.model.UserDataModel

@Dao
interface UserDataDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(data: UserData): Long

    @Delete
   suspend fun deleteUser(data: UserData): Int

    @Query("SELECT * from userdata")
   suspend fun selectAllUser(): MutableList<UserData>

  /*  @Query("UPDATE userdata SET stat=:value WHERE tid = :id")
   suspend fun update(id:Int, value:Int):Long*/


}