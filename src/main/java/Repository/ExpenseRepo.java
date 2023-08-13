package Repository;

import Model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ExpenseRepo extends MongoRepository<Expense, String> {
}
