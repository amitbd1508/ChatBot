package com.blackflag.chatbot;

/**
 * Created by BlackFlag on 7/14/2016.
 */
public class Message {



    public String emotion;
    public String chatbotName;
    public String firstName;
    public String lastName;
    public String gender;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Message() {
    }

    public String getLastName() {

        return lastName;
    }

    public Message(String gender, String name, String message, String lastName, String firstName) {
        this.gender = gender;
        this.name = name;
        this.message = message;
        this.lastName = lastName;
        this.firstName = firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmotion() {
        return emotion;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public String getChatbotName() {
        return chatbotName;
    }

    public void setChatbotName(String chatbotName) {
        this.chatbotName = chatbotName;
    }



    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;
    public String getMessage() {

        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    String message;
}
