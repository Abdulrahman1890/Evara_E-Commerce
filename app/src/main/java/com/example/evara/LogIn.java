package com.example.evara;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogIn extends AppCompatActivity {


    private TextInputEditText password;
    private EditText email;
    private Button login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        getSupportActionBar().hide();

        email = findViewById(R.id.login_edt_email);
        password = findViewById(R.id.login_edt_password);
        login = findViewById(R.id.login_btn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().isEmpty()){
                    email.setError("Can't be Empty");
                }else if(password.getText().toString().isEmpty()){
                    password.setError("Can't be Empty");
                }
                else{
                    login();
                }
            }
        });

    }

    public void login(){
        Call<RegisterRespond> call = ApiClient.getInstance().getApi().loginUser(email.getText().toString(),password.getText().toString());

        call.enqueue(new Callback<RegisterRespond>() {
            @Override
            public void onResponse(Call<RegisterRespond> call, Response<RegisterRespond> response) {
                RegisterRespond registerRespond = response.body();

                if(registerRespond.getStatus()){
                    Toast.makeText(getApplicationContext(), "Successd", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(registerRespond.getErrNum().equals("E007")){
                        email.setError("Invalid Email");
                    }
                    else if(registerRespond.getErrNum().equals("E1001")){
                        password.setError("Invalid Password");
                    }
                    else{
                        Toast.makeText(getApplicationContext(), registerRespond.getMsg(), Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<RegisterRespond> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Connection Failed", Toast.LENGTH_SHORT).show();
            }
        });
    }


}