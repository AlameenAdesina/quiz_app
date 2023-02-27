package com.example.quizapp10

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), View.OnClickListener {



    private var currentPosition:Int = 1
    private var questionsListArr: ArrayList<Question>? = null
    private var selectedOption: Int = 0
    private var myUsername: String? = null
    private var noOfCorrectAnswers: Int = 0




    private var progressBar: ProgressBar? = null
    private var progressTV: TextView? = null
    private var questionTV: TextView? = null
    private var imageV: ImageView? = null
    private var submitBtn: Button? = null

    private var optionOneTV: TextView? = null
    private var optionTwoTV: TextView? = null
    private var optionThreeTV: TextView? = null
    private var optionFourTV: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressBar = findViewById(R.id.progressBar)
        progressTV = findViewById(R.id.progressTextView)
        questionTV = findViewById(R.id.questionTextView)
        imageV = findViewById(R.id.flagImage)
        submitBtn = findViewById(R.id.submitBtn)
        myUsername = intent.getStringExtra(Constants.USER_NAME)


        optionOneTV = findViewById(R.id.option1)
        optionTwoTV = findViewById(R.id.option2)
        optionThreeTV = findViewById(R.id.option3)
        optionFourTV = findViewById(R.id.option4)

        optionOneTV?.setOnClickListener(this)
        optionTwoTV?.setOnClickListener(this)
        optionThreeTV?.setOnClickListener(this)
        optionFourTV?.setOnClickListener(this)
        submitBtn?.setOnClickListener(this)

        questionsListArr = Constants.getQuestions()

        setQuestion()


    }

    private fun setQuestion() {


        defaultOptionView()
        val question: Question = questionsListArr!![currentPosition - 1]
        imageV?.setImageResource(question.image)
        progressBar?.progress = currentPosition
        progressTV?.text = "{$currentPosition/${progressBar?.max}}"
        questionTV?.text = question.question
        optionOneTV?.text = question.optionOne
        optionTwoTV?.text = question.optionTwo
        optionThreeTV?.text = question.optionThree
        optionFourTV?.text = question.optionFour

        if(currentPosition == questionsListArr!!.size){
            submitBtn?.text = "FINISH"
        }else{
            submitBtn?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()

        optionOneTV?.let {
            options.add(0,it)
        }
        optionTwoTV?.let {
            options.add(1,it)
        }
        optionThreeTV?.let {
            options.add(2,it)
        }
        optionFourTV?.let {
            options.add(3,it)
        }


        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.option_default_border)
        }

    }

    private fun selectedOptionView(textView: TextView, selectedOptionNo:Int){
        defaultOptionView()

        selectedOption = selectedOptionNo

        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface,Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this,R.drawable.option_selected_border)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option1 -> {
                optionOneTV?.let {
                    selectedOptionView(it,1)
                }
            }
            R.id.option2 -> {
                optionTwoTV?.let {
                    selectedOptionView(it,2)
                }
            }
            R.id.option3 -> {
                optionThreeTV?.let {
                    selectedOptionView(it,3)
                }
            }
            R.id.option4 -> {
                optionFourTV?.let {
                    selectedOptionView(it,4)
                }
            }

            R.id.submitBtn ->{
                //TODO "Implement Submit Btn"

                if (selectedOption == 0){
                    currentPosition++

                    when{
                        currentPosition <= questionsListArr!!.size -> {setQuestion()}

                        else ->{

                            val intent = Intent(this,ResultPage::class.java)
                            intent.putExtra(Constants.USER_NAME,myUsername)
                            intent.putExtra(Constants.CORRECT_ANSWERS, noOfCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, questionsListArr?.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                }else{
                    val question = questionsListArr?.get(currentPosition - 1)

                    if(question!!.correctAnswer != selectedOption){
                        answerView(selectedOption,R.drawable.option_wrong_border)
                    }else{
                        noOfCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.option_correct_border)

                    if(currentPosition == questionsListArr!!.size){
                        submitBtn?.text = "FINISH"
                    }
                    else{
                        submitBtn?.text = "GO TO NEXT QUESTION"
                    }

                    selectedOption = 0

                }
            }
        }

    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
            1 -> {optionOneTV?.background = ContextCompat.getDrawable(this,drawableView)}
            2 -> {optionTwoTV?.background = ContextCompat.getDrawable(this,drawableView)}
            3 -> {optionThreeTV?.background = ContextCompat.getDrawable(this,drawableView)}
            4 -> {optionFourTV?.background = ContextCompat.getDrawable(this,drawableView)}
        }
    }
}