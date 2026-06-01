import java.util.ArrayList;
import java.util.Scanner;

public class ExpenseTracker {

    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static int idCounter = 1;

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Update Expense");
            System.out.println("4. Delete Expense");
            System.out.println("5. Report");
            System.out.println("6. Save Data");
            System.out.println("7. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addExpense();
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    updateExpense();
                    break;

                case 4:
                    deleteExpense();
                    break;

                case 5:
                    ReportGenerator.totalReport(expenses);
                    break;

                case 6:
                    FileManager.saveExpenses(expenses);
                    break;

                case 7:
                    System.exit(0);
            }
        }
    }

    static void addExpense() {

        System.out.print("Date: ");
        String date = sc.nextLine();

        System.out.print("Amount: ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Category: ");
        String category = sc.nextLine();

        System.out.print("Description: ");
        String description = sc.nextLine();

        expenses.add(new Expense(
                idCounter++,
                date,
                amount,
                category,
                description));

        System.out.println("Expense Added");
    }

    static void viewExpenses() {

        for (Expense e : expenses) {
            System.out.println(e);
        }
    }

    static void updateExpense() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Expense e : expenses) {

            if (e.getId() == id) {

                System.out.print("New Amount: ");
                e.setAmount(sc.nextDouble());
                sc.nextLine();

                System.out.print("New Category: ");
                e.setCategory(sc.nextLine());

                System.out.print("New Description: ");
                e.setDescription(sc.nextLine());

                System.out.println("Updated");
                return;
            }
        }
    }

    static void deleteExpense() {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();

        expenses.removeIf(e -> e.getId() == id);

        System.out.println("Deleted");
    }
}
