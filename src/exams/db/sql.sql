USE [University]
GO

-- Правильный вызов процедуры:
EXEC addStudent
     @SName = 'Баранов',
     @Name = 'Валерий',
     @BirthDate = '1973-01-23'