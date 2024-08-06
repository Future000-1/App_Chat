package com.example.ejemplochat.model;

import java.util.Date;

public class MessageModel {

    private String messageId;       // Identificador único del mensaje
    private String messageText;     // Texto del mensaje
    private String senderId;        // ID del remitente del mensaje
    private String senderName;      // Nombre del remitente del mensaje
    private Date timestamp;         // Marca de tiempo del mensaje
    private String senderEmail;     // Correo electrónico del remitente del mensaje


    // Constructor vacío requerido por Firebase
    public MessageModel(){

    }

    public MessageModel (String messageId, String messageText, String senderId, String senderName, Date timestamp, String senderEmail) {
        this.messageId = messageId;
        this.messageText = messageText;
        this.senderId = senderId;
        this.senderName = senderName;
        this.timestamp = timestamp;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
