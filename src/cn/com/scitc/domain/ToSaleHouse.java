package cn.com.scitc.domain;


public class ToSaleHouse {

/*
   二手房
   
  `houseId` varchar(100) NOT NULL COMMENT '出售房屋编号',
  `houseCity` varchar(30) DEFAULT NULL COMMENT '城市',
  `houseAddress` varchar(100) DEFAULT NULL COMMENT '地址',
  
  `houseRoom` varchar(50) DEFAULT NULL COMMENT '居室',
  `decoration` varchar(30) DEFAULT NULL COMMENT '装修情况',
  `floor` varchar(10) DEFAULT NULL COMMENT '楼层',
  
  `houseArea` double(10,0) DEFAULT NULL COMMENT '面积',
  `housePrice` double(10,0) DEFAULT NULL COMMENT '价格',
  `verify` int(1) DEFAULT NULL COMMENT '审核',
  
  `describle` varchar(500) DEFAULT NULL COMMENT '描述',
  `housePicture` varchar(200) DEFAULT NULL COMMENT '图片',
  `builddate` date DEFAULT NULL COMMENT '落成时间',
  
  `userName` varchar(12) DEFAULT NULL COMMENT '用户名',
  `houseType` varchar(20) DEFAULT NULL COMMENT '房屋类型',
  `publishdate` date DEFAULT NULL COMMENT '发布时间',
 */
	
	private String houseId;
	private String houseShen;
	private String houseCity;
	private String houseAddress;
	
	private String houseRoom;
	private String decoration;
	private String floor;
	
	private Double houseArea;
	private Double housePrice;
	private Integer verify;
	
	private String describle;
	private String housePicture;
	private String builddate;
	
	private String userName;
	private String houseType;
	private String publishdate;
	
	
	public String getHouseId() {
		return houseId;
	}
	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}
	public String getHouseCity() {
		return houseCity;
	}
	public void setHouseCity(String houseCity) {
		this.houseCity = houseCity;
	}
	public String getHouseAddress() {
		return houseAddress;
	}
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	public String getHouseRoom() {
		return houseRoom;
	}
	public void setHouseRoom(String houseRoom) {
		this.houseRoom = houseRoom;
	}
	public String getDecoration() {
		return decoration;
	}
	public void setDecoration(String decoration) {
		this.decoration = decoration;
	}
	public String getFloor() {
		return floor;
	}
	public void setFloor(String floor) {
		this.floor = floor;
	}
	public Double getHouseArea() {
		return houseArea;
	}
	public void setHouseArea(Double houseArea) {
		this.houseArea = houseArea;
	}
	public Double getHousePrice() {
		return housePrice;
	}
	public void setHousePrice(Double housePrice) {
		this.housePrice = housePrice;
	}
	public Integer getVerify() {
		return verify;
	}
	public void setVerify(Integer verify) {
		this.verify = verify;
	}
	public String getDescrible() {
		return describle;
	}
	public void setDescrible(String describle) {
		this.describle = describle;
	}
	public String getHousePicture() {
		return housePicture;
	}
	public void setHousePicture(String housePicture) {
		this.housePicture = housePicture;
	}
	public String getBuilddate() {
		return builddate;
	}
	public void setBuilddate(String builddate) {
		this.builddate = builddate;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getHouseType() {
		return houseType;
	}
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	public String getPublishdate() {
		return publishdate;
	}
	public void setPublishdate(String publishdate) {
		this.publishdate = publishdate;
	}
	public String getHouseShen() {
		return houseShen;
	}
	public void setHouseShen(String houseShen) {
		this.houseShen = houseShen;
	}
	
}
