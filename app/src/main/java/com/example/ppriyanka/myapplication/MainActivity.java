package com.example.ppriyanka.myapplication;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ppriyanka.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    String editText,user,password;
    public final static String USER_NAME ="username";

//    ActivityMainBinding

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main);

//        binding.text.setText("Priyanka");


        binding.ok.setOnClickListener(mClickListener);
    }

    private View.OnClickListener mClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            editText = binding.editText.getText().toString();

            binding.editText.setText("");

            Intent i = new Intent(getApplicationContext(),OkActivity.class);
            i.putExtra(USER_NAME,editText);
            startActivityForResult(i,1);
//            startActivity(i);

        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==1)
        {
            user = data.getStringExtra(USER_NAME);
            password=data.getStringExtra("password");
            binding.textView.setText(user);
            binding.password.setText(password);
        }
    }
}
