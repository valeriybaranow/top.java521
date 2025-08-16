USE [AcademyForHwSeven]
GO

-- First disable all constraints temporarily
EXEC sp_MSforeachtable 'ALTER TABLE ? NOCHECK CONSTRAINT ALL'
GO

-- 1. Create Assistants table
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Assistants')
BEGIN
    CREATE TABLE [dbo].[Assistants](
        [Id] [int] IDENTITY(1,1) NOT NULL,
        [TeacherId] [int] NOT NULL,
     CONSTRAINT [PK_Assistants] PRIMARY KEY CLUSTERED
    (
        [Id] ASC
    )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]

    ALTER TABLE [dbo].[Assistants] WITH CHECK ADD CONSTRAINT [FK_Assistants_Teachers] FOREIGN KEY([TeacherId])
    REFERENCES [dbo].[Teachers] ([Id])

    ALTER TABLE [dbo].[Assistants] CHECK CONSTRAINT [FK_Assistants_Teachers]
END
GO

-- 2. Handle Curators table modification
-- First drop GroupsCurators table if it exists
IF EXISTS (SELECT * FROM sys.tables WHERE name = 'GroupsCurators')
    DROP TABLE [dbo].[GroupsCurators]
GO

-- Now drop the existing Curators table if it exists
IF EXISTS (SELECT * FROM sys.tables WHERE name = 'Curators')
    DROP TABLE [dbo].[Curators]
GO

-- Create the new Curators table
CREATE TABLE [dbo].[Curators](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [TeacherId] [int] NOT NULL,
 CONSTRAINT [PK_Curators] PRIMARY KEY CLUSTERED
(
    [Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

-- Add foreign key to Teachers
ALTER TABLE [dbo].[Curators] WITH CHECK ADD CONSTRAINT [FK_Curators_Teachers] FOREIGN KEY([TeacherId])
REFERENCES [dbo].[Teachers] ([Id])
GO

ALTER TABLE [dbo].[Curators] CHECK CONSTRAINT [FK_Curators_Teachers]
GO

-- 3. Create Deans table
IF NOT EXISTS (SELECT * FROM sys.tables WHERE name = 'Deans')
BEGIN
    CREATE TABLE [dbo].[Deans](
        [Id] [int] IDENTITY(1,1) NOT NULL,
        [TeacherId] [int] NOT NULL,
     CONSTRAINT [PK_Deans] PRIMARY KEY CLUSTERED
    (
        [Id] ASC
    )WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
    ) ON [PRIMARY]

    ALTER TABLE [dbo].[Deans] WITH CHECK ADD CONSTRAINT [FK_Deans_Teachers] FOREIGN KEY([TeacherId])
    REFERENCES [dbo].[Teachers] ([Id])

    ALTER TABLE [dbo].[Deans] CHECK CONSTRAINT [FK_Deans_Teachers]
END
GO

-- 4. Recreate GroupsCurators table
CREATE TABLE [dbo].[GroupsCurators](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [GroupId] [int] NOT NULL,
    [CuratorId] [int] NOT NULL,
 CONSTRAINT [PK_GroupsCurators] PRIMARY KEY CLUSTERED
(
    [Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

-- Add foreign keys to GroupsCurators
ALTER TABLE [dbo].[GroupsCurators] WITH CHECK ADD CONSTRAINT [FK_GroupsCurators_Groups] FOREIGN KEY([GroupId])
REFERENCES [dbo].[Groups] ([Id])
GO

ALTER TABLE [dbo].[GroupsCurators] WITH CHECK ADD CONSTRAINT [FK_GroupsCurators_Curators] FOREIGN KEY([CuratorId])
REFERENCES [dbo].[Curators] ([Id])
GO

ALTER TABLE [dbo].[GroupsCurators] CHECK CONSTRAINT [FK_GroupsCurators_Groups]
ALTER TABLE [dbo].[GroupsCurators] CHECK CONSTRAINT [FK_GroupsCurators_Curators]
GO

-- Re-enable all constraints
EXEC sp_MSforeachtable 'ALTER TABLE ? WITH CHECK CHECK CONSTRAINT ALL'
GO


USE [AcademyForHwSeven]
GO

-- Add Building column to Faculties table
ALTER TABLE [dbo].[Faculties]
ADD [Building] TINYINT NOT NULL
CONSTRAINT [DF_Faculties_Building] DEFAULT 1
CONSTRAINT [CK_Faculties_Building] CHECK ([Building] BETWEEN 1 AND 5)
GO

-- Add Building column to Departments table
ALTER TABLE [dbo].[Departments]
ADD [Building] TINYINT NOT NULL
CONSTRAINT [DF_Departments_Building] DEFAULT 1
CONSTRAINT [CK_Departments_Building] CHECK ([Building] BETWEEN 1 AND 5)
GO

-- Update existing records with building numbers
-- Faculties will be distributed across buildings 1-3
UPDATE [dbo].[Faculties] SET [Building] = 1 WHERE [Id] IN (1, 2, 3)
UPDATE [dbo].[Faculties] SET [Building] = 2 WHERE [Id] IN (4, 5, 6)
UPDATE [dbo].[Faculties] SET [Building] = 3 WHERE [Id] IN (7, 8, 9, 10)
GO

-- Departments will be in the same building as their faculty
UPDATE d
SET d.[Building] = f.[Building]
FROM [dbo].[Departments] d
JOIN [dbo].[Faculties] f ON d.[FacultyId] = f.[Id]
GO


USE [AcademyForHwSeven]
GO

/****** Object:  Table [dbo].[LectureRooms]    Script Date: 09.08.2025 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[LectureRooms](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Building] [tinyint] NOT NULL,
    [Name] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_LectureRooms] PRIMARY KEY CLUSTERED
(
    [Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
 CONSTRAINT [UQ_LectureRooms_Name] UNIQUE NONCLUSTERED
(
    [Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[LectureRooms] ADD  CONSTRAINT [DF_LectureRooms_Building]  DEFAULT ((1)) FOR [Building]
GO

ALTER TABLE [dbo].[LectureRooms]  WITH CHECK ADD  CONSTRAINT [CK_LectureRooms_Building] CHECK  (([Building] BETWEEN 1 AND 5))
GO

ALTER TABLE [dbo].[LectureRooms] CHECK CONSTRAINT [CK_LectureRooms_Building]
GO

ALTER TABLE [dbo].[LectureRooms]  WITH CHECK ADD  CONSTRAINT [CK_LectureRooms_Name] CHECK  (([Name]<>N''))
GO

ALTER TABLE [dbo].[LectureRooms] CHECK CONSTRAINT [CK_LectureRooms_Name]
GO


USE [AcademyForHwSeven]
GO

/****** Object:  Table [dbo].[Schedules]    Script Date: 09.08.2025 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Schedules](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Class] [tinyint] NOT NULL,
    [DayOfWeek] [tinyint] NOT NULL,
    [Week] [tinyint] NOT NULL,
    [LectureId] [int] NOT NULL,
    [LectureRoomId] [int] NOT NULL,
 CONSTRAINT [PK_Schedules] PRIMARY KEY CLUSTERED
(
    [Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Schedules] ADD  CONSTRAINT [DF_Schedules_Class]  DEFAULT ((1)) FOR [Class]
GO

ALTER TABLE [dbo].[Schedules] ADD  CONSTRAINT [DF_Schedules_DayOfWeek]  DEFAULT ((1)) FOR [DayOfWeek]
GO

ALTER TABLE [dbo].[Schedules] ADD  CONSTRAINT [DF_Schedules_Week]  DEFAULT ((1)) FOR [Week]
GO

ALTER TABLE [dbo].[Schedules]  WITH CHECK ADD  CONSTRAINT [CK_Schedules_Class] CHECK  (([Class] BETWEEN 1 AND 8))
GO

ALTER TABLE [dbo].[Schedules] CHECK CONSTRAINT [CK_Schedules_Class]
GO

ALTER TABLE [dbo].[Schedules]  WITH CHECK ADD  CONSTRAINT [CK_Schedules_DayOfWeek] CHECK  (([DayOfWeek] BETWEEN 1 AND 7))
GO

ALTER TABLE [dbo].[Schedules] CHECK CONSTRAINT [CK_Schedules_DayOfWeek]
GO

ALTER TABLE [dbo].[Schedules]  WITH CHECK ADD  CONSTRAINT [CK_Schedules_Week] CHECK  (([Week] BETWEEN 1 AND 52))
GO

ALTER TABLE [dbo].[Schedules] CHECK CONSTRAINT [CK_Schedules_Week]
GO

ALTER TABLE [dbo].[Schedules]  WITH CHECK ADD  CONSTRAINT [FK_Schedules_Lectures] FOREIGN KEY([LectureId])
REFERENCES [dbo].[Lectures] ([Id])
GO

ALTER TABLE [dbo].[Schedules] CHECK CONSTRAINT [FK_Schedules_Lectures]
GO

ALTER TABLE [dbo].[Schedules]  WITH CHECK ADD  CONSTRAINT [FK_Schedules_LectureRooms] FOREIGN KEY([LectureRoomId])
REFERENCES [dbo].[LectureRooms] ([Id])
GO

ALTER TABLE [dbo].[Schedules] CHECK CONSTRAINT [FK_Schedules_LectureRooms]
GO


USE [AcademyForHwSeven]
GO

/****** Object:  Table [dbo].[Curators]    Script Date: 09.08.2025 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Curators](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [TeacherId] [int] NOT NULL,
 CONSTRAINT [PK_Curators] PRIMARY KEY CLUSTERED
(
    [Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[Curators]  WITH CHECK ADD  CONSTRAINT [FK_Curators_Teachers] FOREIGN KEY([TeacherId])
REFERENCES [dbo].[Teachers] ([Id])
GO

ALTER TABLE [dbo].[Curators] CHECK CONSTRAINT [FK_Curators_Teachers]
GO