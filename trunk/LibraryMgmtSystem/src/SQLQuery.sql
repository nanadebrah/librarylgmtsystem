--Create database
CREATE DATABASE Library
go
--Use database
USE Library
go
--------------------------------------------
--Create Employee table
CREATE TABLE Employee(
	EmpID INT NOT NULL IDENTITY,
	[Name] VARCHAR(45) NOT NULL,
	DOB SMALLDATETIME NOT NULL,
	Gender BIT NOT NULL,
	Email VARCHAR(45) NOT NULL,
	Password VARCHAR(32),
	Address VARCHAR(45) NOT NULL,
	Phone VARCHAR(45) NOT NULL,
	Permission BIT NOT NULL,
	Department VARCHAR(45) NOT NULL,
	CONSTRAINT pk_EmpID PRIMARY KEY (EmpID)
)

go
--Create Subject table
CREATE TABLE Subject(
	SubID INT NOT NULL IDENTITY,
	SubName VARCHAR(45) NOT NULL,
	Description VARCHAR(200),
	CONSTRAINT pk_SubID PRIMARY KEY (SubID)
)
go
--Create Book table
CREATE TABLE Book(
	CallNumber VARCHAR(9) NOT NULL,
	ISBN VARCHAR(8) NOT NULL,
	SubID INT NOT NULL,
	Title VARCHAR(100) NOT NULL,
	AuthName VARCHAR(30) NOT NULL,
	Publisher VARCHAR(45) NOT NULL,
	NoOfCopy TINYINT NOT NULL,
	NoInLib TINYINT NOT NULL,
	CONSTRAINT pk_CallNumber PRIMARY KEY (CallNumber),
	CONSTRAINT fk_SubID FOREIGN KEY (SubID)
		REFERENCES Subject(SubID),
)
go
--Create Borrow table
CREATE TABLE Borrow(
	BorID INT NOT NULL IDENTITY,
	EmpID INT NOT NULL,
	
	CONSTRAINT pk_BorID PRIMARY KEY (BorID),
	CONSTRAINT fk_EmpID FOREIGN KEY (EmpID)
		REFERENCES Employee(EmpID),
	
)
go
--Create BorrowDetail table
CREATE TABLE BorrowDetail
(	
	BorID INT NOT NULL REFERENCES Borrow(BorID),
	CallNumber VARCHAR(9) NOT NULL REFERENCES Book(CallNumber),
	IssueStatus BIT NOT NULL,--1 = checked out ,0 = checked in
	IssueDate DATETIME NOT NULL,
	DueDate DATETIME NOT NULL,
	ReturnDate DATETIME,
	TotalFee FLOAT,
)
go
--Create Fee table
CREATE TABLE Fee(
	Fee VARCHAR(10) NOT NULL,
	BorFee FLOAT NOT NULL,
	LateFee FLOAT NOT NULL
)
-----------------------------------
-----------------------------------
--Create Procedure insert employee
CREATE PROC sp_InsEmp(
	@Name VARCHAR(45),
	@DOB SMALLDATETIME,
	@Gender BIT,
	@Email VARCHAR(45),
	@Address VARCHAR(45),
	@Phone VARCHAR(45),
	@Department VARCHAR(45)
)
AS
	BEGIN
		INSERT INTO Employee(
		[Name],DOB,Gender,Email,
		Address,Phone,Permission,Department)
		VALUES(@Name,@DOB,@Gender,@Email,
		@Address,@Phone,0,@Department)
	END
--Create Procedure insert librarian
CREATE PROC sp_InsLib(
	@Name VARCHAR(45),
	@DOB SMALLDATETIME,
	@Gender BIT,
	@Email VARCHAR(45),
	@Password VARCHAR(32),
	@Address VARCHAR(45),
	@Phone VARCHAR(45),
	@Department VARCHAR(45)
)
AS
	BEGIN
		INSERT INTO Employee(
		[Name],DOB,Gender,Email,Password,
		Address,Phone,Permission,Department)
		VALUES(@Name,@DOB,@Gender,@Email,@Password,
		@Address,@Phone,1,@Department)
	END
--get an employee with one parameter : name
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetAnEmpWithName' AND type = 'P')
   DROP PROCEDURE sp_GetAnEmpWithName
GO
CREATE PROC sp_GetAnEmpWithName
	@Name VARCHAR(45)
AS
	SELECT EmpID,[Name],Gender,Email,Department,Permission
	FROM Employee
	WHERE [Name] LIKE '%'+@Name+'%'
--get an employee with one parameter : EmpID
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetAnEmpWithEmpID' AND type = 'P')
   DROP PROCEDURE sp_GetAnEmpWithEmpID
GO
CREATE PROC sp_GetAnEmpWithEmpID
	@EmpID INT
AS
	SELECT EmpID,[Name],Gender,Email,Department,Permission
	FROM Employee
	WHERE EmpId=@EmpID
--get an employee with both of them : name and empID
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetAnEmpAll' AND type = 'P')
   DROP PROCEDURE sp_GetAnEmpAll
GO
CREATE PROC sp_GetAnEmpAll
	@EmpID INT,
	@Name VARCHAR(45)
AS
	SELECT EmpID,[Name],Gender,Email,Department,Permission
	FROM Employee
	WHERE EmpId=@EmpID AND [Name] LIKE '%'+@Name+'%'


--Create Procedure get all field of a Employee
CREATE PROC sp_GetEmp(@EmpID INT)
AS
	BEGIN
		SELECT * FROM Employee
		WHERE EmpID=@EmpID
	END
--Create Procedure get all field of all Employee
CREATE PROC sp_GetAllEmp
AS
	BEGIN
		SELECT EmpID,[Name],Gender,Email,Department,Permission
	FROM Employee
	END
--Create Procedure edit Employee
CREATE PROC sp_EditEmp(
	@EmpID INT,
	@Name VARCHAR(45),
	@DOB SMALLDATETIME,
	@Gender BIT,
	@Email VARCHAR(45),
	@Address VARCHAR(45),
	@Phone VARCHAR(45),
	@Department VARCHAR(45)
)
AS
	BEGIN
		UPDATE Employee SET
		[Name]=@Name,DOB=@DOB,Gender=@Gender,Email=@Email,
		Address=@Address,Phone=@Phone,Department=@Department
		WHERE EmpID=@EmpID
	END
--Create Procedure edit Librarian
CREATE PROC sp_EditLib(
	@EmpID INT,
	@Name VARCHAR(45),
	@DOB SMALLDATETIME,
	@Gender BIT,
	@Email VARCHAR(45),
	@Password VARCHAR(32),
	@Address VARCHAR(45),
	@Phone VARCHAR(45),
	@Department VARCHAR(45)
)
AS
	BEGIN
		UPDATE Employee SET
		[Name]=@Name,DOB=@DOB,Gender=@Gender,Email=@Email,
			Password=@Password,Address=@Address,
				Phone=@Phone,Department=@Department
		WHERE EmpID=@EmpID
	END
-- delete an Employee 
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_DelEmp' AND type = 'P')
   DROP PROCEDURE sp_DelEmp
GO
CREATE PROC sp_DelEmp
	@EmpID INT
AS
	BEGIN
		IF NOT EXISTS (SELECT @EmpID FROM Borrow
			WHERE EmpID = @EmpID AND IssueStatus = 1)
		DELETE FROM Employee WHERE EmpID = @EmpID
		ELSE
			PRINT 'ko duoc'
	END
--Create Procedure Login
CREATE PROC sp_Login(
	@Name VARCHAR(45),
	@Password VARCHAR(32))
AS
	BEGIN
		SELECT EmpID FROM Employee
		WHERE [Name]=@Name AND Password=@Password
			AND Permission=1
	END
--Create procedure to get Book 
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetAllBook' AND type = 'P')
   DROP PROCEDURE sp_GetAllBook
GO
CREATE PROC sp_GetAllBook
(
	@CallNumber VARCHAR(9),
	@ISBN VARCHAR(8),
	@Title VARCHAR(100),
	@AuthName VARCHAR(30)
)
AS
	SELECT CallNumber,ISBN,Title,AuthName,Publisher,NoOfCopy,NoInLib
	FROM Book WHERE
			CallNumber LIKE '%'+@CallNumber+'%'	 
			AND ISBN LIKE '%'+@ISBN+'%'  
			AND Title LIKE '%'+@Title+'%' 
			AND AuthName LIKE '%'+@AuthName+'%'
--procedure to get newest book added
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetNewestBook' AND type = 'P')
   DROP PROCEDURE sp_GetNewestBook
GO
CREATE PROC sp_GetNewestBook
AS
	SELECT TOP 1 CallNumber FROM BOOK
	ORDER BY CallNumber DESC
--procedure to insert a book 
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_AddBook' AND type = 'P')
   DROP PROCEDURE sp_AddBook
GO
CREATE PROC sp_AddBook
(
	@CallNumber VARCHAR(9),
	@ISBN VARCHAR(8),
	@SubID INT,
	@Title VARCHAR(100),
	@Author VARCHAR(30),
	@Publisher VARCHAR(45),
	@NoOfCopy TINYINT,
	@NoInLib TINYINT
)
AS
	INSERT INTO Book(
		CallNumber,ISBN,SubID,Title,
		AuthName,Publisher,NoOfCopy,NoInLib)
		VALUES(@CallNumber,@ISBN,@SubID,@Title,
		@Author,@Publisher,@NoOfCopy,@NoInLib) 
	
--Procedure to edit a book
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_EditBook' AND type = 'P')
   DROP PROCEDURE sp_EditBook
GO
CREATE PROC sp_EditBook
(
	@CallNumber VARCHAR(9),
	@fixCallNumber VARCHAR(9),
	@ISBN VARCHAR(8),
	@SubID INT,
	@Title VARCHAR(100),
	@AuthName VARCHAR(30),
	@Publisher VARCHAR(45),
	@NoOfCopy TINYINT,
	@NoInLib TINYINT
)
AS
	UPDATE Book SET
		CallNumber=@fixCallNumber,ISBN=@ISBN,SubID=@SubID,Title=@Title,
		AuthName=@AuthName,Publisher=@Publisher,
		NoOfCopy=@NoOfCopy,NoInLib=@NoInLib
		WHERE CallNumber=@CallNumber
--Create procedure to get a book by call no
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetABook' AND type = 'P')
   DROP PROCEDURE sp_GetABook
GO
CREATE PROC sp_GetABook
	(@CallNumber VARCHAR(9))
AS
	SELECT * FROM Book WHERE CallNumber=@CallNumber

--Create procedure to get Subject by SubId
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetSubByID' AND type = 'P')
   DROP PROCEDURE sp_GetSubByID
GO
CREATE PROC sp_GetSubByID
	@SubID INT
AS
	SELECT * FROM Subject
	WHERE  SubID = @SubID
--Create procedure to get Subject by SubName
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetSubByName' AND type = 'P')
   DROP PROCEDURE sp_GetSubByName
GO
CREATE PROC sp_GetSubByName
	@SubName VARCHAR(45)
AS
	SELECT * FROM Subject 
	WHERE SubName LIKE '%'+@SubName+'%'
--Create procedure to get Subject by SubID and SubName
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetSubByAll' AND type = 'P')
   DROP PROCEDURE sp_GetSubByAll
GO
CREATE PROC sp_GetSubByAll
	@SubId INT,
	@SubName VARCHAR(45)
AS
	SELECT * FROM Subject
	WHERE SubID = @SubID AND SubName LIKE '%'+@SubName+'%'
--Create procedure to get subject ID by name
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetSubID' AND type = 'P')
   DROP PROCEDURE sp_GetSubID
GO
CREATE PROC sp_GetSubID
	(@SubName VARCHAR(45))
AS
	SELECT SubID FROM Subject WHERE SubName=@SubName
--Create procedure to get subject Name by ID
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetSubName' AND type = 'P')
   DROP PROCEDURE sp_GetSubName
GO
CREATE PROC sp_GetSubName
	(@SubID INT)
AS
	SELECT SubName FROM Subject WHERE SubID=@SubID
--Create procedure to get all subject
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetAllSub' AND type = 'P')
   DROP PROCEDURE sp_GetAllSub
GO
CREATE PROC sp_GetAllSub
AS
	SELECT * FROM Subject
--Create procedure to get all subject name
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetAllSubName' AND type = 'P')
   DROP PROCEDURE sp_GetAllSubName
GO
CREATE PROC sp_GetAllSubName
AS
	SELECT SubName FROM Subject
--Create procedure to insert Subject
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_AddSub' AND type = 'P')
   DROP PROCEDURE sp_AddSub
GO
CREATE PROC sp_AddSub
(
	@SubName VARCHAR(45),
	@Description VARCHAR(200)
)
AS
	INSERT INTO Subject(
		SubName,Description)
		VALUES(@SubName,@Description)
--procedure to edit Subject
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_EditSub' AND type = 'P')
   DROP PROCEDURE sp_EditSub
GO
CREATE PROC sp_EditSub
(
	@SubID int,
	@SubName VARCHAR(45),
	@Description VARCHAR(200)
)
AS
	UPDATE Subject SET SubName=@SubName,
		Description=@Description
		WHERE SubID=@SubID

--procedure to add a Borrow
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_AddBorrow' AND type = 'P')
   DROP PROCEDURE sp_AddBorrow
GO
CREATE PROC sp_AddBorrow
(
	@CallNumber VARCHAR(45),
	@EmpID int,
	@IssueStatus bit,
	@IssueDate DATETIME,
	@DueDate DATETIME,
	@ReturnDate DATETIME,
	@TotalFee float
)
AS
	INSERT INTO Borrow(
		CallNumber,EmpID,IssueStatus,
		IssueDate,DueDate,ReturnDate,TotalFee)
		VALUES(@CallNumber,@EmpID,@IssueStatus,
				@IssueDate,@DueDate,@ReturnDate,@TotalFee)

--get a borrow by CallNumber and EmpName
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetBorrowByAll' AND type = 'P')
   DROP PROCEDURE sp_GetBorrowByAll
GO
CREATE PROC sp_GetBorrowByAll
	@CallNumber INT,
	@EmpName VARCHAR(45)
AS
	SELECT	b.BorID,b.EmpID,e.[Name],
			b.CallNumber,b.IssueDate,b.ReturnDate
	FROM	Borrow b INNER JOIN Employee e
	ON		b.EmpID = e.EmpID
	WHERE	CallNumber LIKE '%'+@CallNumber+'%' AND
			[Name] LIKE '%'+@EmpName+'%'

--Edit a borrow

IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_AddBorrow' AND type = 'P')
   DROP PROCEDURE sp_AddBorrow
GO
CREATE PROC sp_AddBorrow
(
	@CallNumber VARCHAR(45),
	@EmpID int,
	@IssueStatus bit,
	@IssueDate DATETIME,
	@DueDate DATETIME,
	@ReturnDate DATETIME,
	@TotalFee float
)
AS
	UPDATE Borrow SET
		CallNumber=@CallNumber,EmpID=@EmpID,IssueStatus=@IssueStatus,
		IssueDate=@IssueDate,DueDate=@DueDate,ReturnDate=@ReturnDate,
		TotalFee=@TotalFee
		WHERE CallNumber=@CallNumber
--Top 10 Book
--IF EXISTS (SELECT name FROM sysobjects
--         WHERE name = 'sp_TopBook' AND type = 'P')
--   DROP PROCEDURE sp_TopBook
--CREATE PROC sp_TopBook
--AS
--	SELECT


--Procedure get newest EMP
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetNewestEmp' AND type = 'P')
   DROP PROCEDURE sp_GetNewestEmp
GO
CREATE PROC sp_GetNewestEmp
AS
	SELECT TOP 1 EmpID FROM Employee ORDER BY EmpID DESC
--Procedure get newest SUBJECT
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetNewestSub' AND type = 'P')
   DROP PROCEDURE sp_GetNewestSub
GO
CREATE PROC sp_GetNewestSub
AS
	SELECT TOP 1 SubID FROM Subject ORDER BY SubID DESC
--Procedure get fee
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetFee' AND type = 'P')
   DROP PROCEDURE sp_GetFee
GO
CREATE PROC sp_GetFee
AS
	SELECT * FROM Fee WHERE Fee='Fee'
-----------------------------
sp_InsLib 'root','07/27/1991',0,'cuongnqgc00033@fpt.edu.vn',
'63a9f0ea7bb98050796b649e85481845','Ha Noi','0986948677','GC0502'

INSERT INTO Fee VALUES ('Fee',0,0.1)

select * from dbo.Employee

sp_GetEmp 4

sp_Login 'root','root'

DELETE FROM Employee
--Add some sample entity
EXEC sp_AddSub 'Kid','Books for children'
EXEC sp_AddSub 'Teen','Books for teenage'
EXEC sp_AddSub 'Horror','Horror books , horror fiction'
EXEC sp_AddSub 'Romance','Romance books'
EXEC sp_AddSub 'Travel','Travel books, travel guides,travel writting'


EXEC sp_AddBook 'EL-CH-001','993-0001',1,'Elf on the Shelf','Chanda A. Bell',
'CCA and B, LLC',10
EXEC sp_AddBook 'TH-RI-002','927-0002',1,'The Lost Hero','Rick Riordan',
'Hyperion',17
EXEC sp_AddBook 'Aw-Kr-003','978-0003',2,'Awakened','Kristin Cast',
'St. Martins Press',01
EXEC sp_AddBook 'An-Da-004','326-0004',2,'Anatomy of a Boyfriend','Daria Snadowsky',
'Random House Childrens Books',22
EXEC sp_AddBook 'Of-Ba-005','299-0005',1,'Of Thee I Sing: A Letter to My Daughters','Barack Obama',
'Random House Childrens Books',29

EXEC sp_AddBorrow 'El-Ch-001',3,1,'1/1/2011','1/6/2011',Null,5

EXEC sp_DelEmp 3

select * from Employee

select * from Book

select * from Subject

select * from Borrow

select * from Borrow B JOIN BorrowDetail D WHERE B.BorID=D.BorID

update Book set NoInLib=5 where ISBN='978-1402'