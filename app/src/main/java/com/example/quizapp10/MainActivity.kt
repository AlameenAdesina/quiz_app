package com.example.quizapp10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.startBtn)
        val nameEditText: EditText = findViewById(R.id.nameEditTxt)



        startButton.setOnClickListener{
            if(nameEditText.text.isEmpty()){
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_LONG).show()
            }
            else{
                val intent = Intent(this, QuizQuestionsActivity::class.java)

                intent.putExtra(Constants.USER_NAME, nameEditText.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}