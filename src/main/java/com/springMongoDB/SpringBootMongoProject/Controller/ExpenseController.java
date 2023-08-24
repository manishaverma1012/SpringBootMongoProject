package com.springMongoDB.SpringBootMongoProject.Controller;

import com.springMongoDB.SpringBootMongoProject.Model.Expense;
import com.springMongoDB.SpringBootMongoProject.Service.ExpenseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Expense> updateExpense(Expense expense)
    {
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();

    }
    @GetMapping
    public void getAllExpense()
    {
        ResponseEntity.ok(expenseService.getAllExpense());
    }
    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name)
    {
        return ResponseEntity.ok(expenseService.getExpenseByName(name));




    }
    @DeleteMapping("/{Id}")
    public ResponseEntity deleteExpense(@PathVariable String Id)
    {
        expenseService.deleteExpense(Id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }

}
