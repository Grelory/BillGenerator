# Bill Generator

An algorithm which calculates the total price for a given basket.

**Input data:**
  - product_prices.csv - stores information about available products and their price 
  ```
barcode, name, amount, price
1001, beer, 1, 1.20
1001, beer, 2, 2.00
1243, eggs, 1, 0.20
3401, chocolate, 1, 3.15
1243, eggs, 10, 1.90
  ```
  - basket.txt - stores information about a shopping list
  ```
  ...
  3401
  1001
  1243
  1243
  ```

**Output:**

Program prints generated bill in the console:
```
	|name      |amount    |price     |discount  |total     
	|beer      |4         |1.20      |0.80      |4.00      
	|chocolate |4         |3.15      |0.00      |12.60     
	|eggs      |2         |0.20      |0.00      |0.40      
The total price is: 17.00 EUR
```

**Modifying input data:**

Any number of barcodes or new products can be added as long as the file structure remains unchanged.

**Launching:**

The main function requires two parameters which are names of product prices and basket file.

Application starts with run.sh file:
```
mvn clean package
java -classpath target/classes/ com.codecool.billgenerator.App product_prices.csv basket.txt
```
Command:
```
./run.sh
```

