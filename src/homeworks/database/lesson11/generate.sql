-- Создание базы данных Academy11
CREATE DATABASE Academy11;
GO

USE Academy11;
GO

-- Создание таблицы Actions
CREATE TABLE Actions
(
    Id   INT IDENTITY (1,1) PRIMARY KEY,
    Name NVARCHAR(255) NOT NULL UNIQUE CHECK (Name <> '')
);

-- Создание таблицы Teachers
CREATE TABLE Teachers
(
    Id             INT IDENTITY (1,1) PRIMARY KEY,
    EmploymentDate DATE           NOT NULL CHECK (EmploymentDate >= '1990-01-01'),
    Name           NVARCHAR(255)  NOT NULL CHECK (Name <> ''),
    Salary         DECIMAL(18, 2) NOT NULL CHECK (Salary > 0),
    Surname        NVARCHAR(255)  NOT NULL CHECK (Surname <> '')
);

-- Создание таблицы TeacherManipulations
CREATE TABLE TeacherManipulations
(
    Id        INT IDENTITY (1,1) PRIMARY KEY,
    Date      DATETIME NOT NULL CHECK (Date <= GETDATE()),
    ActionId  INT      NOT NULL,
    TeacherId INT      NOT NULL
);

-- Создание таблицы TeacherAddedInfos
CREATE TABLE TeacherAddedInfos
(
    Id             INT IDENTITY (1,1) PRIMARY KEY,
    EmploymentDate DATE           NOT NULL CHECK (EmploymentDate >= '1990-01-01'),
    Name           NVARCHAR(255)  NOT NULL CHECK (Name <> ''),
    Salary         DECIMAL(18, 2) NOT NULL CHECK (Salary > 0),
    Surname        NVARCHAR(255)  NOT NULL CHECK (Surname <> ''),
    ManipulationId INT            NOT NULL
);

-- Создание таблицы TeacherDeletedInfos
CREATE TABLE TeacherDeletedInfos
(
    Id             INT IDENTITY (1,1) PRIMARY KEY,
    EmploymentDate DATE           NOT NULL CHECK (EmploymentDate >= '1990-01-01'),
    Name           NVARCHAR(255)  NOT NULL CHECK (Name <> ''),
    Salary         DECIMAL(18, 2) NOT NULL CHECK (Salary > 0),
    Surname        NVARCHAR(255)  NOT NULL CHECK (Surname <> ''),
    ManipulationId INT            NOT NULL
);

-- Создание внешних ключей для TeacherManipulations
ALTER TABLE TeacherManipulations
    ADD CONSTRAINT FK_TeacherManipulations_Actions
        FOREIGN KEY (ActionId) REFERENCES Actions (Id);

-- Создание внешних ключей для TeacherAddedInfos
ALTER TABLE TeacherAddedInfos
    ADD CONSTRAINT FK_TeacherAddedInfos_TeacherManipulations
        FOREIGN KEY (ManipulationId) REFERENCES TeacherManipulations (Id);

-- Создание внешних ключей для TeacherDeletedInfos
ALTER TABLE TeacherDeletedInfos
    ADD CONSTRAINT FK_TeacherDeletedInfos_TeacherManipulations
        FOREIGN KEY (ManipulationId) REFERENCES TeacherManipulations (Id);


CREATE TABLE Faculties
(
    [Id]        [int] IDENTITY (1,1) NOT NULL,
    [Financing] [money]              NOT NULL,
    [Name]      [nvarchar](100)      NOT NULL,
    PRIMARY KEY CLUSTERED
        (
         [Id] ASC
            ) WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
    UNIQUE NONCLUSTERED
        (
         [Name] ASC
            ) WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
);

ALTER TABLE Faculties
    ADD DEFAULT ((0.0)) FOR [Financing]
GO

ALTER TABLE Faculties
    WITH CHECK ADD CHECK (([Financing] >= (0.0)))
GO

ALTER TABLE Faculties
    WITH CHECK ADD CHECK (([Name] <> N''))
GO