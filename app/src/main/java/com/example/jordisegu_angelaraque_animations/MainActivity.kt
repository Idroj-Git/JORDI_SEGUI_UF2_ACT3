package com.example.jordisegu_angelaraque_animations

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.constraintlayout.widget.ConstraintSet.Motion

class MainActivity : AppCompatActivity() {
    lateinit var changeActivityButton : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeActivityButton = findViewById<Button>(R.id.changeActivityButton)

        changeActivityButton.setOnClickListener{
            val intent = Intent(this, MotionSceneActivity::class.java)
            startActivity(intent)
        }
    }
}