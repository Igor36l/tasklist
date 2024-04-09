insert into users (firstname, username, password)
values ('Jhon', 'Jhon@mail.com', '12345'),
       ('Mike', 'Mike@mail.com', '6789');

insert into tasks (title, description, status, expiration_date)
values ('Buy cheese', null, 'TODO', '2023-01-29 12:00'),
       ('Do homework', 'Math', 'IN_PROGRESS', '2023-01-31 12:00'),
       ('Call Mike', 'Ask about setting', 'TODO', '2023-02-26 15:00');

insert into users_tasks(task_id, user_id)
values (1, 2),
       (2, 2),
       (3, 1);
insert into users_roles(user_id, role)
values (1, 'ROLE_ADMIN'),
       (1, 'ROLE_USER'),
       (2, 'ROLE_USER');