package com.example.quizapp10

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ResultPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_page)

        var nameTextView: TextView = findViewById(R.id.nameTextView)
        var scoreTextView: TextView = findViewById(R.id.scoreTextView)
        var finishBtn: Button = findViewById(R.id.finishButton)
        var trophyImg: ImageView = findViewById(R.id.trophyImage)



        nameTextView?.text = intent.getStringExtra(Constants.USER_NAME)
        trophyImg.setImageResource(R.drawable.trophy_image)
        scoreTextView?.text = "Your Score is ${intent.getIntExtra(Constants.CORRECT_ANSWERS,0)} out of ${intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)}"


        finishBtn.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
    }
}