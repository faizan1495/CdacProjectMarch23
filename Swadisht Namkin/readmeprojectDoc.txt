Entitys->
--LocalUser
-id
-UserName
-EncryptedPassword
-Email
-First name
-LastName
--------------done
--Address
-id
-USer
-Address line1
-Adress line2
-City
-Country
-PostCode
---------------------done

--Product
-id
-name
-Short Description
-Long Description
-Price
--------------------done
--inventory
-product
-inStockQuantity
---------------------done
-Order
-id
-User
-Address
-Products + Quantities

-login validation and regitration
-------------------------------------------------------------------------
Normalizing a database schema for an e-commerce website involves designing the structure of the database tables to minimize data redundancy and improve data integrity. Here's a basic example of how you might normalize a database for an e-commerce website:

Assumption: We'll focus on a simplified scenario with three main entities - Product, User, and Order.

1. First Normal Form (1NF): Ensure that each column holds only atomic (indivisible) values.

Product Table:

ProductID	ProductName	Price	Category
1	Laptop	1000.00	Electronics
2	T-shirt	20.00	Clothing
...	...	...	...
2. Second Normal Form (2NF): Meet 1NF and ensure that each non-key column is fully functionally dependent on the primary key.

User Table:

UserID	Username	Email
1	user123	user123@email.com
2	john_doe	john@example.com
...	...	...
Order Table:

OrderID	UserID	ProductID	Quantity	OrderDate
1	1	1	2	2023-08-01
2	1	2	3	2023-08-02
...	...	...	...	...
3. Third Normal Form (3NF): Meet 2NF and remove transitive dependencies.

Here, the Order table is already in 3NF. However, we need to make sure the Product and User tables do not contain transitive dependencies.

User Table:

UserID	Username	Email
1	user123	user123@email.com
2	john_doe	john@example.com
...	...	...
4. Additional Normalization:
Depending on the complexity of your system, you might want to further normalize your schema or introduce additional tables for features like handling product reviews, storing customer addresses, managing inventory, etc.

Remember, normalization is a balance between reducing redundancy and optimizing query performance. Over-normalization can lead to complex queries and slow performance. Sometimes, denormalization (introducing controlled redundancy) is done to improve query efficiency in read-heavy scenarios.

Additionally, foreign key constraints and indexes play a significant role in maintaining data integrity and optimizing database performance.

Please note that this is a simplified example. Real-world e-commerce databases can be much more complex and involve many more tables and relationships. It's recommended to involve a database expert when designing and implementing a database schema for a production-level application.

