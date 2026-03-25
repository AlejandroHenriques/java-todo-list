package My_First_Project;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

	static ArrayList<String> tasks = new ArrayList<>();
	static ArrayList<Boolean> completedTasks = new ArrayList<>();
	static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		boolean running = true;

		// While loop to show the menu.
		while (running) {
			showMenu();
			int choice = scanner.nextInt();
			scanner.nextLine(); // clear buffer

			switch (choice) {
			case 1:
				viewTasks();
				break;
			case 2:
				addTask();
				break;
			case 3:
				removeTask();
				break;
			case 4:
				markTaskCompleted();
				break;
			case 5:
				running = false;
				System.out.println("Exiting To-Do List. Goodbye!");
				break;
			default:
				System.out.println("Invalid choice. Try again.");
			}
		}
	}

	// Show Menu method.
	public static void showMenu() {
		System.out.println("\n--- TO-DO LIST MENU ---\n");
		System.out.println("1. View tasks");
		System.out.println("2. Add task");
		System.out.println("3. Remove task");
		System.out.println("4. Mark task as completed");
		System.out.println("5. Exit\n");

		System.out.print("Choose an option: ");
	}

	public static void viewTasks() {
		if (tasks.isEmpty()) {
			System.out.println("No tasks available.");
		} else {
			System.out.println("\nYour tasks:\n");

			for (int i = 0; i < tasks.size(); i++) {
				if (completedTasks.get(i) == false) {
					System.out.println((i + 1) + ". " + "[❌] " + tasks.get(i));
				}

				if (completedTasks.get(i) == true) {
					System.out.println((i + 1) + ". " + "[✅] " + tasks.get(i));
				}

			}
		}
	}

	public static void addTask() {
		System.out.print("Enter a new task: ");
		String task = scanner.nextLine();
		tasks.add(task);
		System.out.println("Task added.");
		completedTasks.add(false);
	}

	// Removing task Method.
	public static void removeTask() {
		viewTasks();

		if (!tasks.isEmpty()) {
			System.out.print("Enter task number to remove: ");
			int taskNumber = scanner.nextInt();
			scanner.nextLine(); // clear buffer

			if (taskNumber > 0 && taskNumber <= tasks.size()) {
				tasks.remove(taskNumber - 1);
				System.out.println("Task removed.");
			} else {
				System.out.println("Invalid task number.");
			}
		}
	}

	public static void markTaskCompleted() {
		viewTasks();
		if (!completedTasks.isEmpty()) {

			System.out.println("\nSelect the Task you completed.");
			int choice = scanner.nextInt();
			scanner.nextLine();// Clear buffer.

			if (choice > 0 && choice <= tasks.size()) {

				completedTasks.set(choice - 1, true);
				System.out.println("Task marked as completed");

			} else {
				System.out.println("Invalid Task Number.");

			}
		}
	}
}


