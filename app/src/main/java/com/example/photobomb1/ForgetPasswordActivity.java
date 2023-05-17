package com.example.photobomb1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ForgetPasswordActivity extends AppCompatActivity {

    AppCompatButton btnResetPassword;
    TextInputLayout edtMobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        btnResetPassword=findViewById(R.id.btnResetPassword);
        edtMobile=findViewById(R.id.edtMobile);

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CheckField()){
                    startActivity(new Intent(ForgetPasswordActivity.this,OtpVerificationActivity.class));


                }

            }
        });
    }
    private boolean CheckField (){
        String number=edtMobile.getEditText().getText().toString();
        if (number.isEmpty()){
            edtMobile.setError("This field is required");
            return false;
        }else {
            if (number.length()<10){
                edtMobile.setError("Enter valid number");
                return false;
            }else {
                edtMobile.setError(null);
                return true;
            }
        }

    }
}