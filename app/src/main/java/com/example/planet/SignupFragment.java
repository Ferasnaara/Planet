package com.example.planet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

import org.checkerframework.checker.nullness.qual.NonNull;
public class SignupFragment extends Fragment
{
    private Button btnSignUpSIGNUP;
    private EditText etUsernameSIGNUP,etPasswordSIGNUP;
    private FirebaseServices fbs;

    private static final String ARG_P1 = "p1";
    private static final String ARG_P2 = "p2";

    private String mP1;
    private String mP2;

    public SignupFragment() {
    }


    public static SignupFragment newInstance(String p1, String p2) {
        SignupFragment fragment = new SignupFragment();
        Bundle args = new Bundle();
        args.putString(ARG_P1, p1);
        args.putString(ARG_P2, p2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mP1 = getArguments().getString(ARG_P1);
            mP2 = getArguments().getString(ARG_P2);
        }
    }



    @Override
    public void onStart() {
        super.onStart();
        etUsernameSIGNUP = getView().findViewById(R.id.btnSignupLogin);
        fbs=FirebaseServices.getInstance();
        etPasswordSIGNUP = getView().findViewById(R.id.btnSignupLogin);
        btnSignUpSIGNUP = getView().findViewById(R.id.btnSignupSignup);
        btnSignUpSIGNUP.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String eMail = etUsernameSIGNUP.getText().toString();
                String password = etPasswordSIGNUP.getText().toString();
                if (eMail.trim().isEmpty() && password.trim().isEmpty()) {
                    Toast.makeText(getActivity(), "some fields are empty!!!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                fbs.getAuth().createUserWithEmailAndPassword(eMail, password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        Intent i = new Intent(getActivity(), AllProductsActivity.class);
                        startActivity(i);
                        ((Activity) getActivity()).overridePendingTransition(0, 0);

                    }
                });
            }
        });
    }
    private class AllProductsActivity {
    }
}
