USE [AcademyForHwSeven]
GO

--1. Вывести названия аудиторий, в которых читает лекции преподаватель “Edward Hopper”.
SELECT
	DISTINCT
	l.LectureRoom
FROM Teachers t
JOIN Lectures l ON t.id = l.TeacherId
WHERE t.Name = 'Иван' AND t.Surname = 'Иванов'
--2. Вывести фамилии ассистентов, читающих лекции в группе “F505”.
SELECT
	t.Name,
	g.Name
FROM Assistants a
JOIN Teachers t ON t.id = a.id
JOIN Lectures l ON t.id = l.TeacherId
JOIN GroupsLectures gl ON gl.LectureId = l.id
JOIN Groups g ON g.id = gl.GroupId
WHERE g.Name = 'B201'
--3. Вывести дисциплины, которые читает преподаватель “Alex Carmack” для групп 5-го курса.
SELECT
	s.Name subject,
	g.Name group1
FROM Teachers t
JOIN Lectures l ON t.id = l.TeacherId
JOIN Subjects s ON s.id = l.SubjectId
JOIN GroupsLectures gl ON gl.LectureId = l.id
JOIN Groups g ON g.id = gl.GroupId
WHERE g.Year = 5 AND t.name = 'Светлана' AND t.surname = 'Козлова';
--4. Вывести фамилии преподавателей, которые не читают лекции по понедельникам.
SELECT
	DISTINCT
	concat(t.Surname, ' ', t.Name) teacher
FROM Teachers t
JOIN Lectures l ON t.id = l.TeacherId
WHERE l.DayOfWeek <> 1
--5. Вывести названия аудиторий, с указанием их корпусов, в которых нет лекций в среду второй недели на третьей паре.
SELECT
	DISTINCT
	l.LectureRoom,
	lr.Building,
	s.DayOfWeek,
	s.Week,
	s.Class
FROM  LectureRooms lr
JOIN Lectures l ON l.LectureRoom = lr.name
JOIN Schedules s ON s.LectureId = l.id
WHERE NOT (s.DayOfWeek = 3 AND s.Week = 2 AND s.Class = 2)
ORDER BY s.DayOfWeek;
--6. Вывест полные имена преподавателей факультета “Computer Development”.
SELECT
	DISTINCT
	concat((t.name), ' ', (t.Surname)) teacher_fio,
	(f.name) fuculties_name
FROM Teachers t
LEFT JOIN Lectures l ON l.TeacherId = t.id
LEFT JOIN GroupsLectures gl ON gl.LectureId = l.id
LEFT JOIN Groups g ON g.id = gl.GroupId
LEFT JOIN Departments d ON d.id = g.DepartmentId
LEFT JOIN Faculties f ON f.id = d.FacultyId
WHERE f.Name = 'Инженерный факультет'
ORDER BY concat((t.name), ' ', (t.Surname)), (f.name)
--7. Вывести список номеров всех корпусов, которые имеются в таблицах факультетов, кафедр и аудиторий.
SELECT f.Name, building FROM Faculties f
UNION ALL
SELECT d.Name, building FROM Departments d
UNION ALL
SELECT  FORMATMESSAGE('Аудитория %s', lr.Name), building FROM LectureRooms lr
--8. Вывести полные имена преподавателей в следующем порядке: деканы факультетов, заведующие кафедрами, преподаватели, кураторы, ассистенты.
-- этот запрос в теории должен работать но не проверил т. к. не завел таблицы Heads и Curators
--SELECT concat(Name, ' ', Surname)
--FROM Deans d
--JOIN Teachers t ON t.id = d.id
--UNION ALL
--SELECT concat(Name, ' ', Surname) FROM Teachers d
--UNION ALL
--SELECT concat(Name, ' ', Surname) FROM Curators c
--JOIN Teachers t ON t.id = c.id
--UNION ALL
--SELECT concat(Name, ' ', Surname) FROM Heads h
--JOIN Teachers t ON t.id = h.id
--9. Вывести дни недели (без повторений), в которые имеются занятия в аудиториях “A311” и “A104” корпуса 6.
SELECT
	DISTINCT
	s.DayOfWeek,
	lr.Name,
	lr.Building
FROM  LectureRooms lr
JOIN Lectures l ON l.LectureRoom = lr.name
JOIN Schedules s ON s.LectureId = l.id
WHERE lr.Name IN ('A101', 'A102') AND lr.Building = 1
ORDER BY s.DayOfWeek;
--