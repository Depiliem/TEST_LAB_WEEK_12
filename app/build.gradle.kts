plugins {
    // Plugin utama untuk aplikasi Android dan Kotlin
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    // Plugin untuk pemrosesan anotasi seperti yang digunakan oleh Moshi
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.test_lab_week_12"
    compileSdk = 34 // Disarankan menggunakan versi stabil terbaru

    defaultConfig {
        applicationId = "com.example.test_lab_week_12"
        minSdk = 24
        targetSdk = 34 // Harus cocok dengan compileSdk
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }

    // Jika Anda menggunakan View Binding, aktifkan di sini
    // buildFeatures {
    //     viewBinding = true
    // }
}

dependencies {
    // Core & UI
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.recyclerview)

    // Lifecycle (ViewModel, LiveData, dll.)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    // Networking: Retrofit & Moshi
    implementation(libs.retrofit)
    implementation(libs.converter.moshi) // Konverter untuk Retrofit
    implementation(libs.moshi.kotlin)      // Library utama Moshi untuk Kotlin (ini yang penting)
    kapt(libs.moshi.kotlin.codegen)       // Pemroses anotasi untuk Moshi

    // Coroutines untuk Asynchronous Tasks
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // Image Loading
    implementation(libs.glide)

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
