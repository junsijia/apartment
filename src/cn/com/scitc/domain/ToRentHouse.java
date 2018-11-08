package cn.com.scitc.domain;


public class ToRentHouse {
/*   
   出租
  
  `rentHouseId` varchar(100) NOT NULL COMMENT '出租房屋编号',
  `rentHouseCity` varchar(30) DEFAULT NULL COMMENT '城市',
  `rentHouseAddress` varchar(100) DEFAULT NULL COMMENT '地址',
  
  `rentHouseRoom` varchar(50) DEFAULT NULL COMMENT '居室',
  'rentHouseArea' double(10) DEFAULT NULL COMMENT '面积'，
  `rentHouseDecoration` varchar(10) DEFAULT NULL COMMENT '装修情况',
  `rentHousePrice` double(10,0) DEFAULT NULL COMMENT '出租价格',
  
  `rentHousePicture` varchar(255) DEFAULT NULL COMMENT '图片',
  `rentHouseBuildedTime` date DEFAULT NULL COMMENT '落成时间',
  `depoist` varchar(10) DEFAULT NULL COMMENT '支付方式',
  
  `verify` int(1) DEFAULT NULL COMMENT '审核',0未审核1审核通过
  `publishdate` date DEFAULT NULL COMMENT '发布时间',
  `username` varchar(12) DEFAULT NULL COMMENT '用户名',
  
  `describle` varchar(500) DEFAULT NULL COMMENT '描述',
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
