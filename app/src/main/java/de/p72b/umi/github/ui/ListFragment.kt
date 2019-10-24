package de.p72b.umi.github.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import de.p72b.umi.github.App
import de.p72b.umi.github.R
import de.p72b.umi.github.arch.RepositoryViewModel
import de.p72b.umi.github.services.Repository
import de.p72b.umi.github.utils.Utils
import de.p72b.umi.github.vo.Resource
import de.p72b.umi.github.vo.Status
import kotlinx.android.synthetic.main.fragment_list.*

class ListFragment : Fragment() {
    private lateinit var rootView: View

    private lateinit var repositoriesViewModel: RepositoryViewModel
    private lateinit var adapter: ListAdapter

    companion object {
        val TAG: String = ListFragment::class.java.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_list, null)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()

        repositoriesViewModel = ViewModelProviders.of(this).get(RepositoryViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        getRepositories()
    }

    private fun initViews() {
        vSwipeRefresh.setOnRefreshListener { getRepositories() }
        adapter =
            ListAdapter(App.sInstance,
                object : ListAdapter.AdapterListener {
                    override fun onRepositoryClicked(repository: Repository) {
                        (activity as RepositoryActivity).showDetails(repository)
                    }
                })
        vRecyclerView.adapter = adapter
        vRecyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun getRepositories() {
        vSwipeRefresh.isRefreshing = true
        repositoriesViewModel.allRepositories.observe(this,
            Observer<Resource<List<Repository>>> { resource ->
                vSwipeRefresh.isRefreshing = false
                when (resource.status) {
                    Status.SUCCESS -> resource.data?.let {
                        adapter.setData(it)
                    }
                    Status.ERROR -> resource.message?.let {
                        Utils.showSnackbar(rootView, it)
                    }
                }

            })
    }
}