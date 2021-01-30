package pcproblem;

public class main {

	public static void main(String[] args) 	throws InterruptedException {
	
	
		{ 
		
			final pcprob pc = new pcprob(); 

			Thread t1 = new Thread(new Runnable() { 
				@Override
				public void run() 
				{ 
					try { 
						pc.produce(); 
					} 
					catch (InterruptedException e) { 
						e.printStackTrace(); 
					} 
				} 
			}); 

			Thread t2 = new Thread(new Runnable() { 
				@Override
				public void run() 
				{ 
					try { 
						pc.consume(); 
					} 
					catch (InterruptedException e) { 
						e.printStackTrace(); 
					} 
				} 
			}); 

			
			t1.start(); 
			t2.start(); 

			t1.join(); 
			t2.join(); 
		} 
	}

}
