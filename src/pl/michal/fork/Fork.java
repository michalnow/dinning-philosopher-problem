package pl.michal.fork;

import pl.michal.cutleryInterface.CutleryUsage;

public class Fork implements CutleryUsage {

	private boolean isBeingUsed;
	
	@Override
	public void pickUp() {
		this.isBeingUsed = true;
		
	}

	@Override
	public void putDown() {
		this.isBeingUsed = false;
		
	}
	
	public boolean isBeingUsed() {
		return isBeingUsed;
	} 
}
