package com.xavier.krill.test.api

import android.os.Bundle
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.xavier.krill.BuildConfig
import com.xavier.krill.base.ViewBindingActivity
import com.xavier.krill.databinding.ActivityApiBinding
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import java.util.concurrent.TimeUnit


class ApiActivity : ViewBindingActivity<ActivityApiBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_api)

        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(
                ChuckerInterceptor.Builder(context)
                    .build()
            ).addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        }
        val okHttpClient = builder
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            //.cookieJar(JavaNetCookieJar(cookieManager))
            .build()

        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(ApiService::class.java)
    }

    companion object {
        private const val BASE_URL = "http://192.168.0.5:20003/"
    }

    interface ApiService {
        @POST("")
        @FormUrlEncoded
        @JvmSuppressWildcards
        suspend fun billingRecordList(@FieldMap fieldMap: Map<String, Any>): Any
    }
}