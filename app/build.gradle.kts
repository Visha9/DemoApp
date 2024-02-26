plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")

}


android {
    namespace = "com.example.githubapp"
    compileSdk = rootProject.extra.get("compile_sdk_version") as Int

    defaultConfig {
        applicationId = "com.example.githubapp"
        minSdk = rootProject.extra.get("min_sdk_version") as Int
        targetSdk = rootProject.extra.get("compile_sdk_version") as Int
        versionCode = rootProject.extra.get("version_code") as Int
        versionName = rootProject.extra.get("version_name") as String
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            versionNameSuffix = ".debug"
            isMinifyEnabled = false
            isShrinkResources = false
        }
        create("production") {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        create("dev") {
            versionNameSuffix = ".debug"
            isDebuggable = true
            isMinifyEnabled = false
        }
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
        kotlinCompilerExtensionVersion =
            rootProject.extra.get("kotlin_compiler_extension_version") as String
    }
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

val hiltVersion = rootProject.extra.get("hilt_version") as String
val coreKtxVersion = rootProject.extra.get("core_ktx_version") as String
dependencies {

    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("androidx.compose.material3:material3")
    //Dagger - Hilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    implementation(project(":presentation"))
    implementation(project(":domain"))
    implementation(project(":data"))
}