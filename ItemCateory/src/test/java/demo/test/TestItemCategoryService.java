package demo.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import demo.infra.ResourceLoader;
import demo.service.ItemCategoryServiceImpl;

/**
 * This class instantiates the Impl class and unit test's various methods
 * available to satisfy the business requirement.
 * 
 * @author AnilT
 */
public class TestItemCategoryService {
	private ItemCategoryServiceImpl itemCategoryService = new ItemCategoryServiceImpl();
	private static String DEMO_TEST_ITEM_CATEGORY = "demo.test.item.category";

	@Test
	public void testGenerateItemCategories() {
		boolean isCatGenerated = itemCategoryService.generateItemCategories();
		assertEquals(true, isCatGenerated);
	}

	@Test
	public void testGenerateItemsOfEachCategory() {
		boolean isCatGenerated = itemCategoryService
				.generateItemsOfEachCategory(ResourceLoader.getPropertyValue(DEMO_TEST_ITEM_CATEGORY));
		assertEquals(true, isCatGenerated);
	}

	@Test
	public void testPickOptimizedItemsAndPrintTheValues() {
		boolean isOptimizedItemsPicked = itemCategoryService.pickOptimizedItems();
		assertEquals(true, isOptimizedItemsPicked);

	}

}
