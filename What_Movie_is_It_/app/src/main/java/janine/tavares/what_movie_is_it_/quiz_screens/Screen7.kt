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
import janine.tavares.what_movie_is_it_.R
import janine.tavares.what_movie_is_it_.extension.toast
import janine.tavares.what_movie_is_it_.model.QuizManegement
import kotlinx.android.synthetic.main.activity_screen7.*

class Screen7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen7)

        QuizManegement.context = this@Screen7

        QuizManegement.generateQuestions()
        QuizManegement.shuffleQuestions()
        getScore()

        buttonNext7.visibility = View.INVISIBLE


        val question = QuizManegement.questionArray.get(0)

        questionTextView7.text = question.question.toString()


        radioButton1Screen7.text = question.option1
        radioButton2Screen7.text = question.option2
        radioButton3Screen7.text = question.option3
        radioButton4Screen7.text = question.option4

        buttonAnswer7.setOnClickListener {
            if (radioGroup7.checkedRadioButtonId == -1) {
                toast(R.string.noneRadioSelected)
            } else {
                buttonNext7.visibility = View.VISIBLE
                buttonAnswer7.visibility = View.INVISIBLE
                val id = radioGroup7.checkedRadioButtonId
                var radio: RadioButton = findViewById(id)
                if (QuizManegement.isCorrect(radio.text.toString())) {
                    QuizManegement.playAudio(R.raw.tela7correct, this)
                    toast(R.string.correctAnswer)
                    getScore()
                } else {
                    QuizManegement.playAudio(R.raw.incorrect, this)
                    toast(R.string.incorrectAnswer)
                }
            }
            }

            buttonNext7.setOnClickListener {
                QuizManegement.stopMedia()
                vibrate()
                startActivity(Intent(this, FinalScreen::class.java))
                finish()


            }



    }



    fun getScore() {
        textViewScore7.text = QuizManegement.showScore().toString()
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