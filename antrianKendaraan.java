public class antrianKendaraan {
    nodeKendaraan front;
    nodeKendaraan rear;
    int jumlah;

    public antrianKendaraan(){
        this.front = null;
        this.rear = null;
        this.jumlah = 0;
    }

    public void enqueue(kendaraan kendaraan){
        nodeKendaraan newNode = new nodeKendaraan(kendaraan);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        jumlah++;
    }

    public kendaraan dequeue(){
        if (front == null) {
            return null;
        }
        kendaraan kendaraan = front.kendaraan;
        front = front.next;
        if (front == null) {
            rear = null;
        }
    }
}
