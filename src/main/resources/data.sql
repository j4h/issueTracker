insert into USER
(id, nickname, name, surname, email, password)
values
  (1, "1", "Arnold", "Khovrashkov","j4@gmail.com" , "1");

insert into PROJECT
(ID, CREATOR_ID, NAME, DESCRIPTION, CREATION_DATE)
values
(1, 1, 'testProj', 'test Descriptiom', 1480085477);

insert into PROJECT_USER
(project_id, user_id)
values
  (1, 1);

insert into TASK
(id, project_id, creatorId, assignee_id, name, description, creation_date,
 modification_date, status)
values
  (1, 1, 1, 1, "test Task", "test Task", 1480085477, 1480085477, "TODO");

insert into SUB_TASK
(id, task_id, name, description, creation_date,
 modification_date, status)
values
  (1, 1, "tstSubTsk", "descSub", 1480085477, 1480085477, "TODO");