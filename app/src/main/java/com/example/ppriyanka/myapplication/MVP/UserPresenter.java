package com.example.ppriyanka.myapplication.MVP;

import android.content.Context;

public class UserPresenter {

    User user;
    View mview;

    public UserPresenter(View view) {
        this.mview=view;
        this.user = new User();

    }

    public void updateUserName(String userName) {

        user.setFullName(userName);
        mview.updateInfo(user.toString());
    }

    public void updateEmail(String email) {
        user.setEmail(email);
        mview.updateInfo(user.toString());
    }

    public interface View {
        void updateInfo(String toString);
    }
}
