package com.example.ejemplochat.View;

import com.example.ejemplochat.model.MessageModel;

import java.util.List;

public interface ChatContract {

    /**
     * Interfaz que define las operaciones disponibles para la vista del chat.
     */

    void showConversations (List<MessageModel> conversatios); // Puedes cambiar el tipo de datos según lo que contenga una conversación

    /**
     * Muestra una confirmación de que el mensaje ha sido enviado correctamente.
     */

    void showMessageSentConfirmation ();
}
