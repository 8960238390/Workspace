package com.udemy.design;

public class Swordsman extends GameUnit {

	private String state = "Idle";

	public void attack() {

		this.state = "attacking";
	}

	@Override
	public String toString() {
		return "Swordsman [state=" + state + "]";
	}

	@Override
	protected void reset() {

		this.state = "Idle";
	}

}
