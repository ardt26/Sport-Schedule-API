package com.example.itcapi.service;

import com.example.itcapi.JadwalListener;
import com.example.itcapi.TeamListener;
import com.example.itcapi.model.EventsItem;
import com.example.itcapi.model.JadwalResponse;
import com.example.itcapi.model.TeamResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SportService {
    private Retrofit retrofit = null;

    public SportAPI getAPI(){
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(SportAPI.URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(SportAPI.class);
    }

    public void getJadwal(final JadwalListener listener){
        getAPI().getJadwal().enqueue(new Callback<JadwalResponse>() {
            @Override
            public void onResponse(Call<JadwalResponse> call, Response<JadwalResponse> response) {
                JadwalResponse data = response.body();

                if (data != null && data.getEvents() != null){
                    listener.onSuccess(data.getEvents()); //kayak return
                }
            }

            @Override
            public void onFailure(Call<JadwalResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }

    public void getTeam(String team, final TeamListener listener){
        getAPI().getTeam(team).enqueue(new Callback<TeamResponse>() {
            @Override
            public void onResponse(Call<TeamResponse> call, Response<TeamResponse> response) {
                TeamResponse data = response.body();

                if (data != null && data.getTeams() != null){
                    listener.onSuccess(data.getTeams());
                }
            }

            @Override
            public void onFailure(Call<TeamResponse> call, Throwable t) {
                listener.onFailed(t.getMessage());
            }
        });
    }
}
