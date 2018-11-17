package pl.michal.philosoper;

import pl.michal.fork.Fork;
import pl.michal.knife.Knife;
import pl.michal.waiter.Waiter;

public class Philosopher implements Runnable {
	
	private Waiter waiter;
	
	public Philosopher (Waiter waiter){
		this.waiter = waiter;
	}
	
	@Override
	public void run() {
		
		
	}



}
