package com.example.lab_2.controller

import com.example.lab_2.model.UserId

class UserController(private val userID: UserId) {

    var name: String?
        get() = userID.getName()
        set(value) { userID.setName(value) }
}
