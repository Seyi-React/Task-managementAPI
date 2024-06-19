# Task Management API

## Description

This is a RESTful API for a task management system. It supports user authentication, and CRUD operations for tasks.

## Requirements

- Java 11 or higher 
- Maven

## Setup

1. Clone the repository:
    ```bash
    git clone <repository-link>
    cd task-management-api
    ```

2. Build the project:
    ```bash
    mvn clean install
    ```

3. Run the project:
    ```bash
    mvn spring-boot:run
    ```

4. Access the API documentation at:
    ```
    http://localhost:8080/swagger-ui.html
    ```

## Endpoints

- **Sign Up**: `POST /api/auth/signup`
- **Log In**: `POST /api/auth/login`
- **Create Task**: `POST /api/tasks`
- **Get Tasks**: `GET /api/tasks`
- **Update Task**: `PUT /api/tasks/{taskId}`
- **Delete Task**: `DELETE /api/tasks/{taskId}`

## Assumptions

- The API uses JWT for authentication.
- Tasks belong to a user, and users can only manipulate their own tasks.
- Basic validation and error handling are implemented.
