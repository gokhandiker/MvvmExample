package com.melisa.mvvmexample.di.modules

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.melisa.mvvmexample.util.AppConstants
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Module which provides all required dependencies about network
 */

// Safe here as we are dealing with a Dagger 2 module
@Suppress("unused")
object NetworkModule {



    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @JvmStatic
    internal fun provideRetrofitInterface(tmdbClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(tmdbClient)
            .baseUrl(AppConstants.EXAMPLE_BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

    /**
     * Provides the OkHttpClient object.
     * @return the OkHttpClient object
     */
    @JvmStatic
    internal  fun provideClient(authInterceptor: Interceptor) : OkHttpClient {
        return OkHttpClient().newBuilder().addInterceptor(authInterceptor).build()
    }


    /**
     * Provides the Interceptor object.
     * @return the Interceptor object
     */
    @JvmStatic
    internal  fun provideInterceptor() : Interceptor {
        return Interceptor {chain ->
            val  newUrl = chain.request().url()
                .newBuilder()
             //   .addQueryParameter("api_key", AppConstants.exampleApiKey)
                .build()

            val newRequest = chain.request()
                .newBuilder()
                .url(newUrl)
                .build()

            chain.proceed(newRequest)
        }
    }





}