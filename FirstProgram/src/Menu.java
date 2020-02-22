import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;

public class Menu {
	Scanner scan = new Scanner(System.in);
	private boolean engine = true;
	private int pushElem;
	
	
	public void startMenu(){
		System.out.println("Stack size:");
		int stackSize = scan.nextInt();
		Stack stack = new Stack(stackSize);
		
	while(engine) {
		System.out.println("->Enter 1 to push the element...");
		System.out.println("->Enter 2 to check the peek of the stack...");
		System.out.println("->Enter 3 to pop the element...");
		System.out.println("->Enter 4 for random stack fill...");
		System.out.println("->Enter 5 to show elements...");
		System.out.println("->Enter 6 to clear the stack...");
		System.out.println("->Enter 7 to the progress save in file...");
		System.out.println("->Enter 8 to read from file..."); 
		System.out.println("->Enter 0 to exit...");
		int i = scan.nextInt(); 
		switch(i) {	
		case 0:
			this.engine = false;
			break;
		case 1:
			System.out.println("Element:");	
			this.pushElem = scan.nextInt();
			stack.push(pushElem);				
			System.out.println("Done!");
			System.out.println(" ");
			break;	
		case 2:
			stack.peek();
			break;
		case 3:
			stack.pop();
			System.out.println("Done!");
			System.out.println(" ");
			break;
		case 4:
			stack.randomPush();
			System.out.println("Done!");
			System.out.println(" ");
			break;
		case 5: 
			stack.showElem();
			//System.out.println("Done!");
			System.out.println(" ");
			break;
		case 6:
			stack.clearStack();
			System.out.println("Stack is cleared");
			System.out.println(" ");
			break;
		case 7:
			try {
				File file = new File("myFile.txt");
				PrintWriter pw = new PrintWriter(file);
				if(!file.exists()) file.createNewFile();
				int[] copy = stack.getArray();
				for(int n = stack.getTop(); n >= 0; n--) {
					pw.println(copy[n]);
				}
				pw.close();
			} catch(IOException e) {
				System.out.println("Error" + e);}
			System.out.println("Done!");
			System.out.println(" ");
			break;
		case 8:
				stack.reWriter();
				System.out.println("Done!");
				System.out.println(" ");
		default:
			System.out.println("Please, enter the correct value");
			continue;
		}
   }
 }
}
