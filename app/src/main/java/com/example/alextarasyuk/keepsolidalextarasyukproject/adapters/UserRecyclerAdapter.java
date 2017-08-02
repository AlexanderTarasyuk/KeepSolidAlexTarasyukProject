package com.example.alextarasyuk.keepsolidalextarasyukproject.adapters;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.alextarasyuk.keepsolidalextarasyukproject.listeners.OnUserRecyclerItemClickListener;
import com.example.alextarasyuk.keepsolidalextarasyukproject.model.User;

import java.util.ArrayList;


public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.ViewHolder> {

    private ArrayList<User> users;
    private Context ctx;
    OnUserRecyclerItemClickListener listener;

    public UserRecyclerAdapter(ArrayList<User> users, Context ctx) {
        this.users = users;
        this.ctx = ctx;
    }

    public UserRecyclerAdapter(ArrayList<User> users, Context ctx, OnUserRecyclerItemClickListener listener) {
        this.users = users;
        this.ctx = ctx;
        this.listener = listener;
    }

    @Override
    public UserRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(listener != null){
                    listener.onItemClick(view, viewHolder.getAdapterPosition());
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(UserRecyclerAdapter.ViewHolder holder, int position) {
        holder.tvUserName.setText(users.get(position).getUserName());

        if (users.get(position).getCategory().equals(User.Category.FAMILY)) {
            holder.ivUserCategory.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.img_family));
        } else if (users.get(position).getCategory().equals(User.Category.FRIENDS)) {
            holder.ivUserCategory.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.img_friends));
        } else if (users.get(position).getCategory().equals(User.Category.WORK)) {
            holder.ivUserCategory.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.img_work));
        } else {
            holder.ivUserCategory.setImageDrawable(ContextCompat.getDrawable(ctx, R.drawable.img_other));
        }

        if (users.get(position).isOnline()) {
            holder.vUserStatus.setBackground(ContextCompat.getDrawable(ctx, R.drawable.circle_online));
        } else {
            holder.vUserStatus.setBackground(ContextCompat.getDrawable(ctx, R.drawable.circle_offline));
        }

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvUserName;
        ImageView ivUserCategory;
        View vUserStatus;

        public ViewHolder(View itemView) {
            super(itemView);
            tvUserName = (TextView) itemView.findViewById(R.id.tv_user_name_user_adapter);
            ivUserCategory = (ImageView) itemView.findViewById(R.id.iv_user_category_adapter);
            vUserStatus = itemView.findViewById(R.id.iv_user_category_adapter);
        }
    }
}
