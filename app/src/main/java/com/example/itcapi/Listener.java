package com.example.itcapi;

import com.example.itcapi.model.EventsItem;

import java.util.List;

public interface Listener<T> {
    void onSuccess(List<T> items);
    void onFailed(String msg);
}
