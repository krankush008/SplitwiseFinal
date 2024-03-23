package com.example;

import com.example.Model.EqualExpense;
import com.example.Model.Expense;
import com.example.Model.Group;
import com.example.Model.User;
import com.example.Service.SplitwiseApp;

public class Main {
    public static void main(String[] args) {

        SplitwiseApp splitwiseApp = new SplitwiseApp();
        Expense expense = new EqualExpense(1);
        Group group =  new Group();
        User user1 = new User(1);
        User user2 = new User(2);
        User user3 = new User(5);
        User user4 = new User(7);
        group.addUser(user1);
        group.addUser(user2);
        group.addUser(user3);
        group.addUser(user4);
        expense.setExpense(1, 1000, group);
        splitwiseApp.addExpense(expense);

        Group group1 =  new Group();
        User user5 = new User(1);
        User user6 = new User(2);
        group1.addUser(user5);
        group1.addUser(user6);
        Expense expense1 = new EqualExpense(2);
        expense1.setExpense(2, 1000, group1);
        splitwiseApp.addExpense(expense1);
       // splitwiseApp.showExpense(1);
        splitwiseApp.showLastExpense(5);
    }
}