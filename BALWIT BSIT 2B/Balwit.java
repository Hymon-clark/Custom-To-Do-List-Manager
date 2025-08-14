/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package balwit;
import java.util.Scanner;

public class Balwit{

    // TaskNode Class: Represents a task in the linked list
    static class TaskNode {
        String title;
        TaskNode next;

        public TaskNode(String title) {
            this.title = title;
            this.next = null;
        }
    }

    // ToDoList Class: Implements the linked list and task management functions
    static class ToDoList {
        private TaskNode head; // Head node of the linked list

        // Constructor to initialize the list
        public ToDoList() {
            head = null;
        }

        // Add a task to the end of the list
        public void addTask(String title) {
            TaskNode newTask = new TaskNode(title);
            if (head == null) {
                head = newTask; // If the list is empty, new task becomes head
            } else {
                TaskNode current = head;
                while (current.next != null) {
                    current = current.next; // Traverse to the end of the list
                }
                current.next = newTask; // Add the new task at the end
            }
            System.out.println("Task added!");
        }

        // Delete a task by its title
        public void deleteTask(String title) {
            if (head == null) {
                System.out.println("No tasks to delete.");
                return;
            }

            // If the head is the task to be deleted
            if (head.title.equals(title)) {
                head = head.next;
                System.out.println("Task deleted!");
                return;
            }

            TaskNode current = head;
            while (current.next != null && !current.next.title.equals(title)) {
                current = current.next; // Traverse the list to find the task
            }

            if (current.next == null) {
                System.out.println("Task not found.");
            } else {
                current.next = current.next.next; // Delete the task
                System.out.println("Task deleted!");
            }
        }

        // Print all tasks in the list
        public void printTasks() {
            if (head == null) {
                System.out.println("No tasks to display.");
                return;
            }

            System.out.println("Your Tasks:");
            TaskNode current = head;
            while (current != null) {
                System.out.println("- " + current.title);
                current = current.next;
            }
        }

        // Check if a task exists in the list
        public boolean contains(String title) {
            TaskNode current = head;
            while (current != null) {
                if (current.title.equals(title)) {
                    return true; // Task found
                }
                current = current.next;
            }
            return false; // Task not found
        }

        // Count the number of tasks
        public int countTasks() {
            int count = 0;
            TaskNode current = head;
            while (current != null) {
                count++;
                current = current.next;
            }
            return count;
        }

        // Insert a task at a specific index
        public void insertAtIndex(String title, int index) {
            if (index < 0 || index > countTasks()) {
                System.out.println("Invalid index.");
                return;
            }

            TaskNode newTask = new TaskNode(title);
            if (index == 0) {
                // Insert at the head
                newTask.next = head;
                head = newTask;
            } else {
                // Insert at the specified index
                TaskNode current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                newTask.next = current.next;
                current.next = newTask;
            }
            System.out.println("Task inserted at index " + index + "!");
        }
    }

    // Main Class: Implements the user interface and menu system
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();

        while (true) {
            System.out.println("\n1. Add task");
            System.out.println("2. Delete task");
            System.out.println("3. View all tasks");
            System.out.println("4. Search task");
            System.out.println("5. Count tasks");
            System.out.println("6. Insert task at index");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String taskToAdd = scanner.nextLine();
                    toDoList.addTask(taskToAdd);
                    break;

                case 2:
                    System.out.print("Enter task title to delete: ");
                    String taskToDelete = scanner.nextLine();
                    toDoList.deleteTask(taskToDelete);
                    break;

                case 3:
                    toDoList.printTasks();
                    break;

                case 4:
                    System.out.print("Enter task title to search: ");
                    String taskToSearch = scanner.nextLine();
                    if (toDoList.contains(taskToSearch)) {
                        System.out.println("Task found!");
                    } else {
                        System.out.println("Task not found.");
                    }
                    break;

                case 5:
                    System.out.println("Number of tasks: " + toDoList.countTasks());
                    break;

                case 6:
                    System.out.print("Enter task title: ");
                    String taskToInsert = scanner.nextLine();
                    System.out.print("Enter index to insert at: ");
                    int index = scanner.nextInt();
                    toDoList.insertAtIndex(taskToInsert, index);
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
