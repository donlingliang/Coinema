package com.don.coinema

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var popularRecyclerView: RecyclerView
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initRetrofitClient()
    }

    private fun initRecyclerView() {
        popularRecyclerView = findViewById(R.id.popular_recyclerview)
        popularRecyclerView.layoutManager = GridLayoutManager(
            this,
            2,
            RecyclerView.VERTICAL,
            false
        )

        moviesAdapter = MoviesAdapter(listOf())
        popularRecyclerView.adapter = moviesAdapter
    }

    private fun initRetrofitClient() {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val authInterceptor = Interceptor { chain ->
            val original = chain.request().url
            val requestUrl = original.newBuilder()
                .addQueryParameter("api_key", Api.API_KEY).build()
            val request = chain.request().newBuilder().url(requestUrl).build()
            chain.proceed(request)
        }

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .addInterceptor(authInterceptor)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(Api.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()

        val movieApi = retrofit.create(MovieApi::class.java)
        movieApi.getPopularMovie().enqueue(object : Callback<MovieResponse> {
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "onFailure called", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                Toast.makeText(this@MainActivity, "onResponse called", Toast.LENGTH_SHORT).show()
                moviesAdapter.updateMoviesList(response.body()?.results)
            }
        })
    }
}
