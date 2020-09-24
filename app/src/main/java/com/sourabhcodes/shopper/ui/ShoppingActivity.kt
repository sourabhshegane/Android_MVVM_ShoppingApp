package com.sourabhcodes.shopper.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.sourabhcodes.shopper.R
import com.sourabhcodes.shopper.data.db.ShoppingDatabase
import com.sourabhcodes.shopper.data.repositories.ShoppingRepository
import com.sourabhcodes.shopper.ui.shoppinglist.ShoppingViewModel
import com.sourabhcodes.shopper.ui.shoppinglist.ShoppingViewModelFactory

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository);
        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)
    }
}