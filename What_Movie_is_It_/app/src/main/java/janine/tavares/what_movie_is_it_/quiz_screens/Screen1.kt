package janine.tavares.what_movie_is_it_.quiz_screens

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.provider.MediaStore
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.isNotEmpty
import janine.tavares.what_movie_is_it_.MainActivity
import janine.tavares.what_movie_is_it_.R
import janine.tavares.what_movie_is_it_.extension.toast
import janine.tavares.what_movie_is_it_.model.Question
import janine.tavares.what_movie_is_it_.model.QuizManegement
import kotlinx.android.synthetic.main.activity_screen1.*
import kotlinx.android.synthetic.main.activity_screen2.*


class Screen1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen1)

        QuizManegement.context = this@Screen1
        QuizManegement.generateQuestions()
        QuizManegement.shuffleQuestions()

        val question = QuizManegement.questionArray.get(0)

        questionTextView1.text = question.question.toString()

        getScore()

        buttonNext1.visibility = View.INVISIBLE






        radioButton1Screen1.text = question.option1
        radioButton2Screen1.text = question.option2
        radioButton3Screen1.text = question.option3
        radioButton4Screen1.text = question.option4



        buttonAnswer1.setOnClickListener {
            if (radioGroup1.checkedRadioButtonId == -1) {
                toast(R.string.noneRadioSelected)
            } else {
                buttonNext1.visibility = View.VISIBLE
                buttonAnswer1.visibility = View.INVISIBLE
                val id = radioGroup1.checkedRadioButtonId
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
            buttonNext1.setOnClickListener {
                QuizManegement.stopMedia()
                vibrate()
                startActivity(Intent(this, Screen2::class.java))
                finish()



            }
        }










    fun vibrate() {
        val pattern = longArrayOf(0, 100, 0)
        val hardware = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            hardware.vibrate(VibrationEffect.createWaveform(pattern, -1))
        } else
            hardware.vibrate(pattern, -1)
    }



    fun getScore() {
        textViewScore1.text = QuizManegement.showScore().toString()
    }


}




