class Media {
  final String url;
  final MediaType type;

  const Media({required this.type, required this.url});

  Map<String, String> toMap() {
    return <String, String>{
      "url": url,
      "fileType": type.name,
    };
  }
}

enum MediaType {
  mp4,
  mp3,
  ;
}
