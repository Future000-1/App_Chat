package com.example.ejemplochat.View;

public interface LoginContract {

    interface View{

        void ShowToast(String message);

        void navigateTohome();

        String getEmail();


        String getPassword();

    }
}
