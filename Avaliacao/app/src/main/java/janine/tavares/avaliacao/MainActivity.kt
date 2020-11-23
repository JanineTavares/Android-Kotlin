package janine.tavares.avaliacao

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var buttonCalculator: Button
    private lateinit var buttonRandomic: Button
    private lateinit var textViewOption: TextView
    private lateinit var button2: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializer()

        buttonCalculator.setOnClickListener(this@MainActivity)
        button2.setOnClickListener(this@MainActivity)
        buttonRandomic.setOnClickListener(this@MainActivity)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.buttonCalculator -> {
                val intent = Intent(this, Calculator::class.java)
                startActivity(intent)
            }
                R.id.buttonRandomic -> {
                    val intent = Intent(this, Randomic::class.java)
                    startActivity(intent)

                }
            R.id.button2 -> {
                val intent = Intent(this, AboutScreen::class.java)
                startActivity(intent)


            }
            }
        }



        private fun initializer() {
            buttonCalculator = findViewById(R.id.buttonCalculator)
            buttonRandomic = findViewById(R.id.buttonRandomic)
            textViewOption = findViewById(R.id.textViewOption)
            button2 = findViewById(R.id.button2)
        }

}
