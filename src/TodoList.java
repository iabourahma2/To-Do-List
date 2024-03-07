import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TodoList {
    private final List<String> tasks = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        boolean running = true;

        while (running) {
            System.out.println("\nTo-Do List Application");
            System.out.println("[1] Add Task");
            System.out.println("[2] View Tasks");
            System.out.println("[3] Remove Task");
            System.out.println("[4] Mark Task Completed");
            System.out.println("[5] Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    markTaskCompleted();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addTask() {
        System.out.print("Enter a new task: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Task added.");
    }

    private void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Your to-do list is empty.");
        } else {
            System.out.println("Your tasks:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    private void removeTask() {
        System.out.print("Enter the number of the task to remove: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            tasks.remove(taskNumber - 1);
            System.out.println("Task removed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    private void markTaskCompleted() {
        System.out.print("Enter the number of the task to mark as completed: ");
        int taskNumber = scanner.nextInt();
        scanner.nextLine(); // consume newline
        if (taskNumber > 0 && taskNumber <= tasks.size()) {
            String completedTask = tasks.remove(taskNumber - 1) + " (Completed)";
            tasks.add(taskNumber - 1, completedTask);
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public static void main(String[] args) {
        TodoList app = new TodoList();
        app.start();
    }
}
