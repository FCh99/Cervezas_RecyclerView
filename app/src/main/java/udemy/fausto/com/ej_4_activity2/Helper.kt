package udemy.fausto.com.ej_4_activity2

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

class Helper {
}

fun View.hideKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}