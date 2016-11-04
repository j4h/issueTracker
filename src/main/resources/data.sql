INSERT INTO REST."PUBLIC".project (name, description) VALUES ('testProject', 'test description');
INSERT INTO rest.project (name, description) VALUES ('projectTest', 'description test');

INSERT INTO rest.task (name, description, project_id) VALUES ('testTask', 'description testTask', 1);
INSERT INTO rest.task (name, project_id) VALUES ('testTask', 1);

INSERT INTO rest.task (name, project_id) VALUES ('testTask', 2);

INSERT INTO rest.sub_task(name, task_id) VALUES ('testSubTask',2)