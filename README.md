# av_player

A new Flutter plugin project.

## Set-up

### Dependencies
```gradle
dependencies {
    ...
    def media3_version = "1.1.0"
    implementation "androidx.media3:media3-exoplayer:$media3_version"
    implementation "androidx.media3:media3-ui:$media3_version"
    implementation "androidx.media3:media3-exoplayer-hls:$media3_version"
}
```

```gradle
    ext {
        kotlin_version = '1.9.0'
    }
```

```gradle
plugins {
    ...
    id 'org.jetbrains.kotlin.android' version '1.9.0' apply false
}
```

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

```xml
# in the application tag
<application>
    android:supportsRtl="true"
    android:allowClearUserData="true"
    android:usesCleartextTraffic="true"
</application>
```