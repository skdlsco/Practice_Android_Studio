package practice.practicebroadcast

import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    init {
        var intent: Intent
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intent = Intent(this@MainActivity, MyService::class.java)
    }

    fun start(view: View) {
        startService(intent)
    }

    fun stop(view: View) {
        stopService(intent)
    }
}
