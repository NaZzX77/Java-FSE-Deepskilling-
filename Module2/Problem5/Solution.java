class Task {
    private int taskId;
    private String taskName;
    private String status;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    public int getTaskId() {
        return taskId;
    }

    public String toString() {
        return taskId + " " + taskName + " " + status;
    }
}

class TaskNode {
    Task task;
    TaskNode next;

    public TaskNode(Task task) {
        this.task = task;
    }
}

class TaskList {
    private TaskNode head;

    public void addTask(Task task) {
        TaskNode newNode = new TaskNode(task);

        if (head == null) {
            head = newNode;
            return;
        }

        TaskNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public Task searchTask(int taskId) {
        TaskNode current = head;

        while (current != null) {
            if (current.task.getTaskId() == taskId) {
                return current.task;
            }
            current = current.next;
        }
        return null;
    }

    public void displayTasks() {
        TaskNode current = head;

        while (current != null) {
            System.out.println(current.task);
            current = current.next;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            return;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            return;
        }

        TaskNode current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId() == taskId) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }
}

public class Solution {
    public static void main(String[] args) {
        TaskList taskList = new TaskList();

        taskList.addTask(new Task(1, "Design page", "Pending"));
        taskList.addTask(new Task(2, "Write code", "In Progress"));
        System.out.println("Search: " + taskList.searchTask(2));
        taskList.displayTasks();
        taskList.deleteTask(1);
        System.out.println("After deletion:");
        taskList.displayTasks();

        System.out.println("Add at end: O(n), Search: O(n), Traverse: O(n), Delete: O(n)");
    }
}
