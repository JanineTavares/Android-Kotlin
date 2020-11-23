package janine.tavares.avaliacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Randomic : AppCompatActivity() {

    private lateinit var button:Button
    private lateinit var textViewRandomic: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_randomic)
        inittializer()


        button.setOnClickListener {
            val randomic = Randomic()
            val random = (0..100).random()
            textViewRandomic.text = random.toString()
        }
    }

    private fun inittializer() {
        button = findViewById(R.id.button)
        textViewRandomic = findViewById(R.id.textViewRandomic)
    }
}