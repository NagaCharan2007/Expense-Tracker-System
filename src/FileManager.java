import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileManager {

    public static void saveExpenses(ArrayList<Expense> expenses) {

        try {

            PrintWriter writer =
                    new PrintWriter(new FileWriter("expenses.txt"));

            for (Expense e : expenses) {

                writer.println(
                        e.getId() + "," +
                        e.getDate() + "," +
                        e.getAmount() + "," +
                        e.getCategory() + "," +
                        e.getDescription()
                );
            }

            writer.close();

        } catch (Exception e) {
            System.out.println("Error Saving Data");
        }
    }
}
