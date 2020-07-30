package binar.academy.assignmentweek7.dataSource.factory

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import binar.academy.assignmentweek7.dataSource.MoviesDataSource
import binar.academy.assignmentweek7.model.ResultsItem

/**
 * Created by Abika Chairul Yusri
 * on Friday, 31 July 2020
 * Bismillahirrahmanirrahim
 */
class MoviesDataFactory : DataSource.Factory<Long, ResultsItem>() {

    var mutableLiveData: MutableLiveData<MoviesDataSource> = MutableLiveData()
    var moviesDataSource: MoviesDataSource = MoviesDataSource()

    override fun create(): DataSource<Long, ResultsItem> {
        mutableLiveData.postValue(moviesDataSource)
        return moviesDataSource
    }
}