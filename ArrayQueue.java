public class ArrayQueue implements Queue{
	public int front;
	public int rear;
	public int size;
	private Object[] queue;

	public ArrayQueue(){
		this(10);
	}
	public ArrayQueue(int size){
		if(size<=0){
			throw new IllegalArgumentException("Size cannot be <= 0");
		}
		this.size = size;
		this.queue = new Object[size];
		this.front = -1;
		this.rear = -1;
	}

	public Object dequeue(){
		Object item = null;
		if(isEmpty()){
			throw new IllegalStateException("Queue is empty, cant dequeue");
		}
		else if(front == rear){
			item = queue[front];
			front = -1;
			rear = -1;
		}
		else{
			item = queue[front];
			front = (front+1)%size;
		}
		return item;
	}
	public void enqueue(Object item){
		if((rear+1)%size==front){
			queue = arrExpand(queue, size);
			enqueue(item);
		}
		else if(isEmpty()){
			front++;
			rear++;
			queue[rear]= item;
		}
		else{
			rear = (rear+1)%size;
			queue[rear] = item;
		}
	}
	public boolean isEmpty(){
		return(front == -1 && rear == -1);
	}
	public Object[] arrExpand(Object[] queue, int size){
		Object[] tempQueue = new Object[(size*2)];
		int count = 0;
		for(int i = this.front; i < size; i++){
			tempQueue[count++] = queue[i];
		}
		this.front = 0;
		this.rear = count;
		this.size = size*2;
		return tempQueue;
	}

public static void main(String[] args){
		ArrayQueue a = new ArrayQueue();
		System.out.println(a.isEmpty());
		a.enqueue("k");
		a.enqueue("a");
		a.enqueue("m");
		a.enqueue("b");
		a.enqueue("k");
		a.enqueue("a");
		a.enqueue("m");
		a.enqueue("b");
		a.enqueue("k");
		System.out.println(a.size);
		a.enqueue("a");
		a.enqueue("m");
		a.enqueue("b");
		System.out.println(a.size);
		System.out.println(a.isEmpty());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
		System.out.println(a.dequeue());
	}
}