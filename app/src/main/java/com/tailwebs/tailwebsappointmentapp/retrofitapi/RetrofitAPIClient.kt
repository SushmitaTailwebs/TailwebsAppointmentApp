package com.tailwebs.tailwebsappointmentapp.retrofitapi

import com.tailwebs.tailwebsappointmentapp.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitAPIClient {
    companion object {
        val BASE_IMAGE_URL = ""

        private var retrofit: Retrofit? = null

        fun getClient(): Retrofit? {
            if (retrofit == null) {
                retrofit = Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create()).client(retroLogClient())
                    .build()
            }
            return retrofit
        }


        fun retroLogClient(): OkHttpClient? {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return OkHttpClient.Builder().connectTimeout(300, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS).writeTimeout(300, TimeUnit.SECONDS)
                .addInterceptor(interceptor).build()
        }

    }
}