package com.example.qrcommunicator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText

class ResultActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val editTextResult:EditText=findViewById(R.id.edit_text_result)
        val intent=intent

        if(intent.extras!=null){
            editTextResult.setText(intent.getStringExtra("Result"))
        }

    }


}