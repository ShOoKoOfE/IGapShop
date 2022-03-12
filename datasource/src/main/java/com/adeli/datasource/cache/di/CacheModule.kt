package com.adeli.datasource.cache.di

import android.content.Context
import com.adeli.datasource.cache.CustomerCache
import com.adeli.datasource.cache.CustomerCacheImpl
import com.adeli.datasource.cache.CustomerDatabaseOperations
import com.adeli.datasource.cache.migration
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import io.realm.Realm
import io.realm.RealmConfiguration
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule{

    private const val realmVersion = 1L

    @Provides
    @Singleton
    fun providesRealmDatabase(
        @ApplicationContext context: Context
    ): Realm {
        Realm.init(context)
        val realmConfiguration = RealmConfiguration.Builder()
            .schemaVersion(realmVersion)
            .migration(migration)
            .build()
        Realm.setDefaultConfiguration(realmConfiguration)
        return Realm.getDefaultInstance()
    }

    @Singleton
    @Provides
    fun providesCustomerDatabaseOperations(realm: Realm): CustomerDatabaseOperations =
        CustomerDatabaseOperations(realm)

    @Singleton
    @Provides
    fun providesCustomerCache(databaseOperations: CustomerDatabaseOperations): CustomerCache =
        CustomerCacheImpl(databaseOperations)
}