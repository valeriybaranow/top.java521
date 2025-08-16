USE [master]
GO

-- Переводим БД в однопользовательский режим с немедленным завершением соединений
ALTER DATABASE [AcademyForHwSeven] SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
GO

-- Теперь пробуем удалить БД
DROP DATABASE [AcademyForHwSeven];
GO

/****** Object:  Database [AcademyForHwSeven]    Script Date: 09.08.2025 14:24:18 ******/
CREATE DATABASE [AcademyForHwSeven]
 CONTAINMENT = NONE
 ON  PRIMARY
( NAME = N'AcademyForHwSeven', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\AcademyForHwSeven.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON
( NAME = N'AcademyForHwSeven_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\AcademyForHwSeven_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [AcademyForHwSeven].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO

ALTER DATABASE [AcademyForHwSeven] SET ANSI_NULL_DEFAULT OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET ANSI_NULLS OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET ANSI_PADDING OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET ANSI_WARNINGS OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET ARITHABORT OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET AUTO_CLOSE ON
GO

ALTER DATABASE [AcademyForHwSeven] SET AUTO_SHRINK OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET AUTO_UPDATE_STATISTICS ON
GO

ALTER DATABASE [AcademyForHwSeven] SET CURSOR_CLOSE_ON_COMMIT OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET CURSOR_DEFAULT  GLOBAL
GO

ALTER DATABASE [AcademyForHwSeven] SET CONCAT_NULL_YIELDS_NULL OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET NUMERIC_ROUNDABORT OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET QUOTED_IDENTIFIER OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET RECURSIVE_TRIGGERS OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET  ENABLE_BROKER
GO

ALTER DATABASE [AcademyForHwSeven] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET DATE_CORRELATION_OPTIMIZATION OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET TRUSTWORTHY OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET PARAMETERIZATION SIMPLE
GO

ALTER DATABASE [AcademyForHwSeven] SET READ_COMMITTED_SNAPSHOT OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET HONOR_BROKER_PRIORITY OFF
GO

ALTER DATABASE [AcademyForHwSeven] SET RECOVERY SIMPLE
GO

ALTER DATABASE [AcademyForHwSeven] SET  MULTI_USER
GO

ALTER DATABASE [AcademyForHwSeven] SET PAGE_VERIFY CHECKSUM
GO
-----------------------------------------
----------------------------------------
USE [AcademyForHwSeven]
GO

/****** Object:  Table [dbo].[Faculties]    Script Date: 09.08.2025 14:38:10 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Faculties](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Financing] [money] NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Faculties] ADD  DEFAULT ((0.0)) FOR [Financing]
GO

ALTER TABLE [dbo].[Faculties]  WITH CHECK ADD CHECK  (([Financing]>=(0.0)))
GO

ALTER TABLE [dbo].[Faculties]  WITH CHECK ADD CHECK  (([Name]<>N''))
GO

---------------------------------

USE [AcademyForHwSeven]
GO

/****** Object:  Table [dbo].[Departments]    Script Date: 09.08.2025 14:41:50 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Departments](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Financing] [money] NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
	[FacultyId] [int] NOT NULL,
PRIMARY KEY CLUSTERED
(
	[Id] ASC
) WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Departments] ADD  DEFAULT ((0.0)) FOR [Financing]
GO

ALTER TABLE [dbo].[Departments]  WITH CHECK ADD FOREIGN KEY([FacultyId])
REFERENCES [dbo].[Faculties] ([Id])
GO

ALTER TABLE [dbo].[Departments]  WITH CHECK ADD CHECK  (([Financing]>=(0.0)))
GO

ALTER TABLE [dbo].[Departments]  WITH CHECK ADD CHECK  (([Name]<>N''))
GO

---------------------------------------
USE [AcademyForHwSeven]
GO

/****** Object:  Table [dbo].[Groups]    Script Date: 09.08.2025 14:49:50 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Groups](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
	[Year] [int] NOT NULL,
	[DepartmentId] [int] NOT NULL,
PRIMARY KEY CLUSTERED
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Groups]  WITH CHECK ADD FOREIGN KEY([DepartmentId])
REFERENCES [dbo].[Departments] ([Id])
GO

ALTER TABLE [dbo].[Groups]  WITH CHECK ADD CHECK  (([Name]<>N''))
GO

ALTER TABLE [dbo].[Groups]  WITH CHECK ADD CHECK  (([Year]>=(1) AND [Year]<=(5)))
GO
-----------------------------------
-----------------------------
USE [AcademyForHwSeven]
GO

/****** Object:  Table [dbo].[Subjects]    Script Date: 09.08.2025 14:57:27 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Subjects](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Subjects]  WITH CHECK ADD CHECK  (([Name]<>N''))
GO
-----------------------------------
-----------------------------
USE [AcademyForHwSeven]
GO

/****** Object:  Table [dbo].[Teachers]    Script Date: 09.08.2025 15:01:48 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Teachers](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](max) NOT NULL,
	[Salary] [money] NOT NULL,
	[Surname] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK__Teachers__3214EC071F4B9FDC] PRIMARY KEY CLUSTERED
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[Teachers]  WITH CHECK ADD  CONSTRAINT [CK__Teachers__Name__5629CD9C] CHECK  (([Name]<>N''))
GO

ALTER TABLE [dbo].[Teachers] CHECK CONSTRAINT [CK__Teachers__Name__5629CD9C]
GO

ALTER TABLE [dbo].[Teachers]  WITH CHECK ADD  CONSTRAINT [CK__Teachers__Salary__571DF1D5] CHECK  (([Salary]>(0.0)))
GO

ALTER TABLE [dbo].[Teachers] CHECK CONSTRAINT [CK__Teachers__Salary__571DF1D5]
GO

ALTER TABLE [dbo].[Teachers]  WITH CHECK ADD  CONSTRAINT [CK__Teachers__Surnam__5812160E] CHECK  (([Surname]<>N''))
GO

ALTER TABLE [dbo].[Teachers] CHECK CONSTRAINT [CK__Teachers__Surnam__5812160E]
GO
---------------------------------
----------------------------------
USE [AcademyForHwSeven]
GO

/****** Object:  Table [dbo].[Lectures]    Script Date: 09.08.2025 14:53:31 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Lectures](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[DayOfWeek]  [int] NOT NULL,
	[LectureRoom] [nvarchar](max) NOT NULL,
	[SubjectId] [int] NOT NULL,
	[TeacherId] [int] NOT NULL,
PRIMARY KEY CLUSTERED
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[Lectures]  WITH CHECK ADD FOREIGN KEY([SubjectId])
REFERENCES [dbo].[Subjects] ([Id])
GO

ALTER TABLE [dbo].[Lectures]  WITH CHECK ADD  CONSTRAINT [FK__Lectures__Teache__5FB337D6] FOREIGN KEY([TeacherId])
REFERENCES [dbo].[Teachers] ([Id])
GO

ALTER TABLE [dbo].[Lectures] CHECK CONSTRAINT [FK__Lectures__Teache__5FB337D6]
GO

ALTER TABLE [dbo].[Lectures]  WITH CHECK ADD CHECK  (([LectureRoom]<>N''))
GO

ALTER TABLE [dbo].[Lectures]  WITH CHECK ADD CHECK  (([DayOfWeek]>=(1) AND [DayOfWeek]<=(7)))
GO
-------------------------------------
-------------------------------------
USE [AcademyForHwSeven]
GO

/****** Object:  Table [dbo].[GroupsLectures]    Script Date: 09.08.2025 15:21:34 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[GroupsLectures](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[GroupId] [int] NOT NULL,
	[LectureId] [int] NOT NULL,
PRIMARY KEY CLUSTERED
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[GroupsLectures]  WITH CHECK ADD FOREIGN KEY([GroupId])
REFERENCES [dbo].[Groups] ([Id])
GO

ALTER TABLE [dbo].[GroupsLectures]  WITH CHECK ADD FOREIGN KEY([LectureId])
REFERENCES [dbo].[Lectures] ([Id])
GO
---------------------------------------
---------------------------------------
USE [AcademyForHwSeven]
GO

/****** Object:  Table [dbo].[Curators]    Script Date: 09.08.2025 15:01:48 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Curators](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](max) NOT NULL,
	[Surname] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK__Curators__3214EC071F4B9FDC] PRIMARY KEY CLUSTERED
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

ALTER TABLE [dbo].[Curators]  WITH CHECK ADD  CONSTRAINT [CK__Curators__Name__5629CD9C] CHECK  (([Name]<>N''))
GO

ALTER TABLE [dbo].[Curators] CHECK CONSTRAINT [CK__Curators__Name__5629CD9C]
GO

ALTER TABLE [dbo].[Curators]  WITH CHECK ADD  CONSTRAINT [CK__Curators__Surnam__5812160E] CHECK  (([Surname]<>N''))
GO

ALTER TABLE [dbo].[Curators] CHECK CONSTRAINT [CK__Curators__Surnam__5812160E]
GO
---------------------------------
----------------------------------

USE [AcademyForHwSeven]
GO

/****** Object:  Table [dbo].[GroupsCurators]    Script Date: 09.08.2025 15:21:34 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[GroupsCurators](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[GroupId] [int] NOT NULL,
	[CuratorId] [int] NOT NULL,
PRIMARY KEY CLUSTERED
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[GroupsCurators]  WITH CHECK ADD FOREIGN KEY([CuratorId])
REFERENCES [dbo].[Curators] ([Id])
GO

ALTER TABLE [dbo].[GroupsCurators]  WITH CHECK ADD FOREIGN KEY([GroupId])
REFERENCES [dbo].[Groups] ([Id])
GO
---------------------------------------
---------------------------------------