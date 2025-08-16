USE [AcademyForHwSeven]
GO


--1. Вывести таблицу кафедр в обратном порядке.
SELECT * FROM Departments ORDER BY id DESC;
--2. Вывести названия групп и их рейтинги с уточнением имен полей именем таблицы.
SELECT name as [group name], year as [group year]  FROM Groups;
--3. Вывести для преподавателей их фамилию, процент ставки по отношению к надбавке и процент ставки по отношению к зарплате (сумма ставки и надбавки).
SELECT salary, Premium, salary/Premium*100, (Premium/(Premium+salary))*100  FROM Teachers;
--4. Вывести таблицу факультетов в следующем формате "The dean faculty [faculty] is [dean]"
SELECT  FORMATMESSAGE('The faculty name %s financing %s', name,  FORMAT(Financing, 'C', 'ru-RU')) FROM Departments;
--5. Вывестифамилии преподавателей, которые являются профессорами и ставка которых превышает 1050.
SELECT * FROM Teachers WHERE Salary > 1050;
-- SELECT * FROM Teachers WHERE Salary > 1050 AND isProfessor is true;
--6. Вывести названия кафедр, фонд финансирования которых меньше 11000 или больше 25000.
SELECT * FROM Departments d WHERE d.Financing < 11000 OR d.Financing > 25000;
--7. Вывестиназвания факультетов кромефакультета “Computer Science”.
SELECT * FROM Faculties f WHERE f.Name = 'Юридический факультет';
--8. Вывести фамилии и должности преподавателей, которые не являются профессорами.
SELECT name, Surname FROM Teachers WHERE isProfessor = 1;
--9. Вывести фамилии, должности, ставки и надбавки ассистентов, у которых надбавка в диапазоне от 160 до 550.
SELECT name, Surname, Salary FROM Teachers WHERE Salary BETWEEN 160 AND 550;
--10.Вывести фамилии и ставки ассистентов.
SELECT name, Surname, Salary FROM Teachers;
--11.Вывести фамилии и должности преподавателей, которые были приняты на работу до 01.01.2000.
--
--12.Вывести названия кафедр, которые в алфавитном порядке рвсполагадтся до кафедры "Кафедра химии" выводимое поле должно иметь название “Name of Department”.
SELECT * FROM Departments d WHERE name <= 'Кафедра химии' ORDER BY name;
--13.Вывести фамилии ассистентов, имеющих зарплату (сумма ставки и надбавки) не более 1200.
SELECT name, Surname, Salary FROM Teachers WHERE (Salary + Premium) > 1200;
--14.Вывести названия групп 5-го курса, имеющих рейтинг в диапазоне от 2 до 4
SELECT name FROM Groups WHERE year = 5 AND Rating BETWEEN 2 AND 4;
--15.Вывести фамилии ассистентов со ставкой меньше 550 или надбавкой меньше 200.
SELECT Surname FROM Teachers WHERE Salary < 550 OR Premium < 200;