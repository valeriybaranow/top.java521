--SELECT * FROM PC;

--CREATE TRIGGER addPc ON PC
--FOR INSERT
--AS
--BEGIN
--    PRINT('Хватит добавлять!');
--END

--INSERT INTO PC VALUES('1', 'asdf', 3, 388, '3', 'asdf');

--DROP TRIGGER addPc;

--CREATE TRIGGER addPc ON PC
--FOR INSERT
--AS
--BEGIN
--    PRINT('Хватит добавлять!');
--	ROLLBACK
--END


--CREATE TRIGGER unDelTablePc ON
--DATABASE
--FOR DROP_TABLE
--AS
--BEGIN
--    RAISERROR('Нельзя удалять таблицу', 0, 1);
--	ROLLBACK
--END

--DROP TABLE PC;

--CREATE TRIGGER delDataPC ON PC
--FOR DELETE
--AS
--BEGIN
--	SELECT * FROM deleted;
--	ROLLBACK
--END

--DELETE FROM PC WHERE id = 1;

--use db1
--GO
--CREATE TABLE [dbo].[trashPC1] (
--  [Id] [int] NOT NULL,
--  [name] [nvarchar](50) NOT NULL,
--  [proc] [nvarchar](50) NOT NULL,
--  [ram] [smallint] NOT NULL,
--  [hd] [smallint] NOT NULL,
--  [video] [nvarchar](50) NOT NULL,
--  [OS] [nvarchar](10) NOT NULL,
--  [deletion_time] [datetime] NOT NULL DEFAULT GETDATE(),
--  [deleted_by] [nvarchar](128) NOT NULL DEFAULT SUSER_SNAME()
--)


--ALTER TABLE [dbo].[trashPC]
--ADD
--    [deletion_time] DATETIME NOT NULL DEFAULT GETDATE(),
--    [deleted_by] NVARCHAR(128) NOT NULL DEFAULT SUSER_SNAME();


--DROP TRIGGER addToTrach1;

--CREATE TRIGGER addToTrach1 ON PC
--FOR DELETE
--AS
--BEGIN
--	DECLARE @id int;
--	SELECT @id = id FROM deleted;
--	PRINT (@id)
--	DECLARE @name nvarchar(50);
--	SELECT @name = name FROM deleted;
--	PRINT (@name)

--	DECLARE @proc nvarchar(50);
--	SELECT @proc = [proc] FROM deleted;
--	PRINT (@proc)

--	DECLARE @ram smallint;
--	SELECT @ram = ram FROM deleted;
--	PRINT (@ram)

--	DECLARE @hd smallint;
--	SELECT @hd = hd FROM deleted;
--	PRINT (@hd)

--	DECLARE @video nvarchar(50);
--	SELECT @video = video FROM deleted;
--	PRINT (@video)

--	DECLARE @os nvarchar(50);
--	SELECT @os = OS FROM deleted;
--	PRINT (@os)

--	IF @id IS NOT NULL
--	  INSERT INTO trashPC1 (Id, name, [proc], ram, hd, video, OS) VALUES (@id, @name, @proc, @ram, @hd, @video, @OS)
--	ELSE
--		PRINT('Триггер не сработал')
--END

--DROP TRIGGER addToTrach;

--DELETE FROM PC WHERE id IN (1002,1003);

--TRUNCATE TABLE trashPC1;

INSERT INTO PC VALUES('1', 'asdf', 3, 388, '3', 'asdf');
--INSERT INTO PC VALUES('1', 'asdf', 3, 388, '3', 'asdf');
--SELECT * FROM trashPC1;