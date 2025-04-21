package implementation;

import java.io.PrintStream;
import java.util.List;
import model.Project;
import model.Task;
import operations.ProjectOperations;

public class ProjectManager implements ProjectOperations {
    private Project project = new Project();

    public void addMember(String name) {
        this.project.addMember(name);
        System.out.println("Member added: " + name);
    }

    public void removeMember(String name) {
        this.project.removeMember(name);
        System.out.println("Member removed: " + name);
    }

    public void assignTask(String member, Task task) {
        if (this.project.getMembers().contains(member)) {
            this.project.addTask(task);
            this.project.assignTask(member, task);
            System.out.println("Task assigned to: " + member);
        } else {
            System.out.println("Member not found. Assignment failed.");
        }

    }

    public List<Task> getTasksByMember(String member) {
        if (!this.project.getMembers().contains(member)) {
            System.out.println("No such member in project.");
            return List.of();
        } else {
            List<Task> tasks = this.project.getTasksByMember(member);
            if (tasks.isEmpty()) {
                System.out.println("No tasks assigned to " + member);
            } else {
                System.out.println("Tasks assigned to " + member + ":");

                for(Task t : tasks) {
                    PrintStream var10000 = System.out;
                    String var10001 = t.getTitle();
                    var10000.println("- " + var10001 + " (ID: " + t.getId() + ")");
                }
            }

            return tasks;
        }
    }

    public List<String> getAllMembers() {
        return this.project.getMembers();
    }

    public List<Task> getAllProjectTasks() {
        return this.project.getTasks();
    }
}
