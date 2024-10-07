plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")

    // ksp
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
}

android {
    namespace = "com.dicoding.asclepius"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dicoding.asclepius"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "API_KEY", "\"3ae36dd2f1f14442b1aa3b590e11b0fe\"")
        buildConfigField("String", "BASE_URL", "\"https://newsapi.org/v2/\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
        }

        kotlinOptions {
            jvmTarget = "17"
        }

        buildFeatures {
            viewBinding = true
            mlModelBinding = true
            buildConfig = true
        }

        dependencies {

            implementation("androidx.core:core-ktx:1.12.0")
            implementation("androidx.appcompat:appcompat:1.7.0")
            // implementation("androidx.appcompat:appcompat:1.6.1")
            implementation("com.google.android.material:material:1.12.0")
            // implementation("com.google.android.material:material:1.11.0")
            implementation("androidx.constraintlayout:constraintlayout:2.1.4")
            implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.6")
            implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.6")
            implementation("androidx.navigation:navigation-fragment-ktx:2.8.1")
            implementation("androidx.navigation:navigation-ui-ktx:2.8.1")
            testImplementation("junit:junit:4.13.2")
            androidTestImplementation("androidx.test.ext:junit:1.1.5")
            androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
            implementation("androidx.activity:activity:1.9.2")


            // Tambahkan Library TensorFlow Lite
            implementation("org.tensorflow:tensorflow-lite-support:0.4.4")
            implementation("org.tensorflow:tensorflow-lite-metadata:0.4.4")
            implementation("org.tensorflow:tensorflow-lite-task-vision:0.4.4")



            val room_version = "2.5.2"
            // Room runtime
            implementation ("androidx.room:room-runtime:$room_version")

            // For Kotlin use KSP instead of kapt for annotation processing
            ksp ("androidx.room:room-compiler:$room_version")

            // Optional - Kotlin Extensions for Room (Coroutines support)
            implementation ("androidx.room:room-ktx:$room_version")

            // Optional - LiveData support for Room
            implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

            // Optional - ViewModel support
            implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")

            // retrofit & okhttp
            implementation("com.github.bumptech.glide:glide:4.16.0")
            implementation("com.squareup.retrofit2:retrofit:2.9.0")
            implementation("com.squareup.retrofit2:converter-gson:2.9.0")
            implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")

            // Ucrop
            implementation ("com.github.yalantis:ucrop:2.2.8")
        }
    }
}

