package model;

public class Item {
	private int itemNumber; // item_id
	private String name; //item_name
	private int price;
	private String desc; //description
	private String url; //pciture_url
	private int count;
	
	public Item() {}
	
	public Item(int itemNumber) {
		super();
		this.itemNumber = itemNumber;
	}

	public Item(int itemNumber, String name, int price, String desc, String url) {
		super();
		this.itemNumber = itemNumber;
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.url = url;
	}
	
	public Item(int itemNumber, String name, int price, String desc, String url, int count) {
		super();
		this.itemNumber = itemNumber;
		this.name = name;
		this.price = price;
		this.desc = desc;
		this.url = url;
		this.count = count;
	}
	
	public int getItemNumber() {return itemNumber;}
	public void setItemNumber(int itemNumber) {this.itemNumber = itemNumber;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
	public String getDesc() {return desc;}
	public void setDesc(String desc) {this.desc = desc;}
	public String getUrl() {return url;}
	public void setUrl(String url) {this.url = url;}
	public int getCount() {return count;}
	public void setCount(int count) {this.count = count;}

	@Override
	public String toString() {
		return "Item [itemNumber=" + itemNumber + ", name=" + name + ", price=" + price + ", desc=" + desc + ", url="
				+ url + ", count=" + count + "]";
	}
}
