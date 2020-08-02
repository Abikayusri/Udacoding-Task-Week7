package abika.sinau.assignmentweek7.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.LivePagedListBuilder
import abika.sinau.assignmentweek7.dataSource.factory.MoviesDataFactory
import abika.sinau.assignmentweek7.model.ResultsItem
import java.util.concurrent.Executor
import java.util.concurrent.Executors

/**
 * Created by Abika Chairul Yusri
 * on Friday, 31 July 2020
 * Bismillahirrahmanirrahim
 */
class MainViewModel: ViewModel() {

    var executor: Executor = Executors.newFixedThreadPool(5)
    var moviesData: LiveData<PagedList<ResultsItem>>

    init {
        val moviesFactory = MoviesDataFactory()
        val pageListConfig = PagedList.Config.Builder()
            .setPageSize(20)
            .setInitialLoadSizeHint(10)
            .setEnablePlaceholders(false)
            .build()

        moviesData = LivePagedListBuilder(moviesFactory, pageListConfig).setFetchExecutor(executor).build()
    }

    fun getMovies() : LiveData<PagedList<ResultsItem>> {
        return moviesData
    }
}