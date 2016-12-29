INSERT INTO USER (id, nickname, name, surname, email, password) VALUES
  (1, 'kriva', 'Andrew', 'Krivonosov', 'ak47@levi9.com', '$2a$08$Wd09nbSNrsu1/e1gqYzpiO1S6QXkZEzGqDGP0G6PzooKLcoTp7EV2');

INSERT INTO USER (id, nickname, name, surname, email, password) VALUES
  (2, 'j4', 'Arnold', 'Khovrashkov', 'j4h@leprosorium.ru', '$2a$08$Wd09nbSNrsu1/e1gqYzpiO1S6QXkZEzGqDGP0G6PzooKLcoTp7EV2');

INSERT INTO PROJECT (id, name, description, creation_date, creator_id, deleted)
VALUES (1, '1 Project' , 'This is the first one','2016-12-07 16:24:33', 1, FALSE);

insert into PROJECT (id, name, description, creation_date, creator_id, deleted)
VALUES (2, '2 Project' , 'And that is the second', '2016-12-07 16:24:33' , 2, FALSE);

insert into PROJECT (id, name, description, creation_date, creator_id, deleted)
VALUES (3, '3 Project' , 'And that is the 3', '2016-12-07 16:24:33' , 2, FALSE);

insert INTO TASK (id, name, description, creation_date, modification_date,
                  project_id, status, creator_id, assignee_id, deleted)
VALUES (1, '1 Task' , 'First Task', '2016-12-07', '2016-12-07' , 1, 'TODO', 1, 1, FALSE);

insert INTO TASK (id, name, description, creation_date, modification_date,
                  project_id, status, creator_id, assignee_id, deleted)
VALUES (2, '2 Task' , 'Second Task', '2016-12-07', '2016-12-07' , 2, 'TODO', 1, 2, FALSE);

insert INTO TASK (id, name, description, creation_date, modification_date,
                  project_id, status, creator_id, assignee_id, deleted)
VALUES (3, '3 Task' , 'Third One', '2016-12-07', '2016-12-07' , 1, 'INPROGRESS', 1, 1, FALSE);

insert INTO SUB_TASK (id, name, description, creation_date, modification_date, creator_id, task_id, status, deleted)
VALUES (1, '1 SubTask' , 'First ST', '2016-12-07', '2016-12-07 16:24:33' , 2, 3, 'INPROGRESS', FALSE);

insert INTO SUB_TASK (id, name, description, creation_date, modification_date, creator_id, task_id, status, deleted)
VALUES (2, '2 SubTask' , 'Second ST', '2016-12-07', '2016-12-07 16:24:33' , 2, 3, 'INPROGRESS', FALSE);

INSERT INTO project_user (project_id, user_id) VALUES (1, 1);
INSERT INTO project_user (project_id, user_id) VALUES (2, 1);
INSERT INTO project_user (project_id, user_id) VALUES (2, 2);
INSERT INTO project_user (project_id, user_id) VALUES (3, 2);