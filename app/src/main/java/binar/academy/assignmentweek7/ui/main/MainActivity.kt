package binar.academy.assignmentweek7.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import binar.academy.assignmentweek7.R
import binar.academy.assignmentweek7.adapter.MoviesListAdapter
import binar.academy.assignmentweek7.model.ResultsItem
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        viewModel.getMovies()
        shimmerFrameLayout.startShimmer()
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
        android.os.Handler().postDelayed(Runnable {
            shimmerFrameLayout.visibility = View.GONE
            rvMain.visibility = View.VISIBLE
            rvMain.adapter = adapter
        }, 3000)
    }

    override fun onStart() {
        shimmerFrameLayout.startShimmer()
        super.onStart()
    }

    override fun onResume() {
        shimmerFrameLayout.startShimmer()
        super.onResume()
    }

    override fun onPause() {
        shimmerFrameLayout.stopShimmer()
        super.onPause()
    }
}