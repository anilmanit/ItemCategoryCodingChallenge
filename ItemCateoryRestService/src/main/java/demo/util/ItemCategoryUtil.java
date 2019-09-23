package demo.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import demo.constants.ItemCategoryConstants;
import demo.infra.ResourceLoader;
import demo.model.Item;

/**
 * This is an utility class for Item,Category functionality. It performs
 * following operations.
 * <ol>
 * <li>getRandomNumberForItemInRange : Generates the random number in double
 * between min & max number provided.</li>
 * <li>getRandomNumberForItemInRange : Generates the random number in int
 * between min & max number provided.</li>
 * <li>printCoordinatesOfSelectedItems : Prints the coordinates of the selected
 * items.</li>
 * </ol>
 * 
 * @author AnilT
 */
public class ItemCategoryUtil {

	/**
	 * Generates the random number between min & max number provided
	 * 
	 * @param min
	 * @param max
	 * @return the random number for an item in a range
	 */
	public static double getRandomNumberForItemInRange(double min, double max) {

		if (min >= max) {
			throw new IllegalArgumentException(ResourceLoader
					.getPropertyValue(ItemCategoryConstants.DEMO_ITEM_RANDOM_NUMBER_ILLEGAL_ARGUMENT_MESSAGE));
		}

		return (int) (Math.random() * ((max - min) + 1)) + min;
	}

	/**
	 * Generates the random number between min & max number provided
	 * 
	 * @param min
	 * @param max
	 * @return the random number for an item in a range
	 */
	public static int getRandomNumberForItemInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException(ResourceLoader
					.getPropertyValue(ItemCategoryConstants.DEMO_ITEM_RANDOM_NUMBER_ILLEGAL_ARGUMENT_MESSAGE));
		}

		return (int) (Math.random() * ((max - min) + 1)) + min;
	}

	/**
	 * Picks items randomly from each category
	 * 
	 * @param min
	 * @param max
	 * @return the random number for an item in a range
	 */
	public static Set<String> getRandomItemsForEachCategory(Map<String, ArrayList<Item>> itemOfEachCategory) {
		Set<String> uniqueItems = new HashSet<String>();
		ArrayList<Item> itemList = null;
		for (Map.Entry<String, ArrayList<Item>> entry : itemOfEachCategory.entrySet()) {
			itemList = entry.getValue();
			Random rand = new Random();
			Item item = itemList.get(rand.nextInt(itemList.size()));
			uniqueItems.add(entry.getKey().concat(":").concat(item.getItemId()));
		}
		return uniqueItems;
	}

}
