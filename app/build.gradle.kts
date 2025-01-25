plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.kotlin.parcelize)
    alias(libs.plugins.ksp)
}

android {
    compileSdk = 35
    namespace = "com.myjb.dev"

    defaultConfig {
        applicationId = "com.myjb.dev.mydebugapplication"

        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
        buildConfig = true
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.coordinatorlayout)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.fragment.ktx)
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.swiperefreshlayout)

    // LifeCycle
    implementation(libs.bundles.lifecycle)

    // Material
    implementation(libs.material)

    //TODO
    // Leakcanary (Memory Leak Debug Tool) : https://square.github.io/leakcanary
//    debugImplementation(libs.leakcanary.android)

    //https://github.com/wasabeef/recyclerview-animators
    implementation(libs.recyclerview.animators)

    implementation(libs.stetho)
    implementation(libs.stetho.okhttp3)

    // Telescope (Screenshot + Device Information Debug Tool) : https://github.com/mattprecious/telescope
    implementation(libs.telescope)

    // DebugDrawer (Multi Debug Tool) : https://github.com/palaima/DebugDrawer
    implementation(libs.debugdrawer.base)

    debugImplementation(libs.debugdrawer)
    releaseImplementation(libs.debugdrawer.no.op)

    implementation(libs.debugdrawer.commons)

    implementation(libs.debugdrawer.actions)

    implementation(libs.scalpel)
    implementation(libs.debugdrawer.scalpel)

    implementation(libs.takt)
    implementation(libs.debugdrawer.fps)

    implementation(libs.timber)
    implementation(libs.debugdrawer.timber)

    implementation(libs.lynx)
    debugImplementation(libs.chuck.library)
    releaseImplementation(libs.chuck.library.no.op)
    implementation(libs.debugdrawer.logs)

    implementation(libs.debugdrawer.network.quality)
    implementation(libs.androidx.legacy.support.v4)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}