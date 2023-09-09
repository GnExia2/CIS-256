public class SortedNumberList {
    public Node head;
    public Node tail;

    public SortedNumberList() {
        head = null;
        tail = null;
    }

    // Inserts the number into the list in the correct position
    // such that the list remains sorted in ascending order.
    public void insert(double number) {
        Node newNode = new Node(number);

        if (head == null) {
            // If the list is empty, make the new node both the head and tail
            head = newNode;
            tail = newNode;
        } else if (number <= head.getData()) {
            // If the number is less than or equal to the current head,
            // insert the new node before the current head
            newNode.setNext(head);
            head.setPrevious(newNode);
            head = newNode;
        } else if (number >= tail.getData()) {
            // If the number is greater than or equal to the current tail,
            // insert the new node after the current tail
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        } else {
            // Insert the new node in the middle of the list
            Node current = head;
            while (current != null && current.getData() < number) {
                current = current.getNext();
            }
            if (current != null) {
                Node prev = current.getPrevious();
                newNode.setNext(current);
                newNode.setPrevious(prev);
                prev.setNext(newNode);
                current.setPrevious(newNode);
            }
        }
    }

    // Removes the node with the specified number value from the list.
    // Returns true if the node is found and removed, false otherwise.
    public boolean remove(double number) {
        Node current = head;

        while (current != null) {
            if (current.getData() == number) {
                Node prev = current.getPrevious();
                Node next = current.getNext();

                if (prev != null) {
                    prev.setNext(next);
                } else {
                    // If the removed node is the head, update the head
                    head = next;
                }

                if (next != null) {
                    next.setPrevious(prev);
                } else {
                    // If the removed node is the tail, update the tail
                    tail = prev;
                }

                return true; // Node found and removed
            }

            current = current.getNext();
        }

        return false; // Node not found
    }
}
