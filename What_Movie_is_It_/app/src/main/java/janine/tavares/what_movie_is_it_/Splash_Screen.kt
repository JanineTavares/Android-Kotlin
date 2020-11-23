package janine.tavares.what_movie_is_it_

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class Splash_Screen : AppCompatActivity() {

    private var delayHandler: Handler? = null
    private var SPLASH_DELAY: Long = 2000

    internal var runnable = Runnable {
        if(!isFinishing) {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash__screen)

        delayHandler = Handler()
        delayHandler!!.postDelayed(runnable, SPLASH_DELAY)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        }
    }
