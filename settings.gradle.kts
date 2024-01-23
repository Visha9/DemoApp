pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
//    resolutionStrategy {
//        eachPlugin {
//            if( requested.id.id .equals("dagger.hilt.android.plugin")) {
//                useModule("com.google.dagger:hilt-android-gradle-plugin:2.44")
//            }
//        }
//    }
}
//dependencyResolutionManagement {
//    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
//    repositories {
//        google()
//        mavenCentral()
//    }
//}

rootProject.name = "GithubApp"
include(":app")
 