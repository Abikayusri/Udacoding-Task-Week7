package binar.academy.assignmentweek7.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import binar.academy.assignmentweek7.R
import binar.academy.assignmentweek7.adapter.MoviesListAdapter
import binar.academy.assignmentweek7.model.ResultsItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel : MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getMovies()
        attachObserve()
    }

    private fun attachObserve() {

        viewModel.moviesData.observe(this, Observer {
            showData(it)
        })
    }

    private fun showData(it: PagedList<ResultsItem>?) {

        val adapter = MoviesListAdapter()
        adapter.submitList(it)
        rvMain.adapter = adapter
    }
}