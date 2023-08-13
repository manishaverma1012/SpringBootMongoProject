package Controller;

import Model.Expense;
import Service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }
 //When the @RequestBody annotation is used, Spring Boot will automatically deserialize the request body into the Java object that is annotated with the @RequestBody annotation.
    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense)
    {
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public void updateExpense(Expense expense)
    {

    }
    @GetMapping
    public void getAllExpense()
    {
        ResponseEntity.ok(expenseService.getAllExpense());
    }

    public void getExpenseByName()
    {



    }
    @DeleteMapping
    public void deleteExpense()
    {

    }

}
