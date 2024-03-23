package com.example.Model;

import java.util.HashMap;
import java.util.Map;

public class EqualExpense extends ExactExpense{
    
    public EqualExpense(Integer id){
        super(id);
    }

    public void setExpense(Integer userId, Integer totalAmnt, Group group){
        Map<Integer, Integer> exact = new HashMap<>();
        super.group = group;
        super.paidBy = userId;
        for(int i=0;i<group.getUsers().size();i++){
            if(group.getUsers().get(i).getId()!=userId){
                exact.put(group.getUsers().get(i).getId(), totalAmnt/group.getUsers().size()-1);
            }
        }
        super.setExpense(userId, exact, totalAmnt, group);
    }
}
