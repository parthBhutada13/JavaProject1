// src/implementation/ProjectManager.java
package implementation;

import model.Project;
import model.Task;
import operations.ProjectOperations;

import java.util.List;

public class ProjectManager implements ProjectOperations {
    private Project project;

    public ProjectManager() {
        this.project = new Project();
    }

    @Override
    public void addMember(String name) {
        project.addMember(name);
        System.out.println("Member added: " + name);
    }

    @Override
    public void removeMember(String name) {
        project.removeMember(name);
        System.out.println("Member removed: " + name);
    }

    @Override
    public void assignTask(String member, Task task) {
        if (project.getMembers().contains(member)) {
            project.addTask(task); // add to project task list
            project.assignTask(member, task);
            System.out.println("Task assigned to: " + member);
        } else {
            System.out.println("Member not found. Assignment failed.");
        }
    }

    @Override
    public List<Task> getTasksByMember(String member) {
        if (!project.getMembers().contains(member)) {
            System.out.println("No such member in project.");
            return List.of();
        }

        List<Task> tasks = project.getTasksByMember(member);
        if (tasks.isEmpty()) {
            System.out.println("No tasks assigned to " + member);
        } else {
            System.out.println("Tasks assigned to " + member + ":");
            for (Task t : tasks) {
                System.out.println("- " + t.getTitle() + " (ID: " + t.getId() + ")");
            }
        }
        return tasks;
    }

    public List<String> getAllMembers() {
        return project.getMembers();
    }

    public List<Task> getAllProjectTasks() {
        return project.getTasks();
    }
}
