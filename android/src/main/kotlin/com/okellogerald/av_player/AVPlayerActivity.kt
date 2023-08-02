package com.okellogerald.av_player

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.media3.common.MediaItem
import androidx.media3.common.MimeTypes
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView
import java.lang.Exception

const val SAMPLEVIDEOURL =
    "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"

class Media(
    val url: String,
    val mimeType: MimeTypes,
)

class AVPlayerActivity : AppCompatActivity() {
    private lateinit var player: ExoPlayer
    private lateinit var playerView: PlayerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playerView = findViewById(R.id.player_view)
        player = ExoPlayer.Builder(this).build()

        playerView.player = player

        val mediaItem = MediaItem.Builder()
            .setUri(SAMPLEVIDEOURL)
            .setMimeType(MimeTypes.APPLICATION_MP4)
            .build()
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }
}