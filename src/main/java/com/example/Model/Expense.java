package com.example.Model;

import java.util.HashMap;
import java.util.Map;

public abstract class Expense {
    
    Integer id;
    Group group;
    Integer paidBy;
    Map<Integer, Map<Integer, Integer>> expense;

    public Expense(Integer id){
        this.id = id;
        this.expense = new HashMap<>();
    }   
    
    public Integer getId(){
        return id;
    }

    public Group getGroup(){
        return group;
    }

    public Map<Integer, Map<Integer, Integer>> getExpense(){
        return expense;
    }

    public void setExpense(Integer userId, Map<Integer, Integer> oweAmnt){
        expense.put(userId, oweAmnt);
    }

    public abstract void setExpense(Integer userId, Integer totalAmnt, Group group);
    public abstract void setExpense(Integer userId, Map<Integer, Integer> percentage, Integer totalAmnt, Group group);

    public void showExpense(){
        for(int i=0;i<group.getUsers().size();i++){
            if(group.getUsers().get(i).getId()==paidBy){
                for(int j=0;j<group.getUsers().size();j++){
                    System.out.println("paid by = "+paidBy+" to = "+group.getUsers().get(j).getId()+" amnt = "+expense.get(paidBy).get(group.getUsers().get(j).getId()));
                }
            }    
            else{
                System.out.println("pay by = "+group.getUsers().get(i).getId()+" to = "+paidBy+" amnt = "+expense.get(group.getUsers().get(i).getId()).get(paidBy));
            }
        }
        
    }
}
