package binar.academy.assignmentweek7.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import binar.academy.assignmentweek7.R
import binar.academy.assignmentweek7.model.ResultsItem
import binar.academy.assignmentweek7.utils.Utils.IMAGE
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.item_movies.view.*

/**
 * Created by Abika Chairul Yusri
 * on Friday, 31 July 2020
 * Bismillahirrahmanirrahim
 */
class MoviesListAdapter :
    PagedListAdapter<ResultsItem, RecyclerView.ViewHolder>(DIFF_CALLBACK) {


    companion object {

        var DIFF_CALLBACK: DiffUtil.ItemCallback<ResultsItem> = object :
            DiffUtil.ItemCallback<ResultsItem>() {
            override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movies, parent, false)
        return MoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (holder is MoviesViewHolder) {
            holder.bindTo(getItem(position))
        }
    }

    class MoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindTo(item: ResultsItem?) {
            itemView.tvItemTitle.text = item?.name
            itemView.tvItemLang.text = item?.iso6391
            itemView.tvItemVotes.text = item?.itemCount.toString()
            Glide.with(itemView.context).load(IMAGE + item?.posterPath)
                .listener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        itemView.pbItem.visibility = View.GONE
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        itemView.pbItem.visibility = View.GONE
                        return false
                    }

                })
                .error(R.drawable.ic_launcher_background)
                .into(itemView.ivItemPoster)
        }
    }
}