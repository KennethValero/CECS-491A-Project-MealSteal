package com.example.myapplication

class User {
    var name: String? = null
    var email: String? = null
    var uid: String? = null
    var account_type: String? = null

    constructor() {
    }
    
    constructor(name: String?, email: String?, uid: String?, account_type: String?) {
        this.name = name
        this.email = email
        this.uid = uid
        this.account_type = account_type
    }
}

