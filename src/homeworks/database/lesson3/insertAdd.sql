USE [AcademyForHwSeven]
GO

ALTER TABLE [dbo].[Teachers]
ADD [Premium] [money]
CONSTRAINT [DF_Teachers_Premium] DEFAULT 0
CONSTRAINT [CK_Teachers_Premium] CHECK ([Premium] >= 0);

ALTER TABLE Teachers
ADD isProfessor BIT DEFAULT 0;


ALTER TABLE Groups
ADD Rating DECIMAL(5,2) NULL
CONSTRAINT [DF_Groups_Rating] DEFAULT 0
CONSTRAINT [CK_Groups_Rating] CHECK ([Rating] >= 0 AND [Rating] <= 100);