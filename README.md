# ItemCategoryCodingChallenge
Synopsis
This is a Java application that implements Item, category solution.
The service will expose three methods:
public boolean generateItemCategories();
which generates 20 item categories - (Category1, Category2, .... , Category20).
public boolean generateItemsOfEachCategory();
which generates 10 items of each category – (Item 1, Item 2, ...., Item 10).
public boolean pickOptimizedItems();
The method handles the below operations with the help of some private methods:
▪ It assigns each item randomly;
▪ A price of between $1 to $20
▪ A shipping cost of between $2 to $5
▪ A rating of between 1 to 5 (a bigger value indicates a better rating)
▪ Picks as many items as you can for the basket, while keeping the total cost (price + shipping cost)
  of all picked items below $50, and ensuring that the sum of ratings of all items picked is optimized.
At the end, it also;
• Prints the coordinates of the selected items.
  e.g. – CategoryA:ItemX,CategoryB:ItemY, ....
• Total cost, and
• Sum of ratings of all the items that were picked.

Technologies
IDE - Eclipse(Mars)
Build tool – Maven
Java 1.8 for source code compilation
In memory (java collection) database.
JUnit for testing
Installation
Clone the repository or download it on the local machine.
Execute Maven build operation.

Output
The below is the output, however the values and order of the output may differ on every execution.
Generated item category :: [Category1, Category2, Category3, Category4, Category5, Category6, Category7, Category8, Category9, Category10, Category11, Category12, Category13, Category14, Category15, Category16, Category17, Category18, Category19, Category20]
Generated item of each category :: [Item1, Item2, Item3, Item4, Item5, Item6, Item7, Item8, Item9, Item10]
Coordinates of the selected items :: Category17:Item1,Category3:Item2,Category10:Item8,Category12:Item6
Total Cost of the selected items :: 43.0
Total Rating of the selected items :: 18
Generated optimized items :: Item1
Generated optimized items :: Item2
Generated optimized items :: Item8
Generated optimized items :: Item6

Unit Testing
The application can be tested by following ways.
Right click on the file TestItemCategoryService.java and run it as a JUnit.
