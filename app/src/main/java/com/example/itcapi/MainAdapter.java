package com.example.itcapi;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.itcapi.model.EventsItem;
import com.example.itcapi.model.TeamsItem;
import com.example.itcapi.service.SportService;
import com.squareup.picasso.Picasso;

import java.util.List;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    List<EventsItem> Items;

    public MainAdapter(List<EventsItem> items) {
        Items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item, parent, false);

        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        EventsItem item = Items.get(position);
        holder.tvEvent.setText(item.getStrEvent());
        holder.tvDate.setText(item.getStrDate());
        holder.tvHomeTeam.setText(item.getStrHomeTeam());
        holder.tvAwayTeam.setText(item.getStrAwayTeam());

        Log.d("AAAAA", "" + holder.ivBadgeAway.getDrawable());
        if(Integer.parseInt(holder.ivBadgeAway.getTag().toString()) == 1111) {
            new SportService().getTeam(item.getStrAwayTeam(), new TeamListener() {
                @Override
                public void onSuccess(List<TeamsItem> items) {
                    holder.ivBadgeAway.setTag(R.drawable.ic_launcher_background);
                    Glide.with(holder.itemView.getContext()).load(items.get(0).getStrTeamBadge()).into(holder.ivBadgeAway);
                    //Picasso.get().load(items.get(0).getStrTeamBadge()).fit().into(holder.ivBadgeAway);
                }

                @Override
                public void onFailed(String msg) {
                    Log.i("ISI ERROR", msg);
                }
            });
        }

        if(Integer.parseInt(holder.ivBadgeHome.getTag().toString()) == 1111) {
            new SportService().getTeam(item.getStrHomeTeam(), new TeamListener() {
                @Override
                public void onSuccess(List<TeamsItem> items) {
                    holder.ivBadgeHome.setTag(2222);
                    Glide.with(holder.itemView.getContext()).load(items.get(0).getStrTeamBadge()).into(holder.ivBadgeHome);
                    //Picasso.get().load(items.get(0).getStrTeamBadge()).fit().into(holder.ivBadgeHome);
                }

                @Override
                public void onFailed(String msg) {
                    Log.i("ISI ERROR", msg);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return Items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvEvent, tvDate, tvHomeTeam, tvAwayTeam;
        ImageView ivBadgeAway, ivBadgeHome;
        View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
            tvEvent = itemView.findViewById(R.id.tv_event);
            tvDate = itemView.findViewById(R.id.tv_date);
            tvHomeTeam = itemView.findViewById(R.id.tv_home_team);
            tvAwayTeam = itemView.findViewById(R.id.tv_away_team);
            ivBadgeAway = itemView.findViewById(R.id.iv_badge_away);
            ivBadgeHome = itemView.findViewById(R.id.iv_badge_home);
        }
    }
}
