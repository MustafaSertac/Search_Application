package com.example.testapplication.repo

import androidx.lifecycle.LiveData
import com.example.testapplication.model.ImageResponse
import com.example.testapplication.roomdb.Art
import com.example.testapplication.util.Resource

import retrofit2.Response

interface ArtRepositoryInterface {

    suspend fun insertArt(art : Art)

    suspend fun deleteArt(art: Art)

    fun getArt() : LiveData<List<Art>>

    suspend fun searchImage(imageString : String) : Resource<ImageResponse>

}