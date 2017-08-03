package com.example.alextarasyuk.keepsolidalextarasyukproject.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.alextarasyuk.keepsolidalextarasyukproject.R;
import com.example.alextarasyuk.keepsolidalextarasyukproject.model.User;
import java.util.ArrayList;


public class UserAdapter extends BaseAdapter {

    private ArrayList<User> users;
    private Context ctx;

    public UserAdapter(ArrayList<User> users, Context ctx) {
        this.users = users;
        this.ctx = ctx;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public User getItem(int i) {
        return users.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;

        View v = view;

        if (v == null) {
            LayoutInflater inflater =
                    LayoutInflater.from(ctx);
            v = inflater.inflate(R.layout.user_item, viewGroup, false);

            holder = new ViewHolder();

            holder.tvUserName = (TextView) v.findViewById(R.id.tv_user_name);
            holder.vUserStatus = v.findViewById(R.id.tv_user_category);

            v.setTag(holder);
        } else{
            holder = (ViewHolder) v.getTag();
        }

            holder.tvUserName.setText(getItem(i).getUserName());

            if(getItem(i).isOnline()){
                holder.vUserStatus.setBackground(ContextCompat.getDrawable(ctx, R.drawable.circle_online));
            } else {
                holder.vUserStatus.setBackground(ContextCompat.getDrawable(ctx, R.drawable.circle_offline));
            }
        return v;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    private static class ViewHolder {
        TextView tvUserName;
        View vUserStatus;
    }
}
