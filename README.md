## Beekeeping Information System 🐝🐝🐝

This project demonstrates the full lifecycle of relational database design and implementation in the beekeeping domain. It includes conceptual modeling, relational schema design, implementation in PostgreSQL, and integration with a Java application.

### 1. Conceptual model (sql3.pdf)

Eight main entities: User, Personal Data, Customer, Beekeeper, Honey, Jar, Comment, Beehive + the associative entity Recommended.  
It contains weak entities (e.g. Personal Data dependent on User), recursive relationships (a beekeeper collaborating with another beekeeper), inheritance (User as a superclass for Customer and Beekeeper), and composite identifiers.

### 2. Relational model and database implementation

The model was transformed into a relational schema with corresponding tables in PostgreSQL.  
All key relationships were preserved: 1:1, 1:N, N:M, as well as recursive relationships.  
Sample data was inserted for testing, and SQL queries were prepared demonstrating joins, aggregations, nested selects, set operations, and pagination.

### 3. Advanced database elements (sql4.pdf)

Trigger: Prevents the deletion of a beekeeper if at least one beehive is assigned to them.  
Transaction: Demonstrates a change of user role by converting a beekeeper into a customer within a serializable transaction.  
Views: Provide simplified access to filtered data (e.g. jars with a specific type and amount of honey).  
Indexes: Improve search performance based on selected attributes, such as honey composition.

### 4. Java integration

The relational schema was connected to a Java project in IntelliJ IDEA.  
Entities were mapped to database tables using JPA/Hibernate.  
DAO classes were implemented for database operations and encapsulation of persistent logic.

### 5. Purpose of the project

The project serves as a case study of database design and software engineering. It combines conceptual modeling, relational implementation, and application development into a single cohesive system.
