package pro.developer.qiblafinder

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity()  ,SensorEventListener {

    private var currentDegree = 0f
    private var mSensorManager: SensorManager? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        // ---------------------------------------------------------

        val warnin = findViewById<ImageView>(R.id.img_warning)

// --------------------------------------------------------------

        val view=View.inflate(this,R.layout.activity_bsohlanish,null)
        val builder=AlertDialog.Builder(this)
        builder.setView(view)

        val dialog=builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
//---------------------------------------------------------------------------------
        Handler().postDelayed({
           // startActivity(Intent(this,MainActivity::class.java))
            //finish()
            dialog.dismiss()
        },3000)

//------------------------------------------------------------------

        warnin.setOnClickListener {



            val view1=View.inflate(this,R.layout.activity_dialog,null)
            val builder1=AlertDialog.Builder(this)
            builder1.setView(view1)

            val dialog1=builder1.create()
            dialog1.show()
            dialog1.window?.setBackgroundDrawableResource(android.R.color.transparent)




        }

        initData()

        // ---------------------------------------------------------------------------------------------------------
    }

    private fun initData() {
        mSensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
    }

    override fun onResume() {
        super.onResume()
       @Suppress("DEPRECATION")
        mSensorManager?.registerListener(
            this, mSensorManager?.getDefaultSensor(Sensor.TYPE_ORIENTATION),
            SensorManager.SENSOR_DELAY_GAME
        )
    }

    override fun onAccuracyChanged(s: Sensor, i: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {

        val degree = Math.round(event?.values?.get(0)!!)
        val rotateAnm = RotateAnimation(
            currentDegree,
            (-degree).toFloat(),
            Animation.RELATIVE_TO_SELF,
            0.5f,
            Animation.RELATIVE_TO_SELF,
            0.5f
        )

        rotateAnm.duration = 210
        rotateAnm.fillAfter = true


        var img_compas = findViewById<ImageView>(R.id.img_compass)
        img_compas.startAnimation(rotateAnm)
        currentDegree = (-degree).toFloat()
    }


}


