
Shop management : The sample application developed in spring boot, mysql , html, javascript 
The application displays list of existing shops.
shop details include -  ID ,	Name ,	Category ,	Address, 	Owner

user can add a new shop by entering following fields
Name ,	Category ,	Address, 	Owner  and clicking submit button

user can delete an existing shop
on entering shopname and ID and clicking submit button

steps to install application
1 ) go to mysql
if test database not present


create database test;
use test;

create table - shops
  
DROP TABLE IF EXISTS test.shops;
CREATE TABLE test.shops (
	id INT NOT NULL AUTO_INCREMENT,
	name VARCHAR(100) NOT NULL,
	category varchar(30),
	address varchar(100),
	owner varchar(30),
	PRIMARY KEY (id));
  
insert sample data  
  
insert into test.shops(name,category,address,owner)values('seasons','mall','boatclub','amit');
insert into test.shops(name,category,address,owner)values('onmart','shop','chandani chowk','vijay');
insert into test.shops(name,category,address,owner)values('big bazar','mall','kothrud','biyani');
insert into test.shops(name,category,address,owner)values('nmart','mall','boatclub','bhushan');	
commit;

check if data is inserted in shops table
select * from shops;

2 ) import project in spring tool suite
Folder - ShopManagement

3 ) open pom.xml
update maven command to download the necessary jars

4 ) run project by running following file - run as application
\ShopManagement\src\main\java\com\shopping\ShopManageApp.java
check if the application starts successfully.

5) open browser. enter the following url
http://localhost:8080/shops/

If successful, it shows page 
shop list is displayed.

6 )to add a shop 
enter - name,category, address, owner
click on submit

shop gets added in the list

7)to delete a shop
enter - name, id
click on submit

if the shopname,id is correct, 
it will get deleted from the list



################################################

file details
1)\ShopManagement\src\main\resources\application.properties
property file containing various application related properties

2)\ShopManagement\src\main\resources\templates\index.html
UI screen that gets loaded after clinking the url
http://localhost:8080/shops/

3)\ShopManagement\src\main\java\com\shopping\ShopManageApp.java
To run the application

4)\ShopManagement\src\main\java\com\shopping\DataSourceConfig.java
To create Datasource object

5 )\ShopManagement\src\main\java\com\shopping\controller\ShopController.java
will contain request mapping - method calls - display , add , delete operations

6 ) \ShopManagement\src\main\java\com\shopping\model\Shop.java
model class - shop entity

7 )\ShopManagement\src\main\java\com\shopping\service\ShopService.java
interface containing methods for database operations

8 )\ShopManagement\src\main\java\com\shopping\service\ShopServiceImpl.java
implementation of above interface


################################################
This file modified on 1 aug 2024