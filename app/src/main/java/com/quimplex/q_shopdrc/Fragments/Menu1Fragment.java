package com.quimplex.q_shopdrc.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.quimplex.q_shopdrc.R;


public class Menu1Fragment extends Fragment implements View.OnClickListener{

    DrawerLayout drawerLayout;
    ImageView navigationBar;
    NavigationView navigationView;
    TextView tv_logout;
    private TextView un,deux;
    private  View view;

    public Menu1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_menu1, container, false);

        onSetNavigationDrawerEvents();
        return view;
    }
    private void onSetNavigationDrawerEvents() {
        drawerLayout = (DrawerLayout)view.  findViewById(R.id.drawerLayout);
        navigationView = (NavigationView)view.  findViewById(R.id.navigationView);

        drawerLayout.openDrawer(GravityCompat.START);

        navigationBar = (ImageView)view. findViewById(R.id.navigationBar);

        un = (TextView) view. findViewById(R.id.textView2);
        deux = (TextView) view. findViewById(R.id.textView3);

        navigationBar.setOnClickListener(this);
        un.setOnClickListener(this);
        deux.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.navigationBar:
                drawerLayout.openDrawer(navigationView, true);
                break;
            case R.id.textView2:
                Toast.makeText(getContext(),"Un",Toast.LENGTH_LONG).show();
                break;
            case R.id.textView3:
                Toast.makeText(getContext(),"Un",Toast.LENGTH_LONG).show();
                break;

        }
    }






}
