use studydb;

-- Database setup --
---------

create database studydb;

use studydb;


--------------
-- TABLES DDLS--
--------------

-- target table employee--

drop table `employee`;

create table `employee`(
  `id` int not null auto_increment,
  `first_name` varchar(45) null,
  `last_name` varchar(45) null,
  `email` varchar(45) null,
primary key (`id`)
)ENGINE=InnoDB auto_increment=1 charset=latin1;

-- target table USERS

drop table `users`;

CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(80) NOT NULL,
  `enabled` tinyint NOT NULL,
PRIMARY KEY (`username`)
)ENGINE = InnoDB DEFAULT CHARSET=latin1;

drop table `authorities`;

-- target table authorities--

CREATE TABLE `authorities`(
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `authorities_idx_1` (`username`, `authority`),
CONSTRAINT `authorities_ibfk_1`
FOREIGN KEY (`username`)
REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-------------
--Mock Data--
------------

INSERT INTO `users`
VALUES
('John', '{bcrypt}$2a$10$T.X38dhW7X9bQljqJPkcXuW39NxNZLYDugL44R1q7nSAMWJNpBpIy', 1),
('Mary', '{bcrypt}$2a$10$Hbnu1jYtJa9z1Bt3lPzeCO0BmKII3p.EIHBIJ0iUzx72jHMDTp1Qe', 1),
('Susan', '{bcrypt}$2a$10$NNtpOB0VmE225hP8C4fK5OEMgtsT2mHz6gnqEjwxjHvD6yQ9kggF2', 1);



INSERT INTO `authorities`
VALUES
('John', 'ROLE_EMPLOYEE'),
('Mary', 'ROLE_EMPLOYEE'),
('Mary', 'ROLE_MANAGER'),
('Susan', 'ROLE_EMPLOYEE'),
('Susan', 'ROLE_MANAGER'),
('Susan', 'ROLE_ADMIN');

INSERT INTO `employee` values
(1, "Dana", "Scully","dana@mail.com"),
(2, "Tim", "Smith", "tim@mail.com"),
(3, "Doug", "Thomas", "tomtom@mail.com");