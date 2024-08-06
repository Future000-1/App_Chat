package com.example.ejemplochat.View;

import com.example.ejemplochat.model.UserModel;

import java.util.List;

public interface UserListContract {


    void displayUser(List<UserModel> users);



    void showError(String message);
}
