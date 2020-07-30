package binar.academy.assignmentweek7.network

import binar.academy.assignmentweek7.model.ResponseMovies
import io.reactivex.rxjava3.core.Flowable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Abika Chairul Yusri
 * on Friday, 31 July 2020
 * Bismillahirrahmanirrahim
 */
interface MoviesService {
    @GET("/movie/5/lists")
    fun getMovies(
        @Query("api_key") apiKey: String,
        @Query("language") lang: String,
        @Query("page") page: Long,
        @Query("total_result") tResult: Int
    ): Flowable<ResponseMovies>
}