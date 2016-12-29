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
Example of response: application/json
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
Example of response: application/json
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

DELETE /projects/{id}/tasks/{id} - delete Task by ID
Example of response: string
"Task with ID:2 was successfully deleted"


POST /projects/{id}/tasks - create new Task
Example of request:
{
  "name": "4 Project",
  "description": "And that is the 3",
  "creationDate": 1481120673000
}


GET /projects/{id}/tasks/{id}/subtasks - get all SubTasks
Example of response: application/json
[
  {
    "id": 1,
    "name": "1 SubTask",
    "description": "First ST",
    "creation_date": 1481061600000,
    "modification_date": 1481120673000,
    "creatorId": 2,
    "deleted": false,
    "status": "INPROGRESS"
  },
  {
    "id": 2,
    "name": "2 SubTask",
    "description": "Second ST",
    "creation_date": 1481061600000,
    "modification_date": 1481120673000,
    "creatorId": 2,
    "deleted": false,
    "status": "INPROGRESS"
  }
]


GET /projects/{id}/tasks/{id}subtasks/{id} - get SubTask by ID
Example of response: application/json
{
  "id": 1,
  "name": "1 SubTask",
  "description": "First ST",
  "creation_date": 1481061600000,
  "modification_date": 1481120673000,
  "creatorId": 2,
  "deleted": false,
  "status": "INPROGRESS"
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
