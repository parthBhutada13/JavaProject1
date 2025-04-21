package implementation;

import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;
import model.Task;
import model.TaskList;
import operations.TaskListOperations;

public class TaskListManager implements TaskListOperations {
    private TaskList taskList;

    public TaskListManager(int priority) {
        this.taskList = new TaskList(priority);
    }

    public void addTask(Task task) {
        this.taskList.addTask(task);
        System.out.println("Task added to the list.");
    }

    public void removeTask(Task task) {
        this.taskList.removeTask(task);
        System.out.println("Task removed from the list.");
    }

    public List<Task> getAllTasks() {
        return this.taskList.getTasks();
    }

    public void sortTasksByDueDate() {
        Sorter sorter = new Sorter();
        sorter.sortByDueDate(this.taskList.getTasks());
        System.out.println("Tasks sorted by due date.");
    }

    public void searchTask(String keyword) {
        List<Task> tasks = this.taskList.getTasks();
        boolean found = false;

        for(Task task : tasks) {
            if (task.getTitle().toLowerCase().contains(keyword.toLowerCase()) || task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                PrintStream var10000 = System.out;
                String var10001 = task.getTitle();
                var10000.println("Found: " + var10001 + " (ID: " + task.getId() + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No task matched the keyword.");
        }

    }

    public void editTask() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Task ID to edit: ");
        int taskId = Integer.parseInt(sc.nextLine());

        for(Task task : this.taskList.getTasks()) {
            if (task.getId() == taskId) {
                System.out.print("New Title: ");
                task.setTitle(sc.nextLine());
                System.out.print("New Description: ");
                task.setDescription(sc.nextLine());
                System.out.println("Task updated.");
                return;
            }
        }

        System.out.println("Task not found.");
    }
}
