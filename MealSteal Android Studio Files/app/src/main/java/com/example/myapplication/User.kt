package com.example.myapplication
//We will store the information in Google Firebase Firestore
//open lets the class be inheritable
open class User {
    var name: String? = null
        get() = field
        set(value) {
            field = value
        }

    var email: String? = null
        get() = field
        set(value) {
            field = value
        }

    var password: String? = null
        get() = field
        set(value) {
            field = value
        }

    //There should be no way to change uid and account_type
    var uid: String? = null
    var account_type: String? = null

    constructor() {
    }
    
    constructor(name: String?, email: String?, password: String?, uid: String?, account_type: String?) {
        this.name = name
        this.email = email
        this.password = password
        this.uid = uid
        this.account_type = account_type
    }



}

