package com.example.Service;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.Model.Expense;
import com.example.Model.Group;
import com.example.Model.User;

import java.util.Map;


public class SplitwiseApp {
    
    Expense lastExpense;
    ArrayList<Expense> expenses;
    ArrayList<User> users;
    public SplitwiseApp(){
        expenses = new ArrayList<>();
        users =  new ArrayList<>();
    } 

    public void adjustExpense(Expense expense){
        Group group = expense.getGroup();
        for(int i=0; i<group.getUsers().size(); i++){
            for(int j=0; j<group.getUsers().size(); j++){
                if(i!=j){
                    Map<Integer, Integer> oweAmntLastExpense = lastExpense.getExpense().get(group.getUsers().get(i).getId())!=null?lastExpense.getExpense().get(group.getUsers().get(i).getId()): new HashMap<>();
                    Integer valueLastExpense = oweAmntLastExpense.get(group.getUsers().get(j).getId())!=null?oweAmntLastExpense.get(group.getUsers().get(j).getId()):0;
                    Map<Integer, Integer> oweAmntExpense = expense.getExpense().get(group.getUsers().get(i).getId())!=null?expense.getExpense().get(group.getUsers().get(i).getId()): new HashMap<>();
                    Integer valueExpense = oweAmntExpense.get(group.getUsers().get(j).getId())!=null?oweAmntExpense.get(group.getUsers().get(j).getId()):0;
                    oweAmntLastExpense.put(group.getUsers().get(j).getId(), valueExpense+valueLastExpense);
                    lastExpense.setExpense(group.getUsers().get(i).getId(), oweAmntLastExpense);
                }
            }
        }
    }

    public ArrayList<Expense> getExpenses(){
        return expenses;
    }

    public void addUser(Expense expense){
        for(int i=0; i<expense.getGroup().getUsers().size(); i++){
            boolean isPresentUser = false;
            for(int j=0; j<users.size(); j++){
                if(expense.getGroup().getUsers().get(i).getId()==users.get(j).getId()){
                    isPresentUser = true;
                }
            }
            if(isPresentUser==false){
                users.add(expense.getGroup().getUsers().get(i));
            }
        }
    }

    public void addExpense(Expense expense){
        this.expenses.add(expense);
        addUser(expense);
        if(this.expenses.size()==1){
            lastExpense = expense;
        }
        else{
            adjustExpense(expense);
        }
    }

    public void showExpense(Integer id){
        for(int i=0;i<expenses.size();i++){
            if(expenses.get(i).getId()==id){
                expenses.get(i).showExpense();
            }
        }
    }

    public Expense getLastExpense(){
        return lastExpense;
    }

    public void showLastExpense(Integer userId){
        for(int i=0; i<users.size(); i++){
            if(lastExpense.getExpense().get(userId).get(users.get(i).getId())!=null){
                System.out.println("user id = "+userId+" pays to = "+users.get(i).getId()+" amnt = "+lastExpense.getExpense().get(userId).get(users.get(i).getId()));
            }
        }
    }
}
