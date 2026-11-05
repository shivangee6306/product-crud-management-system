# Product Management System (CRUD)

Tech: Java 17, Spring Boot 3, Spring Data JPA (Hibernate), SQL Server, HTML + JavaScript

## Run kaise kare
1. SSMS me `database.sql` run karo (ProductDB ban jayega).
2. `src/main/resources/application.properties` me apna SQL Server username/password daalo.
3. VS Code me folder open karo -> `ProductManagementApplication.java` open karke Run dabao
   (ya terminal me: `mvn spring-boot:run`).
4. Browser me kholo: http://localhost:8082

## API
- GET    /api/products            -> sab products (?search=text se search)
- GET    /api/products/{id}       -> ek product
- POST   /api/products            -> naya product
- PUT    /api/products/{id}       -> update
- DELETE /api/products/{id}       -> delete

## Flow
Browser (index.html) -> Controller -> Service -> Repository -> SQL Server
