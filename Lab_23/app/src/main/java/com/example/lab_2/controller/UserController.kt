package com.example.lab_2.controller
import com.example.lab_2.model.UserModel

class UserController(private val userModel: UserModel) {

    fun getUserId(): String {
        return userModel.getUserId()
    }

    fun setUserId(userId: String) {
        userModel.setUserId(userId)
    }
}
