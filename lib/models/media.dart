class Media {
  final String url;
  final MediaFormat type;

  const Media({required this.type, required this.url});

  Map<String, String> toMap() {
    return <String, String>{
      "url": url,
      "fileType": type.fileExtension,
    };
  }
}

abstract class MediaFormat {
  final String fileExtension;
  const MediaFormat(this.fileExtension);

  bool get isAudioFormat;
  bool get isVideoFormat;
}

class AudioFormat extends MediaFormat {
  AudioFormat.mp3() : super("mp3");
  AudioFormat.m4a() : super("m4a");
  AudioFormat.wav() : super("wav");

  @override
  bool get isAudioFormat => true;

  @override
  bool get isVideoFormat => false;
}

class VideoFormat extends MediaFormat {
  VideoFormat.mp4() : super("mp4");
  VideoFormat.mkv() : super("mkv");
  VideoFormat.webm() : super("webm");

  @override
  bool get isAudioFormat => false;

  @override
  bool get isVideoFormat => true;
}
