# Bookstore Application

## Setup Instructions

### Prerequisites
- Java JDK 8 or later installed
- Apache Maven installed
- Docker running
- PostgreSQL database server installed and running
- docker exec -it shoppy psql -U logikcode -d manuel_bookstore -c "CREATE USER logikcode WITH PASSWORD 'password';"

### Steps to Run the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/logikcode/bookstore.git
2. Navigate to the project directory
   ```bash
   cd bookstore

3. Build the project using Maven:
   ```bash
   mvn clean install

4. Run the application:
   ```bash
   java -jar target/bookstore.jar

## Design Explanation
### Database Design
#### Entities: 
The application has entities for Author, Publisher, Category, Book, StoreUser, and FavouriteBook.
#### Relationships:
Many-to-One: Books have one author, publisher, and category.

One-to-Many: Users can have many favorite books.

Join Tables:
book_author for the many-to-many relationship between books and authors.
favourite_books to store information about favorite book relationships.

## Application Architecture
Spring Boot: The application is built using Spring Boot for rapid application development.
Spring Data JPA: For easy database access and ORM mapping.
Flyway: For database schema version control and migration.
API Layer: RESTful APIs to interact with the bookstore data.

## API Documentation

## Book Endpoints

Create a new book

- POST /books
##### Description: Add a new book to the database.

- Request Body Example:

`{
"title": "Book Title",
"isbn": "1234567890123",
"price": 19.99,
"publication_date": "2024-01-01",
"description": "Description of the book",
"availability_status": "Available",
"author_id": 1,
"publisher_id": 1,
"category_id": 1
}`
### Retrieve a book by ID

- GET /books/{id}

Description: Fetch a book by its ID.

### Update a book

- PUT /books/{id}

Description: <br> Update the details of an existing book.

Request Body Example:<br>

`{
"title": "Updated Book Title",
"isbn": "1234567890123",
"price": 25.99,
"publication_date": "2024-01-01",
"description": "Updated description of the book",
"availability_status": "Not Available",
"author_id": 1,
"publisher_id": 1,
"category_id": 1
}`

### Delete a book by ID

- DELETE /books/{id}

Description: <br>Remove a book from the database by its ID.

### Store User Endpoints
#### Retrieve all store users

- GET /users

Description:<br> Fetch all store users from the database.

- Create a new store user. 
- POST /users
- Sample Payload:<br>
`{
  "name": "User Name",
  "email": "user@example.com",
  "address": "123 User Address",
  "phone": "123-456-7890",
  "registration_date": "2024-01-01"
  }
  `
Description: <br> Add a new store user to the database.
Request Body Example:

### Update a store user

- PUT /users/{id}

Description: <br>Update the details of an existing store user.

Request Body Example:<br>
`{
  "name": "Updated User Name",
  "email": "user@example.com",
  "address": "123 Updated Address",
  "phone": "987-654-3210",
  "registration_date": "2024-01-01"
  }`


### Author Endpoints
GET /authors: Retrieve all authors.

POST /authors: Create a new author.

GET /authors/{id}: Retrieve an author by ID.

PUT /authors/{id}: Update an author.

DELETE /authors/{id}: Delete an author by ID.



### Favourite Book Endpoints
GET /users/{userId}/favourites: Retrieve all favorite books for a user.

POST /users/{userId}/favourites: Add a book to a user's favorites list.

DELETE /users/{userId}/favourites/{bookId}: Remove a book from a user's favorites list.
