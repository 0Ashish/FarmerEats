package com.example.farmereats

import com.example.farmereats.Model.ForgotPasswordRequest
import com.example.farmereats.Model.ForgotPasswordResponse
import com.example.farmereats.Model.LoginRequest
import com.example.farmereats.Model.LoginResponse
import com.example.farmereats.Model.OtpRequest
import com.example.farmereats.Model.OtpResponse
import com.example.farmereats.Model.RegisterRequest
import com.example.farmereats.Model.RegisterResponse
import com.example.farmereats.Model.ResetPasswordRequest
import com.example.farmereats.Model.ResetPasswordResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("user/login")
    fun userLogin(
        @Body
        body: LoginRequest
    ): Call<LoginResponse>

    @POST("user/register")
    fun userRegister(
        @Body
        body: RegisterRequest
    ): Call<RegisterResponse>

    @POST("user/forgot-password")
    fun userForgotPassword(
        @Body
        body: ForgotPasswordRequest
    ):Call<ForgotPasswordResponse>

    @POST("user/verify-otp")
    fun userResetPassword(
        @Body
        body: ResetPasswordRequest
    ): Call<ResetPasswordResponse>

    @POST("user/reset-password")
    fun verifyOtp(
        @Body
        body: OtpRequest
    ):Call<OtpResponse>
}