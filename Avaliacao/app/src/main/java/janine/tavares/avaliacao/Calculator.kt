package janine.tavares.avaliacao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import janine.tavares.avaliacao.model.Calculator

class Calculator : AppCompatActivity() {
    private lateinit var editNumber1: EditText
    private lateinit var editNumber2: EditText
    private lateinit var spinner1: Spinner
    private lateinit var buttonCalculatorResult: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        initializer()



        buttonCalculatorResult.setOnClickListener {

            if (editNumber1.text.toString().isNotEmpty() && editNumber2.text.toString().isNotEmpty()) {
                val calculator = Calculator(editNumber1.text.toString().toDouble(), editNumber2.text.toString().toDouble())
                if (spinner1.selectedItemPosition == 0) { Toast.makeText(this, getString(janine.tavares.avaliacao.R.string.chooseCalculator), Toast.LENGTH_LONG).show()
                } else if (spinner1.selectedItemPosition == 1) {Toast.makeText(this,"Result: ${calculator.toMultiplicate()}",Toast.LENGTH_LONG).show()
                } else if (spinner1.selectedItemPosition == 2) {Toast.makeText(this,"Result: ${calculator.toDivise()}",Toast.LENGTH_LONG).show()
                } else if (spinner1.selectedItemPosition == 3) {android.widget.Toast.makeText(this,"Result: ${calculator.toAdd()}",Toast.LENGTH_LONG ).show()
                } else if (spinner1.selectedItemPosition == 4) {android.widget.Toast.makeText(this,"Result: ${calculator.toSubtracte()}",Toast.LENGTH_LONG ).show()}
                } else {Toast.makeText(this, getString(R.string.noOptionChoseCalculator), Toast.LENGTH_LONG).show()}
        }









        }
    private fun initializer() {
        editNumber1 = findViewById(R.id.editNumber1)
        editNumber2 = findViewById(R.id.editNumber2)
        spinner1 = findViewById(R.id.spinner1)
        buttonCalculatorResult = findViewById(R.id.buttonCalculatorResult)
    }

}












