plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)

    id("maven-publish")
}

android {
    namespace = "com.momen.weatherutils"
    compileSdk = 35

    defaultConfig {
        minSdk = 25

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
}
publishing {
    publications {
        create<MavenPublication>("release") {
            groupId = "com.momen"
            artifactId = "weatherutils"
            version = "1.0.0"

            afterEvaluate {
                from(components["release"])
            }
        }
    }
    repositories {
        mavenLocal()
    }
}
dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}