plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.expenseminiproject"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.expenseminiproject"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    buildFeatures {
        viewBinding = true
    }
}

val navVersion = "2.8.9"

dependencies {
    implementation("androidx.core:core-ktx:1.12.0") // Thay vì 1.16.0
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0") // 1.12.0 hơi mới
    implementation("androidx.activity:activity:1.8.2") // Thay vì 1.10.1
    implementation("androidx.constraintlayout:constraintlayout:2.1.4") // 2.2.1 mới quá

    val navVersion = "2.7.7" // Ổn định cho SDK 34
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")
    implementation("androidx.navigation:navigation-compose:$navVersion")
    implementation("androidx.navigation:navigation-fragment:$navVersion")
    implementation("androidx.navigation:navigation-ui:$navVersion")
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$navVersion")
    androidTestImplementation("androidx.navigation:navigation-testing:$navVersion")

    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3") // Tương thích hơn

    // Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    // material design
    implementation ("com.google.android.material:material:1.12.0")

}


