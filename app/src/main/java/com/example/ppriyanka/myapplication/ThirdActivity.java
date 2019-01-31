package com.example.ppriyanka.myapplication;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ppriyanka.myapplication.databinding.ActivityThirdBinding;

public class ThirdActivity extends AppCompatActivity {
    private ActivityThirdBinding binding;
    String user,password;
    public final static String USER_NAME ="username";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_third);

        binding=DataBindingUtil.setContentView(this,R.layout.activity_third);

        user=getIntent().getStringExtra(USER_NAME);
        password=getIntent().getStringExtra("password");

        binding.username.setText(user);
        binding.password.setText(password);

    }
}
