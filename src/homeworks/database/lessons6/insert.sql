USE [Hospital]
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[Patients](
    [Id] [int] IDENTITY(1,1) NOT NULL,
    [Department] [nvarchar](100) NOT NULL,
    [StartDate] [date] NOT NULL,
    [EndDate] [date] NOT NULL,
    [BirthDate] [date] NOT NULL,
    [Surname] [nvarchar](max) NOT NULL,
    [Doctor] [nvarchar](max) NOT NULL,
    [Disease] [nvarchar](100) NOT NULL,
CONSTRAINT [PK_Patients] PRIMARY KEY CLUSTERED
(
    [Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO

-- Add constraints
ALTER TABLE [dbo].[Patients] WITH CHECK ADD CONSTRAINT [CK_Patients_Doctor] CHECK (([Doctor]<>N''))
GO
ALTER TABLE [dbo].[Patients] CHECK CONSTRAINT [CK_Patients_Doctor]
GO

ALTER TABLE [dbo].[Patients] ADD CONSTRAINT [DF_Patients_Doctor] DEFAULT ('Doe') FOR [Doctor]
GO

ALTER TABLE [dbo].[Patients] WITH CHECK ADD CONSTRAINT [CK_Patients_Surname] CHECK (([Surname]<>N''))
GO
ALTER TABLE [dbo].[Patients] CHECK CONSTRAINT [CK_Patients_Surname]
GO

ALTER TABLE [dbo].[Patients] WITH CHECK ADD CONSTRAINT [CK_Patients_Department] CHECK (([Department]<>N''))
GO
ALTER TABLE [dbo].[Patients] CHECK CONSTRAINT [CK_Patients_Department]
GO

ALTER TABLE [dbo].[Patients] WITH CHECK ADD CONSTRAINT [CK_Patients_Disease] CHECK (([Disease]<>N''))
GO
ALTER TABLE [dbo].[Patients] CHECK CONSTRAINT [CK_Patients_Disease]
GO

ALTER TABLE [dbo].[Patients] ADD CONSTRAINT [DF_Patients_Disease] DEFAULT ('Undefined') FOR [Disease]
GO

ALTER TABLE [dbo].[Patients] WITH CHECK ADD CONSTRAINT [CK_Patients_EndDate] CHECK (([EndDate]>[StartDate]))
GO
ALTER TABLE [dbo].[Patients] CHECK CONSTRAINT [CK_Patients_EndDate]
GO

ALTER TABLE [dbo].[Patients] WITH CHECK ADD CONSTRAINT [CK_Patients_BirthDate] CHECK (([BirthDate]<GETDATE()))
GO
ALTER TABLE [dbo].[Patients] CHECK CONSTRAINT [CK_Patients_BirthDate]
GO


USE [Hospital]
GO

INSERT INTO [dbo].[Patients]
([Department], [StartDate], [EndDate], [BirthDate], [Surname], [Doctor], [Disease])
VALUES
('Cardiology', '2025-01-15', '2025-01-22', '1978-05-12', 'Smith', 'Dr. Johnson', 'Hypertension'),
('Orthopedics', '2025-02-10', '2025-02-20', '1985-11-03', 'Williams', 'Dr. Brown', 'Fractured femur'),
('Neurology', '2025-03-05', '2025-03-15', '1962-07-21', 'Davis', 'Dr. Wilson', 'Migraine'),
('Pediatrics', '2025-01-20', '2025-01-25', '2020-09-14', 'Miller', 'Dr. Taylor', 'Bronchitis'),
('Oncology', '2025-04-01', '2025-04-30', '1955-12-30', 'Anderson', 'Dr. Moore', 'Lymphoma'),
('Cardiology', '2025-02-15', '2025-02-25', '1973-04-18', 'Martinez', 'Dr. Johnson', 'Arrhythmia'),
('General Surgery', '2025-03-10', '2025-03-18', '1988-08-09', 'Thompson', 'Dr. White', 'Appendicitis'),
('Dermatology', '2025-01-05', '2025-01-10', '1991-02-27', 'Garcia', 'Dr. Lee', 'Psoriasis'),
('Pulmonology', '2025-04-05', '2025-04-15', '1967-10-11', 'Robinson', 'Dr. Harris', 'Pneumonia'),
('Endocrinology', '2025-02-01', '2025-02-10', '1975-06-23', 'Clark', 'Dr. Martin', 'Diabetes'),
('Neurology', '2025-03-20', '2025-04-05', '1958-03-15', 'Rodriguez', 'Dr. Wilson', 'Epilepsy'),
('Orthopedics', '2025-01-25', '2025-02-05', '1993-07-07', 'Lewis', 'Dr. Brown', 'Torn ACL'),
('Pediatrics', '2025-04-10', '2025-04-17', '2018-12-24', 'Walker', 'Dr. Taylor', 'Asthma'),
('Cardiology', '2025-03-01', '2025-03-10', '1949-09-30', 'Hall', 'Dr. Johnson', 'Heart failure'),
('Dermatology', '2025-02-18', '2025-02-25', '1982-01-05', 'Allen', 'Dr. Lee', 'Eczema')
GO