package com.example.itcapi;

import com.example.itcapi.model.EventsItem;

import java.util.List;

//Fungsi class ini untuk menghubungkan MainActivity dengan SportService

public interface JadwalListener {
    void onSuccess(List<EventsItem> items);
    void onFailed(String msg);
}
