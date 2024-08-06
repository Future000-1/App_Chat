package com.example.ejemplochat.Presenter;

import com.example.ejemplochat.View.RegistroContract;
import com.example.ejemplochat.model.RegistroModel;
import com.google.firebase.auth.FirebaseUser;

import java.util.HashMap;
import java.util.Map;

public class RegistroPresenter {

    private RegistroContract.View view; // interfaz de vista que maneja la interaccion
    private RegistroModel model; // modelo que maneja la logica del proyecto


    public RegistroPresenter(RegistroContract.View view, RegistroModel model) {
        this.view = view;
        this.model = model;
    }

    public void registerUser(){
        String name = view.getName();
        String email = view.getEmail();
        String password = view.getPassword();

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()){
            view.showToast("Por favor, completa todos los campos");
            return;
        }

        if (password.length() < 6) {
            view.showToast("La contraseña debe tener al menos 6 caracteres"); // Muestra un mensaje de advertencia en la vista
            return; // Sale del método si la contraseña es demasiado corta
        }

        model.registerUser(email, password, new RegistroModel.RegistroCallback() {
            @Override
            public void onSuccess(Object result) {
                FirebaseUser user = (FirebaseUser) result;
                Map<String, Object> userData = new HashMap<>();
                userData.put("name", name);
                userData.put("email", email);

                model.storeUserData(user, userData, new RegistroModel.RegistroCallback() {
                    @Override
                    public void onSuccess(Object result) {
                        view.showToast("Registro exitoso"); // Muestra un mensaje de éxito en la vista
                        view.clearInputField(); // Limpia los campos de entrada en la vista
                        view.navigateToLogin(); // Navega a la pantalla de inicio de sesión en la vista

                    }

                    @Override
                    public void onFailure(Exception e) {
                        view.showToast("Error al registrar en Firestore"); // Muestra un mensaje de error en la vista

                    }
                });
            }

            @Override
            public void onFailure(Exception e) {
                view.showToast("Error al registrar usuario"); // Muestra un mensaje de error en la vista

            }
        });
    }


}
