package de.p72b.umi.github.activity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import de.p72b.umi.github.R
import de.p72b.umi.github.arch.RepositoryViewModel
import de.p72b.umi.github.services.Repository
import kotlinx.android.synthetic.main.activity_main.*


class RepositoryListActivity : AppCompatActivity() {

    private lateinit var repositoriesViewModel: RepositoryViewModel
    private lateinit var adapter: RepositoryListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        repositoriesViewModel = ViewModelProviders.of(this).get(RepositoryViewModel::class.java)
    }

    private fun initViews() {
        vSwipeRefresh.setOnRefreshListener { getRepositories() }
        adapter =
            RepositoryListAdapter(this,
                object : RepositoryListAdapter.AdapterListener {
                    override fun onRepositoryClicked(repository: Repository) {
                        // TODO: open details view here
                    }
                })
        vRecyclerView.adapter = adapter
        vRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun getRepositories() {
        vSwipeRefresh.isRefreshing = true
        repositoriesViewModel.allRepositories.observe(this,
            Observer<List<Repository>> { items ->
                vSwipeRefresh.isRefreshing = false
                adapter.setData(items)
            })
    }
}
