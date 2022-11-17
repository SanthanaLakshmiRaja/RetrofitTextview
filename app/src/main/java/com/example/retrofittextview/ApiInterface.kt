package com.example.retrofittextview

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("/posts")
  fun getdata(): Call<List<DataListItem>>
}