package com.mehedi.nasaapiastoroiedradar.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ImageOfTheDayDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertImageOfTheDay(image: ImageOfTheDayEntity)

    @Query("SELECT * FROM image_of_the_day WHERE date = :date")
    fun getImageOfTheDayByDate(date: String): Flow<ImageOfTheDayEntity?>

    @Query("SELECT * FROM image_of_the_day")
    fun getAllImagesOfTheDay(): Flow<List<ImageOfTheDayEntity>>
}
