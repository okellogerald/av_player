package com.okellogerald.av_player

import android.app.Activity
import android.content.Intent
import androidx.core.content.ContextCompat.startActivity

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

class AvPlayerPlugin : FlutterPlugin, MethodCallHandler, ActivityAware {
    private lateinit var channel: MethodChannel
    private lateinit var context: Activity

    override fun onAttachedToEngine(flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
        channel = MethodChannel(flutterPluginBinding.binaryMessenger, "av_player_plugin")
        channel.setMethodCallHandler(this)
    }

    override fun onMethodCall(call: MethodCall, result: Result) {
        when (call.method) {
            "getPlatformVersion" -> {
                result.success("Android ${android.os.Build.VERSION.RELEASE}")
            }

            "play_video" -> {
                playVideo(call, result)
            }

            "play_audio" -> {
                playAudio(call, result)
            }

            else -> {
                result.notImplemented()
            }
        }
    }

    private fun playVideo(call: MethodCall, result: Result) {
        val intent = Intent(context, VideoPlayerActivity::class.java)
        val media = VideoPlayerActivity.createMediaFrom(args = call.arguments)
            ?: return invalidMediaError(result)
        intent.putExtra("media", media)
        startActivity(context, intent, null)
    }

    private fun playAudio(call: MethodCall, result: Result) {
        val intent = Intent(context, AudioPlayerActivity::class.java)
        val media = AudioPlayerActivity.createMediaFrom(args = call.arguments)
            ?: return invalidMediaError(result)
        intent.putExtra("media", media)
        startActivity(context, intent, null)
    }

    private fun invalidMediaError(result: Result) {
        result.error("100", "Invalid Media Args", null)
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        channel.setMethodCallHandler(null)
    }

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        context = binding.activity
    }

    override fun onDetachedFromActivityForConfigChanges() {
        TODO("Not yet implemented")
    }

    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
        TODO("Not yet implemented")
    }

    override fun onDetachedFromActivity() {
        TODO("Not yet implemented")
    }
}
