# Yoga API

## Yoga_API is a robust system facilitating seamless management of yoga classes, user subscriptions, and payments.
It provides a structured database, enabling users to effortlessly connect, subscribe to tailored packages, and track attendance for a harmonious yoga experience.


To set up the Yoga API, follow these steps:

## 1. Set up PostgreSQL Database

First, create a Docker container for the PostgreSQL database:

```bash
docker run -p 5432:5432 --name Yoga-postgres -e POSTGRES_USER=yoga -e POSTGRES_PASSWORD=root -e POSTGRES_DB=yoga -d postgres
```


## 2. Connect Database with Spring

Connect the Yoga API with the PostgreSQL database by configuring the `application.properties` file with the following properties:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/yoga
spring.datasource.username=yoga
spring.datasource.password=root
```


## 3. Create Database Tables

![Yoga_diagram](https://github.com/Mostafahassen1/Yoga-API/assets/134046265/359b92cf-2010-4072-9e65-0fe88e6c0b54)


## Explaination of Tables:

### Users
Contains information about users.

### Classes
Stores information about the classes for the week, including details for different skill levels (beginner, advanced, medium).


### Packages
In the business case, there are three packages:
- Package A: Yoga
- Package B: Yoga, Pilates
- Package C: Yoga, Pilates, Tai Chi

### Subscriptions
Holds information about users subscribed to a specific package.

### Payments
Records information about user payments for a package, including the payment method.

### Attendance
Logs information about users attending specific classes.


