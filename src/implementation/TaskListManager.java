// src/implementation/TaskListManager.java
package implementation;

import model.Task;
import model.TaskList;
import operations.TaskListOperations;

import java.util.List;
import java.util.Scanner;

public class TaskListManager implements TaskListOperations {
    private TaskList taskList;

    public TaskListManager(int priority) {
        this.taskList = new TaskList(priority);
    }

    @Override
    public void addTask(Task task) {
        taskList.addTask(task);
        System.out.println("Task added to the list.");
    }

    @Override
    public void removeTask(Task task) {
        taskList.removeTask(task);
        System.out.println("Task removed from the list.");
    }

    @Override
    public List<Task> getAllTasks() {
        return taskList.getTasks();
    }

    @Override
    public void sortTasksByDueDate() {
        Sorter sorter = new Sorter();
        sorter.sortByDueDate(taskList.getTasks());
        System.out.println("Tasks sorted by due date.");
    }

    @Override
    public void searchTask(String keyword) {
        List<Task> tasks = taskList.getTasks();
        boolean found = false;

        for (Task task : tasks) {
            if (task.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                    task.getDescription().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println("Found: " + task.getTitle() + " (ID: " + task.getId() + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No task matched the keyword.");
        }
    }

    @Override
    public void editTask() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Task ID to edit: ");
        int taskId = Integer.parseInt(sc.nextLine());

        for (Task task : taskList.getTasks()) {
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
