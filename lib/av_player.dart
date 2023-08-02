import 'package:flutter/services.dart';

class AvPlayer {
  static const _channel = MethodChannel("av_player_plugin");

  Future<String?> getPlatformVersion() async {
    return "Android Lollipop";
  }

  void playVideo() {
    _channel.invokeMethod("play_video");
  }
}
