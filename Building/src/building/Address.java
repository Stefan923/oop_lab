package building;

public class Address {
	private String street;
	private String city;
	private Integer number;

	public Address(String street, String city, Integer number) {
		this.street = street;
		this.city = city;
		this.number = number;
	}

	public String toString() {
		return city + ", " + street + ", " + number;
	}
}
