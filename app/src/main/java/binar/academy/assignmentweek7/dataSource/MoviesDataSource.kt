package binar.academy.assignmentweek7.dataSource

import androidx.paging.PageKeyedDataSource
import binar.academy.assignmentweek7.model.ResultsItem
import binar.academy.assignmentweek7.network.ConfigNetwork
import binar.academy.assignmentweek7.network.MoviesService
import binar.academy.assignmentweek7.utils.Utils.API_KEY
import binar.academy.assignmentweek7.utils.Utils.LANG
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

/**
 * Created by Abika Chairul Yusri
 * on Friday, 31 July 2020
 * Bismillahirrahmanirrahim
 */
class MoviesDataSource : PageKeyedDataSource<Long, ResultsItem>() {

    var api: MoviesService = ConfigNetwork.service()

    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ResultsItem>
    ) {
        api.getMovies(API_KEY, LANG, 1, params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                response.results?.let {
                    callback.onResult(it, null, 2L)
                }
            }, {

            })
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {
        api.getMovies(API_KEY, LANG, params.key, params.requestedLoadSize)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                response.results?.let {
                    callback.onResult(it, params.key + 1L)
                }
            }, {

            })
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {

    }
}