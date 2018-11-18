package pl.michal.philosoper;

import pl.michal.fork.Fork;
import pl.michal.knife.Knife;
import pl.michal.waiter.Waiter;

public class Philosopher implements Runnable {

	private Waiter waiter;
	private Fork fork;
	private Knife knife;
	private int hungryLevel;
	private String name;

	public Philosopher(Waiter waiter, String name) {
		this.waiter = waiter;
		this.hungryLevel = 0;
		this.name = name;
	}

	@Override
	public void run() {

		System.out.println(name + " IS THINKING...");
		int eatTurns = 0;
		while (eatTurns  < 3) {
			fork = waiter.provideFork();
			knife = waiter.provideKnife();
			if (!(fork == null) && !(knife == null)) {
				while (hungryLevel < 5) {

					System.out.println(name + " took knife and fork");

					try {
						Thread.sleep((long) (3000 * Math.random() + 1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}

					System.out.println(name + " IS EATING");

					try {
						Thread.sleep((long) (4000 * Math.random() + 1000));
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					hungryLevel++;
				}
				System.out.println(name + " IS BACK TO THINKING");
			}

			hungryLevel = 0;
			
			eatTurns++;
		}
		
		System.out.println("\n\n" + name + " is full. He can work in peace \n\n");
	}

}
