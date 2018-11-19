package pl.michal.app;


import pl.michal.philosoper.Philosopher;
import pl.michal.waiter.Waiter;

public class AppStart {
	final static String[] names = {
			"Archimedes", "Sokrates", "Platon", "Arystoteles", "Zenon", "Anaksagoras" , "Odys" , "Panoramix" , "Kloptfeusz",
			"Xenoneusz" , "Loptfeusz" , "Zaranktos" ,"Uletes"
			};
	final static int PHILOSOPHERS_QUANTITY = 7;
	final static int KNIVES_QUANTITY = 3;
	final static int FORKS_QUANTITY = 2;

	public static void main(String[] args) {
		Waiter waiter = new Waiter(FORKS_QUANTITY, KNIVES_QUANTITY);

		Philosopher[] philosophers = new Philosopher[PHILOSOPHERS_QUANTITY];

		for (int i = 0; i < PHILOSOPHERS_QUANTITY; i++) {
			philosophers[i] = new Philosopher(waiter, names[i]);

			Thread thread = new Thread(philosophers[i], names[i]);
			thread.start();
		}
	}

}
