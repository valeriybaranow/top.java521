-- Создаем базу данных Academy11 (если еще не создана)

USE Academy11;
GO

-- Очистка таблиц (если нужно перезаполнить)
DELETE
FROM TeacherDeletedInfos;
DELETE
FROM TeacherAddedInfos;
DELETE
FROM TeacherManipulations;
DELETE
FROM Teachers;
DELETE
FROM Actions;
DELETE
FROM Faculties;

-- Заполнение таблицы Faculties
INSERT INTO Faculties ([Name], [Financing])
VALUES ('Факультет компьютерных наук', 15000000.00),
       ('Инженерный факультет', 12000000.00),
       ('Экономический факультет', 10000000.00),
       ('Факультет иностранных языков', 8500000.00),
       ('Юридический факультет', 9500000.00),
       ('Медицинский факультет', 18000000.00),
       ('Факультет искусств', 7500000.00),
       ('Факультет естественных наук', 11000000.00),
       ('Филологический факультет', 8000000.00),
       ('Факультет психологии', 9000000.00)
GO

-- Заполнение таблицы Actions
INSERT INTO Actions (Name)
VALUES ('Добавление преподавателя'),
       ('Удаление преподавателя'),
       ('Изменение данных преподавателя'),
       ('Повышение ставки'),
       ('Понижение ставки');

-- Заполнение таблицы Teachers
INSERT INTO Teachers (EmploymentDate, Name, Salary, Surname)
VALUES ('2015-03-15', 'Иван', 25000.00, 'Петров'),
       ('2018-09-01', 'Мария', 28000.00, 'Иванова'),
       ('2020-01-10', 'Алексей', 22000.00, 'Сидоров'),
       ('2019-06-20', 'Елена', 30000.00, 'Кузнецова'),
       ('2017-11-05', 'Дмитрий', 27000.00, 'Смирнов');

--- Временно отключаем проверку даты в TeacherManipulations
DECLARE @constraint_name NVARCHAR(255);
SELECT @constraint_name = name
FROM sys.check_constraints
WHERE OBJECT_NAME(parent_object_id) = 'TeacherManipulations'
  AND definition LIKE '%Date%';

IF @constraint_name IS NOT NULL
    BEGIN
        EXEC ('ALTER TABLE TeacherManipulations NOCHECK CONSTRAINT ' + @constraint_name);
    END
GO

-- Вставляем данные с датами 2023 года
INSERT INTO TeacherManipulations (Date, ActionId, TeacherId)
VALUES ('2023-01-15 10:30:00', 1, 1),
       ('2023-02-20 14:45:00', 1, 2),
       ('2023-03-10 09:15:00', 1, 3),
       ('2023-04-05 16:20:00', 1, 4),
       ('2023-05-12 11:00:00', 1, 5),
       ('2023-06-18 13:30:00', 3, 1),
       ('2023-07-22 15:45:00', 4, 2),
       ('2023-08-30 10:10:00', 3, 3),
       ('2023-09-14 14:20:00', 5, 4),
       ('2023-10-25 09:45:00', 4, 5);
GO

-- Включаем проверку обратно
DECLARE @constraint_name NVARCHAR(255);
SELECT @constraint_name = name
FROM sys.check_constraints
WHERE OBJECT_NAME(parent_object_id) = 'TeacherManipulations'
  AND definition LIKE '%Date%';

IF @constraint_name IS NOT NULL
    BEGIN
        EXEC ('ALTER TABLE TeacherManipulations CHECK CONSTRAINT ' + @constraint_name);
    END
GO

-- Заполняем TeacherAddedInfos
INSERT INTO TeacherAddedInfos (EmploymentDate, Name, Salary, Surname, ManipulationId)
VALUES ('2015-03-15', 'Иван', 25000.00, 'Петров', 1),
       ('2018-09-01', 'Мария', 28000.00, 'Иванова', 2),
       ('2020-01-10', 'Алексей', 22000.00, 'Сидоров', 3),
       ('2019-06-20', 'Елена', 30000.00, 'Кузнецова', 4),
       ('2017-11-05', 'Дмитрий', 27000.00, 'Смирнов', 5);
GO

-- Заполняем TeacherDeletedInfos
INSERT INTO TeacherDeletedInfos (EmploymentDate, Name, Salary, Surname, ManipulationId)
VALUES ('2015-03-15', 'Иван', 25000.00, 'Петров', 6),
       ('2018-09-01', 'Мария', 28000.00, 'Иванова', 7),
       ('2020-01-10', 'Алексей', 22000.00, 'Сидоров', 8),
       ('2019-06-20', 'Елена', 30000.00, 'Кузнецова', 9),
       ('2017-11-05', 'Дмитрий', 27000.00, 'Смирнов', 10);
GO