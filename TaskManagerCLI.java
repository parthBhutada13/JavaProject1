package cli;

import implementation.ProjectManager;
import implementation.SearchManager;
import implementation.Sorter;
import implementation.TaskListManager;
import implementation.TaskManager;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import model.Task;

public class TaskManagerCLI {
    private final TaskManager taskManager;
    private final TaskListManager taskListManager;
    private final ProjectManager projectManager;
    private final Sorter sorter;
    private final SearchManager searchManager;
    private final Scanner scanner;

    public TaskManagerCLI(TaskManager tm, TaskListManager tlm, ProjectManager pm, Sorter s, SearchManager sm) {
        this.scanner = new Scanner(System.in);
        this.taskManager = tm;
        this.taskListManager = tlm;
        this.projectManager = pm;
        this.sorter = s;
        this.searchManager = sm;
    }

    public void run() {
        for(boolean running = true; running; System.out.println()) {
            this.printMenu();
            switch (this.scanner.nextLine().trim()) {
                case "1":
                    this.taskManager.createTask();
                    break;
                case "2":
                    this.editTask();
                    break;
                case "3":
                    this.deleteTask();
                    break;
                case "4":
                    this.markTaskComplete();
                    break;
                case "5":
                    this.viewTaskDetails();
                    break;
                case "6":
                    this.assignTaskToMember();
                    break;
                case "7":
                    this.addMember();
                    break;
                case "8":
                    this.listTasksByMember();
                    break;
                case "9":
                    this.searchTask();
                    break;
                case "10":
                    this.sortTasks();
                    break;
                case "11":
                    this.viewAllTasks();
                    break;
                case "12":
                    this.taskManager.showDueDateReminders();
                    break;
                case "0":
                    this.taskManager.save();
                    running = false;
                    System.out.println("\ud83d\udc4b Exiting CLI Task Manager. See you soon!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

    }

    private void printMenu() {
        System.out.println("====================================");
        System.out.println("\ud83d\udccb CLI Task Manager - Menu");
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
        int taskId = Integer.parseInt(this.scanner.nextLine());
        this.taskManager.editTask(taskId);
    }

    private void deleteTask() {
        System.out.print("Enter Task ID to delete: ");
        int taskId = Integer.parseInt(this.scanner.nextLine());
        this.taskManager.deleteTask(taskId);
    }

    private void markTaskComplete() {
        System.out.print("Enter Task ID to mark complete: ");
        int taskId = Integer.parseInt(this.scanner.nextLine());
        this.taskManager.markAsComplete(taskId);
    }

    private void viewTaskDetails() {
        System.out.print("Enter Task ID to view details: ");
        int taskId = Integer.parseInt(this.scanner.nextLine());
        this.taskManager.getTaskDetails(taskId);
    }

    private void assignTaskToMember() {
        System.out.print("Enter Member Name: ");
        String member = this.scanner.nextLine();
        System.out.print("Enter Task ID to assign: ");
        int taskId = Integer.parseInt(this.scanner.nextLine());
        Task task = (Task)this.taskManager.getAllTasks().stream().filter((t) -> t.getId() == taskId).findFirst().orElse((Object)null);
        if (task != null) {
            this.projectManager.assignTask(member, task);
        } else {
            System.out.println("Task not found.");
        }

    }

    private void addMember() {
        System.out.print("Enter member name to add: ");
        String member = this.scanner.nextLine();
        this.projectManager.addMember(member);
    }

    private void listTasksByMember() {
        System.out.print("Enter member name: ");
        String member = this.scanner.nextLine();
        this.projectManager.getTasksByMember(member);
    }

    private void searchTask() {
        System.out.print("Enter task title to search: ");
        String title = this.scanner.nextLine();
        this.searchManager.searchTaskByTitle(title);
    }

    private void sortTasks() {
        List<Task> tasks = (List)this.taskManager.getAllTasks();
        this.sorter.sortByDueDate(tasks);
        System.out.println("Tasks sorted by due date:");
        tasks.forEach((t) -> {
            PrintStream var10000 = System.out;
            String var10001 = t.getTitle();
            var10000.println("- " + var10001 + " (ID: " + t.getId() + ")");
        });
    }

    private void viewAllTasks() {
        List<Task> tasks = (List)this.taskManager.getAllTasks();
        if (tasks.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            tasks.forEach((t) -> {
                PrintStream var10000 = System.out;
                int var10001 = t.getId();
                var10000.println("[" + var10001 + "] " + t.getTitle() + (t.isComplete() ? " ✅" : " ❌"));
            });
        }

    }
}
