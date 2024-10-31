package com.example.checkbox_snackbar_1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

                 private lateinit var editText: EditText
                 private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)


    }

        @SuppressLint("SetTextI18n")
        fun clearText(v: View) {

            hideKeyboard()

           val snackbar = Snackbar.make(v, "Подтвердите удаление", Snackbar.LENGTH_LONG)
                .setAction("Удалить") {
                    editText.text.clear();textView.setText("_________________")
                   Snackbar.make(v,"Данные удалены",Snackbar.LENGTH_LONG).show()

                }
            snackbar.setActionTextColor(Color.RED).show() }

        fun saveText(s: View) { textView.text = editText.text; editText.text.clear() }

        private fun hideKeyboard(){

            val view = this.currentFocus
            if (view != null) {
                val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view.windowToken, 0) }
        }


}


