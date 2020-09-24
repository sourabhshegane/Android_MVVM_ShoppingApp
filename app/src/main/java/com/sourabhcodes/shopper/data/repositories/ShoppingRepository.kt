package com.sourabhcodes.shopper.data.repositories

import com.sourabhcodes.shopper.data.db.ShoppingDatabase
import com.sourabhcodes.shopper.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val database: ShoppingDatabase
) {
    suspend fun upsert(item: ShoppingItem) = database.getShoppingDao().upsert(item)
    suspend fun delete(item: ShoppingItem) = database.getShoppingDao().delete(item)
    fun getAllShoppingItems(item: ShoppingItem) = database.getShoppingDao().getShoppingItems()
}