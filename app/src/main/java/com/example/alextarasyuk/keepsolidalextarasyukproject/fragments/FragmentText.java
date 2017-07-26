package com.example.alextarasyuk.keepsolidalextarasyukproject.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alextarasyuk.keepsolidalextarasyukproject.R;
import com.example.alextarasyuk.keepsolidalextarasyukproject.SecondActivity;
import com.example.alextarasyuk.keepsolidalextarasyukproject.adapters.UserRecyclerAdapter;
import com.example.alextarasyuk.keepsolidalextarasyukproject.listeners.OnUserRecyclerItemClickListener;
import com.example.alextarasyuk.keepsolidalextarasyukproject.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentText extends Fragment {


    private RecyclerView usersRecyclerView;
    private UserRecyclerAdapter adapter;
    private ArrayList<User> users;

    public FragmentText() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.frag_text, container, false);

        users = new ArrayList<>();

        users.add(new User("Brad Pitt", 0, true, "pit@gmail.ru", User.Category.FRIENDS));
        users.add(new User("Ilon Mosk", 1, true, "mosk@gmail.ru", User.Category.WORK));
        users.add(new User("Christopher Nolan", 2, false, "nolan@gmail.ru", User.Category.FAMILY));
        users.add(new User("Soros", 3, false, "soros@gmail.ru", User.Category.OTHERS));



        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User u1, User u2) {
                return u1.getUserName().toLowerCase().compareTo(u2.getUserName().toLowerCase());
            }
        });

        usersRecyclerView = (RecyclerView) v.findViewById(R.id.rv_container);

        adapter = new UserRecyclerAdapter(users, getActivity(), new OnUserRecyclerItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                intent.putExtra("Username", users.get(position).getUserName());
                intent.putExtra("UserID", users.get(position).getUserId());
                intent.putExtra("UserStatus", users.get(position).isOnline());
                intent.putExtra("UserAddress", users.get(position).getUserAddress());
                intent.putExtra("UserCategory", users.get(position).getCategory());
                startActivityForResult(intent, 1);
            }
        });

        usersRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        usersRecyclerView.setAdapter(adapter);

        return v;
    }
}
