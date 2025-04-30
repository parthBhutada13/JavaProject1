// src/model/Project.java
package model;

import java.util.*;

public class Project {
    private List<String> members;
    private List<Task> tasks;
    private Map<Task, String> taskAssignments;

    public Project() {
        this.members = new ArrayList<>();
        this.tasks = new ArrayList<>();
        this.taskAssignments = new HashMap<>();
    }

    public void addMember(String name) {
        if (!members.contains(name)) {
            members.add(name);
        }
    }

    public void removeMember(String name) {
        members.remove(name);
        // Also remove their task assignments
        taskAssignments.values().removeIf(assignedName -> assignedName.equals(name));
    }

    public void assignTask(String member, Task task) {
        if (members.contains(member) && tasks.contains(task)) {
            taskAssignments.put(task, member);
        }
    }

    public List<Task> getTasksByMember(String member) {
        List<Task> result = new ArrayList<>();
        for (Map.Entry<Task, String> entry : taskAssignments.entrySet()) {
            if (entry.getValue().equals(member)) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        taskAssignments.remove(task);
    }

    public List<String> getMembers() {
        return members;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public Map<Task, String> getTaskAssignments() {
        return taskAssignments;
    }
}
