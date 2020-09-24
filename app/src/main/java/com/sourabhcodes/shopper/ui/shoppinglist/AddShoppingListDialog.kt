package com.sourabhcodes.shopper.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatDialog
import com.sourabhcodes.shopper.R
import com.sourabhcodes.shopper.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingListDialog(context: Context, var dialogListener: DialogListener) :
    AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        tvAdd.setOnClickListener {

            if (!etName.text.toString().isNullOrEmpty() && !etAmount.text.toString()
                    .isNullOrEmpty()
            ) {
                val name = etName.text.toString()
                val amount = etAmount.text.toString().toInt()
                val item = ShoppingItem(name, amount)
                dialogListener.onAddButtonClicked(item)
                dismiss()
            }
        }

        tvCancel.setOnClickListener {
            cancel()
        }
    }
}