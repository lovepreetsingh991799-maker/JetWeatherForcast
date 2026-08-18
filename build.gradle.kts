plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.compose) apply false   // ← only this, no kotlin.android
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.hilt.android) apply false
}