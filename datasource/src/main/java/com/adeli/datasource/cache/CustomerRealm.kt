package com.adeli.datasource.cache

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class CustomerRealm (
    @PrimaryKey
    var id: Int = 0,
    var email: String = "",
    var firstName: String = "",
    var lastName: String = "",
    var username: String = ""
): RealmObject()