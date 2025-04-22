// src/implementation/TaskManager.java
package implementation;

import model.Task;
import model.SimpleTask;
import model.RecurringTask;
import operations.TaskOperations;
import storage.TaskStorage;

import java.time.LocalDate;
import java.util.*;

public class TaskManager implements TaskOperations {
    private final HashMap<Integer, Task> taskMap;
    private int idCounter = 1;

    public TaskManager() {
        taskMap = TaskStorage.loadTasks();
        if (!taskMap.isEmpty()) {
            idCounter = Collections.max(taskMap.keySet()) + 1;
        }
    }

    public void save() {
        TaskStorage.saveTasks(taskMap);
    }

    @Override
    public Collection<Task> getAllTasks() {
        return taskMap.values();
    }

    @Override
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
            task = new RecurringTask(idCounter, title, desc, dueDate, pattern);
        } else {
            task = new SimpleTask(idCounter, title, desc, dueDate);
        }

        taskMap.put(idCounter, task);
        System.out.println("✅ Task created with ID: " + idCounter);
        idCounter++;
    }

    @Override
    public void editTask(int taskId) {
        Task task = taskMap.get(taskId);
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
            } catch (Exception e) {
                System.out.println("❌ Invalid date format. Skipping due date update.");
            }

            System.out.println("✅ Task updated.");
        } else {
            System.out.println("❌ Task not found.");
        }
    }

    @Override
    public void deleteTask(int taskId) {
        if (taskMap.remove(taskId) != null) {
            System.out.println("✅ Task deleted.");
        } else {
            System.out.println("❌ Task not found.");
        }
    }

    @Override
    public void markAsComplete(int taskId) {
        Task task = taskMap.get(taskId);
        if (task != null) {
            task.markAsComplete();
            System.out.println("✅ Task marked as complete.");
        } else {
            System.out.println("❌ Task not found.");
        }
    }

    @Override
    public void getTaskDetails(int taskId) {
        Task task = taskMap.get(taskId);
        if (task != null) {
            System.out.println("📝 Task Details:");
            System.out.println("ID         : " + task.getId());
            System.out.println("Title      : " + task.getTitle());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Due Date   : " + task.getDueDate());
            System.out.println("Type       : " + task.getTaskType());
            System.out.println("Completed  : " + (task.isComplete() ? "✅ Yes" : "❌ No"));
        } else {
            System.out.println("❌ Task not found.");
        }
    }

    // Step 4: Show tasks due today or overdue
    public void showDueDateReminders() {
        LocalDate today = LocalDate.now();
        boolean found = false;

        System.out.println("\n⏰ Due Today or Overdue Tasks:");
        for (Task task : taskMap.values()) {
            if (!task.isComplete() && (task.getDueDate().isBefore(today) || task.getDueDate().isEqual(today))) {
                System.out.println("[#" + task.getId() + "] " + task.getTitle() + " (Due: " + task.getDueDate() + ")");
                found = true;
            }
        }
        if (!found) {
            System.out.println("🎉 No tasks due today or overdue.");
        }
    }
}
