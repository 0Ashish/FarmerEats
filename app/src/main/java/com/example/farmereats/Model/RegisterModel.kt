package com.example.farmereats.Model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RegisterRequest(
    val full_name: String,
    val email: String,
    val phone: String,
    val password: String,
    val role: String,
    val business_name: String,
    val informal_name: String,
    val address: String,
    val city: String,
    val state: String,
    val zip_code: Int,
    val registration_proof: String,
    val business_hours: BusinessHours,
    val device_token: String,
    val type: String,
    val social_id: String
): Parcelable

@Parcelize
data class BusinessHours(
    val mon: List<String>,
    val tue: List<String>,
    val wed: List<String>,
    val thu: List<String>,
    val fri: List<String>,
    val sat: List<String>,
    val sun: List<String>
): Parcelable

@Parcelize
data class RegisterResponse(
    val success: Boolean,
    val message: String
): Parcelable