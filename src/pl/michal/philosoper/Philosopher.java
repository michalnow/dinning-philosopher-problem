package pl.michal.philosoper;

import pl.michal.waiter.Waiter;

public class Philosopher implements Runnable {

	private Waiter waiter;
	private int hungryLevel;
	private String name;


	public Philosopher(Waiter waiter, String name) {
		this.waiter = waiter;
		this.hungryLevel = 0;
		this.name = name;
	}

	private void delay(int sec) {
		try {
			Thread.sleep((long) (sec * 1000 * Math.random() + 1000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void eat(int amount) {
		while (hungryLevel < amount) {

			delay(3);
			System.out.println(String.format("%s IS EATING", name));
			hungryLevel++;
			delay(4);

		}
		
		hungryLevel = 0;
	}

	@Override
	public void run() {

		System.out.println(String.format("%s IS THINKING...", name));

		waiter.provideFork();
		waiter.provideKnife();
		delay(4);

		System.out.println(String.format("%s took knife and fork", name));
		eat(3);

		System.out.println(String.format("\n%s IS GIVING BACK CUTLERY", name));
		waiter.takeBackCutlery();
		System.out.println(String.format("\n%s IS BACK TO THINKING", name));

		delay(1);
		System.out.println(String.format("\n%s is full. He can work in peace\n", name));
	}

}
