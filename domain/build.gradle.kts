plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    val compileSdkVersion = rootProject.extra.get("compile_sdk_version") as Int
    namespace = "com.example.domain"
    compileSdk = compileSdkVersion

    defaultConfig {
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
val retrofitVersion = rootProject.extra.get("retrofit_version") as String
val hiltVersion = rootProject.extra.get("hilt_version") as String
val coreKtxVersion = rootProject.extra.get("core_ktx_version") as String
val mockkVersion = rootProject.extra.get("mockk_version") as String
val coroutineTestVersion = rootProject.extra.get("coroutine_test_version") as String
val coreArchVersion = rootProject.extra.get("core_arch_version") as String
val jUnitVersion = rootProject.extra.get("junit_version") as String

dependencies {
    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:$jUnitVersion")
    testImplementation ("io.mockk:mockk:$mockkVersion")
    testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineTestVersion")
    testImplementation ("android.arch.core:core-testing:$coreArchVersion")
    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")
    //Dagger - Hilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
}