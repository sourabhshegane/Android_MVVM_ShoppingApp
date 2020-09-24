package com.sourabhcodes.shopper.ui.shoppinglist

import com.sourabhcodes.shopper.data.db.entities.ShoppingItem

interface DialogListener {
    fun onAddButtonClicked(item: ShoppingItem)
}