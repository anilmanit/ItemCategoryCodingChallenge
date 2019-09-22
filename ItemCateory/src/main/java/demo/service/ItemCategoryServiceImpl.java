package demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import demo.constants.ItemCategoryConstants;
import demo.infra.EntityLogger;
import demo.infra.ResourceLoader;
import demo.model.Category;
import demo.model.Item;
import demo.util.ItemCategoryUtil;

/**
 * This is an implementation class for Item,Category functionality. It performs
 * following operations.
 * <ol>
 * <li>generateItemCategories : Generates 20 item categories - (Category1,
 * Category2, .... , Category20).</li>
 * <li>generateItemsOfEachCategory : Generate 10 items of each category �
 * (Item 1, Item 2, ...., Item 10).</li>
 * <li>printCoordinatesOfSelectedItems : Prints the coordinates of the selected
 * items.</li>
 * <li>getTotalCostWithOptimizedRating : Gets the total item cost & sum of item
 * ratings</li>
 * </ol>
 * 
 * @author AnilT
 */
public class ItemCategoryServiceImpl implements demo.service.intrfc.ItemCategoryService {
	/**
	 * This attribute represents the component name.
	 */
	private static final String THIS_COMPONENT_NAME = ItemCategoryServiceImpl.class.getName();
	/**
	 * This creates a instance of logger for the component name as class name.
	 */
	private static Logger logger = EntityLogger.getUniqueInstance().getLogger(THIS_COMPONENT_NAME);
	private static List<Category> categoryStore = new ArrayList<Category>();
	private static List<Item> itemStore = new ArrayList<Item>();
	private static Map<String, ArrayList<Item>> itemOfEachCategory = new HashMap<String, ArrayList<Item>>();
	private static Map<String, ArrayList<String>> itemCoordinatesMap = new HashMap<String, ArrayList<String>>();
	private static List<String> itemCoordinatesList = new ArrayList<String>();
	private double finalOptimizedCost = 0;
	private int finalOptimizedRating = 0;
	private String strItemCoordinates = null;
	private double itemCost = 0;
	private int itemRatingTotal = 0;
	private List<Item> itemListForCoordinates = new ArrayList<Item>();
	static {
		// In memory store for Item and Category
		String categoryId = null;
		String itemCoordinates = null;
		try {
			for (int catId = 1; catId <= Integer.parseInt(
					ResourceLoader.getPropertyValue(ItemCategoryConstants.DEMO_ITEM_CATEGORY_COUNT)); catId++) {
				categoryId = ItemCategoryConstants.CONST_CATEGORY.concat(String.valueOf(catId));
				Category category = new Category();
				category.setCategoryId(categoryId);
				categoryStore.add(category);
				for (int itmId = 1; itmId <= Integer.parseInt(
						ResourceLoader.getPropertyValue(ItemCategoryConstants.DEMO_ITEM_ITEM_COUNT)); itmId++) {
					Item item = new Item();
					item.setItemId(ItemCategoryConstants.CONST_ITEM.concat(String.valueOf(itmId)));
					item.setCategoryId(categoryId);
					item.setItemPrice(ItemCategoryUtil.getRandomNumberForItemInRange(
							Double.parseDouble(
									ResourceLoader.getPropertyValue(ItemCategoryConstants.DEMO_ITEM_MIN_PRICE)),
							Double.parseDouble(
									ResourceLoader.getPropertyValue(ItemCategoryConstants.DEMO_ITEM_MAX_PRICE))));
					item.setItemRating(ItemCategoryUtil.getRandomNumberForItemInRange(
							Integer.parseInt(
									ResourceLoader.getPropertyValue(ItemCategoryConstants.DEMO_ITEM_MIN_RATING)),
							Integer.parseInt(
									ResourceLoader.getPropertyValue(ItemCategoryConstants.DEMO_ITEM_MAX_RATING))));
					item.setShippingCharges(ItemCategoryUtil.getRandomNumberForItemInRange(
							Double.parseDouble(
									ResourceLoader.getPropertyValue(ItemCategoryConstants.DEMO_ITEM_MIN_SHIPPING_COST)),
							Double.parseDouble(ResourceLoader
									.getPropertyValue(ItemCategoryConstants.DEMO_ITEM_MAX_SHIPPING_COST))));
					itemStore.add(item);
					itemCoordinates = String.valueOf(categoryId).concat(ItemCategoryConstants.DEMO_ITEM_SPLITER_COLON)
							.concat(item.getItemId());
					itemCoordinatesList.add(itemCoordinates);
					itemCoordinatesMap.put(item.getItemId(), (ArrayList<String>) itemCoordinatesList);
					itemOfEachCategory.put(categoryId, (ArrayList<Item>) itemStore);
				}
			}
		} catch (IllegalArgumentException ex) {
			logger.log(Level.INFO, "IllegalArgumentException thrown during in memory data creation :: " + ex);
		}
	}

	/**
	 * Generates 20 item categories - (Category1, Category2, .... , Category20)
	 * 
	 * @return item categories
	 */
	public boolean generateItemCategories() {
		List<String> itemCategoryList = new ArrayList<String>();
		categoryStore.forEach(category -> {
			itemCategoryList.add(category.getCategoryId());
		});
		logger.log(Level.INFO, "Generated item category :: " + itemCategoryList);
		return itemCategoryList.size() > 0 ? true : false;
	}

	/**
	 * Generate 10 items of each category -(Item 1, Item 2, ...., Item 10).
	 * 
	 * @param categoryId
	 * @return Items of each category
	 */
	public boolean generateItemsOfEachCategory(String categoryId) {
		List<String> itemOfEachCategoryList = new ArrayList<String>();

		itemOfEachCategory.entrySet().stream().filter(p -> p.getKey().equals(categoryId))
				.flatMap(p -> p.getValue().stream()).collect(Collectors.toList()).forEach(item -> {
					if (categoryId.equals(item.getCategoryId())) {
						itemOfEachCategoryList.add(item.getItemId());
					}
				});

		logger.log(Level.INFO, "Generated item of each category :: " + itemOfEachCategoryList);
		return itemOfEachCategoryList.size() > 0 ? true : false;
	}

	/**
	 * Picks as many items as it can for the basket, while keeping the total
	 * cost (price + shipping cost) of all picked items below $50, and ensuring
	 * that the sum of ratings of all items picked is optimized.
	 * 
	 * @param categoryId
	 * @return Items of each category
	 */

	public boolean pickOptimizedItems() {
		Set<Item> randomItems = new HashSet<Item>();
		List<Item> optimizedItemList = null;
		Set<String> uniqueItems = ItemCategoryUtil.getRandomItemsForEachCategory(itemOfEachCategory);
		try {
			uniqueItems.forEach(itemStr -> {
				String[] splitVal = itemStr.split(ItemCategoryConstants.DEMO_ITEM_SPLITER_COLON);
				String categoryId = splitVal[0];
				String itemId = splitVal[1];
				itemStore.forEach(item -> {
					if (item.getCategoryId().equals(categoryId) && item.getItemId().equals(itemId)) {
						randomItems.add(item);
					}
				});
			});
		} catch (ArrayIndexOutOfBoundsException ex) {
			logger.log(Level.WARNING, "ArrayIndexOutOfBoundsException thrown in pickOptimizedItems");
		}
		optimizedItemList = getTotalCostWithOptimizedRating(randomItems);
		
		optimizedItemList.forEach(item -> {
			logger.log(Level.INFO, "Generated optimized items :: " + item.getItemId());
		});
		
		return optimizedItemList.size() > 0 ? true : false;
	}

	/**
	 * Print the coordinates of the selected items.
	 * 
	 * @param categoryId
	 * @return coordinates of selected items
	 */
	private String printCoordinatesOfSelectedItems(List<Item> items) {
		items.forEach(item -> {
			if (strItemCoordinates == null)
				strItemCoordinates = item.getCategoryId().concat(ItemCategoryConstants.DEMO_ITEM_SPLITER_COLON)
						.concat(item.getItemId());
			else
				strItemCoordinates = strItemCoordinates.concat(ItemCategoryConstants.DEMO_ITEM_SPLITER_COMMA) + item
						.getCategoryId().concat(ItemCategoryConstants.DEMO_ITEM_SPLITER_COLON).concat(item.getItemId());
		});
		logger.log(Level.INFO, "Coordinates of the selected items :: " + strItemCoordinates);
		return strItemCoordinates;
	}

	/**
	 * Gets the total item cost and total ratings
	 * 
	 * @param items
	 * @return returns total item cost
	 */
	private List<Item> getTotalCostWithOptimizedRating(Set<Item> list) {
		list.forEach(item -> {
			// Condition to get the good rating(>3) items and to choose items
			// between lowest cost 3 to the highest cost.
			// Also to consider the item cost <50 so that the maximum optimized
			// items can be taken into consideration.
			if (item.getItemRating() > Integer
					.parseInt(ResourceLoader.getPropertyValue(ItemCategoryConstants.DEMO_ITEM_LOWEST_COST))
					&& (item.getItemPrice() + item.getShippingCharges()) < Integer
							.parseInt(ResourceLoader.getPropertyValue(ItemCategoryConstants.DEMO_ITEM_HIGHEST_COST))) {
				itemRatingTotal = itemRatingTotal + item.getItemRating();
				itemCost = itemCost + item.getItemPrice() + item.getShippingCharges();
				if (itemCost < Double
						.parseDouble(ResourceLoader.getPropertyValue(ItemCategoryConstants.DEMO_ITEM_MAX_COST))) {
					itemListForCoordinates.add(item);
					finalOptimizedCost = itemCost;
					finalOptimizedRating = itemRatingTotal;
				}
			}
		});
		printCoordinatesOfSelectedItems(itemListForCoordinates);
		logger.log(Level.INFO, "Total Cost of the selected items :: " + finalOptimizedCost);
		logger.log(Level.INFO, "Total Rating of the selected items :: " + finalOptimizedRating);
		return itemListForCoordinates;
	}

}
