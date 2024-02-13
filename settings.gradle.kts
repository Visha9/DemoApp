pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}


rootProject.name = "GithubApp"
include(":app")
include(":presentation")
include(":domain")
include(":data")
