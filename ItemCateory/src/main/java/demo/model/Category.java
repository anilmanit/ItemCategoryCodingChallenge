package demo.model;

/**
 * This class represents the pojo for Category.
 * 
 * @author AnilT
 */
public class Category {
	/**
	 * Represents the categoryId
	 */
	private String categoryId;

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + "]";
	}
}
