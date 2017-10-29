package util;

public class IntegerLinkedList {
    public IntegerNode head;
    private IntegerNode current;

    public void add(int data) {
        if (head == null) {
            head = new IntegerNode(data);
            current = head;
        } else {
            current.next = new IntegerNode(data);
            current = current.next;
        }
    }

    public void print() {
        if (head != null) {
            current = head;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public int length() {
        if (head == null) {
            return -1;
        }
        current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }
}
