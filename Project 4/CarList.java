public abstract class CarList {
    public CarNode head;
    public CarNode tail;
    public int length = 0;


    public CarList() {
        this.head = new CarNode();
        this.tail = this.head;
    }

    public void append(Car car) {
        CarNode node = new CarNode(car);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public String toString() {
        String data = "";
        CarNode node = head.next;
        while (node != null) {
            data += node.data.toString() + "\n";
            node = node.next;
        }
        return data;
    }
}