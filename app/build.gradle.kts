plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    kotlin("plugin.serialization") version "1.9.23"
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.swiggydeomo"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.swiggydeomo"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Core Kotlin extensions for Android
    implementation("androidx.core:core-ktx:1.13.1")

// Lifecycle components for Android
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

// Compose integration with Android Activity
    implementation("androidx.activity:activity-compose:1.9.0")

// BOM for managing Compose dependencies
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))

// Core UI components for Compose
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")

// Hilt integration for Navigation in Compose
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

// Image loading library for Compose
    implementation("io.coil-kt:coil-compose:2.6.0")

// Navigation component for Compose
    implementation("androidx.navigation:navigation-compose:2.8.0-beta04")

// JSON serialization library for Kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

// Preview support for Compose UI
    implementation("androidx.compose.ui:ui-tooling-preview")

// Material Design 3 components for Compose
    implementation("androidx.compose.material3:material3")

// Retrofit for network requests
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

// Hilt dependency injection library
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-android-compiler:2.50")

// Gson converter for Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

// Coroutines for Kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")

// JUnit for unit testing
    testImplementation("junit:junit:4.13.2")

// AndroidX testing libraries
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

// BOM for managing Compose dependencies in tests
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.08.00"))

// Compose testing library
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")

// Debugging tools for Compose UI
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

}