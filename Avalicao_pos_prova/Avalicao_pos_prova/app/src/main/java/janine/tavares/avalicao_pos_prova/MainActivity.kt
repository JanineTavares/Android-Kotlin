package janine.tavares.avalicao_pos_prova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import janine.tavares.avalicao_pos_prova.model.Month
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        see_result_button.setOnClickListener(this@MainActivity)
    }

    override fun onClick(p0: View?) {
        if (box_insert_number.text.toString().isEmpty()) {
            return Toast.makeText(this, getString(R.string.number_not_inserted), Toast.LENGTH_LONG).show()
        } else {
            val month = Month(
                box_insert_number.text.toString().toInt(), this@MainActivity
            )
            when (p0?.id) {
                R.id.see_result_button -> {
                    view_show_number.text = month.showChosenMonth().toString()
                }
            }
        }
    }
}

