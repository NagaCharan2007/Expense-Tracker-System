import java.util.ArrayList;

public class ReportGenerator {

    public static void totalReport(ArrayList<Expense> expenses) {

        double total = 0;

        for (Expense e : expenses) {
            total += e.getAmount();
        }

        System.out.println("\n===== REPORT =====");
        System.out.println("Total Expense: ₹" + total);
    }
}
