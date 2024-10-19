import android.util.Log
import com.example.farmereats.ApiService
import com.example.farmereats.Model.BusinessHours
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
import retrofit2.Callback
import retrofit2.Response

class ApiRepository(
    private val apiService: ApiService
) {

    fun userLogin(
        email: String,
        password: String,
        role: String,
        device_token: String,
        type: String,
        social_id: String,
        callback: (Result<LoginResponse>) -> Unit
    ) {
        val request = LoginRequest(email = email, password = password, role = role, device_token = device_token, type = type, social_id = social_id)
        Log.d("request", request.toString())
        val call = apiService.userLogin(request)
        call.enqueue(object : Callback<LoginResponse> {
             override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callback(Result.success(it))
                    } ?: callback(Result.failure(Exception("Response body is null")))
                } else {
                    callback(Result.failure(Exception("Response is not successful")))
                }
            }

             override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                callback(Result.failure(t))
            }
        })
    }

    fun forgotPassword(
        mobile: String,
        callback: (Result<ForgotPasswordResponse>) -> Unit
    ){
        val call = apiService.userForgotPassword(ForgotPasswordRequest(mobile))
        call.enqueue(object : Callback<ForgotPasswordResponse> {
            override fun onResponse(call: Call<ForgotPasswordResponse>, response: Response<ForgotPasswordResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callback(Result.success(it))
                    } ?: callback(Result.failure(Exception("Response body is null")))
                } else {
                    callback(Result.failure(Exception("Response is not successful")))
                }
            }

            override fun onFailure(call: Call<ForgotPasswordResponse>, t: Throwable) {
                callback(Result.failure(t))
            }
        })
    }

    fun resetPassword(
        token: String,
        password: String,
        cpassword: String,
        callback: (Result<ResetPasswordResponse>) -> Unit
    ){
        val call = apiService.userResetPassword(ResetPasswordRequest(token, password, cpassword))
        call.enqueue(object : Callback<ResetPasswordResponse> {
            override fun onResponse(call: Call<ResetPasswordResponse>, response: Response<ResetPasswordResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callback(Result.success(it))
                    } ?: callback(Result.failure(Exception("Response body is null")))
                } else {
                    callback(Result.failure(Exception("Response is not successful")))
                }
            }

            override fun onFailure(call: Call<ResetPasswordResponse>, t: Throwable) {
                callback(Result.failure(t))
            }
        })
    }

    fun verifyOtp(
        mobile: String,
        callback: (Result<OtpResponse>) -> Unit
    ){
        val call = apiService.verifyOtp(OtpRequest(mobile))
        call.enqueue(object : Callback<OtpResponse> {
            override fun onResponse(call: Call<OtpResponse>, response: Response<OtpResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callback(Result.success(it))
                    } ?: callback(Result.failure(Exception("Response body is null")))
                } else {
                    callback(Result.failure(Exception("Response is not successful")))
                }
            }

            override fun onFailure(call: Call<OtpResponse>, t: Throwable) {
                callback(Result.failure(t))
            }
        })
    }

    fun userRegister(
        full_name: String,
        email: String,
        phone: String,
        password: String,
        role: String,
        business_name: String,
        informal_name: String,
        address: String,
        city: String,
        state: String,
        zip_code: Int,
        registration_proof: String,
        business_hours: BusinessHours,
        device_token: String,
        type: String,
        social_id: String,
        callback: (Result<RegisterResponse>) -> Unit
    ) {
        val request = RegisterRequest(
            full_name = full_name,
            email = email,
            phone = phone,
            password = password,
            role = role,
            business_name = business_name,
            informal_name = informal_name,
            address = address,
            city = city,
            state = state,
            zip_code = zip_code,
            registration_proof = registration_proof,
            business_hours = business_hours,
            device_token = device_token,
            type = type,
            social_id = social_id
        )
        val call = apiService.userRegister(request)
        call.enqueue(object : Callback<RegisterResponse> {
            override fun onResponse(call: Call<RegisterResponse>, response: Response<RegisterResponse>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        callback(Result.success(it))
                    } ?: callback(Result.failure(Exception("Response body is null")))
                } else {
                    callback(Result.failure(Exception("Response is not successful")))
                }
            }

            override fun onFailure(call: Call<RegisterResponse>, t: Throwable) {
                callback(Result.failure(t))
            }
        })
    }


}