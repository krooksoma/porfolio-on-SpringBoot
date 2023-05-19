-- Database setup --
---------

create database studydb;

use studydb;


--------------
--TABLES DDLS--
--------------

--target table employee--

create table `employee`(
`id` int not null auto_increment,
`first_name` varchar(45) null,
`last_name` varchar(45) null,
`email` varchar(45) null,
primary key (`id`)
)ENGINE=InnoDB auto_increment=1 charset=latin1;

--target table USERS--

CREATE TABLE `users` (
`username` varchar(50) NOT NULL,
`password` varchar(50) NOT NULL,
`enabled` tinyint NOT NULL,
PRIMARY KEY (`username`)
)ENGINE = InnoDB DEFAULT CHARSET=latin1;

--target table authorities--

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
		('John', '{noop}john123', 1),
        ('Mary', '{noop}mary123', 1),
        ('Susan', '{noop}susan123', 1);



INSERT INTO `authorities`
	VALUES
		('John', 'EMPL_ROLE'),
        ('Mary', 'EMPL_ROLE'),
        ('Mary', 'MNGR_ROLE'),
        ('Susan', 'EMPL_ROLE'),
        ('Susan', 'MNGR_ROLE'),
        ('Susan', 'ADMN_ROLE');

INSERT INTO `employee` values
     (1, "Dana", "Scully","dana@mail.com"),
     (2, "Tim", "Smith", "tim@mail.com"),
     (3, "Doug", "Thomas", "tomtom@mail.com");