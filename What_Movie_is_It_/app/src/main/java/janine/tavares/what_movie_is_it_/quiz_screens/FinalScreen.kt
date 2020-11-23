package janine.tavares.what_movie_is_it_.quiz_screens

import android.content.Intent
import kotlin.math.round
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import janine.tavares.what_movie_is_it_.MainActivity
import janine.tavares.what_movie_is_it_.R
import janine.tavares.what_movie_is_it_.model.QuizManegement
import kotlinx.android.synthetic.main.activity_final_screen.*
import kotlinx.android.synthetic.main.activity_screen1.*
import kotlin.concurrent.fixedRateTimer

class FinalScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final_screen)

        QuizManegement.finalResult(this)
        getScore()

        resultCorrects.text = "${QuizManegement.showScore().toString()}/7"
        textViewFinalScore.text = "${Math.round(QuizManegement.checkAverageScore()).toString()}%"


        buttonPlayAgain.setOnClickListener{
            QuizManegement.clear()
            QuizManegement.stopMedia()
            startActivity(Intent(this@FinalScreen, MainActivity::class.java))
            finish()

        }
    }



    fun getScore() {
        textViewFinalScore.text = QuizManegement.showScore().toString()
    }
}