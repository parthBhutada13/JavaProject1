// src/storage/TaskStorage.java
package storage;

import model.Task;

import java.io.*;
import java.util.HashMap;

public class TaskStorage {
    private static final String FILE_PATH = "tasks.ser";

    public static void saveTasks(HashMap<Integer, Task> taskMap) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(taskMap);
            System.out.println("✅ Tasks saved to file.");
        } catch (IOException e) {
            System.out.println("❌ Failed to save tasks: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static HashMap<Integer, Task> loadTasks() {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (HashMap<Integer, Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("❌ Failed to load tasks: " + e.getMessage());
            return new HashMap<>();
        }
    }
}
