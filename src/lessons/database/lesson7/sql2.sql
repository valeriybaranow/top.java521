CREATE DATABASE Students5
GO
USE Students5
CREATE TABLE Student(ID int PRIMARY KEY IDENTITY(1,1) NOT NULL,
FirstName nchar(15), LastName nchar(15),
BirthDate date,	Grants int, Email nchar(25),GroupId int)
INSERT INTO Student VALUES ('Jack', 'Jones','1997-11-05',1256,'jj@net.eu',1)
INSERT INTO Student VALUES ('Harry','Miller','1998-02-11',1100,'hm@net.eu',1)
INSERT INTO Student VALUES ('Grace', 'Evans', '1997-06-24', NULL, 'eg@net.eu', 2)
INSERT INTO Student VALUES ('Lily', 'Wilson', '1998-09-12', NULL, 'lw@net.eu', 2)
INSERT INTO Student VALUES ('Joshua', 'Jonson', '1997-05-23', 1100.00, 'jo@net.eu', 3)
INSERT INTO Student VALUES ('Emily', 'Taylor', '19971227', 1100, 'et@net.eu', 4)
INSERT INTO Student VALUES ('Charlie', 'Tomas', '19980131', 1256, 'ct@net.eu', 4)
INSERT INTO Student VALUES ('Oliver', 'Moore', '1997-07-05', NULL, 'om@net.eu', 4)
INSERT INTO Student VALUES ('Jessica', 'Brown', '1997-07-17', 1100.00, 'jb@net.eu', 5)

CREATE TABLE GroupID (ID int PRIMARY KEY IDENTITY(1,1) NOT NULL, NameGroup char(10))
INSERT INTO GroupID VALUES ('31PPS11')
INSERT INTO GroupID VALUES ('32PR31')
INSERT INTO GroupID VALUES ('30PR11')
INSERT INTO GroupID VALUES ('29PR21')
INSERT INTO GroupID VALUES ('32PPS11')

CREATE TABLE Achievements (ID int PRIMARY KEY IDENTITY(1,1) NOT NULL, Graid int)
INSERT INTO Achievements VALUES (12)
INSERT INTO Achievements VALUES (11)
INSERT INTO Achievements VALUES (10)
INSERT INTO Achievements VALUES (9)
INSERT INTO Achievements VALUES (8)



INSERT INTO GroupID VALUES ('NewGroup');

INSERT INTO Student VALUES ('New', 'Man', '1997-07-17', 1100.00, 'jb@net.eu', Null)

----------------------------------
--запросы

--SELECT * FROM Student, GroupID where Student.GroupId = GroupId.ID;
--SELECT * FROM GroupID;

--SELECT * From Student
--Inner JOIN GroupID
--ON Student.GroupId = GroupId.ID;


--SELECT * From Student
--LEFT JOIN GroupID
--ON Student.GroupId = GroupId.ID;

--SELECT * From Student
--RIGHT JOIN GroupID
--ON Student.GroupId = GroupId.ID;

--SELECT * From Student
--FULL JOIN GroupID
--ON Student.GroupId = GroupId.ID;

----------------------
--практика
-- Создайте таблицы StudentIt и StudentDesigner
-- поля одинаковые id, name, position
-- заполните таблицы данными, уникальными и дублирующимися

-- Объедините с помощью UNION/UNION ALL
-- найдите студентов, которые есть только в обоих списках (INTERSECT вместо UNION)
-- найдите студентов, которые есть только в StudentIt и нет в StudentDez (EXCEPT вместо UNION)
-------------------------------

USE [Students5]
GO

/****** Object:  Table [dbo].[StudentIt]    Script Date: 09.08.2025 11:44:14 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[StudentDez](
	[id] [int] NOT NULL,
	[name] [nchar](100) NOT NULL,
	[surname] [nchar](100) NOT NULL,
	[position] [int] NOT NULL,
 CONSTRAINT [PK_StudentDez] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO


INSERT INTO StudentDez VALUES (1, 'NameDez1', 'SurnameDez1', 5);
INSERT INTO StudentDez VALUES (2, 'NameDez2', 'SurnameDez2', 4);
INSERT INTO StudentDez VALUES (3, 'NameDez3', 'SurnameDez3', 5);
INSERT INTO StudentDez VALUES (4,'NameDez', 'SurnameDez4', 2);
INSERT INTO StudentDez VALUES (5, 'NameDez5', 'SurnameDez5', 1);
INSERT INTO StudentDez VALUES (6, 'NameDez6', 'SurnameDez6', 3);

INSERT INTO StudentIt VALUES (1, 'NameIt1', 'Surname1', 5);
INSERT INTO StudentIt VALUES (2,  'NameIt2', 'Surname2', 4);
INSERT INTO StudentIt VALUES (3, 'NameIt3', 'Surname3', 5);
INSERT INTO StudentIt VALUES (4,'NameIt4', 'Surname4', 2);
INSERT INTO StudentIt VALUES (5, 'NameIt5', 'Surname5', 1);
INSERT INTO StudentIt VALUES (6, 'NameIt6', 'Surname6', 3);