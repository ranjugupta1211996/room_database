package com.ranju.roomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ranju.roomapp.data.remote.GroupViewModel
import com.ranju.roomapp.data.remote.model.Baseurl
import com.ranju.roomapp.data.remote.model.Group
import com.ranju.roomapp.list.GroupWithBaseUrl
import com.ranju.roomapp.list.ListAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel: GroupViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ListAdapter()
        recycler_view.adapter = adapter
        recycler_view.layoutManager = LinearLayoutManager(this)
        viewModel.allGroups.observe(this) { list: List<Group> ->
            viewModel.allUrls.observe(this) { baseurl ->
                Log.d("HK", baseurl.toString())
                adapter.submitList(list.map {
                    GroupWithBaseUrl(
                        group = it,
                        baseurl = baseurl
                    )
                })
            }
        }
    }
}