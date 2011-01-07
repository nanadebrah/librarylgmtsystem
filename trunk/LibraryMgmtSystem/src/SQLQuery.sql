--Create database
CREATE DATABASE Library
go

--Use database
USE Library
go

/* CREATE TABLE */
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
	BookID INT IDENTITY NOT NULL,
	CallNumber VARCHAR(9) NOT NULL,
	ISBN VARCHAR(8) NOT NULL,
	SubID INT NOT NULL,
	Title VARCHAR(100) NOT NULL,
	AuthName VARCHAR(30) NOT NULL,
	Publisher VARCHAR(45) NOT NULL,
	NoOfCopy TINYINT NOT NULL,
	NoInLib TINYINT NOT NULL,
	CONSTRAINT pk_BookID PRIMARY KEY (BookID),
	CONSTRAINT uq_CallNumber UNIQUE (CallNumber),
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

/********************************************************************/

/* EMPLOYEE */
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

--Procedure get newest EMP
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetNewestEmp' AND type = 'P')
   DROP PROCEDURE sp_GetNewestEmp
GO
CREATE PROC sp_GetNewestEmp
AS
	SELECT TOP 1 EmpID FROM Employee ORDER BY EmpID DESC
/*-------------------------------------------------------------------*/


/* LOGIN */
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
/*--------------------------------------------------------------------*/


/* SUBJECT */
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

--Procedure get newest SUBJECT
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetNewestSub' AND type = 'P')
   DROP PROCEDURE sp_GetNewestSub
GO
CREATE PROC sp_GetNewestSub
AS
	SELECT TOP 1 SubID FROM Subject ORDER BY SubID DESC

/*-----------------------------------------------------*/

/* BOOK */
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
	SELECT TOP 1 BookID FROM BOOK
	ORDER BY BookID DESC

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
	SELECT CallNumber,ISBN,SubID,
	Title,AuthName,Publisher,NoOfCopy,NoInLib
	FROM Book WHERE CallNumber=@CallNumber

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

/*-------------------------------------------------------*/

--Create procedure get newest borrow
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetNewestBorrowID' AND type = 'P')
   DROP PROCEDURE sp_GetNewestBorrowID
GO
CREATE PROC sp_GetNewestBorrowID
AS
	SELECT TOP 1 BorID FROM Borrow ORDER BY BorID DESC

/*---------------------------------------------------------*/

/* Borrow  Manage*/
--get a borrow by CallNumber
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetBorrowByCalNo' AND type = 'P')
   DROP PROCEDURE sp_GetBorrowByCalNo
GO
CREATE PROC sp_GetBorrowByCalNo
	(@CallNumber VARCHAR(9))
AS
	SELECT B.BorID,E.EmpID,E.[Name],BO.CallNumber,BO.Title,
	BD.IssueDate, BD.DueDate, BD.IssueStatus, BD.ReturnDate,BD.TotalFee
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.CallNumber=BO.CallNumber WHERE BO.CallNumber LIKE '%'+@CallNumber+'%'

--Get a borrow by emp name
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetBorrowByEmpID' AND type = 'P')
   DROP PROCEDURE sp_GetBorrowByEmpID
GO
CREATE PROC sp_GetBorrowByEmpID
	(@EmpID INT)
AS
	SELECT B.BorID,E.EmpID,E.[Name],BO.CallNumber,BO.Title,
	BD.IssueDate, BD.DueDate, BD.IssueStatus, BD.ReturnDate,BD.TotalFee
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.CallNumber=BO.CallNumber WHERE E.EmpID=@EmpID

--Get a borrow by emp name
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetBorrowByBoth' AND type = 'P')
   DROP PROCEDURE sp_GetBorrowByBoth
GO
CREATE PROC sp_GetBorrowByBoth
	(@CallNumber VARCHAR(9),@EmpID INT)
AS
	SELECT B.BorID,E.EmpID,E.[Name],BO.CallNumber,BO.Title,
	BD.IssueDate, BD.DueDate, BD.IssueStatus, BD.ReturnDate,BD.TotalFee
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.CallNumber=BO.CallNumber WHERE BO.CallNumber LIKE
	'%'+@CallNumber+'%' AND E.EmpID=@EmpID

--Get all borrow to table
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetAllBorrow' AND type = 'P')
   DROP PROCEDURE sp_GetAllBorrow
GO
CREATE PROC sp_GetAllBorrow
AS
	SELECT B.BorID,E.EmpID,E.[Name],BO.CallNumber,BO.Title,
	BD.IssueDate, BD.DueDate, BD.IssueStatus, BD.ReturnDate,BD.TotalFee
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.CallNumber=BO.CallNumber

--View Borrow FULL information
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetFullBorrowInfo' AND type = 'P')
   DROP PROCEDURE sp_GetFullBorrowInfo
GO
CREATE PROC sp_GetFullBorrowInfo
	(
		@BorID INT,
		@EmpID INT,
		@CallNumber VARCHAR(9)
	)
AS
	SELECT E.EmpID,E.[Name],E.DOB,E.Gender,E.Email,E.Department,
	E.Address,E.Phone,E.Permission,BD.BorID,BD.IssueStatus,
	BD.IssueDate,BD.DueDate,BD.ReturnDate,BD.TotalFee,
	BO.CallNumber,BO.ISBN,BO.Title,BO.AuthName,BO.Publisher
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.CallNumber=BO.CallNumber WHERE BD.BorID=@BorID
	AND E.EmpID=@EmpID AND BO.CallNumber=@CallNumber
/* ---------------------------------------------------------------- */


/* CHECK OUT */
-- Prepare check out. Create new new Order ID and Employee check out
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_PrepareCheckOut' AND type = 'P')
   DROP PROCEDURE sp_PrepareCheckOut
GO
CREATE PROC sp_PrepareCheckOut
	(@EmpID INT)
AS
	INSERT INTO Borrow(EmpID) VALUES (@EmpID)

--Check out, add new check out to borrow and borrow detail
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_CheckOut' AND type = 'P')
   DROP PROCEDURE sp_CheckOut
GO
CREATE PROC sp_CheckOut
	(
		@CallNumber VARCHAR(9),
		@IssueDate DATETIME,
		@DueDate DATETIME
	)
AS
	BEGIN	
	DECLARE @BorID INT
	SELECT TOP 1 @BorID=BorID FROM Borrow ORDER BY BorID DESC	

	INSERT INTO BorrowDetail(BorID,CallNumber,IssueStatus,IssueDate,DueDate)
	VALUES(@BorID,@CallNumber,0,@IssueDate,@DueDate)

	UPDATE Book SET NoInLib=NoInLib-1 WHERE CallNumber=@CallNumber
	END
/*------------------------------------------------------------------*/

/* SEARCH CHECK-OUT */ 
--Get all check out information to check in
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_SearhAllCheckOut' AND type = 'P')
   DROP PROCEDURE sp_SearhAllCheckOut
GO
CREATE PROC sp_SearhAllCheckOut
AS
	SELECT B.BorID,E.EmpID,BO.CallNumber,BO.ISBN,BO.Title,BO.AuthName,
	BO.Publisher,BD.DueDate,BD.IssueDate
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.CallNumber=BO.CallNumber
	AND BD.IssueStatus=0

--Search Check out information by borrow id
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_SearhCheckOutByBorID' AND type = 'P')
   DROP PROCEDURE sp_SearhCheckOutByBorID
GO
CREATE PROC sp_SearhCheckOutByBorID
	(@BorID INT)
AS
	SELECT B.BorID,E.EmpID,BO.CallNumber,BO.ISBN,BO.Title,BO.AuthName,
	BO.Publisher,BD.DueDate,BD.IssueDate
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.CallNumber=BO.CallNumber WHERE B.BorID=@BorID
	AND BD.IssueStatus=0

--Search Check out information by book information
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_SearhCheckOutByBookInfo' AND type = 'P')
   DROP PROCEDURE sp_SearhCheckOutByBookInfo
GO
CREATE PROC sp_SearhCheckOutByBookInfo
	(
		@CallNumber VARCHAR(9),
		@ISBN VARCHAR(8),
		@Title VARCHAR(100),
		@AuthName VARCHAR(30)
	)
AS
	SELECT B.BorID,E.EmpID,BO.CallNumber,BO.ISBN,BO.Title,BO.AuthName,
	BO.Publisher,BD.DueDate,BD.IssueDate
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.CallNumber=BO.CallNumber WHERE
	BO.CallNumber LIKE '%'+@CallNumber+'%'
	AND BO.ISBN LIKE '%'+@ISBN+'%'
	AND BO.Title LIKE '%'+@Title+'%'
	AND BO.AuthName LIKE '%'+@AuthName+'%'
	AND BD.IssueStatus=0

--Search Check out information by employee information
--By EmpID
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_SearhCheckOutByEmpID' AND type = 'P')
   DROP PROCEDURE sp_SearhCheckOutByEmpID
GO
CREATE PROC sp_SearhCheckOutByEmpID
	(@EmpID INT)
AS
	SELECT B.BorID,E.EmpID,BO.CallNumber,BO.ISBN,BO.Title,BO.AuthName,
	BO.Publisher,BD.DueDate,BD.IssueDate
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.CallNumber=BO.CallNumber WHERE E.EmpID=@EmpID
	AND BD.IssueStatus=0

--By EmpName
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_SearhCheckOutByEmpName' AND type = 'P')
   DROP PROCEDURE sp_SearhCheckOutByEmpName
GO
CREATE PROC sp_SearhCheckOutByEmpName
	(@Name VARCHAR(45))
AS
	SELECT B.BorID,E.EmpID,BO.CallNumber,BO.ISBN,BO.Title,BO.AuthName,
	BO.Publisher,BD.DueDate,BD.IssueDate
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.CallNumber=BO.CallNumber WHERE E.[Name] LIKE '%'+@Name+'%'
	AND BD.IssueStatus=0

--By EmpID & EmpName
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_SearhCheckOutByAllEmpInfo' AND type = 'P')
   DROP PROCEDURE sp_SearhCheckOutByAllEmpInfo
GO
CREATE PROC sp_SearhCheckOutByAllEmpInfo
	(
		@EmpID INT,
		@Name VARCHAR(45)
	)
AS
	SELECT B.BorID,E.EmpID,BO.CallNumber,BO.ISBN,BO.Title,BO.AuthName,
	BO.Publisher,BD.DueDate,BD.IssueDate
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.CallNumber=BO.CallNumber WHERE
	E.EmpID=@EmpID AND E.[Name] LIKE '%'+@Name+'%'
	AND BD.IssueStatus=0

/*----------------------------------------------------------------*/

/*CHECK IN*/
---------------------------------------------------------------
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_CheckIn' AND type = 'P')
   DROP PROCEDURE sp_CheckIn
GO
CREATE PROC sp_CheckIn
	(
		@BorID INT,
		@CallNumber VARCHAR(9),
		@ReturnDate DATETIME,
		@TotalFee FLOAT		
	)
AS
	BEGIN
		UPDATE BorrowDetail SET ReturnDate=@ReturnDate,
		TotalFee=@TotalFee,IssueStatus=1 WHERE
		BorID=@BorID AND CallNumber=@CallNumber

		UPDATE Book SET NoInLib=NoInLib+1 WHERE
		CallNumber=@CallNumber
	END
/*------------------------------------------------------*/

/* FEE */
--Procedure get fee
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetFee' AND type = 'P')
   DROP PROCEDURE sp_GetFee
GO
CREATE PROC sp_GetFee
AS
	SELECT * FROM Fee WHERE Fee='Fee'

--Procedure edit fee
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_EditFee' AND type = 'P')
   DROP PROCEDURE sp_EditFee
GO
CREATE PROC sp_EditFee
	(@BorFee FLOAT,
	@LateFee FLOAT)
AS
	UPDATE Fee SET BorFee=@BorFee,LateFee=@LateFee
	WHERE Fee='Fee'
-----------------------------

/* DEFAULT VALUE */

--Insert default user with User&Pass [root|root]
sp_InsLib 'root','07/27/1991',1,'cuongnqgc00033@fpt.edu.vn',
'63a9f0ea7bb98050796b649e85481845','Ha Noi','0986948677','GC0502'

--Insert default fee value
INSERT INTO Fee VALUES ('Fee',0,0.1)

/*--------------------------------------------------------------*/

select * from dbo.Employee


EXEC sp_DelEmp 3

select * from Employee

select * from Book

select * from Subject

select * from Borrow

select * from BorrowDetail

select * from Borrow B JOIN BorrowDetail D ON B.BorID=D.BorID

select IssueStatus from Borrow B JOIN BorrowDetail BD
ON B.BorID=BD.BorID WHERE DB.BorID=3

update Book set NoInLib=5 where ISBN='978-1402'

SELECT E.EmpID,E.[Name],E.DOB,E.Gender,E.Email,E.Department,
E.Address,E.Phone,E.Permission,BD.BorID,BD.IssueStatus,
BD.IssueDate,BD.DueDate,BD.ReturnDate,BD.TotalFee,
BO.CallNumber,BO.ISBN,BO.Title,BO.AuthName,BO.Publisher
FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
ON BD.CallNumber=BO.CallNumber

SELECT * FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID