package com.elearning.restcall;

import com.elearning.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface Api {

    String BASE_URL = "http://10.0.2.2:8000/api/";

    /**
     * The return type is important here
     * The class structure that you've defined in Call<T>
     * should exactly match with your json response
     * If you are not using another api, and using the same as mine
     * then no need to worry, but if you have your own API, make sure
     * you change the return type appropriately
     **/
    @GET("core/User/")
    Call<List<User>> getUsers();

    @POST("authentication/user/login/")
    Call<List<User>> getUserDetail(@Body User body);


    @POST("authentication/user/registration/")
    Call<User> saveData(@Body User user);
}
