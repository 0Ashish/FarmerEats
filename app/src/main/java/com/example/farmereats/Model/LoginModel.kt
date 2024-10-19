package com.example.farmereats.Model

import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class LoginRequest(
    val email: String,
    val password: String,
    val role: String,
    val device_token: String,
    val type: String,
    val social_id: String
) : Parcelable

@Parcelize
data class LoginResponse(
    val success: Boolean,
    val message: String,
    val token: String
) : Parcelable