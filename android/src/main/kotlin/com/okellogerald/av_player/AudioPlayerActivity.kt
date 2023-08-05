package com.okellogerald.av_player

import android.app.Activity
import android.os.Bundle
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.ui.PlayerView


class AudioPlayerActivity() : Activity() {
    private lateinit var player: ExoPlayer
    private lateinit var playerView: PlayerView

    companion object Factory {
        fun createMediaFrom(args: Any): Media? {
            return try {
                val data = args as Map<*, *>
                val url = data["url"] as String
                val fileType = data["fileType"] as String
                Media.network(url, fileType)
            } catch (_: Exception) {
                null
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        playerView = findViewById(R.id.player_view)
        player = ExoPlayer.Builder(this).build()

        playerView.player = player

        val media = intent.getSerializableExtra("media") as Media
        val mediaItem = MediaItem.Builder()
            .setUri(media.url)
            .setMimeType(media.getMimeType())
            .build()
        player.setMediaItem(mediaItem)
        player.prepare()
        player.play()
    }

    override fun onStop() {
        super.onStop()

        player.pause()
    }

    override fun onResume() {
        super.onResume()

        player.play()
    }

    override fun onDestroy() {
        super.onDestroy()

        player.pause()
        player.release()
    }
}