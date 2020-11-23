package janine.tavares.what_movie_is_it_

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import janine.tavares.what_movie_is_it_.model.QuizManegement
import janine.tavares.what_movie_is_it_.quiz_screens.FinalScreen

import janine.tavares.what_movie_is_it_.quiz_screens.Screen1
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        QuizManegement.context = this
        QuizManegement.generateQuestions()
        QuizManegement.shuffleQuestions()
        QuizManegement.clear()
        button_start_quiz.setOnClickListener{
            startActivity(Intent(this, Screen1::class.java))

        }
    }


}