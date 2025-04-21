package implementation;

import java.util.Comparator;
import java.util.List;
import model.RecurringTask;
import model.SimpleTask;
import model.Task;
import operations.SortingOperations;

public class Sorter implements SortingOperations {
    public void sortByDueDate(List<Task> tasks) {
        tasks.sort((t1, t2) -> {
            if (t1 instanceof SimpleTask && t2 instanceof SimpleTask) {
                return ((SimpleTask)t1).getDueDate().compareTo(((SimpleTask)t2).getDueDate());
            } else if (t1 instanceof RecurringTask && t2 instanceof RecurringTask) {
                return ((RecurringTask)t1).getDueDate().compareTo(((RecurringTask)t2).getDueDate());
            } else if (t1 instanceof SimpleTask && t2 instanceof RecurringTask) {
                return ((SimpleTask)t1).getDueDate().compareTo(((RecurringTask)t2).getDueDate());
            } else {
                return t1 instanceof RecurringTask && t2 instanceof SimpleTask ? ((RecurringTask)t1).getDueDate().compareTo(((SimpleTask)t2).getDueDate()) : 0;
            }
        });
    }

    public void sortByCompletionStatus(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::isComplete));
    }

    public List<Task> sortTasks(List<Task> tasks, Comparator<Task> comparator) {
        tasks.sort(comparator);
        return tasks;
    }
}
