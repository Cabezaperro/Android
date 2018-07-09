package com.cabezaperro.pjgamboa.myrobotkotlin

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    var color: Int = 0xFFFFFFFF.toInt()
    var imageChanged: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            color = savedInstanceState?.getInt("Color", Color.RED)
            imageChanged = savedInstanceState.getBoolean("imgChanged", false)
            txvText.setBackgroundColor(color)

            if (imageChanged)
                imageView.setImageResource(R.mipmap.ic_launcher_round)
        }

        btnRed.setOnClickListener(this)
        imageView.setOnClickListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putInt("Color", color)
        outState?.putBoolean("imgChanged", imageChanged)
    }

    override fun onClick(v: View) {
        when (v) {
            btnRed -> color = Color.RED
            imageView -> {
                imageChanged = true
                imageView.setImageResource(R.mipmap.ic_launcher_round)

                if (rbtBlue.isChecked)
                    color = Color.BLUE
                if (rbtGreen.isChecked)
                    color = Color.GREEN
            }
        }

        txvText.setBackgroundColor(color)
    }
}
