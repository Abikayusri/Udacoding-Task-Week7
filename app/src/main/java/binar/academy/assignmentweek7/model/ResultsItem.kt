package binar.academy.assignmentweek7.model

import androidx.recyclerview.widget.DiffUtil
import com.google.gson.annotations.SerializedName

data class ResultsItem(

    @field:SerializedName("item_count")
    val itemCount: Int? = null,

    @field:SerializedName("list_type")
    val listType: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("favorite_count")
    val favoriteCount: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("iso_639_1")
    val iso6391: String? = null,

    @field:SerializedName("poster_path")
    val posterPath: String? = null,

    var DIFF_CALLBACK: DiffUtil.ItemCallback<ResultsItem> = object :
        DiffUtil.ItemCallback<ResultsItem>() {
        override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
            return oldItem == newItem
        }

    }
)