package com.sourabhcodes.shopper.utilities

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sourabhcodes.shopper.model.ShoppingItem

@Dao
interface ShoppingDataAccessObject {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item : ShoppingItem)

    @Delete
    suspend fun delete(item : ShoppingItem)

    @Query("SELECT * from shopping_items")
    suspend fun getShoppingItems():LiveData<List<ShoppingItem>>
}