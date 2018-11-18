package pl.michal.knife;

import pl.michal.cutleryInterface.CutleryUsage;

public class Knife implements CutleryUsage {
	
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

	public void setBeingUsed(boolean isBeingUsed) {
		this.isBeingUsed = isBeingUsed;
	}

	
	
}
