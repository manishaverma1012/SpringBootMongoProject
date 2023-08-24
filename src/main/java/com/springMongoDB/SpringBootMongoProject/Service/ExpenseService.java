package com.springMongoDB.SpringBootMongoProject.Service;

import com.springMongoDB.SpringBootMongoProject.Model.Expense;
import com.springMongoDB.SpringBootMongoProject.Repository.ExpenseRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepo expenseRepo;

    public ExpenseService(ExpenseRepo expenseRepo) {
        this.expenseRepo = expenseRepo;
    }

    public void addExpense(Expense expense)
    {
        expenseRepo.insert(expense);

    }
    public void updateExpense(Expense expense)
    {
        Expense savedExpense=expenseRepo.findById(expense.getId()).orElseThrow(()-> new RuntimeException(String.format("cannot find the expense by id", expense.getId())));

        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        expenseRepo.save(expense);


    }
    public List<Expense> getAllExpense()
    {
        return expenseRepo.findAll();
    }

    public Expense getExpenseByName(String name)
    {
        return expenseRepo.findByName(name).orElseThrow(()->new RuntimeException(String.format("cannot find the data by name", name)));

    }
    public void deleteExpense(String Id)
    {
        expenseRepo.deleteById(Id);

    }

}
