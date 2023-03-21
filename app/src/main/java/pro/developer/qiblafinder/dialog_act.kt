package pro.developer.qiblafinder

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class dialog_act : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog)

        var link1 = findViewById<TextView>(R.id.link1)
        var link2 = findViewById<TextView>(R.id.link2)
        var link3 = findViewById<TextView>(R.id.link3)

        link1.setOnClickListener {

            val openuRl=Intent(android.content.Intent.ACTION_VIEW)
            openuRl.data=Uri.parse("https://www.youtube.com/@ibof_yt")
            startActivity(openuRl)
        }
        link2.setOnClickListener {
            val openuRl=Intent(android.content.Intent.ACTION_VIEW)
            openuRl.data=Uri.parse("https://t.me/IBOF_YouTube")
            startActivity(openuRl)
        }
        link3.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/ibrohimjonovv_portfolio"))
            startActivity(browserIntent)
        }

    }
}