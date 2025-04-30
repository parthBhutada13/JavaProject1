package implementation;

import java.io.PrintStream;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import model.RecurringTask;
import model.SimpleTask;
import model.Task;
import operations.TaskOperations;
import storage.TaskStorage;

public class TaskManager implements TaskOperations {
    private final HashMap<Integer, Task> taskMap = TaskStorage.loadTasks();
    private int idCounter = 1;

    public TaskManager() {
        if (!this.taskMap.isEmpty()) {
            this.idCounter = (Integer)Collections.max(this.taskMap.keySet()) + 1;
        }

    }

    public void save() {
        TaskStorage.saveTasks(this.taskMap);
    }

    public Collection<Task> getAllTasks() {
        return this.taskMap.values();
    }

    public void createTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter task type (simple/recurring): ");
        String type = sc.nextLine().trim().toLowerCase();
        System.out.print("Enter title: ");
        String title = sc.nextLine();
        System.out.print("Enter description: ");
        String desc = sc.nextLine();
        System.out.print("Enter due date (yyyy-mm-dd): ");
        LocalDate dueDate = LocalDate.parse(sc.nextLine());
        Task task;
        if (type.equals("recurring")) {
            System.out.print("Enter recurrence pattern: ");
            String pattern = sc.nextLine();
            task = new RecurringTask(this.idCounter, title, desc, dueDate, pattern);
        } else {
            task = new SimpleTask(this.idCounter, title, desc, dueDate);
        }

        this.taskMap.put(this.idCounter, task);
        System.out.println("✅ Task created with ID: " + this.idCounter);
        ++this.idCounter;
    }

    public void editTask(int taskId) {
        Task task = (Task)this.taskMap.get(taskId);
        if (task != null) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Edit title: ");
            task.setTitle(sc.nextLine());
            System.out.print("Edit description: ");
            task.setDescription(sc.nextLine());
            System.out.print("Edit due date (yyyy-mm-dd): ");

            try {
                LocalDate newDate = LocalDate.parse(sc.nextLine());
                task.setDueDate(newDate);
            } catch (Exception var5) {
                System.out.println("❌ Invalid date format. Skipping due date update.");
            }

            System.out.println("✅ Task updated.");
        } else {
            System.out.println("❌ Task not found.");
        }

    }

    public void deleteTask(int taskId) {
        if (this.taskMap.remove(taskId) != null) {
            System.out.println("✅ Task deleted.");
        } else {
            System.out.println("❌ Task not found.");
        }

    }

    public void markAsComplete(int taskId) {
        Task task = (Task)this.taskMap.get(taskId);
        if (task != null) {
            task.markAsComplete();
            System.out.println("✅ Task marked as complete.");
        } else {
            System.out.println("❌ Task not found.");
        }

    }

    public void getTaskDetails(int taskId) {
        Task task = (Task)this.taskMap.get(taskId);
        if (task != null) {
            System.out.println("\ud83d\udcdd Task Details:");
            PrintStream var10000 = System.out;
            int var10001 = task.getId();
            var10000.println("ID         : " + var10001);
            var10000 = System.out;
            String var7 = task.getTitle();
            var10000.println("Title      : " + var7);
            var10000 = System.out;
            var7 = task.getDescription();
            var10000.println("Description: " + var7);
            var10000 = System.out;
            var7 = String.valueOf(task.getDueDate());
            var10000.println("Due Date   : " + var7);
            var10000 = System.out;
            var7 = task.getTaskType();
            var10000.println("Type       : " + var7);
            System.out.println("Completed  : " + (task.isComplete() ? "✅ Yes" : "❌ No"));
        } else {
            System.out.println("❌ Task not found.");
        }

    }

    public void showDueDateReminders() {
        LocalDate today = LocalDate.now();
        boolean found = false;
        System.out.println("\n⏰ Due Today or Overdue Tasks:");

        for(Task task : this.taskMap.values()) {
            if (!task.isComplete() && (task.getDueDate().isBefore(today) || task.getDueDate().isEqual(today))) {
                PrintStream var10000 = System.out;
                int var10001 = task.getId();
                var10000.println("[#" + var10001 + "] " + task.getTitle() + " (Due: " + String.valueOf(task.getDueDate()) + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("\ud83c\udf89 No tasks due today or overdue.");
        }

    }
}
