package demo.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import demo.service.ItemCategoryServiceImpl;

@RestController
public class ItemCategoryRestController {
	@Autowired
	private ItemCategoryServiceImpl itemCategoryServiceImpl;

	@RequestMapping(value = "/item/category/pickoptimizeditems", method = RequestMethod.GET, produces = "application/json")
	public Map<String, ArrayList<String>> getOptimizedItems() {

		return itemCategoryServiceImpl.pickOptimizedItems();

	}

	@RequestMapping(value = "/item/category/generateItemsOfEachCategory", method = RequestMethod.GET, produces = "application/json")
	public List<String> generateItemsOfEachCategory() {

		return itemCategoryServiceImpl.generateItemsOfEachCategory("Category2");

	}

	@RequestMapping(value = "/item/category/generateItemCategories", method = RequestMethod.GET, produces = "application/json")
	public List<String> generateItemCategories() {

		return itemCategoryServiceImpl.generateItemCategories();

	}

}
