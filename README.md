<i>There will appear a description of the API soon.</i>

GET /projects - get all Pprojects

Example of response: application/json
{
  "id": 2,
  "name": "2 Project",
  "description": "And that is the second",
  "creationDate": 1481120673000,
  "creatorId": 2,
  "deleted": false,
  "tasks": [
    {
      "id": 2,
      "name": "2 Task",
      "description": "Second Task",
      "creation_date": 1481061600000,
      "modification_date": 1481061600000,
      "projectId": 2,
      "creatorId": 1,
      "assigneeId": 2,
      "deleted": false,
      "status": "TODO",
      "subTaskList": []
    }
  ]
}

GET /projects/{id} - get Project by ID

Example of response: application/json
{
  "id": 2,
  "name": "2 Project",
  "description": "And that is the second",
  "creationDate": 1481120673000,
  "creatorId": 2,
  "deleted": false,
  "tasks": [
    {
      "id": 2,
      "name": "2 Task",
      "description": "Second Task",
      "creation_date": 1481061600000,
      "modification_date": 1481061600000,
      "projectId": 2,
      "creatorId": 1,
      "assigneeId": 2,
      "deleted": false,
      "status": "TODO",
      "subTaskList": []
    }
  ]
}

DELETE /projects/{id} - delete Project by ID

Example of response: string
"Project with ID:3 was successfully deleted"

POST /projects - create new Project

Example of request:
{
  "name": "4 Project",
  "description": "And that is the 3",
  "creationDate": 1481120673000
}

GET /projects/{id}/tasks - get all Tasks

[
  {
    "id": 2,
    "name": "2 Task",
    "description": "Second Task",
    "creation_date": 1481061600000,
    "modification_date": 1481061600000,
    "projectId": 2,
    "creatorId": 1,
    "assigneeId": 2,
    "deleted": false,
    "status": "TODO",
    "subTaskList": []
  }
]

GET /projects/{id}/tasks/{id} - get Task by ID
[
  {
    "id": 2,
    "name": "2 Task",
    "description": "Second Task",
    "creation_date": 1481061600000,
    "modification_date": 1481061600000,
    "projectId": 2,
    "creatorId": 1,
    "assigneeId": 2,
    "deleted": false,
    "status": "TODO",
    "subTaskList": []
  }
]

/projects/{id}/tasks/{id}/subtasks
