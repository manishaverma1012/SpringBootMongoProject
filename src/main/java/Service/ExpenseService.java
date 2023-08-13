package Service;

import Model.Expense;
import Repository.ExpenseRepo;
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
        expenseRepo.save(expense);


    }
    public List<Expense> getAllExpense()
    {
        return expenseRepo.findAll();
    }
    public void getExpenseByName()
    {

    }
    public void deleteExpense(Expense expense)
    {
        expenseRepo.delete(expense);

    }

}
