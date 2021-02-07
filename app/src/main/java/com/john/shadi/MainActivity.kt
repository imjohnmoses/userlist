package com.john.shadi

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.john.shadi.domain.model.UserData
import com.john.shadi.domain.model.UserDataModel
import com.john.shadi.ui_helper.HomeAdapter
import com.john.shadi.vm.MainViewModel
import com.john.shadi.vm.ViewModelFactory
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(), HomeAdapter.OnClickReference {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    lateinit var viewModel: MainViewModel
    val adapter: HomeAdapter by lazy { HomeAdapter(arrayListOf()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        adapter.setListener(this)
        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
        with(viewModel) {
            homeData.observe(this@MainActivity, Observer {
                //initView(it)
            }
            )
            normalData.observe(this@MainActivity, Observer {
                initView(it)
            }
            )
            error.observe(this@MainActivity, Observer {
                progressBar_home.visibility = View.GONE
                Toast.makeText(this@MainActivity, "${it?.message}", Toast.LENGTH_LONG).show()
            })

            userListCount.observe(this@MainActivity, Observer {
                Toast.makeText(this@MainActivity, "you have $it user list in your dataBase !!", Toast.LENGTH_LONG)
                    .show()
            })

        }
    }
    private fun initView(it: List<UserData>?) {
        rv_main_home.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_main_home.adapter = adapter
        progressBar_home.visibility= View.GONE
        if (it!!.isNotEmpty()) {
            adapter.clear()
            adapter.add(it)

        }else{
            Toast.makeText(this, "No data", android.widget.Toast.LENGTH_LONG).show()
        }
    }

    override fun onClickUser(userData: UserData) {
        viewModel.updateData(userData)
    }
}