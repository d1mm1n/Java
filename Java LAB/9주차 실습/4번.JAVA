//자바로 스택 구현하기
package asd;
import java.util.*;

interface Stack{
	void push(int item);
	int pop();
	int peek();
	boolean isEmpty();
}

class MyStack implements Stack{
	ArrayList<Integer> s=new ArrayList<>();
	int top=-1;
	public void push(int item) {
		top++;
		s.add(item);
	}

	@Override
	public int pop() {
		return s.remove(top--);
	}

	@Override
	public int peek() {
		
		return s.get(top);
	}

	@Override
	public boolean isEmpty() {
		if(top<0) {
			return true;
		}
		else{
			return false;
		
		}
	}
	
}

public class Main{	
	
	public static void main(String[] args) {
		MyStack stack=new MyStack();
		// 스택에 요소 추가
		stack.push(1);
		stack.push(2);
		stack.push(3);
		
		// 스택에서 요소 제거 및 출력
		System.out.println(stack.pop()); // 3
		System.out.println(stack.pop()); // 2
		// 스택의 top 요소 확인
		System.out.println(stack.peek()); // 1
		// 스택이 비어있는지 확인
		System.out.println(stack.isEmpty()); // false
	}

}