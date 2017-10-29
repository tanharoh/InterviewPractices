import util.IntegerLinkedList;
import util.IntegerNode;

/**
 * 第二章 链表问题
 * 打印两个链表问题的公共部分
 * Page 34
 */

public class A11_PrintCommonPart {
    public static void printCommonPart(IntegerNode head1, IntegerNode head2) {
        System.out.println("Common part: ");
        while (head1 != null && head2 != null) {
            if (head1.value < head2.value) {
                head1 = head1.next;
            } else if (head1.value > head2.value) {
                head2 = head2.next;
            } else {
                System.out.print(head1.value + " ");
                head1 = head1.next;
                head2 = head2.next;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        IntegerLinkedList linkedList1 = new IntegerLinkedList();
        IntegerLinkedList linkedList2 = new IntegerLinkedList();

        for (int i = 0; i < 5; i++) {
            linkedList1.add(i);
        }
        for (int i = 3; i < 7; i++) {
            linkedList2.add(i);
        }

        linkedList1.print();
        linkedList2.print();

        printCommonPart(linkedList2.head, linkedList1.head);
    }
}
