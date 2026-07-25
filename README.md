**Event Management System**

**Overview**

The Event Management System is a Spring Boot based RESTful web application designed to manage events, users, ticket bookings, notifications, and feedback. The application provides secure authentication using JWT, password encryption using BCrypt, API documentation using Swagger OpenAPI, input validation, and centralized exception handling.

**Features**

**User Management**

User Registration
User Login
View All Users
View User By ID
Update User Details
Delete User

**Event Management**

Create Event
View All Events
View Event By ID
Update Event
Delete Event
Search Events By Category
Search Events By Location

**Ticket Management**

Book Ticket
View Tickets
View Ticket By ID
View Tickets By User
View Tickets By Event
Cancel Ticket
Delete Ticket

**Notification Management**

Create Notifications
View Notifications
View Notifications By User
Delete Notifications

**Feedback Management**

Submit Feedback
View Feedback
View Feedback By User
View Feedback By Event
Delete Feedback


**Security Features**


**JWT Authentication**

User authentication using JSON Web Token (JWT)
Secure access to protected APIs
Stateless authentication mechanism

**Spring Security**

Endpoint protection
Authentication and authorization support
Custom JWT Authentication Filter

**BCrypt Password Encryption**

Passwords are encrypted before storing in the database
Plain-text passwords are never stored
Secure password verification using BCryptPasswordEncoder


**Validation**

Bean Validation has been implemented using Jakarta Validation.
Validations

Name cannot be empty
Email must follow a valid format
Password must contain a minimum number of characters
Contact number must contain exactly 10 digits

**Annotations Used**

@NotBlank
@Email
@Size
@Pattern
@Valid


**Exception** **Handling**

Global Exception Handling is implemented using @RestControllerAdvice.
Handled Exceptions

Resource Not Found Exception
Validation Exceptions
Generic Exceptions

**HTTP** **Status** **Codes**

200 OK
400 Bad Request
404 Not Found
500 Internal Server Error


**API** **Documentation**

Swagger OpenAPI is integrated for API testing and documentation.
Swagger URL
Plain Text1http://localhost:1111/swagger-ui/index.htmlShow more lines
OpenAPI Specification
Plain Text1http://localhost:1111/v3/api-docsShow more lines

**Technologies** **Used**
**Backend**

Java
Spring Boot
Spring Security
Spring Data JPA
Hibernate
Maven

Database

MySQL

Security

JWT Authentication
BCrypt Password Encryption

API Documentation

Swagger OpenAPI

Tools

Postman
Swagger UI
Git
GitHub
IntelliJ IDEA


**Project** **Architecture**

Client ->Spring Security  ->JWT Authentication Filter  ->Controllers  ->Services  ->Repositories  ->MySQL Database

**Database** **Tables**

User

UserID
Name
Email
Password
ContactNumber

Event

EventID
Name
Category
Location
Date
OrganizerID

Ticket

TicketID
EventID
UserID
BookingDate
Status

Notification

NotificationID
UserID
EventID
Message
SentTimestamp

Feedback

FeedbackID
EventID
UserID
Rating
Comments
SubmittedTimestamp


**Implemented** **Concepts**

✅ REST API Development
✅ Layered Architecture
✅ Spring Boot
✅ Spring Security
✅ JWT Authentication
✅ BCrypt Password Encryption
✅ Swagger OpenAPI Documentation
✅ Bean Validation
✅ Global Exception Handling
✅ Spring Data JPA
✅ Hibernate ORM
✅ MySQL Database Integration
✅ Git & GitHub Version Control

**Future** **Enhancements**

Role Based Access Control (Admin/User)
Angular Frontend Integration
Email Notifications
Docker Containerization
Nginx Load Balancer
Cloud Deployment (AWS/Azure/Railway)
Report Generation

**Author**
Palani Murugan

GitHub: palanimurugan9038
