Bus Ticket Booking System
Project Overview
The Bus Ticket Booking System is a web-based application that allows users to book tickets for bus journeys. The system provides functionalities for managing bus seats, viewing available tickets, and making bookings. It is designed to streamline the process of ticket booking and seat allocation.

Features
User Interface: A simple and interactive web interface for users to view bus details, book tickets, and check available seats.

Seat Management: Admin can add and manage bus seats, as well as track seat availability.

Ticket Booking: Users can book tickets for available bus routes and seats.

Database Integration: All data (bus details, seats, and tickets) are stored in a local MySQL database.

Authentication: Admin access to manage bus details and user tickets.

No Frontend Option for Adding Buses: To add buses, you'll need to use Postman or similar tools.

Tech Stack
Backend: Spring Boot (Java)

Frontend: HTML, CSS, JavaScript

Database: MySQL (local database)

Version Control: Git, GitHub

Installation
Clone the repository:

bash
Copy
Edit
git clone https://github.com/your-username/bus-ticket-booking-system.git
Set up the MySQL database:

Create a new local database in MySQL:

pgsql
Copy
Edit
CREATE DATABASE bus_ticket_booking;
Import the database schema from the project or create tables manually based on the entities (Bus, Seat, Ticket).

Configure the database connection:

In the src/main/resources/application.properties file, update the database connection settings to match your local MySQL configuration:

ini
Copy
Edit
spring.datasource.url=jdbc:mysql://localhost:3306/bus_ticket_booking
spring.datasource.username=your-username
spring.datasource.password=your-password
Add Bus Details Using Postman:

Since the frontend does not provide an option to add bus details, use Postman to make POST requests to the backend for adding bus details in JSON format.

Endpoint: http://localhost:8080/api/bus

Request Type: POST

Body (JSON format):

json
Copy
Edit
{
  "busName": "Express Bus",
  "busNumber": "1234",
  "route": "City A to City B",
  "totalSeats": 40
}
How to use Postman:

Open Postman and set the method to POST.

Enter the URL: http://localhost:8080/api/bus.

Go to the Body tab, select raw, and choose JSON.

Paste the JSON request (shown above).

Click Send to make the request.

This will add the bus details to the database, and you can verify by checking the Bus table in the database.

Build and run the application:

If you're using Maven:

arduino
Copy
Edit
mvn clean install
mvn spring-boot:run
Usage
Launch the application by running the Spring Boot application.

Access the web interface through a browser at http://localhost:8080.

Use the admin panel to view available buses and book tickets.

Users can book tickets only for buses that have been added using Postman.

Database Schema
Bus: Stores bus details (e.g., bus name, bus number, route, total seats).

Seat: Stores seat availability and pricing information.

Ticket: Stores ticket bookings, associated with a bus and seat.

Contributing
Feel free to fork the repository, make improvements, and create pull requests. Contributions are always welcome!
