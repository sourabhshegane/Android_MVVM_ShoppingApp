package com.sourabhcodes.shopper.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sourabhcodes.shopper.data.db.entities.ShoppingItem

@Dao
interface ShoppingDataAccessObject {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item : ShoppingItem)

    @Delete
    suspend fun delete(item : ShoppingItem)

    @Query("SELECT * from shopping_items")
    fun getShoppingItems():LiveData<List<ShoppingItem>>
}