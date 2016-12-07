insert into issueTracker.project (name, description, creation_date, creator_id)
VALUES ('1 Project' , 'This is the first one', 1481103343 , 1);

insert into issueTracker.project (name, description, creation_date, creator_id)
VALUES ('2 Project' , 'And that is the second', 1481103343 , 2);

insert INTO issueTracker.task (name, description, creation_date, modification_date, project_id, status, creator_id, assignee_id)
VALUES ('1 Task' , 'First Task', 1481103343, 1481103343 , 1, 'TODO', 1, 1);

insert INTO issueTracker.task (name, description, creation_date, modification_date, project_id, status, creator_id, assignee_id)
VALUES ('2 Task' , 'Second Task', 1481103343, 1481103343 , 2, 'TODO', 1, 2);

insert INTO issueTracker.task (name, description, creation_date, modification_date, project_id, status, creator_id, assignee_id)
VALUES ('3 Task' , 'Third One', 1481103343, 1481103343 , 1, 'INPROGRESS', 1, 1);

insert INTO issueTracker.sub_task (name, description, creation_date, modification_date, task_id, status)
VALUES ('1 SubTask' , 'First ST', 1481103343, 1481103343 , 3, 'INPROGRESS');

insert INTO issueTracker.sub_task (name, description, creation_date, modification_date, task_id, status)
VALUES ('2 SubTask' , 'Second ST', 1481103343, 1481103343 , 3, 'INPROGRESS');

INSERT INTO issueTracker.user (nickname, name, surname, email, password) VALUES
 ('kriva', 'Andrew', 'Krivonosov', 'ak47@levi9.com', '$2a$08$Wd09nbSNrsu1/e1gqYzpiO1S6QXkZEzGqDGP0G6PzooKLcoTp7EV2');

 INSERT INTO issueTracker.user (nickname, name, surname, email, password) VALUES
 ('j4', 'Arnold', 'Khovrashkov', 'j4h@leprosorium.ru', '$2a$08$Wd09nbSNrsu1/e1gqYzpiO1S6QXkZEzGqDGP0G6PzooKLcoTp7EV2');

INSERT INTO issueTracker.project_user (project_id, user_id) VALUES (1, 1);
INSERT INTO issueTracker.project_user (project_id, user_id) VALUES (2, 2);