--SELECT Surname, D.Name
--FROM Departments AS D, Teachers AS T
--WHERE T.DepartmentId = D.Id;

--SELECT Surname, S.Name AS SubjectName
--FROM Teachers AS T, Subjects AS S, TeachersSubjects AS TS
--WHERE T.Id = TS.TeacherId AND S.Id = TS.SubjectId;

--SELECT D.Name AS DepName, S.Name AS SubjectName
--FROM Departments AS D, Teachers AS T, Subjects AS S, TeachersSubjects AS TS
--WHERE D.Id = T.DepartmentId AND T.Id = TS.TeacherId AND S.Id = TS.SubjectId;

--SELECT COUNT(DISTINCT Grants) AS [Number of records]
--FROM Students;

--SELECT AVG(Grants) AS [Average grant]
--FROM Students;

--SELECT AVG(DATEDIFF(dd, BirthDate, GETDATE())/365.25) AS [Average age]
--FROM Students;

--SELECT SUM(Grants) AS [Sum grants]
--FROM Students;

--SELECT MIN(BirthDate) AS [Min date]
--FROM Students;

--SELECT MAX(LastName) AS [Maximum last name]
--FROM Students;

--SELECT COUNT(*) AS [Number of students]
--FROM Students
--WHERE FirstName LIKE 'J%';

--SELECT G.Name, Grants, COUNT(*) AS [Number of students]
--FROM Students AS S, Groups AS G, GroupsStudents AS SG
--WHERE S.Id = SG.StudentId AND G.Id = SG.GroupId
--GROUP BY G.Name, Grants;

--SELECT LastName, Grants
--FROM Students
--GROUP BY LastName, Grants
--HAVING AVG(Grants) <= 1200
--ORDER BY LastName;

--SELECT G.Name, COUNT(*)
--FROM Students AS S, Groups AS G, GroupsStudents AS SG
--WHERE S.Id = SG.StudentId AND G.Id = SG.GroupId
--GROUP BY G.Name
--HAVING COUNT(SG.GroupId) > 2;
