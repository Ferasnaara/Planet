package com.example.planet;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;


public class AddPlanetFragment extends Fragment {

    private FirebaseServices fbs;
    private EditText etName, etSize, etOrbit, etDistance;
    private Button btnAdd;


    private static final String ARG_P1 = "p1";
    private static final String ARG_P2 = "p2";

    private String mParam1;
    private String mParam2;

    public  AddPlanetFragment () {
    }
    public static  AddPlanetFragment  newInstance(String param1, String param2) {
        AddPlanetFragment fragment = new  AddPlanetFragment ();
        Bundle args = new Bundle();
        args.putString(ARG_P1, param1);
        args.putString(ARG_P2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_P1);
            mParam2 = getArguments().getString(ARG_P2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        connectComponents();

    }

    private void connectComponents() {
        fbs = FirebaseServices.getInstance();
        etName = getView().findViewById(R.id.btnSignupLogin);
        etSize = getView().findViewById(R.id.btnBackSignup);
        etOrbit = getView().findViewById(R.id.btnBackSignup);
        etDistance = getView().findViewById(R.id.btnSignupLogin);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get data from screen
                String Name = etName.getText().toString();
                String Size = etSize.getText().toString();
                String Orbit = etOrbit.getText().toString();
                String Distance = etDistance.getText().toString();

                if (Name.trim().isEmpty() || Size.trim().isEmpty() ||
                        Orbit.trim().isEmpty() || Distance.trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Some fields are empty!", Toast.LENGTH_LONG).show();
                    return;
                }

                Planet planet= new Planet(Name,Size,Orbit,Distance);

                fbs.getFire().collection("restaurants").add(fbs).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getActivity(), "Successfully added your restaurant!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("Failure AddRestaurant: ", e.getMessage());
                    }
                });


            }
        });
    }
}
