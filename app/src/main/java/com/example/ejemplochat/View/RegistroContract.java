package com.example.ejemplochat.View;

public interface RegistroContract {

    interface View{
        void showToast(String message);

        void clearInputField();

        void navigateToLogin();

        String getName();

        String getEmail();
        String getPassword();
    }
}
