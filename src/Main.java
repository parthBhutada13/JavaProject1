// src/Main.java
import cli.TaskManagerCLI;
import implementation.*;
import model.Task;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;



public class Main {
    public static void main(String[] args) {

        // Initialize components
        TaskManager taskManager = new TaskManager();
        TaskListManager taskListManager = new TaskListManager(1); // default priority
        ProjectManager projectManager = new ProjectManager();
        Sorter sorter = new Sorter();

        // SearchManager can be updated with all tasks dynamically
        SearchManager searchManager = new SearchManager(new ArrayList<>(taskManager.getAllTasks()));

        System.out.println("🔥 Welcome to CLI Task Manager!");
        System.out.println("Launching CLI interface...\n");

        // Pass components into CLI handler
        TaskManagerCLI cli = new TaskManagerCLI(taskManager, taskListManager, projectManager, sorter, searchManager);
        cli.run();  // Start the interactive CLI

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);
        }

        for(int j = 0;j<5;j++){
            System.out.println("*");
        }
        System.out.println("*");
        System.out.println("Demo Fork1");
        System.out.println("Demo Fork2");
        System.out.println("Demo Fork3");
        System.out.println("Demo Fork4");
        System.out.println("Demo Fork5");
        System.out.println("Demo Fork6");
        
        System.out.println("Demo Fork5");
        System.out.println("Demo Fork6");
    }
}
