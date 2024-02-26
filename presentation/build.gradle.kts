plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")

}


android {
    val compileSdkVersion = rootProject.extra.get("compile_sdk_version") as Int
    val kotlinCompilerExtVersion = rootProject.extra.get("kotlin_compiler_extension_version") as String
    namespace = "com.example.presentation"
    compileSdk = compileSdkVersion

    defaultConfig {
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
        kotlinCompilerExtensionVersion = kotlinCompilerExtVersion
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
val coroutineTestVersion = rootProject.extra.get("coroutine_test_version") as String
val coreArchVersion = rootProject.extra.get("core_arch_version") as String
val jUnitVersion = rootProject.extra.get("junit_version") as String
dependencies {
    implementation(project(":domain"))
    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation(platform("androidx.compose:compose-bom:2023.08.00"))
    implementation("io.coil-kt:coil-compose:1.4.0")
    implementation("androidx.compose.material3:material3")

    testImplementation("junit:junit:$jUnitVersion")
    testImplementation("io.mockk:mockk:$mockkVersion")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:$coroutineTestVersion")
    testImplementation("android.arch.core:core-testing:$coreArchVersion")
    //Dagger - Hilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    kapt("com.google.dagger:hilt-android-compiler:$hiltVersion")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    testImplementation("junit:junit:$jUnitVersion")
}