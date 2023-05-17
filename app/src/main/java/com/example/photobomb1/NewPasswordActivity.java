package com.example.photobomb1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class NewPasswordActivity extends AppCompatActivity {

    AppCompatButton btnSavePassword;
    String passwordPtn = "^(?=.*[A-Za-z])(?=.*\\\\d)(?=.*[$@$!%*#?&])[A-Za-z\\\\d$@$!%*#?&]{8,}$";
    TextInputLayout edtPassword,edtConfirmPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password);

        btnSavePassword=findViewById(R.id.btnSavePassword);
        edtPassword=findViewById(R.id.edtPassword);
        edtConfirmPassword=findViewById(R.id.edtConfirmPassword);





        btnSavePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordValidation()|confirmPasswordValidation())
                startActivity(new Intent(NewPasswordActivity.this,SuccessfullySetPassword.class));
            }
        });
    }



    private boolean passwordValidation() {
        String passwordInput = edtPassword.getEditText().toString().trim();
        if (passwordInput.isEmpty()) {
            edtPassword.setError("Enter your Password");
            return false;
        } else if (!passwordInput.matches(passwordPtn)) {
            edtPassword.setError("Enter strong password");
            return false;
        } else {
            edtPassword.setError(null);
            return true;
        }
    }

    private boolean confirmPasswordValidation() {
        String confirmPasswordInput = edtConfirmPassword.getEditText().getText().toString().trim();
        if (confirmPasswordInput.isEmpty()) {
            edtConfirmPassword.setError("Enter your confirm password");
            return false;
        } else if (!confirmPasswordInput.equals(edtPassword.getEditText().getText().toString())) {
            edtConfirmPassword.setError("password not match");
            return false;
        } else {
            edtConfirmPassword.setError(null);
            return true;
        }
    }

}