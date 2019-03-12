package com.example.buttonclickapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.method.ScrollingMovementMethod
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

private const val TAG = "MainActivity"
private const val TEXT_CONTENT = "TextContent"

class MainActivity : AppCompatActivity() {
    private var textView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val userInput: EditText = findViewById(R.id.editText)
        userInput.text.clear()
        val button: Button = findViewById(R.id.button)
        textView = findViewById(R.id.textView)
        textView?.text = ""
        textView?.movementMethod = ScrollingMovementMethod()
        button.setOnClickListener {
            textView?.append(userInput.text)
            textView?.append("\n")
            userInput.text.clear()
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.e(TAG, "onsave instance state called")
        super.onSaveInstanceState(outState)
        outState?.putString(TEXT_CONTENT, textView?.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.e(TAG, savedInstanceState?.getString(TEXT_CONTENT, ""))
        Log.e(TAG, "onrestore instance state called")
        textView?.text = savedInstanceState?.getString(TEXT_CONTENT, "")
    }
}
