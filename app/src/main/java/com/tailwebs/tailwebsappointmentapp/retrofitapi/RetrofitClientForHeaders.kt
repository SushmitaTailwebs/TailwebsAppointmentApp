package com.tailwebs.tailwebsappointmentapp.retrofitapi

import android.content.Context
import com.tailwebs.tailwebsappointmentapp.utils.Constants
import com.tailwebs.tailwebsappointmentapp.utils.GlobalValue
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClientForHeaders {
    companion object {
        val BASE_IMAGE_URL = ""

        private var retrofit: Retrofit? = null

        private var client: OkHttpClient? = null

        fun getClient(context: Context?): Retrofit? {
            try {
                client = OkHttpClient.Builder()
                    .addInterceptor { chain ->
                        chain.proceed(
                            chain.request()
                                .newBuilder()
                                .addHeader("secret", GlobalValue.secret)
                                .addHeader("secret-id", GlobalValue.secret_id)
                                .addHeader("HTTP-LOCALE", GlobalValue.http_locale)
                                .addHeader("HTTP-TIMEZONE", GlobalValue.http_timezone)
                                .addHeader("platform", "android")
                                .addHeader("current-version", GlobalValue.app_version)
                                .build()
                        )
                    }
                    .connectTimeout(300, TimeUnit.SECONDS)
                    .readTimeout(300, TimeUnit.SECONDS)
                    .writeTimeout(300, TimeUnit.SECONDS)
                    .build()
                retrofit = Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            } catch (e: NullPointerException) {
                print("Caught the NullPointerException")
            } catch (e: Exception) {
                print("Caught the Exception")
            }
            return retrofit
        }
    }
}