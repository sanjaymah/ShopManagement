
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
