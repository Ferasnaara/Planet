package com.example.planet;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class HomePlanetFragment extends Fragment {

    Button btnAdd, btnShow;
    private String mParam1;
    private String mParam2;

    public HomePlanetFragment() {
    }

    public HomePlanetFragment newInstance(String param1, String param2) {
        HomePlanetFragment fragment = new HomePlanetFragment();
        Bundle args = new Bundle();
        args.putString(mParam1, param1);
        args.putString(param2, param2);
        fragment.equals(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(mParam1);
            mParam2 = getArguments().getString(mParam2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.sign_up, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        connectComponents();
    }

    private void connectComponents() {
        btnAdd = getView().findViewById(R.id.btnAddAddPlanet);
        btnShow = getView().findViewById(R.id.btnSendForgot);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoAddProductsFragment();
            }
        });

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoShowPlanetFragment();
            }
        });
    }

    private void gotoShowPlanetFragment() {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain, new ShowPlanetFragment());
        ft.commit();
    }

    private void gotoAddProductsFragment() {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain, new AddPlanetFragment());
        ft.commit();
    }
}