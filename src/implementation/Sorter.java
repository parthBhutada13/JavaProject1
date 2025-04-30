// src/implementation/Sorter.java
package implementation;

import model.Task;
import model.SimpleTask;
import model.RecurringTask;
import operations.SortingOperations;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sorter implements SortingOperations {

    @Override
    public void sortByDueDate(List<Task> tasks) {
        tasks.sort((t1, t2) -> {
            if (t1 instanceof SimpleTask && t2 instanceof SimpleTask) {
                return ((SimpleTask) t1).getDueDate().compareTo(((SimpleTask) t2).getDueDate());
            } else if (t1 instanceof RecurringTask && t2 instanceof RecurringTask) {
                return ((RecurringTask) t1).getDueDate().compareTo(((RecurringTask) t2).getDueDate());
            } else if (t1 instanceof SimpleTask && t2 instanceof RecurringTask) {
                return ((SimpleTask) t1).getDueDate().compareTo(((RecurringTask) t2).getDueDate());
            } else if (t1 instanceof RecurringTask && t2 instanceof SimpleTask) {
                return ((RecurringTask) t1).getDueDate().compareTo(((SimpleTask) t2).getDueDate());
            }
            return 0;
        });
    }

    @Override
    public void sortByCompletionStatus(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::isComplete));
    }

    @Override
    public List<Task> sortTasks(List<Task> tasks, Comparator<Task> comparator) {
        tasks.sort(comparator);
        return tasks;
    }
}
