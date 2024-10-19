package com.example.farmereats.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ForgotPasswordRequest(
    val mobile:String
) : Parcelable

@Parcelize
data class ForgotPasswordResponse(
    val success: Boolean,
    val message: String
) : Parcelable