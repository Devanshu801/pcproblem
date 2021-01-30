package pcproblem;

import java.util.ArrayList;

public class pcprob {

	
	
	ArrayList<Integer> list = new ArrayList<>(); 
	int capacity = 2; 
	
	public void produce() throws InterruptedException 
	{ 
		int value = 0; 
		while (true) { 
			synchronized (this) 
			{ 
				 
				while (list.size() == capacity) 
					wait(); 

				System.out.println("Producer produced-"+ value); 
				
				list.add(value++); 

				System.out.println(list);
	 
				notify(); 

				Thread.sleep(1000); 
			} 
		} 
	} 


	public void consume() throws InterruptedException 
	{ 
		while (true) { 
			synchronized (this) 
			{ 
			
				while (list.size() == 0) 
					wait(); 

			
				int a = list.remove(0);
				
				System.out.println("Consumer consumed-"+ a); 
				System.out.println(list);
			
				notify(); 

				Thread.sleep(1000); 
			} 
		} 
	} 
} 
