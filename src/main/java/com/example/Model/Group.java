package com.example.Model;

import java.util.ArrayList;

public class Group {
    
    ArrayList<User> users;

    public Group(){
        users = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public ArrayList<User> getUsers(){
        return users;
    }
}
