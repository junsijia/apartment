package cn.com.scitc.domain;

public class ToRentHouseItem {

	private ToRentHouse rentHouse;
	

	public ToRentHouse getRentHouse() {
		return rentHouse;
	}

	public void setRentHouse(ToRentHouse rentHouse) {
		this.rentHouse = rentHouse;
	}
	public ToRentHouseItem (ToRentHouse rentHouse) {
		super();
		this.rentHouse=rentHouse;
	}
}
