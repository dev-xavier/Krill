package com.xavier.plugin

// AndroidX
object AndroidX {
    const val appCompat = "androidx.appcompat:appcompat:${VersionUpdate.appCompat}"
    const val coreKtx = "androidx.core:core-ktx:${VersionUpdate.coreKtx}"
    const val constraintlayout =
        "androidx.constraintlayout:constraintlayout:${VersionUpdate.constraintlayout}"
}

// Google 开源
object GoogleDeps {
    const val material = "com.google.android.material:material:${VersionUpdate.material}"
    const val flexboxLayout = "com.google.android.flexbox:flexbox:${VersionUpdate.flexboxLayout}"
    const val timber = "com.jakewharton.timber:timber:${VersionUpdate.timber}"
}

// 对 Jetpack AAC 架构组件的一些扩展/补充/工具
object AccExpand {
    const val viewBindingKtx =
        "com.github.DylanCaiCoding.ViewBindingKTX:viewbinding-base:${VersionUpdate.viewBindingKtx}"
}

// Retrofit + OkHttp + Coroutines 全家桶
object RemoteIO {
    const val retrofit = "com.squareup.retrofit2:retrofit:${VersionUpdate.retrofit}"
    const val retrofitGson = "com.squareup.retrofit2:converter-gson:${VersionUpdate.retrofit}"
    const val retrofitMoshi = "com.squareup.retrofit2:converter-moshi:${VersionUpdate.retrofit}"
    const val retrofitScalars = "com.squareup.retrofit2:converter-scalars:${VersionUpdate.retrofit}"

    const val okhttp = "com.squareup.okhttp3:okhttp:${VersionUpdate.okHttp}"
    const val okhttpLoggingInterceptor =
        "com.squareup.okhttp3:logging-interceptor:${VersionUpdate.okHttp}"

    const val kotlinXCoroutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${VersionUpdate.kotlinXCoroutinesCore}"
}

object TestDeps {
    const val junit = "androidx.test.ext:junit:${VersionUpdate.junit}"
    const val extJunit = "androidx.test.ext:junit:${VersionUpdate.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${VersionUpdate.espressoCore}"
}

object DebugImplementationDeps {
    const val chucker = "com.github.chuckerteam.chucker:library:${VersionUpdate.chucker}"
}

object ReleaseImplementationDeps {
    const val chucker = "com.github.chuckerteam.chucker:library-no-op:${VersionUpdate.chucker}"
}