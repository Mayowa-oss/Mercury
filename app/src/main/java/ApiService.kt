import com.example.learnviewmodel.response.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("Account/Auth")
    fun getLogin(@Body body: LoginPayload): Call<LoginResponse>
}