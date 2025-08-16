USE [Hospital]
GO

--1) Вывести информацию обо всех пациентах, находящихся в больнице;
SELECT * FROM Patients;
--2) Показать данные о пациентах, которые лежат в определенном отделении;
SELECT * FROM Patients WHERE Department = 'Pediatrics';
--3) Получить данные о пациентах, которые лежат в больнице больше месяца, отсортировав
--их по возрастанию даты поступления;
SELECT * FROM Patients WHERE  DATEDIFF(month, StartDate, GETDATE()) >= 1;
--4) Вывести информацию о пациентах, которые были выписаны в прошлом месяце (вам
--поможет стандартная функция GETDATE() языка T-SQL, которая позволяет получить
--текущую дату);
SELECT * FROM Patients WHERE  DATEDIFF(month, EndDate, GETDATE()) < 1;
--5) Показать информацию о пациентах, которые лежали в больнице с октября по декабрь
--прошлого года в определенном отделении;
SELECT * FROM Patients WHERE StartDate >= '2024-10-01' AND EndDate <= '2024-12-31';
--6) Вывести информацию о самом молодом пациенте и его возраст (для написания этого
--запроса вам следует самостоятельно изучить стандартную функцию DATEDIFF(),
--информацию о которой вы можете получить по следующей ссылке
--https://docs.microsoft.com/en-us/sql/t-sql/functions/datediff-transact-sql);
SELECT MAX(BirthDate) maxBirthDate, DATEDIFF ( year ,  MAX(BirthDate) , GETDATE() ) age FROM Patients;
--7) Показать всех пациентов, фамилия которых начинается на букву Р;
SELECT * FROM Patients WHERE Surname LIKE 'S%';
--8) Вывести данные о пациентах, которых лечит определенный врач с одинаковыми
--заболеваниями;
SELECT * FROM Patients WHERE Doctor = 'Dr. Lee';
--9) Удалить всех пациентов, которые были выписаны больше чем полгода назад
DELETE FROM Patients WHERE DATEDIFF(month, EndDate, GETDATE()) > 6;