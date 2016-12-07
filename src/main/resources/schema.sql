CREATE TABLE issueTracker.user
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nickname VARCHAR(35) NOT NULL,
    name VARCHAR(35) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    email VARCHAR(70) NOT NULL,
    password VARCHAR(100) NOT NULL
);
CREATE UNIQUE INDEX user_email_uindex ON issueTracker.user (email);
CREATE UNIQUE INDEX user_id_uindex ON issueTracker.user (id);
CREATE UNIQUE INDEX user_nickname_uindex ON issueTracker.user (nickname);

CREATE TABLE issueTracker.project
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(35) NOT NULL,
    description TEXT,
    creation_date TIMESTAMP NOT NULL,
    creator_id INT(11) NOT NULL,
    CONSTRAINT project_user_id_fk FOREIGN KEY (creator_id) REFERENCES user (id)
);
CREATE UNIQUE INDEX PROJECT_id_uindex ON issueTracker.project (id);
CREATE UNIQUE INDEX project_name_uindex ON issueTracker.project (name);
CREATE INDEX project_user_id_fk ON issueTracker.project (creator_id);

CREATE TABLE issueTracker.task
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(35) NOT NULL,
    description TEXT,
    creation_date TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
    modification_date TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
    project_id INT(11) NOT NULL,
    status VARCHAR(25) NOT NULL,
    creator_id INT(11) NOT NULL,
    assignee_id INT(11) NOT NULL,
    CONSTRAINT TASK_PROJECT_id_fk FOREIGN KEY (project_id) REFERENCES project (id),
    CONSTRAINT task_user_assignee_id_fk FOREIGN KEY (assignee_id) REFERENCES user (id),
    CONSTRAINT task_user_id_fk FOREIGN KEY (creator_id) REFERENCES user (id)
);
CREATE UNIQUE INDEX TASK_id_uindex ON issueTracker.task (id);
CREATE INDEX TASK_PROJECT_id_fk ON issueTracker.task (project_id);
CREATE INDEX task_user_assignee_id_fk ON issueTracker.task (assignee_id);
CREATE INDEX task_user_id_fk ON issueTracker.task (creator_id);

CREATE TABLE issueTracker.sub_task
(
    id INT(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(35) NOT NULL,
    description TEXT,
    creation_date TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
    modification_date TIMESTAMP DEFAULT 'CURRENT_TIMESTAMP' NOT NULL,
    task_id INT(11) NOT NULL,
    status VARCHAR(25) NOT NULL,
    CONSTRAINT subtask_task_id_fk FOREIGN KEY (task_id) REFERENCES task (id)
);
CREATE UNIQUE INDEX SUBTASK_id_uindex ON issueTracker.sub_task (id);
CREATE INDEX subtask_task_id_fk ON issueTracker.sub_task (task_id);

CREATE TABLE issueTracker.project_user
(
    project_id INT(11) NOT NULL,
    user_id INT(11) NOT NULL,
    CONSTRAINT `PRIMARY` PRIMARY KEY (project_id, user_id),
    CONSTRAINT fk_projectuser_project FOREIGN KEY (project_id) REFERENCES project (id),
    CONSTRAINT fk_projectuser_user FOREIGN KEY (user_id) REFERENCES user (id)
);
CREATE INDEX fk_projectuser_project ON issueTracker.project_user (project_id);
CREATE INDEX fk_projectuser_user ON issueTracker.project_user (user_id);

