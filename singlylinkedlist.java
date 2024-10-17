// Node class to represent each element in the linked list
class Node {
    int data; // Data part of the node
    Node next; // Pointer to the next node

    // Constructor to create a new node
    Node(int data) {
        this.data = data;
        this.next = null; // Initially, the next node is set to null
    }
}

// Singly Linked List class
class SinglyLinkedList {
    Node head; // Head node of the linked list

    // Method to add a new node at the end of the list
    public void add(int data) {
        Node newNode = new Node(data); // Create a new node with given data
        if (head == null) {
            head = newNode; // If the list is empty, make the new node the head
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next; // Traverse to the last node
            }
            current.next = newNode; // Set the next of last node to the new node
        }
    }

    // Method to display the linked list
    public void display() {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next; // Move to the next node
        }
        System.out.println("null");
    }

    // Method to delete a node by its value
    public void delete(int data) {
        if (head == null) {
            System.out.println("The list is empty");
            return;
        }
        // If the head node itself needs to be deleted
        if (head.data == data) {
            head = head.next; // Change head to the next node
            return;
        }
        // Find the node to be deleted
        Node current = head;
        Node previous = null;
        while (current != null && current.data != data) {
            previous = current;
            current = current.next;
        }
        // If the node to be deleted was not found
        if (current == null) {
            System.out.println("Element not found");
            return;
        }
        // Unlink the node from the linked list
        previous.next = current.next;
    }

    // Method to search for a node by its value
    public boolean search(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true; // Data found
            }
            current = current.next; // Move to the next node
        }
        return false; // Data not found
    }
}

// Main class to test the Singly Linked List implementation
public class Main {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Adding elements to the linked list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Displaying the linked list
        System.out.println("Linked List:");
        list.display();

        // Searching for an element
        int searchValue = 20;
        System.out.println("Searching for " + searchValue + ": " + list.search(searchValue));

        // Deleting an element
        int deleteValue = 30;
        System.out.println("Deleting " + deleteValue);
        list.delete(deleteValue);

        // Displaying the linked list after deletion
        System.out.println("Linked List after deletion:");
        list.display();
    }
}
