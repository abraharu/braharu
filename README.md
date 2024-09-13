# TodoList Application

## Description
This is a RESTful API for managing tasks (ToDo List), developed using Spring Boot. The application supports basic user functions such as registration, authentication, and task creation, update, and deletion. Files can also be attached to tasks and stored on the server.

## Features
- User registration and authentication.
- Create, update, and delete tasks.
- Attach files to tasks.

## Technology Stack
- **Spring Boot** — main framework for developing the REST API.
- **Spring Security** — for user authentication and authorization.
- **Lombok** — to simplify code (auto-generation of getters, setters, constructors).
- **H2** — for data storage.
- **Maven** — dependency management and project build tool.

## API Documentation
### Registration
- **URL:** /users/register
- **Method:** POST
- **Request Body:**
```json
{
    "username": "user",
    "password": "password"
}
```

### Authenticate a User
- **URL:** /auth/login
- **Method:** POST
- **Request Body:**
```json
{
    "username": "user",
    "password": "password"
}
```
- **Response Body:**
```json
{
    "message": "User authenticated successfully"
}
```
### Get All Tasks
- **URL:** /tasks
- **Method:** GET
- **Response Body:**
```json
[
  {
    "id": 1,
    "description": "Test",
    "completed": false,
    "filePath": null,
    "user": {
      "id": 1,
      "username": "newuser"
    }
  }
]
```
### Create a Task
- **URL:** /tasks
- **Method:** POST
- **Request Example:**
  - Content Type: multipart/form-data
  - Fields:
  - description: Task description.
  - completed: Task completion status.
  - file: (Optional) Attached file.
- **Response Body:**
```json
{
  "id": 1,
  "description": "Test",
  "completed": false,
  "filePath": null,
  "user": {
    "id": 1,
    "username": "newuser"
  }
}
```
### Update a Task
- **URL:** /tasks/{id}
- **Method:** PUT
- **Request Example:**
  - Content Type: multipart/form-data
  - Fields:
  - description: Task description.
  - completed: Task completion status.
  - file: (Optional) Attached file.
- **Response Body:**
```json
{
  "id": 1,
  "description": "Prikol",
  "completed": true,
  "filePath": "C:\\uploads\\tasks\\1726266974400_New Text Document.txt",
  "user": {
    "id": 1,
    "username": "newuser"
  }
}
```
### Delete a Task
- **URL:** /tasks/{id}
- **Method:** DELETE
- **Response Body:**
```json
{
  "message": "Task deleted successfully"
}
```