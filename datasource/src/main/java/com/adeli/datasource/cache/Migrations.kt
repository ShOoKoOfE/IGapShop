package com.adeli.datasource.cache

import io.realm.RealmMigration


val migration = RealmMigration { realm, oldVersion, newVersion ->
   val customerSchema = realm.schema.get("CustomerRealm")
}
