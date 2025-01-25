<h1>My Debug Tool Sample</h1>

<p>
  <a href="https://kotlinlang.org"><img alt="Kotlin Version" src="https://img.shields.io/badge/Kotlin-2.0.21-blueviolet.svg?style=flat"/></a>
  <a href="https://android-arsenal.com/api?level=24"><img alt="API" src="https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat"/></a>
  <a href="https://developer.android.com/studio/releases/gradle-plugin"><img alt="AGP" src="https://img.shields.io/badge/AGP-8.5.2-blue?style=flat"/></a>
</p>

Debug Tool 에 대한 예제 입니다.

# Android

- Supports Android Studio Koala
- minsdk 24
- targetSdk 35
- AGP 8.5.2
- Gradle 8.7


# Language

- [Kotlin](https://kotlinlang.org)


# JetPack [AAC(Android Architecture Components)](https://blog.naver.com/dev2jb/223230422126)

- View Binding


# UI

- MyDebugApplication
  implements [StrictMode](https://developer.android.com/reference/android/os/StrictMode)
- TelescopeActivity implements [Telescope](https://github.com/mattprecious/telescope)
- DebugDrawerActivity implements [DebugDrawer](https://github.com/palaima/DebugDrawer)


# 3rd Party Libraries

- [Leakcanary](https://square.github.io/leakcanary) (Memory Leak Debug Tool)
- [Telescope](https://github.com/mattprecious/telescope) (ScreenCapture + Device Information Debug
  Tool)
- [DebugDrawer](https://github.com/palaima/DebugDrawer) (Multi Debug Tool)

# Build Dependency

- [version catalog](https://developer.android.com/build/migrate-to-catalogs)

# Troubleshooting

- DebugDrawer's NetworkModule doesn't work.
- DebugDrawer's TimberModule doesn't work.