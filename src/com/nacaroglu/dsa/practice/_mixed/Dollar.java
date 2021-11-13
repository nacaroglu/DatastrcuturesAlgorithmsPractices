package com.nacaroglu.dsa.practice._mixed;

public class Dollar {

	private int amount;

	public Dollar(int amount) {
		this.amount = amount;
	}

	public Dollar times(int times) {		
		return new Dollar(amount*times);	
	}
	

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dollar other = (Dollar) obj;
		if (amount != other.amount)
			return false;
		
		return true;
	}
	
	
}
