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
                MimeTypes.VIDEO_MP4
            }

            "mkv" -> {
                MimeTypes.VIDEO_H263
            }

            "webm" -> {
                MimeTypes.VIDEO_WEBM
            }

            "wav" -> {
                MimeTypes.AUDIO_WAV
            }

            "mp3" -> {
                MimeTypes.AUDIO_AC4
            }

            "m4a" -> {
                MimeTypes.AUDIO_AAC
            }

            else -> null
        }
    }
}