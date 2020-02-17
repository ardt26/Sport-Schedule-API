package com.example.itcapi;

import com.example.itcapi.model.TeamsItem;

import java.util.List;

public interface TeamListener {
    void onSuccess(List<TeamsItem> items);
    void onFailed(String msg);
}
