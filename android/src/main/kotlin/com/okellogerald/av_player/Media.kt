package com.okellogerald.av_player

import androidx.media3.common.MimeTypes
import java.io.Serializable

data class Media constructor(
    val url: String,
    val fileType: String,
) : Serializable {
    companion object {
        fun network(url: String, fileType: String) = Media(url, fileType)
    }

    fun getMimeType(): String? {
        return when (fileType) {
            "mp4" -> {
                MimeTypes.APPLICATION_MP4
            }

            "mp3" -> {
                MimeTypes.AUDIO_MPEG
            }

            else -> null
        }
    }
}