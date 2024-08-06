package com.example.ejemplochat.model;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class RegistroModel {

    private FirebaseAuth auth;
    private FirebaseFirestore db;
    private DatabaseReference database; // referenia a bases de datos en  tiempo real


    // Constructor para inicializar las instancias de FirebaseAuth, FirebaseFirestore y DatabaseReference

    public RegistroModel(){
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        database = FirebaseDatabase.getInstance().getReference();
    }

    public void registerUser(String email, String Password, RegistroCallback callback){
        auth.createUserWithEmailAndPassword(email, Password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        FirebaseUser user = auth.getCurrentUser();
                        if (user != null){
                            callback.onSuccess(user);
                        }
                    }else {
                        callback.onFailure(task.getException());
                    }
                });
    }

    // Método para almacenar los datos del usuario en Firestore
    public void storeUserData(FirebaseUser user, Map<String, Object> userData, RegistroCallback callback){
        db.collection("usuarios")
                .document(user.getUid())
                .set(userData)
                .addOnSuccessListener(Void -> callback.onSuccess(null))
                .addOnFailureListener(callback::onFailure);
    }

    // Método para guardar los datos del usuario en la base de datos en tiempo real de Firebase
    public void guardarUsuario(UserModel user){
        DatabaseReference usersRef = database.child("users");
        usersRef.child(user.getUserId()).setValue(user)
                .addOnSuccessListener(Void -> {

                })
                .addOnFailureListener(e -> {

                });
    }
    


    public interface RegistroCallback{
        void onSuccess (Object result); // Método llamado cuando la operación tiene éxito
        void onFailure(Exception e); // Método llamado cuando la operación falla
    }

}
