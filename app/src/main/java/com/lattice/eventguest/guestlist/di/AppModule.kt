package com.lattice.eventguest.guestlist.di

import com.lattice.eventguest.guestlist.common.Constants.BASE_URL
import com.lattice.eventguest.guestlist.data.remote.EventApiService
import com.lattice.eventguest.guestlist.data.remote.GuestApiService
import com.lattice.eventguest.guestlist.data.remote.PeopleApiService
import com.lattice.eventguest.guestlist.data.repository.EventRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor { chain ->
                val original = chain.request()
                val requestBuilder = original.newBuilder()
                    .header("Authorization","EAAEZBrnLN114BO6BZB554AZBXocvZChihyGREv57mo71BBU5NYA329XDYKPeXjuuPH0JOmhAWUTNbLvA1jdMn9mZC0hEfjDZBrH6ZAZAtMZC1sHJyWII4zYYuRODtWfD81Pq2jZCVHz0PGbD6OZCcFdBEjkv1xM1ZCdlLstJk4p2kVoiTzGnxbxNwRU6lV8bdx2kSidkjSA4ywgwOIZAwfTnPzOZBVz5bbA28ZD")
                    .header("Content-Type","application/json")
                val request = requestBuilder.build()
                chain.proceed(request)
            }.build()
    }

    @Provides
    @Singleton
    fun provideMyApi(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient())
            .build()
    }

    @Provides
    @Singleton
    fun provideGuestApiService(retrofit: Retrofit): GuestApiService {
        return retrofit.create(GuestApiService::class.java)
    }

    @Provides
    @Singleton
    fun providePeopleApiService(retrofit: Retrofit): PeopleApiService {
        return retrofit.create(PeopleApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideEventApiService(retrofit: Retrofit): EventApiService {
        return retrofit.create(EventApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideMyRepository(guestApiService: GuestApiService): EventRepository {
        return EventRepositoryImpl(guestApiService)
    }
}