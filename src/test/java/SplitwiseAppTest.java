

import com.example.Model.EqualExpense;
import com.example.Model.Expense;
import com.example.Model.Group;
import com.example.Model.User;
import com.example.Service.SplitwiseApp;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class SplitwiseAppTest {

    @Test
    public void testAddExpense() {
        SplitwiseApp splitwiseApp = new SplitwiseApp();
        Expense expense = new EqualExpense(1);
        ArrayList<Expense> expenses = new ArrayList<>();
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
        expenses.add(expense);
        expenses.add(expense1);
        // Add expense
        splitwiseApp.addExpense(expense1);

        // Verify that the expense was added
        assertEquals(expenses, splitwiseApp.getExpenses());
        Map<Integer, Integer> expenseForUser = new HashMap<>();
        expenseForUser.put(1, -333);
        Map<Integer, Map<Integer, Integer> >expensesForUsers = new HashMap<>();
        Map<Integer, Integer> expense0 = new HashMap<>();
        expense0.put(2, -667);
        expense0.put(5, 333);
        expense0.put(7, 333);
        expensesForUsers.put(1, expense0);
        Map<Integer, Integer> expense2 = new HashMap<>();
        expense2.put(1, 667);
        expensesForUsers.put(2, expense2);
        Map<Integer, Integer> expense3 = new HashMap<>();
        expense3.put(1, -333);
        expensesForUsers.put(5, expense3);
        Map<Integer, Integer> expense4 = new HashMap<>();
        expense4.put(1, -333);
        expensesForUsers.put(7, expense4);
        assertEquals(expensesForUsers, splitwiseApp.getLastExpense().getExpense());
        //assertEquals(expense1, splitwiseApp.getLastExpense());
    }

    
}
