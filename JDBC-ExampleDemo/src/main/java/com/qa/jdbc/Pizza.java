package com.qa.jdbc;

public class Pizza {

	private long pizzaId;
	private String flavour;
	private int slices;
	private boolean stuffedCrust;

	// Constructors - the way mySQL handles AUTO_INCREMENT
	// Overloading - having multiple constructors

	// Constructor WITH id - When retrieving data we need to know what the id is
	public Pizza(long pizzaId, String flavour, int slices, boolean stuffedCrust) {
		super();
		this.pizzaId = pizzaId;
		this.flavour = flavour;
		this.slices = slices;
		this.stuffedCrust = stuffedCrust;
	}

	// Constructor WITHOUT id - when posting data you don't know what the id is
	public Pizza(String flavour, int slices, boolean stuffedCrust) {
		super();
		this.flavour = flavour;
		this.slices = slices;
		this.stuffedCrust = stuffedCrust;
	}

	public long getPizzaId() {
		return pizzaId;
	}

	public void setPizzaId(long pizzaId) {
		this.pizzaId = pizzaId;
	}

	public String getFlavour() {
		return flavour;
	}

	public void setFlavour(String flavour) {
		this.flavour = flavour;
	}

	public int getSlices() {
		return slices;
	}

	public void setSlices(int slices) {
		this.slices = slices;
	}

	public boolean isStuffedCrust() {
		return stuffedCrust;
	}

	public void setStuffedCrust(boolean stuffedCrust) {
		this.stuffedCrust = stuffedCrust;
	}

	@Override
	public String toString() {
		return "Pizza [pizzaId=" + pizzaId + ", flavour=" + flavour + ", slices=" + slices + ", stuffedCrust="
				+ stuffedCrust + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((flavour == null) ? 0 : flavour.hashCode());
		result = prime * result + (int) (pizzaId ^ (pizzaId >>> 32));
		result = prime * result + slices;
		result = prime * result + (stuffedCrust ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (flavour == null) {
			if (other.flavour != null)
				return false;
		} else if (!flavour.equals(other.flavour))
			return false;
		if (pizzaId != other.pizzaId)
			return false;
		if (slices != other.slices)
			return false;
		if (stuffedCrust != other.stuffedCrust)
			return false;
		return true;
	}

}
