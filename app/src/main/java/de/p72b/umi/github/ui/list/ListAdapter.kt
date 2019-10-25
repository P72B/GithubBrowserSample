package de.p72b.umi.github.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.p72b.umi.github.R
import de.p72b.umi.github.services.Repository

class ListAdapter(
    context: Context, private val listener: AdapterListener
) : RecyclerView.Adapter<ListAdapter.RepositoryViewHolder>() {

    private val inflater = LayoutInflater.from(context)
    private var list: List<Repository>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        val viewItem = inflater.inflate(R.layout.recyclerview_repository_item, parent, false)
        return RepositoryViewHolder(
            viewItem
        )
    }

    override fun getItemCount(): Int {
        return when (list) {
            null -> 0
            else -> list!!.size
        }
    }

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) {
        val item = list!![position]
        holder.root.setOnClickListener {
            listener.onRepositoryClicked(item)
        }
        holder.name.text = item.name
        item.owner?.let {
            holder.owner.text = it.login
        }
        holder.stars.text = item.stargazersCount.toString()
    }

    fun setData(items: List<Repository>) {
        list = items
        notifyDataSetChanged()
    }

    class RepositoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val root: View = itemView.findViewById(R.id.vItemRoot)
        val name: TextView = itemView.findViewById(R.id.vName)
        val owner: TextView = itemView.findViewById(R.id.vOwner)
        val stars: TextView = itemView.findViewById(R.id.vStars)
    }

    interface AdapterListener {
        fun onRepositoryClicked(repository: Repository)
    }
}