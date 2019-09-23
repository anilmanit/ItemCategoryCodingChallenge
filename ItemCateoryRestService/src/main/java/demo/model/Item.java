package demo.model;

/**
 * This class represents the pojo for Item.
 * 
 * @author AnilT
 */
public class Item {
	/**
	 * Represents the itemId
	 */
	private String itemId;	
	/**
	 * Represents the categoryId which acts as a foreign key and has one to one
	 * mapping
	 */
	private String categoryId;
	/**
	 * Represents the price of an item
	 */
	private double itemPrice;
	/**
	 * Represents the rating of an item
	 */
	private int itemRating;
	/**
	 * Represents the shipping charges of an item
	 */
	private double shippingCharges;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemRating() {
		return itemRating;
	}

	public void setItemRating(int itemRating) {
		this.itemRating = itemRating;
	}

	public double getShippingCharges() {
		return shippingCharges;
	}

	public void setShippingCharges(double shippingCharges) {
		this.shippingCharges = shippingCharges;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", categoryId=" + categoryId + ", itemPrice=" + itemPrice + ", itemRating="
				+ itemRating + ", shippingCharges=" + shippingCharges + "]";
	}

}
