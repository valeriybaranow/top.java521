USE [AcademyForHwSeven]
GO
--=======================================
--1. Вывестивсе возможные пары строк преподавателей и групп
--=======================================
--SELECT
--	DISTINCT
--	concat(t.name, ' ', t.Surname),
--	g.name
--FROM Teachers t
--JOIN Lectures l ON l.TeacherId = t.id
--JOIN GroupsLectures gl ON gl.LectureId = l.id
--JOIN Groups g ON g.id = gl.GroupId
--ORDER BY concat(t.name, ' ', t.Surname), g.name
--=======================================
--=======================================
--2. Вывести названия факультетов, фонд финансирования кафедр которых превышает фонд финансирования факультета
--=======================================
--SELECT
--	max(f.id),
--	max(f.Name),
--	max(f.Financing) Faculty_financing,
--	sum(d.Financing) Department_financing
--FROM
--	Faculties f
--JOIN Departments d ON d.FacultyId = f.id
--GROUP BY f.id
--having sum(f.Financing) > sum(d.Financing)
--=======================================
--=======================================
-- 3. Вывести фамилии кураторов групп и названия групп, которые они курируют
--=======================================
--SELECT c.Surname cur_surname, g.Name group_name
--FROM Curators c
--JOIN GroupsCurators gc ON c.id = gc.CuratorId
--JOIN Groups g ON g.id = gc.CuratorId
--=======================================
--=======================================
--4. Вывести имена и фамилии преподавателей, которые читают лекции у группы “P107”.
--=======================================
--SELECT
--	DISTINCT
--	concat((t.name), ' ', (t.Surname)) teacher_fio,
--	(g.name) group_name
--FROM Teachers t
--JOIN Lectures l ON l.TeacherId = t.id
--JOIN GroupsLectures gl ON gl.LectureId = l.id
--JOIN Groups g ON g.id = gl.GroupId
--WHERE g.Name = 'AC-401'
--ORDER BY concat((t.name), ' ', (t.Surname)), (g.name)
--=======================================
--=======================================
--5. Вывести фамилии преподавателей и названия факультетов на которых они читают лекции.
--=======================================
--SELECT
--	DISTINCT
--	concat((t.name), ' ', (t.Surname)) teacher_fio,
--	(f.name) fuculties_name
--FROM Teachers t
--LEFT JOIN Lectures l ON l.TeacherId = t.id
--LEFT JOIN GroupsLectures gl ON gl.LectureId = l.id
--LEFT JOIN Groups g ON g.id = gl.GroupId
--LEFT JOIN Departments d ON d.id = g.DepartmentId
--LEFT JOIN Faculties f ON f.id = d.FacultyId
--ORDER BY concat((t.name), ' ', (t.Surname)), (f.name)
--=======================================
--6. Вывести названия кафедр и названия групп, которые к ним относятся.
--=======================================
--SELECT
--	DISTINCT
--	d.name AS department_name,
--	g.name group_name
--FROM Departments d
--LEFT JOIN Groups g ON g.DepartmentId = d.id
--ORDER BY d.name, g.name
--=======================================
--=======================================
--7. Вывести названия дисциплин, которые читает преподаватель “Samantha Adams”.
--=======================================
--SELECT
--	DISTINCT
--	concat(t.name, ' ', t.Surname),
--	s.name
--FROM Teachers t
--JOIN Lectures l ON l.TeacherId = t.id
--JOIN Subjects s ON s.Id = l.SubjectId
--WHERE t.name = 'Иван' AND t.Surname = 'Иванов'
--ORDER BY concat(t.name, ' ', t.Surname), s.name
--=======================================
--8. Вывести названия кафедр, на которых читается дисциплина
--=======================================
--SELECT
--	DISTINCT
--	s.name,
--	d.Name
--FROM Subjects s
-- JOIN Lectures l ON l.SubjectId = s.id
-- JOIN GroupsLectures gl ON gl.LectureId = l.id
-- JOIN Groups g ON g.id = gl.GroupId
-- JOIN Departments d ON d.id = g.DepartmentId
--ORDER BY s.name, d.Name
--=======================================
--=======================================
--9. Вывести названия групп, которые относятся к факультету “Computer Science”.
--=======================================
--SELECT
--	DISTINCT
--	f.name faculty_name,
--	d.Name department_name
--FROM
--	Faculties f
--RIGHT JOIN Departments d ON d.FacultyId = f.id
--RIGHT JOIN Groups g ON g.DepartmentId = d.id
--WHERE f.Name = 'Инженерный факультет'
--=======================================
--=======================================
--10. Вывести названия групп 5-го курса, а также название факультетов, к которым они относятся.
--=======================================
--SELECT
--	DISTINCT
--	g.name,
--	g.year,
--	f.Name
--FROM
--	Faculties f
--RIGHT JOIN Departments d ON d.FacultyId = f.id
--RIGHT JOIN Groups g ON g.DepartmentId = d.id
--WHERE g.Year = 5
--=======================================

--=======================================
--11. Вывести полные имена преподавателей и лекции, которые  они читают (названия дисциплин и групп),причем отобрать  только те лекции, которые читаются в аудитории “B103”.
--=======================================
SELECT
	DISTINCT
	concat(t.name, ' ', t.Surname) TeachetFio,
	s.name SubjectName,
	l.LectureRoom,
	g.Name GroupName
FROM Teachers t
 JOIN Lectures l ON l.TeacherId = t.id
 JOIN Subjects s ON s.Id = l.SubjectId
 JOIN GroupsLectures gl ON gl.GroupId = l.SubjectId
 JOIN Groups g ON g.id = gl.GroupId
WHERE l.LectureRoom = 'A101'
ORDER BY
	concat(t.name, ' ', t.Surname),
	s.name,
	g.Name
--=======================================
