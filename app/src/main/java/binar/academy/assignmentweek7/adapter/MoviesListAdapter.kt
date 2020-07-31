package binar.academy.assignmentweek7.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import binar.academy.assignmentweek7.R
import binar.academy.assignmentweek7.model.ResultsItem
import binar.academy.assignmentweek7.utils.Utils.IMAGE
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_movies.view.*

/**
 * Created by Abika Chairul Yusri
 * on Friday, 31 July 2020
 * Bismillahirrahmanirrahim
 */
class MoviesListAdapter :
    PagedListAdapter<ResultsItem, RecyclerView.ViewHolder>(ResultsItem().DIFF_CALLBACK) {
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
            Glide.with(itemView.context).load(IMAGE + item?.posterPath).into(itemView.ivItemPoster)
        }
    }
}