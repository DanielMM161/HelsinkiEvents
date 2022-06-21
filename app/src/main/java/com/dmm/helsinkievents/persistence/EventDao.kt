package com.dmm.helsinkievents.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.dmm.helsinkievents.model.EventCategory

@Dao
interface EventDao {

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun insertEventCategory(eventCategoryList: List<EventCategory>)

	@Query("SELECT * FROM EventCategory WHERE categoryName = :categoryName_ AND page = :page_")
	suspend fun getEventCategory(categoryName_: String, page_: Int) : List<EventCategory>
}