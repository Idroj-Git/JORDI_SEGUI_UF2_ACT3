package com.example.jordisegu_angelaraque_animations

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.GridLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintSet.Motion
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MotionSceneActivity : AppCompatActivity() {
    private lateinit var activateAnimationButton : Button
    private lateinit var motionLayout: MotionLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_motion_scene)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        activateAnimationButton = findViewById<Button>(R.id.activateAnimationButton)

        motionLayout = findViewById<MotionLayout>(R.id.main)


        motionLayout.setTransitionListener(object : MotionLayout.TransitionListener{
            override fun onTransitionStarted(p0: MotionLayout?, p1: Int, p2: Int) {}
            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {}
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                if (currentId == R.id.end){
                    ChangeActivity()
                }
            }
            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}
        })
        activateAnimationButton.setOnClickListener{
            val intent = Intent(this, DancingButtonActivity::class.java)
            startActivity(intent)
        }
    }

    fun ChangeActivity(){
        val intent = Intent(this, DancingButtonActivity::class.java)
        startActivity(intent)
    }
}