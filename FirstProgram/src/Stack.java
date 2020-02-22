import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.io.File;
//import java.io.IOException;
//import java.io.PrintWriter;
import java.util.Arrays;

class Stack {
	Random random = new Random();
	
	private int size;
	private int[] array;
	private int top;
	
	public Stack(int[] array) {
		this.array = Arrays.copyOf(array, array.length);
	}
	
	public int[] getArray() {
		return Arrays.copyOf(array, array.length);
	}
	
	public int getTop(){
		return top;
	}

	public Stack(int s) {
		this.size = s;
		array = new int[size];
		top = -1;
	}
	
	public boolean isEmpty() {
	   return(top == -1);	
	}
	
	public boolean isFull() {
		return(top == size - 1);
	}
	
	public void push(int a) {
		//int i = ++top;
		if(!isFull()) {
			array[++top] = a;
			//System.out.println("Current Top is:" + top);
		} else {
			System.out.println("Error: Stack is full");
			System.out.println(" ");
		}
	}
	
	public void randomPush() {
		for(int j = 0; j < size; j++) {
			top++;
			array[j] = random.nextInt(100);
		}
	}
	
	public void showElem() {
		if(!isEmpty()) {for(int k = top; k >= 0; k--) {
			System.out.println(array[k]);	}
		} else {
			System.out.println("Error: Stack is empty");
		}
	}
	
	public int pop(){
		if(isEmpty()) {
			System.out.println("Error: Stack is empty");
			return 0;
		} else {
			//System.out.println("Current Top is:" + top);
			return array[top--];} 
	}
	
	public void clearStack() {
		if(!isEmpty()) {for(int l = top; l >=0; l--) {
			--top;}
		} else {
			System.out.println("Error: Stack is empty");
		}
	}
	
	public int peek() {
		if(isEmpty()) {
			System.out.println("Error: Stack is empty");
			System.out.println(" ");
			return 0;
		} else {
			System.out.println("Current peek element is: " + array[top] + " (Top = " + top +")");
			System.out.println(" ");
			return array[top];
		}
	}
	
	public void reWriter() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("myFile.txt"));
			String line;
			int count = top;
			int temp = 0;
			while((line = br.readLine()) != null) {
				temp = Integer.parseInt(line);
				array[count] = temp;
				count--;
				}
			}catch(IOException e) {
				System.out.println("Error" + e);
				} finally { 
					try {
						br.close();
					} catch(IOException e) {
						System.out.println("Error" + e);
					}
				}
	}
}
	
	