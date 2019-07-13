package com.ps.motionlayout_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.ceil

/**
 * Ref : https://code.tutsplus.com/tutorials/creating-animations-with-motionlayout-for-android--cms-31497
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        motion_container.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionTrigger(motionLayout: MotionLayout?, currentId: Int, p2: Boolean, p3: Float) {
            }

            override fun onTransitionStarted(motionLayout: MotionLayout?, currentId: Int, p2: Int) {
            }

            override fun onTransitionChange(motionLayout: MotionLayout?, startId: Int, endId: Int, progress: Float) {
                Log.d("motionlayout_demo", "motion Progress : " + progress)
                Log.d("motionlayout_demo", "seekbar_Progress : " + ceil(progress * 100))
                seekbar.progress = ceil(progress * 100).toInt()
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                if (currentId == R.id.ending_set) {
                    motion_container.transitionToStart()
                }
            }
        })
    }

    fun start(v: View) {
        motion_container.transitionToEnd()
    }
}
