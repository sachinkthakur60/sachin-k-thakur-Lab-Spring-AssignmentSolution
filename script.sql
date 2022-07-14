insert into roles (name) values ('NORMAL_USER');
insert into roles (name) values ('ADMIN_USER');

insert into users (username, password) values (
'sachin', '$2a$12$vRl2/tMcwdmSvN5whfiWdelqFgwxBCMh5LB6zJ9jW/WDHuqbbXxt.');


insert into users (username, password) values (
'amar', '$2a$12$vRl2/tMcwdmSvN5whfiWdelqFgwxBCMh5LB6zJ9jW/WDHuqbbXxt.');

insert into users_roles (user_id, role_id) values (
(select user_id from users where username = 'sachin'),
(select role_id from roles where name = 'ADMIN_USER')
);


insert into users_roles (user_id, role_id) values (
(select user_id from users where username = 'amar'),
(select role_id from roles where name = 'NORMAL_USER')
);


#Password Mapping

#"javafsd" -> $2a$12$vRl2/tMcwdmSvN5whfiWdelqFgwxBCMh5LB6zJ9jW/WDHuqbbXxt.
