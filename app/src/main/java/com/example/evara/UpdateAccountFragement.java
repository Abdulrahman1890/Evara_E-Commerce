package com.example.evara;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.textfield.TextInputEditText;

public class UpdateAccountFragement extends Fragment {
    @Nullable

    private TextInputEditText password,confirmPassword;
    private EditText userName,email;
    private Button update;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.update_account_fragement,container,false);

        userName = view.findViewById(R.id.update_edt_username);
        email = view.findViewById(R.id.update_edt_email);
        password = view.findViewById(R.id.update_edt_password);
        confirmPassword = view.findViewById(R.id.update_edt_confirmpassword);
        update = view.findViewById(R.id.update_btn);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder m = new AlertDialog.Builder(getContext())
                        .setTitle("Updated...")
                        .setIcon(R.drawable.evara)
                        .setMessage("Your account has been updated")
                        .setPositiveButton("Thanks ♥️", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                startActivity(new Intent(getContext(), LogIn.class));
                            }
                        });
                m.create().show();
            }
        });
        return view;

    }
}
