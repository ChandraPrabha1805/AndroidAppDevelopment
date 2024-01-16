package com.malviyastudio.omganeshaynamanew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {


    EditText edUsername, edPassword;
    Button btn;
    TextView tvNewUser, tvFp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername=findViewById(R.id.editTextLoginUsername);
        edPassword=findViewById(R.id.editTextLoginPassword);
        btn=findViewById(R.id.buttonLogin);
        tvNewUser=findViewById(R.id.textViewNewUser);
        tvFp=findViewById((R.id.textViewForgotPassword));

        btn.setOnClickListener(new View.OnClickListener()
        {@Override
            public void onClick(View view)
        {
            String username=edUsername.getText().toString();
            String password=edPassword.getText().toString();
            Database db=new Database(getApplicationContext(),"Malviya Studio",null,1);
            if( username.length()==0 || password.length() ==0)
            {
                Toast.makeText(getApplicationContext(),"Please fill all details",Toast.LENGTH_SHORT).show();
            }else {
                if(db.login(username,password)==1)
                {
                    Toast.makeText(getApplicationContext(),"Login successfully",Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences=getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("username",username);
                    //to save our data with key and value in local memory
                    editor.apply();
                    startActivity(new Intent(LoginActivity.this,HomeActivity.class));

                }else {
                    Toast.makeText(getApplicationContext(),"Invalid username and password",Toast.LENGTH_SHORT).show();
                }
            }
            }
        });
        tvNewUser.setOnClickListener(new View.OnClickListener()
        {@Override
        public void onClick(View view) {
        startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        }
        });
    }
}