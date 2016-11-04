CREATE TABLE rest.project
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(35) NOT NULL,
    description TEXT,
    creation_date TIMESTAMP NOT NULL
);
CREATE UNIQUE INDEX PROJECT_id_uindex ON rest.project (id);

CREATE TABLE rest.task
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(35) NOT NULL,
    description TEXT,
    creation_date TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
    modification_date TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
    project_id INT(11) NOT NULL,
    CONSTRAINT TASK_PROJECT_id_fk FOREIGN KEY (project_id) REFERENCES project (id)
);
CREATE UNIQUE INDEX TASK_id_uindex ON rest.task (id);
CREATE INDEX TASK_PROJECT_id_fk ON rest.task (project_id);

CREATE TABLE rest.sub_task
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(35) NOT NULL,
    description TEXT,
    creation_date TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
    modification_date TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
    task_id INT(11) NOT NULL,
    CONSTRAINT subtask_task_id_fk FOREIGN KEY (task_id) REFERENCES task (id)
);
CREATE UNIQUE INDEX SUBTASK_id_uindex ON rest.sub_task (id);
CREATE INDEX subtask_task_id_fk ON rest.sub_task (task_id);