import 'package:av_player/models/media.dart';
import 'package:flutter/services.dart';

export 'models/media.dart';

class AvPlayer {
  static const _channel = MethodChannel("av_player_plugin");

  Future<String?> getPlatformVersion() async {
    return "Android Lollipop";
  }

  void playVideo(Media media) {
    _channel.invokeMethod("play_video", media.toMap());
  }
}
