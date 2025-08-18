USE [University]
GO

CREATE PROCEDURE addStudent
	@Name NVARCHAR(100),        -- Имя студента
    @SName NVARCHAR(100),       -- Фамилия студента
    @BirthDate DATE             -- Дата рождения
AS
BEGIN
    INSERT INTO Students (Name, SName, BirthDate) VALUES(@Name, @SName, @BirthDate)
    PRINT 'Студент успешно добавлен. ID: ' + CAST(SCOPE_IDENTITY() AS NVARCHAR(10))
END
GO