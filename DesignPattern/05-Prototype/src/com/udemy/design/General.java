package com.udemy.design;

public class General extends GameUnit {

	private String state = "Idle";

	public void boostMorale() {
		this.state = "MoraleBoost";
	}

	@Override
	public String toString() {
		return "General [state=" + state + "]";
	}

	@Override
	public GameUnit clone() throws CloneNotSupportedException {

		throw new CloneNotSupportedException("General are unique");
	}

	@Override
	protected void reset() {

		throw new UnsupportedOperationException("Reset not Supported");
	}

}
