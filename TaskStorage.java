package storage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import model.Task;

public class TaskStorage {
    private static final String FILE_PATH = "tasks.ser";

    public static void saveTasks(HashMap<Integer, Task> taskMap) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tasks.ser"))) {
            oos.writeObject(taskMap);
            System.out.println("✅ Tasks saved to file.");
        } catch (IOException e) {
            System.out.println("❌ Failed to save tasks: " + e.getMessage());
        }

    }

    public static HashMap<Integer, Task> loadTasks() {
        File file = new File("tasks.ser");
        if (!file.exists()) {
            return new HashMap();
        } else {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tasks.ser"))) {
                return (HashMap)ois.readObject();
            } catch (ClassNotFoundException | IOException e) {
                System.out.println("❌ Failed to load tasks: " + ((Exception)e).getMessage());
                return new HashMap();
            }
        }
    }
}
