# Aspect Ratio ImageView

[![](https://jitpack.io/v/santalu/aspect-ratio-imageview.svg)](https://jitpack.io/#santalu/aspect-ratio-imageview) [![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-Aspect%20Ratio%20ImageView-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/6071) [![Build Status](https://travis-ci.org/santalu/aspect-ratio-imageview.svg?branch=master)](https://travis-ci.org/santalu/aspect-ratio-imageview)

A simple imageview which scales the width or height aspect with the given ratio

## Sample

<img src="https://github.com/santalu/aspect-ratio-imageview/blob/master/media/sample.png"/>

## Usage

### Gradle
```
allprojects {
  repositories {
    maven { url 'https://jitpack.io' }
  }
}
```
```
dependencies {
  implementation 'com.github.santalu:aspect-ratio-imageview:1.0.7'
}
```

### XML
```xml
<com.santalu.aspectratioimageview.AspectRatioImageView
    android:layout_width="200dp"
    android:layout_height="0dp"
    android:scaleType="centerCrop"
    android:src="@drawable/sample"
    app:ari_ratio="1.2"/>
```

## License
```
Copyright 2017 Fatih Santalu

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
