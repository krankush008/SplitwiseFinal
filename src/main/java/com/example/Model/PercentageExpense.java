package com.example.Model;

import java.util.HashMap;
import java.util.Map;

public abstract class PercentageExpense extends Expense{
    
    public PercentageExpense(Integer id){
        super(id);
    }

    public void setExpense(Integer userId, Map<Integer, Integer> percentage, Integer totalAmnt, Group group){
        Map<Integer, Integer> expenseForUser = new HashMap<>();
        super.group = group;
        super.paidBy = paidBy;
        for(int i=0;i<group.getUsers().size();i++){
            expenseForUser.put(group.getUsers().get(i).getId(), totalAmnt/(group.getUsers().size()-1));
        }
        expense.put(userId, expenseForUser);
        for(int i=0;i<group.getUsers().size();i++){
            Map<Integer, Integer> expenseForOweUser = new HashMap<>();
            expenseForOweUser.put(userId, totalAmnt/(group.getUsers().size()-1));
            expense.put(group.getUsers().get(i).getId(), expenseForOweUser);
        }
    }
}
