package br.net.easify.toasts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_toast.*

/**
 * @author Vinicius Pontes
 *
 * https://developer.android.com/guide/topics/ui/notifiers/toasts
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        defaultButton.setOnClickListener {
            val text = "This is as simple toast"
            val duration = Toast.LENGTH_LONG
            Toast.makeText(applicationContext, text, duration)
                .show()
        }

        customPositionButton.setOnClickListener {
            val text = "This is as simple toast"
            val duration = Toast.LENGTH_LONG
            var toast = Toast.makeText(applicationContext, text, duration)
            toast.setGravity(Gravity.TOP or Gravity.CENTER, 0, 0)
            toast.show()
        }

        customButton.setOnClickListener {
            val inflater = layoutInflater
            val layout: View? = inflater.inflate(R.layout.custom_toast, customToastContainer)
            val text: TextView = layout!!.findViewById(R.id.text)
            text.text = "This is a custom toast"
            with (Toast(applicationContext)) {
                setGravity(Gravity.BOTTOM, 0, 30)
                duration = Toast.LENGTH_LONG
                view = layout
                show()
            }
        }
    }
}
