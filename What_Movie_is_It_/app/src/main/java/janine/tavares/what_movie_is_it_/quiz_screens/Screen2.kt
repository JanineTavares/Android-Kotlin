package janine.tavares.what_movie_is_it_.quiz_screens

import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.widget.RadioButton
import janine.tavares.what_movie_is_it_.MainActivity
import janine.tavares.what_movie_is_it_.R
import janine.tavares.what_movie_is_it_.extension.toast
import janine.tavares.what_movie_is_it_.model.QuizManegement
import kotlinx.android.synthetic.main.activity_screen1.*
import kotlinx.android.synthetic.main.activity_screen2.*
import kotlinx.android.synthetic.main.activity_screen2.*

class Screen2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen2)

        QuizManegement.context = this@Screen2

        QuizManegement.generateQuestions()
        QuizManegement.shuffleQuestions()
        getScore()


        buttonNext2.visibility = View.INVISIBLE


        val question = QuizManegement.questionArray.get(0)

        questionTextView2.text = question.question.toString()


        radioButton1Screen2.text = question.option1
        radioButton2Screen2.text = question.option2
        radioButton3Screen2.text = question.option3
        radioButton4Screen2.text = question.option4


        buttonAnswer2.setOnClickListener {
            if (radioGroup2.checkedRadioButtonId == -1) {
                toast(R.string.noneRadioSelected)
            } else {
                buttonNext2.visibility = View.VISIBLE
                buttonAnswer2.visibility = View.INVISIBLE
                val id = radioGroup2.checkedRadioButtonId
                var radio: RadioButton = findViewById(id)
                if (QuizManegement.isCorrect(radio.text.toString())) {
                    QuizManegement.playAudio(R.raw.correct, this)
                    toast(R.string.correctAnswer)
                    getScore()
                } else {
                    QuizManegement.playAudio(R.raw.incorrect, this)
                    toast(R.string.incorrectAnswer)
                }
            }
            }

            buttonNext2.setOnClickListener {
                QuizManegement.stopMedia()
                vibrate()
                startActivity(Intent(this, Screen3::class.java))
                finish()


            }



    }


    fun getScore() {
        textViewScore2.text = QuizManegement.showScore().toString()
    }

    fun vibrate() {
         val pattern = longArrayOf(0, 100, 0)
                 val hardware = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

                 hardware?.let {
                         if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                             hardware.vibrate(VibrationEffect.createWaveform(pattern, -1))
                         } else
                             hardware.vibrate(pattern, -1)
                     }
    }
}



