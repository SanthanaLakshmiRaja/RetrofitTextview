package com.example.retrofittextview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.retrofittextview.RetrofitInstance.Api
import com.example.retrofittextview.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

getdata()

    }
    fun getdata()
    {


            val result = Api.getdata()

            result.enqueue(object : Callback<List<DataListItem>?> {
                override fun onResponse(
                    call: Call<List<DataListItem>?>,
                    response: Response<List<DataListItem>?>
                ) {
                    val responsebody = response.body()!!

                    val stringbuild = StringBuilder()

                    for (mydata in responsebody) {
                        stringbuild.append(mydata.id)
                        stringbuild.append("\n")
                    }
                    binding.txtView.text = stringbuild


                }

                override fun onFailure(call: Call<List<DataListItem>?>, t: Throwable) {
                    Log.d("Error: ", t.message.toString())
                }
            })

            //if (result != null)
            // Checking the results

            //  binding.txtView.text=result.body().toString()
            // Log.d("ayush: ", result.body().toString())
        }





}