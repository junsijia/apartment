package cn.com.scitc.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/*
 * ��ע
 */

public class RentAttention {
	private Map<String, ToRentHouseItem> itemMap = new HashMap<String,ToRentHouseItem>();

	public Map<String, ToRentHouseItem> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<String, ToRentHouseItem> itemMap) {
		this.itemMap = itemMap;
	}
	/*
	 * ��ȡ���еĹ�ע��
	 */
	public  Collection<ToRentHouseItem> getAttentionItems(){
		return itemMap.values();
	}
	
	/*
	 * �����ע
	 */
	public void addAttention(ToRentHouseItem item) {
		String id = item.getRentHouse().getRentHouseId();
		itemMap.put(id,item);
	}
	/*
	 * �Ƴ���ע
	 */
	public void delAttention(String id) {
		itemMap.remove(id);
	}
	/*
	 * ��չ�ע
	 */
	public void clearAttention() {
		itemMap.clear();
	}

}
