<HTML>
<HEAD>
</HEAD>
<BODY LANG="en-US" DIR="LTR">
<PRE CLASS="western"><h1># Item Category Coding Challenge</h1>
<h2>Synopsis</h2>
This is a Java application that implements Item, category solution.</br>
The service will expose three methods:</br>
public boolean generateItemCategories();</br>
which generates 20 item categories - (Category1, Category2, .... , Category20).</br>
public boolean generateItemsOfEachCategory();</br>
which generates 10 items of each category &ndash; (Item 1, Item 2, ...., Item 10).</br>
public boolean pickOptimizedItems();</br>
The method handles the below operations with the help of some private methods:</br>
1) It assigns each item randomly;</br>
2) A price of between $1 to $20</br>
3) A shipping cost of between $2 to $5</br>
4) A rating of between 1 to 5 (a bigger value indicates a better rating)</br>
5) Picks as many items as you can for the basket, while keeping the total cost (price + shipping cost)</br>
  of all picked items below $50, and ensuring that the sum of ratings of all items picked is optimized.</br>
At the end, it also;</br>
&bull; Prints the coordinates of the selected items.</br>
  e.g. &ndash; CategoryA:ItemX,CategoryB:ItemY, ....</br>
&bull; Total cost, and</br>
&bull; Sum of ratings of all the items that were picked.</br>

<h2>Technologies</h2>
IDE - Eclipse(Mars)</br>
Build tool &ndash; Maven</br>
Java 1.8 for source code compilation</br>
In memory (java collection) database.</br>
JUnit for testing</br>

<h2>Installation</h2>
Clone the repository or download it on the local machine.</br>
Execute Maven build operation.</br>

<h2>Output</h2>
The below is the output, however the values and order of the output may differ on every execution.</br>
Sep 22, 2019 8:08:30 PM demo.service.ItemCategoryServiceImpl generateItemCategories</br>
INFO: Generated item category :: [Category1, Category2, Category3, Category4, Category5, Category6, Category7, Category8, Category9, Category10, Category11, Category12, Category13, Category14, Category15, Category16, Category17, Category18, Category19, Category20]</br>
Sep 22, 2019 8:08:30 PM demo.service.ItemCategoryServiceImpl generateItemsOfEachCategory</br>
INFO: Generated item of each category :: [Item1, Item2, Item3, Item4, Item5, Item6, Item7, Item8, Item9, Item10]</br>
Sep 22, 2019 8:08:30 PM demo.service.ItemCategoryServiceImpl printCoordinatesOfSelectedItems</br>
INFO: Coordinates of the selected items :: Category5:Item1,Category11:Item9,Category4:Item6</br>
Sep 22, 2019 8:08:30 PM demo.service.ItemCategoryServiceImpl getTotalCostWithOptimizedRating</br>
INFO: Total Cost of the selected items :: 37.0</br>
Sep 22, 2019 8:08:30 PM demo.service.ItemCategoryServiceImpl getTotalCostWithOptimizedRating</br>
INFO: Total Rating of the selected items :: 14</br>
Sep 22, 2019 8:08:30 PM demo.service.ItemCategoryServiceImpl lambda$5</br>
INFO: Generated optimized items :: Item1</br>
Sep 22, 2019 8:08:30 PM demo.service.ItemCategoryServiceImpl lambda$5</br>
INFO: Generated optimized items :: Item9</br>
Sep 22, 2019 8:08:30 PM demo.service.ItemCategoryServiceImpl lambda$5</br>
INFO: Generated optimized items :: Item6</br>


<h2>Unit Testing</h2>
The application can be tested by following ways.</br>
Right click on the file TestItemCategoryService.java and run it as a JUnit.</br>
</PRE>
</BODY>
</HTML>
