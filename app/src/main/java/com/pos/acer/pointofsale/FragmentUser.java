package com.pos.acer.pointofsale;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUser extends Fragment implements View.OnClickListener {

    private DatabaseManager databaseManager;
    private RecyclerView recyclerView;
    private ArrayList<User> users;
    private UserAdapter userAdapter = new UserAdapter(users,getContext());
    private RecyclerView.LayoutManager layoutManager;
    private Button addUser;
    public FragmentUser() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.activity_fragment_user,container,false);
        addUser = (Button) v.findViewById(R.id.addUserForm);
        addUser.setOnClickListener(this);
        recyclerView = (RecyclerView)v.findViewById(R.id.RecyUser);
        recyclerView.setHasFixedSize(true);
        setRetainInstance(true);
        this.setHasOptionsMenu(true);
        layoutManager = new LinearLayoutManager(getActivity());
        databaseManager = new DatabaseManager(getActivity());
        users = databaseManager.getAllUser();
        if(users!= null)
        {
            userAdapter = new UserAdapter(users,getContext());
        }
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(userAdapter);
        return v;
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.addUserForm)
        {
            getActivity().startActivity( new Intent(getContext(),RegisterActivity.class));
        }
    }
}
