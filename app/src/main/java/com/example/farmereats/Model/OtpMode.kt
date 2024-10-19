package com.example.farmereats.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class OtpRequest(
    val otp:String
) : Parcelable

@Parcelize
data class OtpResponse(
    val success: Boolean,
    val message: String
) : Parcelable