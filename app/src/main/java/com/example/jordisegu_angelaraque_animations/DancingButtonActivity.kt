package com.example.jordisegu_angelaraque_animations

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DancingButtonActivity : AppCompatActivity() {
    private lateinit var movingButton : Button
    private lateinit var spinningButton : Button
    private lateinit var motionLayout: MotionLayout
    private lateinit var spinningMotionLayout: MotionLayout
    private var isAtStart = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dancing_button)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        motionLayout = findViewById(R.id.main)

        spinningMotionLayout = findViewById(R.id.spinButtonMotionLayout)

        movingButton = findViewById(R.id.movingButton)
        spinningButton = findViewById(R.id.spinningButton)

        movingButton.setOnClickListener {
            toggleMovement()
        }

        spinningButton.setOnClickListener {
            startSpinning()
            spinningButton.isEnabled = false
        }
    }

    private fun toggleMovement() {
        motionLayout.setTransition(R.id.buttonMovementTransition)
        if (isAtStart) {
            motionLayout.transitionToEnd()
        } else {
            motionLayout.transitionToStart()
        }
        isAtStart = !isAtStart
    }

    private fun startSpinning() {
        // Set up the transition first
        spinningMotionLayout.setTransition(R.id.spinningTransition)

        val spinLoop = object : Runnable {
            override fun run() {
                spinningMotionLayout.setTransition(R.id.spinningTransition)
                spinningMotionLayout.progress = 0f
                spinningMotionLayout.transitionToEnd()
                spinningMotionLayout.postDelayed(this, 3000) // Reiniciar cada 3s (duración de mi animación)
            }
        }
        spinningMotionLayout.post(spinLoop)

        /*spinningMotionLayout.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionCompleted(layout: MotionLayout?, currentId: Int) {
                spinningMotionLayout.transitionToEnd()
            }
            override fun onTransitionStarted(layout: MotionLayout?, startId: Int, endId: Int) {}
            override fun onTransitionChange(layout: MotionLayout?, startId: Int, endId: Int, progress: Float) {}
            override fun onTransitionTrigger(layout: MotionLayout?, triggerId: Int, positive: Boolean, progress: Float) {}
        })

        spinningMotionLayout.transitionToEnd()

        No funka asi que lo he hecho con un loop manual xdd*/
    }
}
