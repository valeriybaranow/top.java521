create trigger addPC
on PC
for insert, update
as
 raiserror('%d строк было добавлено или модифицировано', 0, 1, @@rowcount)
 return
 ------------------------------------------------------------------------------
create trigger CheckTr16 on PC
for insert
as
begin
 declare @Id1 int
 select @Id1 = Id
 from inserted
-- проверяем, сколько прошло дней со дня издания
 if (@Id1=16)
 begin
 raiserror('Нельзя! ',0,1)
 rollback transaction
 end
  else
 PRINT(' Данные добавлены успешно ')
End
-------------------------------------------------------------

insert into PC values(16,'PC1','i5',8,1000,'no','win10')

create trigger NotAlterDropTable
on DATABASE
for DROP_TABLE, ALTER_TABLE
as
begin
print 'Модификация и удаление таблиц запрещены.Обратитесь к администратору.'
rollback
end
DROP TABLE PC
-------------------------------------------------------------
use master;
go
create trigger TriggerConnection5
on ALL SERVER
with execute as 'user1'
for logon
as
begin
 if ORIGINAL_LOGIN()= 'user1'
 begin
 print 'Такой логин запрещен на сервере. Обратитесь к администратору.'
 rollback
 end
end