package demo.service.intrfc;

/**
 * This is an interface which is a facade which gets implemented by the impl
 * class.
 * 
 * @author AnilT
 */
public interface ItemCategoryService {
	/**
	 * Generates 20 item categories - (Category1, Category2, .... , Category20)
	 * 
	 * @return item categories
	 */
	public boolean generateItemCategories();

	/**
	 * Generate 10 items of each category (Item 1, Item 2, ...., Item 10).
	 * 
	 * @param categoryId
	 * @return Items of each category
	 */
	public boolean generateItemsOfEachCategory(String categoryId);

	/**
	 * This method performs the below operation along with private methods -
	 * 
	 * 1) Picks as many items as it can for the basket, while keeping the total
	 * cost (price + shipping cost) of all picked items below $50, and ensuring
	 * that the sum of ratings of all items picked is optimized.
	 * 
	 * 2) Print the coordinates of the selected items.
	 * 
	 * 3) Gets the total item cost and total ratings
	 * 
	 * @param categoryId
	 * @return Items of each category
	 */
	public boolean pickOptimizedItems();
}
