// Top-level build file where you can add configuration options common to all sub-projects/modules.
val composeVersion by extra { "1.5.13" }
val roomVersion by extra {"2.6.1"}
plugins {
    id("com.android.application") version "8.0.2" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    id("com.google.devtools.ksp") version "1.9.23-1.0.20" apply false
}