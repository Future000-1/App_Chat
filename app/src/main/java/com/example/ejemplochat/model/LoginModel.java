package com.example.ejemplochat.model;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginModel {

    private FirebaseAuth auth;


    public LoginModel(){
        auth = FirebaseAuth.getInstance();
    }


    public void loginUser(String email, String password, LoginCallback callback){
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        FirebaseUser user = auth.getCurrentUser();
                        callback.onSuccess(user);
                    }else {
                        callback.onFailure(task.getException());
                    }

                });


    }


    public interface LoginCallback {
        // Método llamado cuando el inicio de sesión es exitoso
        void onSuccess(FirebaseUser user);
        // Método llamado cuando hay un error en el inicio de sesión
        void onFailure(Exception e);
    }
}
