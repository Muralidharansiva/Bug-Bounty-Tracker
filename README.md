#  Bug Bounty Tracker (Java + MySQL)

A simple database-driven Bug Bounty Management System built using **Java**, **JDBC**, and **MySQL**.

This project demonstrates real-world backend concepts such as database connectivity, CRUD operations, and JDBC integration.

---

# Features

✔ Add Bug Reports  
✔ View All Bugs  
✔ Update Bug Status  
✔ Delete Bugs  
✔ Persistent Storage using MySQL  

---

# Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL
- VS Code

---

#Database Structure

Database: `bugtracker`

Table: `bugs`

| Column   | Type         |
|----------|-------------|
| id       | INT (PK)     |
| title    | VARCHAR(255) |
| severity | VARCHAR(50)  |
| status   | VARCHAR(50)  |
| reward   | DOUBLE       |

---

#Setup Instructions

# Create Database

Run this in MySQL:

```sql
CREATE DATABASE bugtracker;
USE bugtracker;

CREATE TABLE bugs(
    id INT PRIMARY KEY,
    title VARCHAR(255),
    severity VARCHAR(50),
    status VARCHAR(50),
    reward DOUBLE
);
