// src/cli/TaskManagerCLI.java
package cli;

import implementation.*;
import model.Task;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TaskManagerCLI {
    private final TaskManager taskManager;
    private final TaskListManager taskListManager;
    private final ProjectManager projectManager;
    private final Sorter sorter;
    private final SearchManager searchManager;

    private final Scanner scanner = new Scanner(System.in);

    public TaskManagerCLI(TaskManager tm, TaskListManager tlm, ProjectManager pm, Sorter s, SearchManager sm) {
        this.taskManager = tm;
        this.taskListManager = tlm;
        this.projectManager = pm;
        this.sorter = s;
        this.searchManager = sm;
    }

    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1" -> taskManager.createTask();
                case "2" -> editTask();
                case "3" -> deleteTask();
                case "4" -> markTaskComplete();
                case "5" -> viewTaskDetails();
                case "6" -> assignTaskToMember();
                case "7" -> addMember();
                case "8" -> listTasksByMember();
                case "9" -> searchTask();
                case "10" -> sortTasks();
                case "11" -> viewAllTasks();
                case "12" -> taskManager.showDueDateReminders();
                case "0" -> {
                    taskManager.save();
                    running = false;
                    System.out.println("👋 Exiting CLI Task Manager. See you soon!");
                }
                default -> System.out.println("Invalid choice. Try again.");
            }

            System.out.println();
        }
    }

    private void printMenu() {
        System.out.println("====================================");
        System.out.println("📋 CLI Task Manager - Menu");
        System.out.println("1. Create Task");
        System.out.println("2. Edit Task");
        System.out.println("3. Delete Task");
        System.out.println("4. Mark Task as Complete");
        System.out.println("5. View Task Details");
        System.out.println("6. Assign Task to Member");
        System.out.println("7. Add Project Member");
        System.out.println("8. List Tasks by Member");
        System.out.println("9. Search Task");
        System.out.println("10. Sort All Tasks");
        System.out.println("11. View All Tasks");
        System.out.println("12. Show Due Date Reminders");
        System.out.println("0. Exit");
        System.out.print("Enter choice: ");
    }

    private void editTask() {
        System.out.print("Enter Task ID to edit: ");
        int taskId = Integer.parseInt(scanner.nextLine());
        taskManager.editTask(taskId);
    }

    private void deleteTask() {
        System.out.print("Enter Task ID to delete: ");
        int taskId = Integer.parseInt(scanner.nextLine());
        taskManager.deleteTask(taskId);
    }

    private void markTaskComplete() {
        System.out.print("Enter Task ID to mark complete: ");
        int taskId = Integer.parseInt(scanner.nextLine());
        taskManager.markAsComplete(taskId);
    }

    private void viewTaskDetails() {
        System.out.print("Enter Task ID to view details: ");
        int taskId = Integer.parseInt(scanner.nextLine());
        taskManager.getTaskDetails(taskId);
    }

    private void assignTaskToMember() {
        System.out.print("Enter Member Name: ");
        String member = scanner.nextLine();

        System.out.print("Enter Task ID to assign: ");
        int taskId = Integer.parseInt(scanner.nextLine());

        Task task = taskManager.getAllTasks().stream()
                .filter(t -> t.getId() == taskId)
                .findFirst()
                .orElse(null);

        if (task != null) {
            projectManager.assignTask(member, task);
        } else {
            System.out.println("Task not found.");
        }
    }

    private void addMember() {
        System.out.print("Enter member name to add: ");
        String member = scanner.nextLine();
        projectManager.addMember(member);
    }

    private void listTasksByMember() {
        System.out.print("Enter member name: ");
        String member = scanner.nextLine();
        projectManager.getTasksByMember(member);
    }

    private void searchTask() {
        System.out.print("Enter task title to search: ");
        String title = scanner.nextLine();
        searchManager.searchTaskByTitle(title);
    }

    private void sortTasks() {
        List<Task> tasks = (List<Task>) taskManager.getAllTasks();
        sorter.sortByDueDate(tasks);
        System.out.println("Tasks sorted by due date:");
        tasks.forEach(t -> System.out.println("- " + t.getTitle() + " (ID: " + t.getId() + ")"));
    }

    private void viewAllTasks() {
        List<Task> tasks = (List<Task>) taskManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            tasks.forEach(t ->
                    System.out.println("[" + t.getId() + "] " + t.getTitle() +
                            (t.isComplete() ? " ✅" : " ❌")));
        }
    }





}
