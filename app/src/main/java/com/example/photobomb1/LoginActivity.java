package com.example.photobomb1;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
public class LoginActivity extends AppCompatActivity {
    String passwordPtn = "^(?=.*[A-Za-z])(?=.*\\\\d)(?=.*[$@$!%*#?&])[A-Za-z\\\\d$@$!%*#?&]{8,}$";


    ImageView backBtn;
    AppCompatButton btnLogin;
    TextInputEditText mobile,Password;
    TextView tvSignup;
    TextView tvForgotPassword;
    boolean isFiledcheck = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

      //  getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnLogin=findViewById(R.id.btnLogin);
        backBtn=findViewById(R.id.backBtn);
        tvSignup=findViewById(R.id.tvSignUp);
        Password=findViewById(R.id.edtPassword);
        tvForgotPassword=findViewById(R.id.tvForgotPassword);
        mobile=findViewById(R.id.edtMobile);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            isFiledcheck=CheckField();
            if (isFiledcheck|passwordMethod()) {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
            }
            }
        });
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,ViewPage.class);
                startActivity(intent);
            }
        });
        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,SignupActivity.class));
            }
        });
        tvForgotPassword.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgetPasswordActivity.class));
            }
        }));
    }
    private boolean CheckField(){
        if(mobile.length()==0) {
            mobile.setError("This filed is required");
            return false;
        }else if (mobile.length()<10){
            mobile.setError("number must be minimum 10 characters");
            return false;
        }
        return true;
    }

    private boolean passwordMethod() {
        String passwordInput = Password.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            Password.setError("Enter your Password");
            return false;
        } else if (!passwordInput.matches(passwordPtn)) {
            Password.setError("Enter strong password");
            return false;
        } else {
            Password.setError(null);
            return true;

        }
    }
}