USE [master]
GO

-- Проверяем существование БД
IF DB_ID('University') IS NOT NULL
BEGIN
    -- Если БД существует, переводим в однопользовательский режим
    ALTER DATABASE [University] SET SINGLE_USER WITH ROLLBACK IMMEDIATE
    -- Удаляем БД
    DROP DATABASE [University]
END
GO

-- Создаем новую БД
CREATE DATABASE [University]
ON PRIMARY
(
    NAME = N'University',
    FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\University.mdf',
    SIZE = 8MB,
    MAXSIZE = UNLIMITED,
    FILEGROWTH = 64MB
)
LOG ON
(
    NAME = N'University_log',
    FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\University_log.ldf',
    SIZE = 8MB,
    MAXSIZE = 2048GB,
    FILEGROWTH = 64MB
)
GO

-- Используем новую БД
USE [University]
GO

-- Настраиваем параметры БД
ALTER DATABASE [University] SET RECOVERY SIMPLE
ALTER DATABASE [University] SET MULTI_USER
ALTER DATABASE [University] SET QUOTED_IDENTIFIER ON
ALTER DATABASE [University] SET ANSI_NULLS ON
GO

-- Создаем таблицы
CREATE TABLE Students (
    StudentID INT PRIMARY KEY IDENTITY(1,1),
    Name NVARCHAR(100) NOT NULL,
    SName NVARCHAR(100) NOT NULL,
    BirthDate DATE
)
GO

CREATE TABLE Courses (
    CourseId INT PRIMARY KEY IDENTITY(1,1),
    CourseName NVARCHAR(100) NOT NULL UNIQUE,
    Credits INT NOT NULL CHECK (Credits > 0)
)
GO

PRINT 'База данных University успешно создана и настроена'
GO