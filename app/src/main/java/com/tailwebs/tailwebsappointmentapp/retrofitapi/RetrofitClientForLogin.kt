package com.tailwebs.tailwebsappointmentapp.retrofitapi

import com.tailwebs.tailwebsappointmentapp.utils.Constants
import com.tailwebs.tailwebsappointmentapp.utils.GlobalValue
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClientForLogin {
    companion object {
        val BASE_IMAGE_URL = ""

        private var retrofit: Retrofit? = null

        private var client: OkHttpClient? = null

        fun getClient(): Retrofit? {
            try {

                //HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
                // interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                client = OkHttpClient.Builder() //    .addInterceptor(interceptor)
                    .addInterceptor { chain ->
                        chain.proceed(
                            chain.request()
                                .newBuilder()
                                .addHeader("HTTP-LOCALE", GlobalValue.http_locale)
                                .addHeader("HTTP-TIMEZONE", GlobalValue.http_timezone)
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
                    .addConverterFactory(ScalarsConverterFactory.create())
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