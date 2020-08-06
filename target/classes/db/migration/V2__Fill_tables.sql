/* Заполнение таблицы ролей */
insert into roles(id, name)
values (1, 'ADMIN'),
       (2, 'USER');

insert into users(id, username, password, role_id)
values (1, '180107250', 'isaisa01', 1),
       (2, '180107252', 'leha99', 1),
       (3, '180107145', 'arsic00', 2);

insert into faculties(id, name)
values (1, 'IT'),
       (2, 'LOWER'),
       (3, 'MATH');

insert into students(id, username, first_name, last_name, birth_date, ent_ball, email, faculty_id)
values (1, '180107250', 'Islambek', 'Togizbayev', '2001-03-09', 105, '180107250@stu.sdu.edu.kz', 1),
       (2, '180107252', 'Kussain', 'Khassen', '2001-08-30', 115, '180107252@stu.sdu.edu.kz', 2),
       (3, '180107180', 'Alisher', 'Nazaraly', '2001-07-21', 90, '180107180@stu.sdu.edu.kz', 1),
       (4, '180107145', 'Arsentyi', 'Zhunussov', '2001-04-10', 95, '180107145@stu.sdu.edu.kz', 3),
       (5, '180107402', 'Zhannat', 'Shakimov', '2001-05-14', 120, '180107402@stu.sdu.edu.kz', 2);