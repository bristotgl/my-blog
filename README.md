# My Blog
This is a REST API for a blog, built with Java and Spring Boot. It provides a complete CRUD (Create, Read, Update, Delete) functionality for managing articles and tags. You can create articles, associate tags with them, and search for articles based on their tags and creation date.

The application uses PostgreSQL as its database, which runs in a Docker container for easy setup and portability.

## Features ✨
- Article Management: Create, read, update, and delete articles.
- Tag Management: Create and associate tags with articles.
- Search Functionality: Search for articles by tags and creation date.
- Docker Integration: PostgreSQL database runs in a Docker container.

## Challenges ⛰️
This project was my first attempt at a project-based learning approach, where I set a clear objective and worked towards it, researching solutions whenever I encountered obstacles. While the API itself is simple, the process taught me a lot about the technologies involved.

My key takeaways from this project where:
- Spring Data JPA simplifies a lot the database interactions
- Splitting up the project in controller/service/repository layers makes creating a REST API much more manageable
- Lombok is a life saver 🛟

## Tech Stack 💻
- Java 23
- Spring Boot
- Hibernate
- Spring Data JPA
- Project Lombok
- Spring Web
- PostgreSQL
- Docker
