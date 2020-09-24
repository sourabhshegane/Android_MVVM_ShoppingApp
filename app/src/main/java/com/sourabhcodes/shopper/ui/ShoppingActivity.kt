package com.sourabhcodes.shopper.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.sourabhcodes.shopper.R
import com.sourabhcodes.shopper.data.db.ShoppingDatabase
import com.sourabhcodes.shopper.data.db.entities.ShoppingItem
import com.sourabhcodes.shopper.data.repositories.ShoppingRepository
import com.sourabhcodes.shopper.other.ShoppingItemAdapter
import com.sourabhcodes.shopper.ui.shoppinglist.AddShoppingListDialog
import com.sourabhcodes.shopper.ui.shoppinglist.DialogListener
import com.sourabhcodes.shopper.ui.shoppinglist.ShoppingViewModel
import com.sourabhcodes.shopper.ui.shoppinglist.ShoppingViewModelFactory
import kotlinx.android.synthetic.main.activity_shopping.*

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repository = ShoppingRepository(database)
        val factory = ShoppingViewModelFactory(repository)
        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingItemAdapter(listOf(), viewModel)
        rvShoppingItems.layoutManager = LinearLayoutManager(this)
        rvShoppingItems.adapter = adapter

        viewModel.getAllItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        fab.setOnClickListener {
            AddShoppingListDialog(this,
                object : DialogListener {
                    override fun onAddButtonClicked(item: ShoppingItem) {
                        viewModel.upsert(item)
                    }
                }).show()
        }
    }
}