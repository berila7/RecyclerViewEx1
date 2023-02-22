package com.example.recyclerviewex1

import android.annotation.SuppressLint
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.MediaController
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val videoView = findViewById<VideoView>(R.id.videoView)
        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

        val uri: Uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.bf)
        videoView.setMediaController(mediaController)
        videoView.setVideoURI(uri)
        videoView.requestFocus()
        videoView.start()
        val editText = findViewById<EditText>(R.id.myEditText)

        editText.onFocusChangeListener = View.OnFocusChangeListener { view, hasFocus ->
            if (hasFocus) {
                // If the EditText has focus, change the text color to black
                editText.setTextColor(Color.BLACK)
            } else {
                // If the EditText loses focus, change the text color to red
                editText.setTextColor(Color.RED)
            }
        }

    }
}