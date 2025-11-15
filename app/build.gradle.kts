plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.viewpage"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.viewpage"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    implementation("com.google.android.material:material:1.11.0")
    // RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    // ViewPager2
    implementation("androidx.viewpager2:viewpager2:1.0.0")
    // Fragment
    implementation("androidx.fragment:fragment-ktx:1.6.2")
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}