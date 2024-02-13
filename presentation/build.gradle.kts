plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")

}


android {
    namespace = "com.example.presentation"
    compileSdk = 34

    defaultConfig {
        minSdk = 26

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
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
val hiltVersion = rootProject.extra.get("hilt_version") as String
val coreKtxVersion = rootProject.extra.get("core_ktx_version") as String
val mockkVersion = rootProject.extra.get("mockk_version") as String
dependencies {
    implementation(project(":domain"))
    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("io.coil-kt:coil-compose:1.4.0")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    testImplementation ("io.mockk:mockk:$mockkVersion")
    //Dagger - Hilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    testImplementation("junit:junit:4.13.2")
}