package com.example.itcapi.service;

import com.example.itcapi.model.JadwalResponse;
import com.example.itcapi.model.TeamResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//Class ini buat taro URL, kalo ada yang mau ditaro lagi.Langsung di bawahnya.

public interface SportAPI {
    static final String URL_BASE = "https://www.thesportsdb.com/";

    @GET("api/v1/json/1/eventsnextleague.php?id=4328")
    Call<JadwalResponse> getJadwal(); //mengambil data dan disimpan di JadwalResponse, nama yang ngambil itu getJadwal()

    @GET("api/v1/json/1/searchteams.php")
    Call<TeamResponse> getTeam(@Query("t") String team);
}
