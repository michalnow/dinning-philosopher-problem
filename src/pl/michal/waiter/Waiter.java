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

		this.forkQuantity = forkQuantity;
		this.forks = new ArrayList<Fork>();

		for (int i = 0; i < forkQuantity; i++) {
			forks.add(new Fork());
		}

		this.knifeQuantity = knifeQuantity;
		this.knives = new ArrayList<Knife>();

		for (int i = 0; i < knifeQuantity; i++) {
			knives.add(new Knife());
		}
	}

	public synchronized void provideFork() {
		if (forks.size() != 0)
			forks.remove(0);
		else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void provideKnife() {
		if (knives.size() != 0)
			knives.remove(0);
		else {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void takeBackCutlery() {
		forks.add(new Fork());
		knives.add(new Knife());
		notify();
	}

}
