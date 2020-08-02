package abika.sinau.assignmentweek7.dataSource

import androidx.paging.PageKeyedDataSource
import abika.sinau.assignmentweek7.model.ResultsItem
import abika.sinau.assignmentweek7.network.ConfigNetwork
import abika.sinau.assignmentweek7.network.MoviesService
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
//        api.getMovies(API_KEY, LANG, 1, params.requestedLoadSize)
        api.getMovies("b64d761def5c00e40e6a36e0032741bf", "en-US", 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                response.results?.let {
                    callback.onResult(it, null, 2L)
                }
            }, { error ->

            })
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {
        api.getMovies("b64d761def5c00e40e6a36e0032741bf", "en-US", params.key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                response.results?.let {
                    callback.onResult(it, params.key + 1L)
                }
            }, { error ->

            })
    }

    override fun loadBefore(params: LoadParams<Long>, callback: LoadCallback<Long, ResultsItem>) {

    }
}