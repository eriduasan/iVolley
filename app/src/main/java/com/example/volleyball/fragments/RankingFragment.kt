package com.example.volleyball.fragments

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.volleyball.R
import com.example.volleyball.adapters.VolleyballAdapter
import com.example.volleyball.clases.Preliminary
import com.example.volleyball.clases.VolleyballResponse
import com.example.volleyball.databinding.FragmentRankingBinding
import com.example.volleyball.dialogs.SearchDialog
import com.example.volleyball.interfaces.ApiInterface
import com.google.android.material.snackbar.Snackbar
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RankingFragment : Fragment(), Callback<VolleyballResponse> {

    private val BASE_URL = "https://5de4-45-133-138-16.ngrok-free.app"
    lateinit var binding: FragmentRankingBinding
    private var rankingList = mutableListOf<Preliminary>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentRankingBinding.inflate(inflater)

        setRecyclerView()
        getVolleyballData()

        // binding.rankingRecview.adapter = VolleyballAdapter(rankingList, requireContext())
        // binding.rankingRecview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)


        val dialogFunction = { year: String ->
            getVolleyballData(year)
        }

        binding.rankingFloatingBtn.setOnClickListener {
            SearchDialog(dialogFunction).show(requireActivity().supportFragmentManager, "SEARCH_DIALOG")
        }


        return binding.root
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        setRecyclerView()

    }

    fun setRecyclerView() {

        binding.rankingRecview.adapter = VolleyballAdapter(rankingList, requireContext())

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            binding.rankingRecview.layoutManager = GridLayoutManager(requireContext(), 2)
        } else {
            binding.rankingRecview.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        }
    }

    private fun getRetrofit(url: String) : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getVolleyballData(string: String = "2023") {
        val call = getRetrofit(BASE_URL)
            .create(ApiInterface::class.java)
            .getData(string)

        call.enqueue(this)
    }

    override fun onResponse(
        call: Call<VolleyballResponse>,
        response: Response<VolleyballResponse>
    ) {
        try {
            val preliminary = response.body()?.data?.preliminary

            rankingList.clear()
            rankingList.addAll(preliminary!!)

            binding.rankingRecview.adapter = VolleyballAdapter(rankingList, requireContext())
        } catch (err: NullPointerException) {
            Snackbar.make(binding.root, getString(R.string.api_call_failed), Snackbar.LENGTH_LONG).show()
        }
    }

    override fun onFailure(call: Call<VolleyballResponse>, t: Throwable) {
        Log.d("data","Error")
    }

}