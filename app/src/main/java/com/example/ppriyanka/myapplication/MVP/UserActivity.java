package com.example.ppriyanka.myapplication.MVP;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.example.ppriyanka.myapplication.R;
import com.example.ppriyanka.myapplication.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity implements UserPresenter.View {

    UserPresenter presenter;

    ProgressBar progressBar;

    ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_user);
//        setContentView(R.layout.activity_user);

        presenter= new UserPresenter(this);
        intialiseProgressBar();

        binding.email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                presenter.updateEmail(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

                hideProgressBar();

            }
        });

        binding.userName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                presenter.updateUserName(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

                hideProgressBar();

            }
        });
    }

    private void hideProgressBar() {

        progressBar.setVisibility(View.INVISIBLE);

    }

    private void intialiseProgressBar() {

        progressBar = new ProgressBar(this,null,R.attr.progressBarStyle);

        progressBar.setIndeterminate(true);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Resources.getSystem().getDisplayMetrics().widthPixels,250);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addContentView(progressBar,params);
        showProgressBar();
    }

    private void showProgressBar() {

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void updateInfo(String userInfo) {
        binding.userInformation.setText(userInfo);
    }
}
