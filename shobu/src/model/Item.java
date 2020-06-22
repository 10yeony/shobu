package model;

public class Item {
	private int itemNumber; //item_id
	private String name; //item_name
	private int price;
	private String description;
	private String url; //picture_url
	private int count;
	//조회수는 만들어질 때 늘어나지 않고 상세정보 볼 때 늘어나므로 사실 객체 생성 때 넣지 않아도 됨.

	public Item(int itemNumber, String name, int price, String description, String url, int count) {
		super();
		this.itemNumber = itemNumber;
		this.name = name;
		this.price = price;
		this.description = description;
		this.url = url;
		this.count = count;
	}
	public Item(int itemNumber, String name, int price, String description, String url) {
		super();
		this.itemNumber = itemNumber;
		this.name = name;
		this.price = price;
		this.description = description;
		this.url = url;
	}
	public Item() {};
	public Item(int itemNumber) { //기본키
		super();
		this.itemNumber = itemNumber;
	}
	
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	@Override
	public String toString() {
		return "Item [itemNumber=" + itemNumber + ", name=" + name + ", price=" + price + ", description=" + description
				+ ", url=" + url + ", count=" + count + "]";
	};
}
