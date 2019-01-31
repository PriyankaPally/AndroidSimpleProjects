package com.example.ppriyanka.myapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ppriyanka.myapplication.databinding.ActivityOkBinding;

public class OkActivity extends AppCompatActivity {

    ActivityOkBinding binding;
    public final static String USER_NAME ="username";
    String text,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=DataBindingUtil.setContentView(this,R.layout.activity_ok);


        binding.submit.setOnClickListener(mClickListener);

    }
    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            password=binding.password.getText().toString();
            text=getIntent().getStringExtra(USER_NAME);
            binding.password.setText("");
            Intent i = new Intent(/*getApplicationContext(),ThirdActivity.class*/);
            i.putExtra(USER_NAME,text);
            i.putExtra("password",password);
            setResult(1,i);
//            startActivityForResult(i,1);
            finish();
//            startActivity(i);
        }
    };
}
