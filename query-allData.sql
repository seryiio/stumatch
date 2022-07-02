INSERT INTO careers(career_id,name)VALUES
('CUISI','Ingenieria de Sistemas de Informacion'),
('CUISW','Ingenieria de Software');

INSERT INTO students(student_id,last_name, first_name, age, credit_amount, cycle, dni, phone_number, email_university, email_personal, career_id)VALUES
('201910528','Gonzales Gutierrez', 'Junior', 21,21,7, 74354673, 981245752, 'U201910528@stumatch.edu.pe', 'junior@gmail.com', 'CUISI'),
('202210232','Perez Gonzales', 'Alvaro', 19,21,6, 74354672, 981245751, 'U202210232@stumatch.edu.pe', 'alvaro@gmail.com', 'CUISW');

INSERT INTO teachers(teacher_id,last_name, first_name, age, dni, phone_number, email_university, career_id)VALUES
('puingbpl','Bravo Peña', 'Luis', 35, 72354186, 925914832, 'puingbpl@stumatch.edu.pe', 'CUISI'),
('puingsgm','Subauste Gomez', 'Maria', 31, 72354182, 925914841, 'puingsgm@stumatch.edu.pe', 'CUISI'),
('puinganp','Alarcon Navarro', 'Pedro', 38, 72354153, 925914812, 'puinganp@stumatch.edu.pe', 'CUISI'),
('puingpgc','Perez Gonzalez', 'Carlos', 41, 72354189, 925914831, 'puingpgc@stumatch.edu.pe', 'CUISI'),
('puingorm','Orellana Rodriguez', 'Miguel', 50, 72354187, 925914833, 'puingorm@stumatch.edu.pe', 'CUISW'),
('puinglaj','Lopez Aliaga', 'Joaquin', 40, 72354120, 925914821, 'puinglaj@stumatch.edu.pe', 'CUISW'),
('puingzmg','Zapata Moreno', 'Guillermo', 50, 72354144, 925914805, 'puingzmg@stumatch.edu.pe', 'CUISW'),
('puingcvw','Chavez Ventocilla', 'Walter', 46, 72354264, 925914233, 'puingcvw@stumatch.edu.pe', 'CUISW');

INSERT INTO courses(course_id,name, number_cycle, number_credits,career_id)VALUES
('CISIADAE','Análisis y Diseño de Arquitectura Empresarial ', 06,05,'CUISI'),
('CISIDA','Digital Analytics', 06,04,'CUISI'),
('CISIEAI','Estadística Aplicada I', 06,04,'CUISI'),
('CISIFIE','Finanzas e Ingeniería Económica', 06,04,'CUISI'),
('CISISMC','Soluciones Móviles y Cloud', 07,04,'CUISI'),
('CISIENSF','Emprendimiento de Negocios Sostenibles: Formulación', 07,03,'CUISI'),
('CISIFSA','Fundamentos en Seguridad y Auditoría', 07,04,'CUISI'),
('CISIDESI','Diseño de Experimentos en SI', 07,04,'CUISI'),
('CISWPW','Programacion en Web', 06,04,'CUISW'),
('CISWCA','Complejidad Algoritmica', 06,04,'CUISW'),
('CISWES','Evolucion de Software', 06,03,'CUISW'),
('CISWRD','Redes y Comunicacion de Datos', 06,04,'CUISW'),
('CISWDM','Aplicaciones para Dispositivos Móviles', 07,03,'CUISW'),
('CISWDE','Diseño de Experimentos de ISW', 07,04,'CUISW'),
('CISWFAS','Fundamentos de Arquitectura de Software', 07,05,'CUISW'),
('CISWIA','Inteligencia Artificial ', 07,05,'CUISW'),
('CISWPD','Programación Concurrente y Distribuida', 07,04,'CUISW');

INSERT INTO sections(section_id, days, vacancies, course_id, start_time, end_time, teacher_id)VALUES
('AD61', 'Martes',10, 'CISIADAE','09:00','12:00','puingbpl'),
('AD62', 'Miercoles',10, 'CISIADAE','15:00','17:00','puingpgc'),
('AD63', 'Viernes',10, 'CISIADAE','17:00','19:00','puingbpl'),
('AD64', 'Martes',10, 'CISIADAE','10:00','13:00','puingpgc'),
('DA61', 'Viernes',10, 'CISIDA','17:00','20:00','puingsgm'),
('DA62', 'Lunes',10, 'CISIDA','09:00','13:00','puingpgc'),
('EA61', 'Lunes',10, 'CISIEAI','13:00','15:00','puingbpl'),
('EA62', 'Viernes',10, 'CISIEAI','17:00','19:00','puingpgc'),
('FI61', 'Martes',10, 'CISIFIE','13:00','15:00','puingsgm'),
('FI62', 'Lunes',10, 'CISIFIE','13:00','15:00','puingbpl'),
('MC61', 'Sabado',10, 'CISISMC','09:00','13:00','puingpgc'),
('MC62', 'Lunes',10, 'CISISMC','13:00','15:00','puingbpl'),
('EN61', 'Lunes',10, 'CISIENSF','13:00','15:00','puingbpl'),
('EN62', 'Miercoles',10, 'CISIENSF','13:00','15:00','puingsgm'),
('FS61', 'Lunes',10, 'CISIFSA','13:00','15:00','puinganp'),
('FS62', 'Miercoles',10, 'CISIFSA','07:00','09:00','puinganp'),
('XI61', 'Jueves',10, 'CISIDESI','15:00','18:00','puingsgm'),
('XI62', 'Miercoles',10, 'CISIDESI','15:00','18:00','puingbpl'),
('PW61', 'Lunes',10, 'CISWPW','13:00','15:00','puingcvw'),
('CA61', 'Martes',10, 'CISWCA','09:00','13:00','puingzmg'),
('WE61', 'Sabado',10, 'CISWES','13:00','15:00','puinglaj'),
('WR61', 'Jueves',10, 'CISWRD','15:00','17:00','puingorm'),
('DM61', 'Viernes',10, 'CISWDM','17:00','19:00','puingzmg'),
('DE61', 'Martes',10, 'CISWDE','07:00','10:00','puingcvw'),
('FAS62', 'Miercoles',10, 'CISWFAS','07:00','09:00','puingzmg'),
('IA61', 'Lunes',10, 'CISWIA','15:00','18:00','puinglaj'),
('PD61', 'Jueves',10, 'CISWPD','17:00','19:00','puingorm');

INSERT INTO users(id, enable, id_segment, password, segment, username)VALUES
(1,true,1,'$2a$10$RcUxMPPGUP7W0OnNvmZxxeoPUtH/0m8mCj7T63nc6YgVfNixLgj5C',1,'admin'),
(2,true,201910528,'$2a$10$RcUxMPPGUP7W0OnNvmZxxeoPUtH/0m8mCj7T63nc6YgVfNixLgj5C',0,'u201910528'),
(3,true,202210232,'$2a$10$RcUxMPPGUP7W0OnNvmZxxeoPUtH/0m8mCj7T63nc6YgVfNixLgj5C',0,'u202210232');

INSERT INTO authorities(id, auth, user_id)VALUES
(1,'ROLE_ADMINISTRATOR',1),
(2,'ROLE_STUDENT',2),
(3,'ROLE_STUDENT',3);