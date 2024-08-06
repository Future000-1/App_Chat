package com.example.ejemplochat;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.ejemplochat.Presenter.ChatPresenter;
import com.example.ejemplochat.Presenter.UserListPresenter;
import com.example.ejemplochat.View.ChatContract;
import com.example.ejemplochat.View.UserListContract;
import com.example.ejemplochat.model.MessageModel;
import com.example.ejemplochat.model.UserModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

public class chat extends AppCompatActivity implements UserListContract, ChatContract {

    private ListView conversationsListView;
    private EditText messageEditText;
    private Button sendButton;
    private ListView listView;
    private EditText searchEmailEditText;
    private Button searchUserButton;
    private TextView textViewMiddleTitle;
    private CardView listViewChatUsuarios;
    private LinearLayout messageInputLayout;

    // Variables de Firebase
    private FirebaseAuth mAuth;
    private FirebaseUser currentUser;

    // Variables de presentador
    private ChatPresenter chatPresenter;
    private UserListPresenter presenter;

    // Lista de usuarios y modelos de usuario
    private List<UserModel> usersList = new ArrayList<>();
    private UserModel user1;
    private UserModel user2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

    }

    @Override
    public void showConversations(List<MessageModel> conversatios) {

    }

    @Override
    public void showMessageSentConfirmation() {

    }

    @Override
    public void displayUser(List<UserModel> users) {

    }

    @Override
    public void showError(String message) {

    }
}