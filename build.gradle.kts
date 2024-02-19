// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    extra.apply {
        set("retrofit_version", "2.9.0")
        set("hilt_version", "2.48")
        set("core_ktx_version", "1.12.0")
        set("mockk_version", "1.12.3")
        set("coroutine_test_version", "1.6.1")
        set("core_arch_version", "1.1.1")
        set("junit_version", "4.13.2")


    }
}

plugins {
    id("com.android.application") version "8.2.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
}