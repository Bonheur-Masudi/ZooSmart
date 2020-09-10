package com.quimplex.q_shopdrc.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.quimplex.q_shopdrc.AccueilActivity;
import com.quimplex.q_shopdrc.MainActivity;
import com.quimplex.q_shopdrc.QRCode.ScaningQR;
import com.quimplex.q_shopdrc.R;


public class Menu2Fragment extends Fragment {

    Button scan;
    public static TextView res;
    public Menu2Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_menu2, container, false);
            scan=(Button)view.findViewById(R.id.scanId);
            res=(TextView)view.findViewById(R.id.textResult);
            scan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent();
                    intent.setClass(getActivity(), ScaningQR.class);
                    getActivity().startActivity(intent);

                }
            });
        return view;
    }


}
