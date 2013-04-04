package at.edu.hti.shop.domain;

public abstract class Product {
	private String name;
	private long id;
	private double prize;
	private double weight;
	private int deliveryDays;
	

	public Product( long id, String name, double prize, double weight, int deliveryDays) {
		super();
		this.name = name;
		this.id = id;
		this.prize = prize;
		this.weight = weight;
		this.deliveryDays = deliveryDays;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	public double getPrize() {
		return prize;
	}

	public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

  public int getDeliveryDays() {
    return deliveryDays;
  }

  public void setDeliveryDays(int deliveryDays) {
    this.deliveryDays = deliveryDays;
  }

  @Override
	public String toString() {
		return "Product [" + name + ", " + id + ", " + prize + ", " + weight + ", " + deliveryDays + "]";
	}

}
