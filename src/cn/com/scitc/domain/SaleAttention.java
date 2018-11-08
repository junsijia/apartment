package cn.com.scitc.domain;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/*
 * 关注
 */

public class SaleAttention {
	private Map<String, ToSaleHouseItem> itemMap = new HashMap<String,ToSaleHouseItem>();

	public Map<String, ToSaleHouseItem> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<String, ToSaleHouseItem> itemMap) {
		this.itemMap = itemMap;
	}
	/*
	 * 获取所有的关注项
	 */
	public  Collection<ToSaleHouseItem> getAttentionItems(){
		return itemMap.values();
	}
	
	/*
	 * 加入关注
	 */
	public void addAttention(ToSaleHouseItem item) {
		String id = item.getSaleHouse().getHouseId();
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
