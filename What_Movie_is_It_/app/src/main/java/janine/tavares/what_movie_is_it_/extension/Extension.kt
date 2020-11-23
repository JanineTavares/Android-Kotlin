package janine.tavares.what_movie_is_it_.extension

import android.app.Activity
import android.content.Context
import android.widget.Toast

fun Activity.toast(result: Int) {
    Toast.makeText(baseContext, getText(result), Toast.LENGTH_LONG).show()
}