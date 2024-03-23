package com.example.Model;

import java.util.HashMap;
import java.util.Map;

public abstract class ExactExpense extends Expense{
    
    public ExactExpense(Integer id){
        super(id);
    }

     public void setExpense(Integer userId, Map<Integer, Integer> percentage, Integer totalAmnt, Group group){
        Map<Integer, Integer> expenseForUser = new HashMap<>();
        super.group = group;
        super.paidBy = paidBy;
        for(int i=0;i<group.getUsers().size();i++){
            if(group.getUsers().get(i).getId()!=userId){
                expenseForUser.put(group.getUsers().get(i).getId(), totalAmnt/(group.getUsers().size()-1));
                Map<Integer, Integer> expenseForOweUser = new HashMap<>();
                expenseForOweUser.put(userId, -1*totalAmnt/(group.getUsers().size()-1));
                expense.put(group.getUsers().get(i).getId(), expenseForOweUser);
            }

        }
       
        expense.put(userId, expenseForUser);
    }
}
