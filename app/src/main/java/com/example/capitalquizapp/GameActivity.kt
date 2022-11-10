package com.example.capitalquizapp


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.ColorStateList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toDrawable
import com.example.capitalquizapp.databinding.ActivityGameBinding
import com.google.android.material.snackbar.Snackbar


class GameActivity : AppCompatActivity() {
    private lateinit var
            binding: ActivityGameBinding
    private val questions = Constants.porvideQuestions().shuffled()
    private var count = 0
    private var selectedAnswerId = -1
    private var currentQuestionId = -1






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.apply {
            binding.progressBar.progress=1
            binding.progressBar.max=questions.size

        }

        currentQuestionId = 0
        setQuestion()

        binding.btnSubmit.text="Submit"



        binding.apply {


            btn1.setOnClickListener {

                optionSelected(btn1)
                selectedAnswerId = 0

            }
            btn2.setOnClickListener {

                optionSelected(btn2)
                selectedAnswerId = 1
            }
            btn3.setOnClickListener {

                optionSelected(btn3)
                selectedAnswerId = 2
            }
            btn4.setOnClickListener {

                optionSelected(btn4)
                selectedAnswerId = 3
            }

            btnSubmit.setOnClickListener {


                binding.apply {
                    btn1.isEnabled = true
                    btn2.isEnabled = true
                    btn3.isEnabled = true
                    btn4.isEnabled = true
                }





                when (btnSubmit.text) {
                    getString(R.string.text_submit) -> checkAnswer()
                    getString(R.string.text_finish) -> {


                        val intent=Intent(this@GameActivity,JuwaplarSani::class.java)
                        intent.putExtra("My_juwap",count.toString())
                        startActivity(intent)
                        finish()

                    }
                    getString(R.string.continue_text) -> {
                        binding.apply {
                            btn1.backgroundTintList = ColorStateList.valueOf(
                                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
                            )
                            btn2.backgroundTintList = ColorStateList.valueOf(
                                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
                            )
                            btn3.backgroundTintList = ColorStateList.valueOf(
                                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
                            )
                            btn4.backgroundTintList = ColorStateList.valueOf(
                                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
                            )
                        }
                        currentQuestionId++
                        setQuestion()

                    }
                }
            }

        }



    }

    private fun setQuestion() {
        val currentQuestions = questions[currentQuestionId]


        binding.progressBar.progress=currentQuestionId+1
        binding.progressBar.max=questions.size
        binding.textProgress.text="${currentQuestionId+1}"+"/"+"${questions.size}"



        binding.apply {

            tvQuestion.setImageResource(currentQuestions.question)
            btn1.text = currentQuestions.answers[0]
            btn2.text = currentQuestions.answers[1]
            btn3.text = currentQuestions.answers[2]
            btn4.text = currentQuestions.answers[3]

            btn1.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )
            btn2.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )
            btn3.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )
            btn4.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )


            btnSubmit.text = getString(R.string.text_submit)
        }
    }

    private fun optionSelected(button: Button) {
        binding.apply {
            btn1.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )
            btn2.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )
            btn3.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )
            btn4.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this@GameActivity, R.color.tranparent_color)
            )
        }

        button.backgroundTintList = ColorStateList.valueOf(
            ContextCompat.getColor(this, R.color.color_option_selected)
        )
    }

    private fun checkAnswer() {
        val currentQuestion = questions[currentQuestionId]

        if(selectedAnswerId==currentQuestion.correctAnswerId){
            count++
        }

        if (selectedAnswerId == -1) {
            Snackbar.make(
                binding.btnSubmit,
                "Variant saylanbadi!",
                Snackbar.LENGTH_SHORT
            ).show()
            return
        }


        binding.apply {
            when (selectedAnswerId) {
                0 -> {
                    btn1.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.error_color)
                    )
                }
                1 -> {
                    btn2.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.error_color)
                    )
                }
                2 -> {
                    btn3.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.error_color)
                    )
                }
                3 -> {
                    btn4.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.error_color)
                    )
                }
            }

            when (currentQuestion.correctAnswerId) {
                0 -> {
                    btn1.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.correct_color)
                    )
                }
                1 -> {
                    btn2.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.correct_color)
                    )
                }
                2 -> {
                    btn3.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.correct_color)
                    )
                }
                3 -> {
                    btn4.backgroundTintList = ColorStateList.valueOf(
                        ContextCompat.getColor(this@GameActivity, R.color.correct_color)
                    )
                }
            }

            if(currentQuestionId!=questions.lastIndex){
                btnSubmit.text=getString(R.string.continue_text)
            }
            else{
                btnSubmit.text=getString(R.string.text_finish)
            }



            btn1.isEnabled = false
            btn2.isEnabled = false
            btn3.isEnabled = false
            btn4.isEnabled = false

        }



selectedAnswerId = -1




    }





}




