package com.example.ejemplochat.Presenter;

import com.example.ejemplochat.View.LoginContract;
import com.example.ejemplochat.model.LoginModel;
import com.google.firebase.auth.FirebaseUser;

public class LoginPresenter {
    private LoginContract.View view;
    private LoginModel model;

    //constructir para inicializar

    public LoginPresenter(LoginContract.View view, LoginModel model) {
        this.view = view;
        this.model = model;
    }

    //cuando se logee

    // Obtener el email y la contraseña ingresados por el usuario desde la vista

    public void loginUser() {
        String email = view.getEmail();
        String password = view.getPassword();

        // Validar que el email y la contraseña no estén vacíos
        if (email.isEmpty() || password.isEmpty()) {
            view.ShowToast("Por favor, completa todos los campos");
            return;
        }

        // Llamar al método del modelo para iniciar sesión, pasando un callback para manejar el resultado
        model.loginUser(email, password, new LoginModel.LoginCallback() {
            @Override
            // Método llamado en caso de éxito al iniciar sesión
            public void onSuccess(FirebaseUser user) {
                view.ShowToast("Inicio de sesión exitoso"); // Mostrar mensaje de éxito en la vista
                view.navigateTohome(); // Navegar a la pantalla de inicio en la vista
            }

            @Override
            // Método llamado en caso de fallo al iniciar sesión
            public void onFailure(Exception e) {
                view.ShowToast("Error de inicio de sesión: " + e.getMessage()); // Mostrar mensaje de error en la vista
            }
        });
    }


}

