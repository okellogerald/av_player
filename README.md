# av_player

A Flutter plugin to handle all platform specific implementations for playing audio and video media files. It is intended to be a 'plugin-n-play' solution. E.g just call a function `playVideo` and that's what it should do.

## Android Set-up

> Add the following dependencies
```gradle
dependencies {
    ...
    def media3_version = "1.1.0"
    implementation "androidx.media3:media3-exoplayer:$media3_version"
    implementation "androidx.media3:media3-ui:$media3_version"
    implementation "androidx.media3:media3-exoplayer-hls:$media3_version"

    implementation "androidx.multidex:multidex:2.0.1"
}
```

> Set up sdk versions as seen below
```gradle
 android {
    ...
    compileSdk 33

    defaultConfig {
        ...
        minSdk 23
        targetSdk 33
        ...
    }
    ...
 }
```

> In `AndroidManifest.xml`
```xml
# in the application tag
<application>
    android:supportsRtl="true"
    android:allowClearUserData="true"
    android:usesCleartextTraffic="true"
</application>
```