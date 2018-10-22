import java.util.EmptyStackException;
public class ArrayStack implements Stack{
	private Object[] stack;
  	private int size;
	
	public ArrayStack(){
		this(10);
	}
	public ArrayStack(int size) {
    	stack = new Object[size];
    	size = 0;
  	}

	public void push(Object item){
		stack[size] = item;
    	size++;
    	if(stack.length == size)
      		doubleSpace();
	}
	public Object pop(){
		if(empty()){
      		throw new EmptyStackException();
  		}
    	size--;
    	return stack[size];
	}
	public Object peek(){
		if(empty()){
      		throw new EmptyStackException();
  		}
    	return stack[size - 1];
	}
	public boolean empty(){
		return size == 0;
	}
	private void doubleSpace(){
		Object[] newstack = new Object[stack.length * 2];
    	for(int i = 0; i < size; i++){
      		newstack[i] = stack[i];
    	}
    	stack = newstack;
	}

	public static void main(String[] args){
		ArrayStack a = new ArrayStack();
		System.out.println(a.empty());
		a.push(8);
		a.push("a");
		System.out.println(a.stack.length);
		a.push(false);
		a.push("K");
		System.out.println(a.peek());
		a.push("t");
		a.push(6);
		a.push(8.8);
		a.push(true);
		a.push('k');
		a.push("jack");
		System.out.println(a.empty());
		a.push("p");
		System.out.println(a.stack.length);
		a.push("V");
		System.out.println(a.pop());

	}
}