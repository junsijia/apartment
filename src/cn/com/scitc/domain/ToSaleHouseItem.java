package cn.com.scitc.domain;

public class ToSaleHouseItem {

	private ToSaleHouse saleHouse;
	
	
	public ToSaleHouse getSaleHouse() {
		return saleHouse;
	}

	public void setSaleHouse(ToSaleHouse saleHouse) {
		this.saleHouse = saleHouse;
	}
	
	public ToSaleHouseItem (ToSaleHouse saleHouse) {
		super();
		this.saleHouse=saleHouse;
	}


}
