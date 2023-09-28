package com.example.amangeldi_abdibaitov_mo2_hw6;


import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.text.Editable;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextWatcher;
import android.content.res.ColorStateList;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        EditText loginEditText = findViewById(R.id.login);
        EditText passwordEditText = findViewById(R.id.password);

        MaterialButton loginButton = findViewById(R.id.login_button);

        TextView text2 = findViewById(R.id.textView2);
        TextView text3 = findViewById(R.id.textView3);
        TextView text4 = findViewById(R.id.textView4);

        loginButton.setEnabled(false);

        loginEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkLoginAndPassword(loginEditText, passwordEditText, loginButton);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        passwordEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                checkLoginAndPassword(loginEditText, passwordEditText, loginButton);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });

        loginButton.setOnClickListener(view -> {

            String login = loginEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            if ("admin".equals(login) && "admin".equals(password)) {
                Toast.makeText(MainActivity.this, "Вы успешно зарегистрировались", Toast.LENGTH_SHORT).show();

                loginEditText.setVisibility(View.GONE);
                passwordEditText.setVisibility(View.GONE);
                loginButton.setVisibility(View.GONE);

                text2.setVisibility(View.GONE);
                text3.setVisibility(View.GONE);
                text4.setVisibility(View.GONE);

            } else {
                Toast.makeText(MainActivity.this, "Неправильный логин или пароль", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void checkLoginAndPassword(EditText loginEditText, EditText passwordEditText, MaterialButton loginButton) {
        String login = loginEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        if ("admin".equals(login) && "admin".equals(password)) {
            loginButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.yellow)));
            loginButton.setEnabled(true);
        } else {
            loginButton.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.gray)));
            loginButton.setEnabled(false);
        }
    }
}