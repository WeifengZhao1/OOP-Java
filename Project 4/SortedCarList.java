public class SortedCarList extends CarList {
    public SortedCarList() {}

    public void add(Car c) {

        CarNode node = new CarNode(c);
        CarNode nextnode = this.head;

        while (nextnode.next != null && node.data.compareTo(nextnode.next.data) > 0) {
            nextnode = nextnode.next;
        }
        node.next = nextnode.next;
        nextnode.next = node;

        if (nextnode == this.tail) this.tail = node;
    }
}