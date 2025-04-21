package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Project {
    private List<String> members = new ArrayList();
    private List<Task> tasks = new ArrayList();
    private Map<Task, String> taskAssignments = new HashMap();

    public void addMember(String name) {
        if (!this.members.contains(name)) {
            this.members.add(name);
        }

    }

    public void removeMember(String name) {
        this.members.remove(name);
        this.taskAssignments.values().removeIf((assignedName) -> assignedName.equals(name));
    }

    public void assignTask(String member, Task task) {
        if (this.members.contains(member) && this.tasks.contains(task)) {
            this.taskAssignments.put(task, member);
        }

    }

    public List<Task> getTasksByMember(String member) {
        List<Task> result = new ArrayList();

        for(Map.Entry<Task, String> entry : this.taskAssignments.entrySet()) {
            if (((String)entry.getValue()).equals(member)) {
                result.add((Task)entry.getKey());
            }
        }

        return result;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
    }

    public void removeTask(Task task) {
        this.tasks.remove(task);
        this.taskAssignments.remove(task);
    }

    public List<String> getMembers() {
        return this.members;
    }

    public List<Task> getTasks() {
        return this.tasks;
    }

    public Map<Task, String> getTaskAssignments() {
        return this.taskAssignments;
    }
}
