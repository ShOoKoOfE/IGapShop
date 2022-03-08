package com.adeli.datasource.network.di

import com.adeli.datasource.BuildConfig
import com.adeli.datasource.network.EndPoints.BASE_URL
import com.adeli.datasource.network.ProductService
import com.adeli.datasource.network.ProductServiceImpl
import com.adeli.datasource.network.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        val builder = OkHttpClient.Builder()
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(loggingInterceptor)
        }
        return builder.build()
    }

        @Singleton
        @Provides
        fun provideConverterFactory(): GsonConverterFactory =
            GsonConverterFactory.create()

        @Singleton
        @Provides
        fun provideRetrofit(
            okHttpClient: OkHttpClient,
            gsonConverterFactory: GsonConverterFactory
        ): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .build()
        }

        @Singleton
        @Provides
        fun provideProductService(retrofit: Retrofit): ProductService =
            retrofit.create(ProductService::class.java)

        @Singleton
        @Provides
        fun provideProductServiceImpl(productService: ProductService):ProductServiceImpl=
            ProductServiceImpl(productService)

        @Singleton
        @Provides
        fun provideRepository(productServiceImpl: ProductServiceImpl): Repository =
            Repository(productServiceImpl)

    }
