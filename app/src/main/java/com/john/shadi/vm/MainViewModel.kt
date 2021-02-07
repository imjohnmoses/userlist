package com.john.shadi.vm

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.john.shadi.domain.model.UserData
import com.john.shadi.domain.model.UserDataModel
import com.john.shadi.domain.model.response.ErrorModel
import com.john.shadi.domain.usecase.GetAllUserFDbUseCase
import com.john.shadi.domain.usecase.GetAllUserUseCase
import com.john.shadi.domain.usecase.InsertUserUseCase
import com.john.shadi.domain.usecase.UpdateUserUseCase
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val getHomeUseCase: GetAllUserUseCase,
    private val insertUserUseCase: InsertUserUseCase,
    private val getAllUserUseCase: GetAllUserFDbUseCase,
    private val updateUseCase: UpdateUserUseCase
) : ViewModel() {
    private val TAG = MainViewModel::class.java.simpleName
    val homeData: MutableLiveData<UserDataModel> by lazy { MutableLiveData<UserDataModel>() }
    val normalData: MutableLiveData<List<UserData>> by lazy { MutableLiveData<List<UserData>>() }
    val error: MutableLiveData<ErrorModel> by lazy { MutableLiveData<ErrorModel>() }
    val userListCount: MutableLiveData<Int> by lazy { MutableLiveData<Int>() }

    init {

        //returnUser()

        getHomeUseCase.execute {
            onComplete {
                Log.d(TAG, it.toString())
                //homeData.value = it
               insert(it)
            }

            onError { throwable ->
                error.value = throwable
                returnUser()

            }

            onCancel {
                returnUser()
            }
        }
    }


    fun insert(model: UserDataModel) {
        insertUserUseCase.userList = model
        insertUserUseCase.execute {
            onComplete {
                returnUser()
            }
            onError { throwable ->
                error.value = throwable
            }
            onCancel {
            }
        }
    }

    private fun returnUser() {
        getAllUserUseCase.execute {
            onComplete {
                normalData.value=it
                userListCount.value = it.size
            }
            onError {
                error.value = it
            }
        }
    }

     fun updateData(userData: UserData){
        updateUseCase.user = userData
        updateUseCase.execute {
            onComplete {
                returnUser()
            }
            onError { throwable ->
                error.value = throwable
            }
            onCancel {
                it.stackTrace
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        insertUserUseCase.unsubscribe()
        getHomeUseCase.unsubscribe()
        getAllUserUseCase.unsubscribe()
    }
}
