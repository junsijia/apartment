package cn.com.scitc.domain;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/*
 * 关注
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
	 * 获取所有的关注项
	 */
	public  Collection<ToRentHouseItem> getAttentionItems(){
		return itemMap.values();
	}
	
	/*
	 * 加入关注
	 */
	public void addAttention(ToRentHouseItem item) {
		String id = item.getRentHouse().getRentHouseId();
		itemMap.put(id,item);
	}
	/*
	 * 移除关注
	 */
	public void delAttention(String id) {
		itemMap.remove(id);
	}
	/*
	 * 清空关注
	 */
	public void clearAttention() {
		itemMap.clear();
	}

}
