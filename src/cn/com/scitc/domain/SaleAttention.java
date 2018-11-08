package cn.com.scitc.domain;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/*
 * ��ע
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
	 * ��ȡ���еĹ�ע��
	 */
	public  Collection<ToSaleHouseItem> getAttentionItems(){
		return itemMap.values();
	}
	
	/*
	 * �����ע
	 */
	public void addAttention(ToSaleHouseItem item) {
		String id = item.getSaleHouse().getHouseId();
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
