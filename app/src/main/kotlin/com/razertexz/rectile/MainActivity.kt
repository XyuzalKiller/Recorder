package com.razertexz.rectile

import android.os.Bundle
import android.content.Context
import android.content.Intent
import android.media.projection.MediaProjectionManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts

import com.razertexz.rectile.ui.HomeScreen

internal class MainActivity : ComponentActivity() {
    private val mediaProjectionManager by lazy {
        getSystemService(Context.MEDIA_PROJECTION_SERVICE) as MediaProjectionManager
    }

    private val startMediaProjection = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == RESULT_OK) {
            startForegroundService(Intent(this, ScreenRecordService::class.java).apply {
                putExtra("RESULT_CODE", it.resultCode)
                putExtra("RESULT_DATA", it.data)
            })
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { HomeScreen() }
        startMediaProjection.launch(mediaProjectionManager.createScreenCaptureIntent())
    }
}