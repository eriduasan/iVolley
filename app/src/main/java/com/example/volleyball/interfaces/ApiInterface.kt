package com.example.volleyball.interfaces

import com.example.volleyball.clases.VolleyballResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface ApiInterface {
    @GET
    fun getData(@Url string: String = ""): Call<VolleyballResponse>

}