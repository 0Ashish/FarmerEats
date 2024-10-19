package com.example.farmereats.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ResetPasswordRequest(
    val token:String,
    val password:String,
    val cpassword:String
) : Parcelable

@Parcelize
data class ResetPasswordResponse(
    val success: Boolean,
    val message: String
) : Parcelable