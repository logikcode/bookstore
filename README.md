# Bookstore Application

## Setup Instructions

### Prerequisites
- Java JDK 17 or later installed
- Apache Maven installed
- Docker installed & running

### Steps to Run the Application
1. Clone the repository:
   ```bash
   git clone https://github.com/logikcode/bookstore.git
2. Navigate to the project directory
   ```bash
   cd bookstore
3. Run the docker compose application to create postgresql container for the application datastore
   ```
   docker-compose up
4. Build the project using Maven:
   ```bash
   cd bookstore
   mvn clean install
   
5. Run the application:
   ```bash
   java -jar target/bookstore-0.0.1-SNAPSHOT.jar

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
### Authentication Endpoints
### Register User Endpoint
- http://localhost:8089/bookstore/api/v1/users/register
- HTTP/ POST
#### Description: Registers a user to the platform
  - Request Body Example:
    ```{
      "firstName": "Emmanuel",
      "lastName": "Emmanuel",
      "email": "emmanuel.admin@gmail.com",
      "password": "12345678",
      "address": "Lagos",
      "phoneNumber": "08012345678"}


### Login Endpoint
- http://localhost:8089/bookstore/api/v1/users/login
- HTTP/ POST
#### Description: Login to the platform.
- Request Body Example:
  ``` {
    "email":"emmanuel.admin@gmail.com",
    "password":"12345678"}

## Book Endpoints

### Retrieve existing books

- HTTP / GET: http://localhost:8089/bookstore/api/v1/books?page=0&size=10&sortField=title&sortDirection=asc
##### Description: Add a new book to the database.
- Prerequisite: <br> Set your Bearer token gotten from login request
- params:
    - page: 
    - size: 
    - sortField
    - sortDirection


### Create a new book

- HTTP / POST: http://localhost:8089/bookstore/api/v1/books
##### Description: Add a new book to the database.
- Prerequisite: Set your Bearer token gotten from login request
- Request Body Example:

`
{
"title": "The Great Gatsby",
"price": 10.99,
"description": "A novel written by American author F. Scott Fitzgerald.",
"availabilityStatus": "AVAILABLE",
"authorNames": ["F. Scott Fitzgerald"],
"publisherName": "Charles Scribner's Sons",
"categoryName": "Fiction"
}
`
### Retrieve a book by ID

- HTTP / GET http://localhost:8089/bookstore/api/v1/books/{id}

- Description: Fetch a book by its ID.
- Prerequisite: Set your Bearer token gotten from login request
- Get Request Example:<br>
  http://localhost:8089/bookstore/api/v1/books/f4b519f6-9e07-4e7c-b2dd-2343b7ace8c2

### Update a book

- HTTP / PUT : http://localhost:8089/bookstore/api/v1/books/edit/{id}

Description: <br> Update the details of an existing book.
- Prerequisite: Set your Bearer token gotten from login request

Request Body Example:<br>

`
{
"title": "The Great Gatsby 2nd",
"price": 19.99,
"description": "A novel written by American author F. Scott Fitzgerald.",
"availabilityStatus": "AVAILABLE",
"authorNames": ["F. Scott Fitzgerald", "Emmanuel O., Sola O."],
"publisherName": "Charles Scribner's Sons 2nd",
"categoryName": "Fiction"
}
`
### Update the status of a book

- HTTP / PUT : http://localhost:8089/bookstore/api/v1/books/f4b519f6-9e07-4e7c-b2dd-2343b7ace8c2/status?status=AVAILABLE

Description: <br> Update the status of an existing book.
- Prerequisite: <br> Set your Bearer token gotten from login request

Request Body Example:<br>

### Delete a book by ID
Description: <br> Delete an existing book.
- Prerequisite: <br> Set your Bearer token gotten from login request

- HTTP / DELETE: http://localhost:8089/bookstore/api/v1/books/{id}

## Book Categories Endpoint
Description: <br>Retrieve all book categories from data store.
- HTTP / GET: http://localhost:8089/bookstore/api/v1/categories
- Prerequisite: <br> Set your Bearer token gotten from login request


## Book Authors Endpoint
Description: <br>Retrieve all book authors from data store.
- HTTP / GET: http://localhost:8089/bookstore/api/v1/authors
- Prerequisite: <br> Set your Bearer token gotten from login request
