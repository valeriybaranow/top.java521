CREATE
OR ALTER
TRIGGER checkUpdateFaculties on Faculties
    AFTER
UPDATE
    AS
BEGIN
    DECLARE
@oldFinancing money;
    DECLARE
@newFinancing money;
    IF
UPDATE (Financing)
BEGIN
SELECT @newFinancing = Financing
FROM inserted;
SELECT @oldFinancing = Financing
FROM deleted;
IF
@newFinancing < @oldFinancing
BEGIN
ROLLBACK TRANSACTION; -- Отменить транзакцию
RAISERROR
('Финансирование не может быть уменьшено', 16, 1);
END
ELSE
                PRINT 'Финансирование увеличено '
END
END

--

UPDATE Faculties
SET Financing = 15000000
WHERE id = 1;
UPDATE Faculties
SET Financing = 15000001
WHERE id = 1;