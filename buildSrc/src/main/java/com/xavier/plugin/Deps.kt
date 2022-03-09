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

object TestDeps {
    const val junit = "androidx.test.ext:junit:${VersionUpdate.junit}"
    const val extJunit = "androidx.test.ext:junit:${VersionUpdate.extJunit}"
    const val espressoCore = "androidx.test.espresso:espresso-core:${VersionUpdate.espressoCore}"
}

// 对 Jetpack AAC 架构组件的一些扩展/补充/工具
object AccExpand {
    const val viewBindingKtx =
        "com.github.DylanCaiCoding.ViewBindingKTX:viewbinding-base:${VersionUpdate.viewBindingKtx}"
}