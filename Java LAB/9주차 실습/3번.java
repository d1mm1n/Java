//자바로 큐 구현하기
package asd;
import java.util.*;

interface Queue{
	int dequeue();
	void enqueue(int item);
	boolean isEmpty();
}

class MyQueue implements Queue{
	int rear=-1;
	int front=-1;
	ArrayList<Integer> q = new ArrayList<>();
	
	public boolean isEmpty() {
		if(rear==front) {
			return true;
		}
		else return false;
		
	}
	public int dequeue() {
		if(isEmpty()==true) {
			return 0;
		}
		else {
			int tmp=q.get(++front);
			return tmp;
		}
	}


	public void enqueue(int item) {
		rear++;
		q.add(item);
	}
	
}


public class Main{	
	
	public static void main(String[] args) {
		Queue queue= new MyQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		System.out.println(queue.dequeue()); // 출력: 1
		System.out.println(queue.dequeue()); // 출력: 2
		System.out.println(queue.isEmpty()); // 출력: false
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		System.out.println(queue.dequeue()); // 출력: 3
		System.out.println(queue.dequeue()); // 출력: 4
		System.out.println(queue.dequeue()); // 출력: 5
		System.out.println(queue.dequeue()); // 출력: 6
		System.out.println(queue.isEmpty()); // 출력: true
	
	}
	
}