package cn.com.scitc.domain;


public class ToRentHouse {
/*   
   ����
  
  `rentHouseId` varchar(100) NOT NULL COMMENT '���ⷿ�ݱ��',
  `rentHouseCity` varchar(30) DEFAULT NULL COMMENT '����',
  `rentHouseAddress` varchar(100) DEFAULT NULL COMMENT '��ַ',
  
  `rentHouseRoom` varchar(50) DEFAULT NULL COMMENT '����',
  'rentHouseArea' double(10) DEFAULT NULL COMMENT '���'��
  `rentHouseDecoration` varchar(10) DEFAULT NULL COMMENT 'װ�����',
  `rentHousePrice` double(10,0) DEFAULT NULL COMMENT '����۸�',
  
  `rentHousePicture` varchar(255) DEFAULT NULL COMMENT 'ͼƬ',
  `rentHouseBuildedTime` date DEFAULT NULL COMMENT '���ʱ��',
  `depoist` varchar(10) DEFAULT NULL COMMENT '֧����ʽ',
  
  `verify` int(1) DEFAULT NULL COMMENT '���',0δ���1���ͨ��
  `publishdate` date DEFAULT NULL COMMENT '����ʱ��',
  `username` varchar(12) DEFAULT NULL COMMENT '�û���',
  
  `describle` varchar(500) DEFAULT NULL COMMENT '����',
 */
	private String rentHouseId;
	private String rentHouseShen;
	private String rentHouseCity;
	private String rentHouseAddress;
	
	private String rentHouseRoom;
	private String rentHouseDecoration;
	private Double rentHousePrice;
	
	private String rentHousePicture;
	private String rentHouseBuildedTime;
	private String depoist;
	
	private Integer verify;
	private String publishdate;
	private String username;
	
	private String describle;
	private Double rentHouseArea;
	

	
	public String getRentHouseId() {
		return rentHouseId;
	}

	public void setRentHouseId(String rentHouseId) {
		this.rentHouseId = rentHouseId;
	}

	public String getRentHouseCity() {
		return rentHouseCity;
	}

	public void setRentHouseCity(String rentHouseCity) {
		this.rentHouseCity = rentHouseCity;
	}

	public String getRentHouseAddress() {
		return rentHouseAddress;
	}

	public void setRentHouseAddress(String rentHouseAddress) {
		this.rentHouseAddress = rentHouseAddress;
	}

	public String getRentHouseRoom() {
		return rentHouseRoom;
	}

	public void setRentHouseRoom(String rentHouseRoom) {
		this.rentHouseRoom = rentHouseRoom;
	}

	public String getRentHouseDecoration() {
		return rentHouseDecoration;
	}

	public void setRentHouseDecoration(String rentHouseDecoration) {
		this.rentHouseDecoration = rentHouseDecoration;
	}

	public Double getRentHousePrice() {
		return rentHousePrice;
	}

	public void setRentHousePrice(Double rentHousePrice) {
		this.rentHousePrice = rentHousePrice;
	}

	public String getRentHousePicture() {
		return rentHousePicture;
	}

	public void setRentHousePicture(String rentHousePicture) {
		this.rentHousePicture = rentHousePicture;
	}

	public String getRentHouseBuildedTime() {
		return rentHouseBuildedTime;
	}

	public void setRentHouseBuildedTime(String rentHouseBuildedTime) {
		this.rentHouseBuildedTime = rentHouseBuildedTime;
	}

	public String getDepoist() {
		return depoist;
	}

	public void setDepoist(String depoist) {
		this.depoist = depoist;
	}

	public Integer getVerify() {
		return verify;
	}

	public void setVerify(Integer verify) {
		this.verify = verify;
	}

	public String getPublishdate() {
		return publishdate;
	}

	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescrible() {
		return describle;
	}

	public void setDescrible(String describle) {
		this.describle = describle;
	}

	public Double getRentHouseArea() {
		return rentHouseArea;
	}

	public void setRentHouseArea(Double rentHouseArea) {
		this.rentHouseArea = rentHouseArea;
	}

	public String getRentHouseShen() {
		return rentHouseShen;
	}

	public void setRentHouseShen(String rentHouseShen) {
		this.rentHouseShen = rentHouseShen;
	}


	
	
	
}
