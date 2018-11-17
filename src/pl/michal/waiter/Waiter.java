package pl.michal.waiter;

import java.util.ArrayList;
import java.util.List;

import pl.michal.fork.Fork;
import pl.michal.knife.Knife;

public class Waiter {
	
	private int forkQuantity;
	private int knifeQuantity;
	private List<Knife> knives;
	private List<Fork> forks;
	
	public Waiter(int forkQuantity, int knifeQuantity) {
		for(int i=0;i<forkQuantity;i++) {
			forks.add(new Fork());
		}
		
		for(int i=0;i<knifeQuantity;i++) {
			knives.add(new Knife());
		}
	}
	
	public synchronized Fork provideFork() {
		for(Fork fork: forks) {
			if(!fork.isBeingUsed()) {
				return fork;
			}
		}
		
		return null;
	}
	
	public synchronized Knife provideKnife() {
		for(Knife knife: knives) {
			if(!knife.isBeingUsed()) {
				knife.pickUp();
				return knife;
			}
		}
		
		return null;
	}
	
	public synchronized void takeBackFork() {
		for(Fork fork: forks) {
			if(fork.isBeingUsed()) {
				fork.putDown();
				break;
			}
		}
	}
	
	public synchronized void takeBackKnife() {
		for(Knife knife: knives) {
			if(!knife.isBeingUsed()) {
				knife.putDown();
				break;
			}
		}
	}	
 
	
	
}
