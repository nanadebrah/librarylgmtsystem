--Create database
USE master
GO
IF EXISTS (SELECT NAME FROM sys.databases
         WHERE NAME = 'Library')
   DROP DATABASE Library
GO
CREATE DATABASE Library
GO

--Use database
USE Library
GO

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
GO

--Create Subject table
CREATE TABLE Subject(
	SubID INT NOT NULL IDENTITY,
	SubName VARCHAR(45) NOT NULL,
	Description VARCHAR(200),
	CONSTRAINT pk_SubID PRIMARY KEY (SubID)
)
GO

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
	CONSTRAINT uq_CallNumber UNIQUE (CallNumber,ISBN),
	CONSTRAINT fk_SubID FOREIGN KEY (SubID)
		REFERENCES Subject(SubID),
)
GO

--Create Borrow table
CREATE TABLE Borrow
	(
	BorID INT NOT NULL IDENTITY,
	EmpID INT NOT NULL,
	
	CONSTRAINT pk_BorID PRIMARY KEY (BorID),
	CONSTRAINT fk_EmpID FOREIGN KEY (EmpID)
		REFERENCES Employee(EmpID)
	)
GO

--Create BorrowDetail table
CREATE TABLE BorrowDetail
(	
	BorID INT NOT NULL REFERENCES Borrow(BorID),
	BookID INT NOT NULL,
	IssueStatus BIT NOT NULL,
	IssueDate DATETIME NOT NULL,
	DueDate DATETIME NOT NULL,
	ReturnDate DATETIME,
	TotalFee FLOAT,
	CONSTRAINT fk_BookID FOREIGN KEY (BookID)
		REFERENCES Book(BookID)
)
GO

--Create Fee table
CREATE TABLE Fee(
	Fee VARCHAR(10) NOT NULL PRIMARY KEY,
	BorFee FLOAT NOT NULL,
	LateFee FLOAT NOT NULL
)

/********************************************************************/

/* EMPLOYEE */
-----------------------------------
-----------------------------------
--Create Procedure insert employee
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_AddEmp' AND TYPE = 'P')
   DROP PROCEDURE sp_AddEmp
GO
CREATE PROC sp_AddEmp
(
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
GO
--Create Procedure insert librarian
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_AddLib' AND TYPE = 'P')
   DROP PROCEDURE sp_AddLib
GO
CREATE PROC sp_AddLib
(
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
	IF NOT EXISTS (SELECT [Name] FROM Employee
		WHERE [Name]=@Name)

		INSERT INTO Employee(
		[Name],DOB,Gender,Email,Password,
		Address,Phone,Permission,Department)
		VALUES(@Name,@DOB,@Gender,@Email,@Password,
		@Address,@Phone,1,@Department)
	ELSE
		SELECT 'ERROR'
	END
GO
--get an employee with one parameter : NAME
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_GetAnEmpWithName' AND TYPE = 'P')
   DROP PROCEDURE sp_GetAnEmpWithName
GO
CREATE PROC sp_GetAnEmpWithName
	(
		@Name VARCHAR(45),
		@PageIndex INT,
		@NumRows INT,
		@TotalPage INT OUTPUT
	)
AS
	BEGIN
	SELECT @TotalPage=COUNT(*) FROM Employee
	WHERE [Name] LIKE '%'+@Name+'%'
	DECLARE @startRowIndex INT
	SET @startRowIndex = (@PageIndex * @NumRows) + 1;
	WITH Temp AS
		(
			SELECT ROW_NUMBER() OVER (ORDER BY EmpID ASC) AS [No],
			EmpID,[Name],Gender,Email,Department,Permission
			FROM Employee WHERE [Name] LIKE '%'+@Name+'%'
		)
	SELECT EmpID,[Name],CASE Gender WHEN 1 THEN 'Male'
	ELSE 'Female' END AS 'Gender',Email,Department,
	CASE Permission WHEN 1 THEN 'Librarin' ELSE
	'Employee' END AS 'Permission'
	FROM Temp
	WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
	END
GO
--get an employee with one parameter : EmpID
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_GetAnEmpWithEmpID' AND TYPE = 'P')
   DROP PROCEDURE sp_GetAnEmpWithEmpID
GO
CREATE PROC sp_GetAnEmpWithEmpID
	(
		@EmpID INT,
		@PageIndex INT,
		@NumRows INT,
		@TotalPage INT OUTPUT
	)
AS
	BEGIN
	SELECT @TotalPage=COUNT(*) FROM Employee
	WHERE EmpID=@EmpID
	DECLARE @startRowIndex INT
	SET @startRowIndex = (@PageIndex * @NumRows) + 1;
	WITH Temp AS
		(
			SELECT ROW_NUMBER() OVER (ORDER BY EmpID ASC) AS [No],
			EmpID,[Name],Gender,Email,Department,Permission
			FROM Employee WHERE EmpID=@EmpID
		)
	SELECT EmpID,[Name],CASE Gender WHEN 1 THEN 'Male'
	ELSE 'Female' END AS 'Gender',Email,Department,
	CASE Permission WHEN 1 THEN 'Librarin' ELSE
	'Employee' END AS 'Permission'
	FROM Temp
	WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
	END
GO
--Create Procedure get all field of a Employee
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_GetEmpInfo' AND TYPE = 'P')
   DROP PROCEDURE sp_GetEmpInfo
GO
CREATE PROC sp_GetEmpInfo
	(@EmpID INT)
AS
	BEGIN
		SELECT * FROM Employee
		WHERE EmpID=@EmpID
	END
GO
--Create Procedure get all borrow info of Employee

IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_GetEmpBorowInfo' AND TYPE = 'P')
   DROP PROCEDURE sp_GetEmpBorowInfo
GO
CREATE PROC sp_GetEmpBorowInfo
	(@EmpID INT)
AS
	SELECT B.BorID, BO.BookID,BO.CallNumber,BO.Title,BD.IssueDate,
	BD.DueDate,CASE BD.IssueStatus WHEN 1 THEN 'Checked-In'
	ELSE 'Checked-Out' END AS 'IssueStatus',BD.ReturnDate,BD.TotalFee
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Book BO ON BD.BookID=BO.BookID
	WHERE B.EmpID=@EmpID
GO
--Create Procedure get all field of all Employee (Pages)
IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_GetAllEmp' AND TYPE = 'P')
   DROP PROCEDURE sp_GetAllEmp
GO
CREATE PROC sp_GetAllEmp
	(
		@PageIndex INT,
		@NumRows INT,
		@TotalPage INT OUTPUT
	)
AS
BEGIN
SELECT @TotalPage=COUNT(*) FROM Employee
DECLARE @startRowIndex INT
SET @startRowIndex = (@PageIndex * @NumRows) + 1;
WITH Temp AS
	(
		SELECT ROW_NUMBER() OVER (ORDER BY EmpID ASC) AS [No],
		EmpID,[Name],Gender,Email,Department,Permission FROM Employee
	)
SELECT EmpID,[Name],Gender,Email,Department,Permission
FROM Temp
WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
END
GO

--Create Procedure edit Employee
IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_EditEmp' AND TYPE = 'P')
   DROP PROCEDURE sp_EditEmp
GO
CREATE PROC sp_EditEmp
(
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
GO
--Create Procedure edit Librarian

IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_EditLib' AND TYPE = 'P')
   DROP PROCEDURE sp_EditLib
GO
CREATE PROC sp_EditLib
(
	@EmpID INT,
	@Name VARCHAR(45),
	@fixName VARCHAR(45),
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
	IF NOT EXISTS (SELECT [Name] FROM Employee
	WHERE [Name]=@fixName AND EmpID<>@EmpID)
		UPDATE Employee SET
		[Name]=@fixName,DOB=@DOB,Gender=@Gender,Email=@Email,
			Password=@Password,Address=@Address,
				Phone=@Phone,Department=@Department
		WHERE EmpID=@EmpID
	ELSE
		SELECT 'ERROR'
	END
GO
-- delete an Employee 
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_DelEmp' AND TYPE = 'P')
   DROP PROCEDURE sp_DelEmp
GO
CREATE PROC sp_DelEmp
	(@EmpID INT)
AS
	BEGIN
		IF NOT EXISTS
		(
			SELECT TOP 1 EmpID FROM Borrow B JOIN
			BorrowDetail BD ON B.BorID=BD.BorID
			WHERE EmpID = @EmpID AND IssueStatus = 0
		)
		BEGIN
		DELETE FROM BorrowDetail WHERE BorID
		=(SELECT TOP 1 B.BorID FROM Borrow B JOIN 
		BorrowDetail BD ON B.BorID=BD.BorID
		WHERE B.EmpID=@EmpID)
		DELETE FROM Borrow WHERE EmpID=@EmpID
		DELETE FROM Employee WHERE EmpID = @EmpID
		END
		ELSE
			SELECT 'ERROR'
	END
GO
/*-------------------------------------------------------------------*/


/* LOGIN */
--Create Procedure Login
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_Login' AND TYPE = 'P')
   DROP PROCEDURE sp_Login
GO
CREATE PROC sp_Login
(
	@Name VARCHAR(45),
	@Password VARCHAR(32)
)
AS
	BEGIN
		SELECT EmpID FROM Employee
		WHERE [Name]=@Name AND Password=@Password
			AND Permission=1
	END
GO
/*--------------------------------------------------------------------*/


/* SUBJECT */
--Create procedure to get Subject by SubName
IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_GetSubByName' AND TYPE = 'P')
   DROP PROCEDURE sp_GetSubByName
GO
CREATE PROC sp_GetSubByName
	(
		@SubName VARCHAR(45),
		@PageIndex INT,
		@NumRows INT,
		@TotalPage INT OUTPUT
	)
AS
BEGIN
	SELECT @TotalPage=COUNT(*) FROM Subject
	WHERE SubName LIKE '%'+@SubName+'%'
	DECLARE @startRowIndex INT
	SET @startRowIndex = (@PageIndex * @NumRows) + 1;
	WITH Temp AS
		(
			SELECT ROW_NUMBER() OVER (ORDER BY SubID ASC) AS [No],
			* FROM Subject WHERE SubName LIKE '%'+@SubName+'%'
		)
	SELECT SubID,SubName,Description FROM Temp
	WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
END

--Create procedure to get subject ID by NAME
IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_GetSubByID' AND TYPE = 'P')
   DROP PROCEDURE sp_GetSubByID
GO
CREATE PROC sp_GetSubByID
	(
		@SubID INT,
		@PageIndex INT,
		@NumRows INT,
		@TotalPage INT OUTPUT
	)
AS
BEGIN
	SELECT @TotalPage=COUNT(*) FROM Subject
	WHERE SubID=@SubID
	DECLARE @startRowIndex INT
	SET @startRowIndex = (@PageIndex * @NumRows) + 1;
	WITH Temp AS
		(
			SELECT ROW_NUMBER() OVER (ORDER BY SubID ASC) AS [No],
			* FROM Subject WHERE SubID=@SubID
		)
	SELECT SubID,SubName,Description FROM Temp
	WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
END
GO

--Create procedure to get subject ID by Name
IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_GetSubName' AND TYPE = 'P')
   DROP PROCEDURE sp_GetSubName
GO
CREATE PROC sp_GetSubName
	(@SubID INT)
AS
	SELECT SubName FROM Subject WHERE SubID=@SubID
GO
--Create procedure to get subject ID by Name
IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_GetSubID' AND TYPE = 'P')
   DROP PROCEDURE sp_GetSubID
GO
CREATE PROC sp_GetSubID
	(@SubName VARCHAR(45))
AS
	SELECT SubID FROM Subject WHERE SubName=@SubName
GO
--Create procedure to get all subject NAME
IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_GetAllSubName' AND TYPE = 'P')
   DROP PROCEDURE sp_GetAllSubName
GO
CREATE PROC sp_GetAllSubName
AS
	SELECT SubName FROM Subject
GO
--Create procedure to insert Subject
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_AddSub' AND TYPE = 'P')
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
GO
--procedure to edit Subject
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_EditSub' AND TYPE = 'P')
   DROP PROCEDURE sp_EditSub
GO
CREATE PROC sp_EditSub
(
	@SubID int,
	@SubName VARCHAR(45),
	@Description VARCHAR(200)
)
AS
	BEGIN
	UPDATE Subject SET SubName=@SubName,
		Description=@Description
		WHERE SubID=@SubID
	END
GO
--Create procedure to get Subject by SubId
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_GetSub' AND TYPE = 'P')
   DROP PROCEDURE sp_GetSub
GO
CREATE PROC sp_GetSub
	@SubID INT
AS
	SELECT * FROM Subject
	WHERE  SubID = @SubID
GO
-- DELETE subject
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_DelSub' AND TYPE = 'P')
   DROP PROCEDURE sp_DelSub
GO
CREATE PROC sp_DelSub
	(@SubID INT)
AS
	BEGIN
		IF NOT EXISTS
		(
			SELECT TOP 1 SubID FROM Book
			WHERE SubID=@SubID
		)
		DELETE FROM Subject WHERE SubID=@SubID
		ELSE
			SELECT 'ERROR'
	END
GO
/*-----------------------------------------------------*/

/* BOOK */
--Create procedure to get Book 
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_SearchBook' AND TYPE = 'P')
   DROP PROCEDURE sp_SearchBook
GO
CREATE PROC sp_SearchBook
(
	@CallNumber VARCHAR(9),
	@ISBN VARCHAR(8),
	@Title VARCHAR(100),
	@AuthName VARCHAR(30),
	@PageIndex INT,
	@NumRows INT,
	@TotalPage INT OUTPUT
)
AS
	BEGIN
	SELECT @TotalPage=COUNT(BookID) FROM Book WHERE
			CallNumber LIKE '%'+@CallNumber+'%'	 
			AND ISBN LIKE '%'+@ISBN+'%'  
			AND Title LIKE '%'+@Title+'%' 
			AND AuthName LIKE '%'+@AuthName+'%'
	DECLARE @startRowIndex INT
	SET @startRowIndex = (@PageIndex * @NumRows) + 1;
	WITH Temp AS
		(
			SELECT ROW_NUMBER() OVER (ORDER BY BookID ASC) AS [No],BookID,
			CallNumber,ISBN,Title,AuthName,Publisher,S.SubName,NoOfCopy,
			NoInLib FROM Book B JOIN Subject S ON B.SubID=S.SubID WHERE
			CallNumber LIKE '%'+@CallNumber+'%'	 
			AND ISBN LIKE '%'+@ISBN+'%'  
			AND Title LIKE '%'+@Title+'%' 
			AND AuthName LIKE '%'+@AuthName+'%'
		)
	SELECT BookID,CallNumber,ISBN,Title,AuthName,Publisher,SubName,
	NoOfCopy,NoInLib FROM Temp
	WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
	END
GO
--procedure to get newest book added
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_GetNewestBookID' AND TYPE = 'P')
   DROP PROCEDURE sp_GetNewestBookID
GO
CREATE PROC sp_GetNewestBookID
AS
	SELECT TOP 1 BookID FROM BOOK
	ORDER BY BookID DESC
GO
--procedure to insert a book 
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_AddBook' AND TYPE = 'P')
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
	IF NOT EXISTS
	(
		SELECT ISBN FROM Book
		WHERE ISBN=@ISBN		
	)	
	BEGIN
	INSERT INTO Book(
	CallNumber,ISBN,SubID,Title,
	AuthName,Publisher,NoOfCopy,NoInLib)
	VALUES(@CallNumber,@ISBN,@SubID,@Title,
	@Author,@Publisher,@NoOfCopy,@NoInLib)
	END
	ELSE
		SELECT 'ERROR'	 
GO
--Procedure to edit a book
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_EditBook' AND TYPE = 'P')
   DROP PROCEDURE sp_EditBook
GO
CREATE PROC sp_EditBook
(
	@BookID INT,
	@CallNumber VARCHAR(9),
	@ISBN VARCHAR(8),
	@SubID INT,
	@Title VARCHAR(100),
	@AuthName VARCHAR(30),
	@Publisher VARCHAR(45),
	@NoOfCopy TINYINT,
	@NoInLib TINYINT
)
AS
	BEGIN
	IF NOT EXISTS (SELECT ISBN FROM Book
	WHERE ISBN=@ISBN AND BookID<>@BookID)
	BEGIN
		UPDATE Book SET
			CallNumber=@CallNumber,ISBN=@ISBN,SubID=@SubID,Title=@Title,
			AuthName=@AuthName,Publisher=@Publisher,
			NoOfCopy=@NoOfCopy,NoInLib=@NoInLib
			WHERE BookID=@BookID
	END
	ELSE
		SELECT 'ERROR'
	END
GO
--Create procedure to get a book by call no
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_GetBookInfo' AND TYPE = 'P')
   DROP PROCEDURE sp_GetBookInfo
GO
CREATE PROC sp_GetBookInfo
	(@BookID INT)
AS
	SELECT BookID,CallNumber,ISBN,S.SubName,
	Title,AuthName,Publisher,NoOfCopy,NoInLib
	FROM Book B JOIN Subject S ON B.SubID=S.SubID
	WHERE BookID=@BookID
GO
--Create Procedure get book's borrow info

IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_GetBookBorInfo' AND TYPE = 'P')
   DROP PROCEDURE sp_GetBookBorInfo
GO
CREATE PROC sp_GetBookBorInfo
	(@BookID INT)
AS
	SELECT B.BorID, E.EmpID, E.[Name],E.Department,BD.IssueDate,
	BD.DueDate,CASE BD.IssueStatus WHEN 1 THEN 'Checked-In' 
	ELSE 'Checked-Out' END AS 'IssueStatus',BD.ReturnDate,BD.TotalFee
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON E.EmpID=B.EmpID
	WHERE BookID=@BookID

GO
--- DELETE BOOK
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_DelBook' AND TYPE = 'P')
   DROP PROCEDURE sp_DelBook
GO
CREATE PROC sp_DelBook
	(@BookID INT)
AS
	BEGIN		
		IF NOT EXISTS
		(
			SELECT TOP 1 BookID FROM BorrowDetail
			WHERE BookID=@BookID AND IssueStatus=0
		)
		BEGIN
		DELETE FROM BorrowDetail WHERE BookID=@BookID
		DELETE FROM Book WHERE BookID=@BookID
		END
		ELSE
			SELECT 'ERROR'
	END
GO
/*---------------------------------------------------------*/

/* Borrow  Manage*/
--get a borrow by CallNumber
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_GetBorrowByCalNo' AND TYPE = 'P')
   DROP PROCEDURE sp_GetBorrowByCalNo
GO
CREATE PROC sp_GetBorrowByCalNo
	(
		@CallNumber VARCHAR(9),
		@PageIndex INT,
		@NumRows INT,
		@TotalPage INT OUTPUT
	)
AS
BEGIN
	SELECT @TotalPage=COUNT(B.BorID) FROM Borrow B JOIN 
	BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.BookID=BO.BookID 
	WHERE BO.CallNumber LIKE '%'+@CallNumber+'%'
	DECLARE @startRowIndex INT
	SET @startRowIndex = (@PageIndex * @NumRows) + 1;
	WITH Temp AS
		(
			SELECT ROW_NUMBER() OVER (ORDER BY B.BorID ASC) AS [No],
			B.BorID,E.EmpID,BO.BookID,E.[Name],BO.CallNumber,BO.Title,
			BD.IssueDate, BD.DueDate, BD.IssueStatus, BD.ReturnDate,
			BD.TotalFee FROM Borrow B JOIN 
			BorrowDetail BD ON B.BorID=BD.BorID
			JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
			ON BD.BookID=BO.BookID  WHERE
			BO.CallNumber LIKE '%'+@CallNumber+'%'
		)
	SELECT	BorID,EmpID,BookID,[Name],CallNumber,Title,
			IssueDate, DueDate, IssueStatus,
			ReturnDate, TotalFee
	FROM Temp
	WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
END
GO
--Get a borrow by emp id
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_GetBorrowByEmpID' AND TYPE = 'P')
   DROP PROCEDURE sp_GetBorrowByEmpID
GO
CREATE PROC sp_GetBorrowByEmpID
	(	
		@EmpID INT,
		@PageIndex INT,
		@NumRows INT,
		@TotalPage INT OUTPUT	
	)
AS
BEGIN
	SELECT @TotalPage=COUNT(*) FROM Borrow B JOIN 
	BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.BookID=BO.BookID 
	WHERE E.EmpID=@EmpID
	DECLARE @startRowIndex INT
	SET @startRowIndex = (@PageIndex * @NumRows) + 1;
	WITH Temp AS
		(
			SELECT ROW_NUMBER() OVER (ORDER BY B.BorID ASC) AS [No],
			B.BorID,E.EmpID,BO.BookID,E.[Name],BO.CallNumber,BO.Title,
			BD.IssueDate, BD.DueDate, BD.IssueStatus, BD.ReturnDate,
			BD.TotalFee FROM Borrow B JOIN 
			BorrowDetail BD ON B.BorID=BD.BorID
			JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
			ON BD.BookID=BO.BookID  WHERE
			E.EmpID=@EmpID
		)
	SELECT	BorID,EmpID,BookID,[Name],CallNumber,Title,
			IssueDate, DueDate, IssueStatus,
			ReturnDate, TotalFee
	FROM Temp
	WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
END
GO
--View Borrow FULL information
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_GetFullBorrowInfo' AND TYPE = 'P')
   DROP PROCEDURE sp_GetFullBorrowInfo
GO
CREATE PROC sp_GetFullBorrowInfo
	(
		@BorID INT,
		@EmpID INT,
		@BookID INT
	)
AS
	SELECT E.EmpID,E.[Name],E.DOB,E.Gender,E.Email,E.Department,
	E.Address,E.Phone,E.Permission,BD.BorID,BD.IssueStatus,
	BD.IssueDate,BD.DueDate,BD.ReturnDate,BD.TotalFee,
	BO.CallNumber,BO.ISBN,BO.Title,BO.AuthName,BO.Publisher,S.SubName
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.BookID=BO.BookID JOIN Subject S ON S.SubID=BO.SubID
	WHERE BD.BorID=@BorID AND E.EmpID=@EmpID AND BO.BookID=@BookID
GO
-- DELETE BORROW
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_DelBorrow' AND TYPE = 'P')
   DROP PROCEDURE sp_DelBorrow
GO
CREATE PROC sp_DelBorrow
	(
		@BorID INT,
		@BookID INT
	)
AS
	BEGIN		
		IF NOT EXISTS
		(
			SELECT TOP 1 BookID FROM BorrowDetail
			WHERE BookID=BookID AND BorID=@BorID
			AND IssueStatus=0
		)
		BEGIN
		DELETE FROM BorrowDetail WHERE BookID=BookID
		AND BorID=@BorID
		END
		ELSE
			SELECT 'ERROR'
	END
GO
/* ---------------------------------------------------------------- */


/* CHECK OUT */
-- Prepare check out. Create new new Order ID and Employee check out
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_PrepareCheckOut' AND TYPE = 'P')
   DROP PROCEDURE sp_PrepareCheckOut
GO
CREATE PROC sp_PrepareCheckOut
	(@EmpID INT)
AS
	INSERT INTO Borrow(EmpID) VALUES (@EmpID)
GO
--Check out, add new check out to borrow and borrow detail
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_CheckOut' AND TYPE = 'P')
   DROP PROCEDURE sp_CheckOut
GO
CREATE PROC sp_CheckOut
	(
		@BookID INT,
		@IssueDate DATETIME,
		@DueDate DATETIME
	)
AS
	BEGIN	
	DECLARE @BorID INT
	SELECT TOP 1 @BorID=BorID FROM Borrow ORDER BY BorID DESC	

	INSERT INTO BorrowDetail(BorID,BookID,IssueStatus,IssueDate,DueDate)
	VALUES(@BorID,@BookID,0,@IssueDate,@DueDate)

	UPDATE Book SET NoInLib=NoInLib-1 WHERE BookID=@BookID
	END
GO
/*------------------------------------------------------------------*/

/* SEARCH CHECK-OUT */ 
--Search Check out information by borrow id
IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_SearhCheckOutByBorID' AND TYPE = 'P')
   DROP PROCEDURE sp_SearhCheckOutByBorID
GO
CREATE PROC sp_SearhCheckOutByBorID
	(@BorID INT)
AS
	SELECT B.BorID,E.EmpID,BO.CallNumber,BO.ISBN,BO.Title,BO.AuthName,
	BO.Publisher,BD.DueDate,BD.IssueDate
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.BookID=BO.BookID WHERE B.BorID=@BorID
	AND BD.IssueStatus=0
GO
--Search Check out information by book information
IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_SearhCheckOutByBookInfo' AND TYPE = 'P')
   DROP PROCEDURE sp_SearhCheckOutByBookInfo
GO
CREATE PROC sp_SearhCheckOutByBookInfo
	(
		@CallNumber VARCHAR(9),
		@ISBN VARCHAR(8),
		@Title VARCHAR(100),
		@AuthName VARCHAR(30),
		@PageIndex INT,
		@NumRows INT,
		@TotalPage INT OUTPUT
	)
AS
BEGIN
	SELECT @TotalPage=COUNT(B.BorID) FROM 
	Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.BookID=BO.BookID WHERE
	BO.CallNumber LIKE '%'+@CallNumber+'%'
	AND BO.ISBN LIKE '%'+@ISBN+'%'
	AND BO.Title LIKE '%'+@Title+'%'
	AND BO.AuthName LIKE '%'+@AuthName+'%'
	AND BD.IssueStatus=0
	DECLARE @startRowIndex INT
	SET @startRowIndex = (@PageIndex * @NumRows) + 1;
	WITH Temp AS
		(
			SELECT ROW_NUMBER() OVER (ORDER BY B.BorID ASC) AS [No],
			B.BorID,E.EmpID,BO.BookID,BO.CallNumber,BO.ISBN,BO.Title,BO.AuthName,
			BO.Publisher,BD.DueDate,BD.IssueDate
			FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
			JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
			ON BD.BookID=BO.BookID WHERE
			BO.CallNumber LIKE '%'+@CallNumber+'%'
			AND BO.ISBN LIKE '%'+@ISBN+'%'
			AND BO.Title LIKE '%'+@Title+'%'
			AND BO.AuthName LIKE '%'+@AuthName+'%'
			AND BD.IssueStatus=0
		)
	SELECT BorID,EmpID,BookID,CallNumber,ISBN,Title,AuthName,
	Publisher,DueDate,IssueDate
	FROM Temp
	WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
END
GO
--Search Check out information by employee information
--By EmpID
IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_SearhCheckOutByEmpID' AND TYPE = 'P')
   DROP PROCEDURE sp_SearhCheckOutByEmpID
GO
CREATE PROC sp_SearhCheckOutByEmpID
	(
		@EmpID INT,
		@PageIndex INT,
		@NumRows INT,
		@TotalPage INT OUTPUT
	)
AS
BEGIN
	SELECT @TotalPage=COUNT(B.BorID) FROM Borrow B JOIN
	BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.BookID=BO.BookID WHERE E.EmpID=@EmpID
	AND BD.IssueStatus=0
	DECLARE @startRowIndex INT
	SET @startRowIndex = (@PageIndex * @NumRows) + 1;
	WITH Temp AS
		(
			SELECT ROW_NUMBER() OVER (ORDER BY B.BorID ASC) AS [No],
			B.BorID,E.EmpID,BO.BookID,BO.CallNumber,BO.ISBN,BO.Title,
			BO.AuthName,BO.Publisher,BD.DueDate,BD.IssueDate FROM Borrow B JOIN 
			BorrowDetail BD ON B.BorID=BD.BorID
			JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
			ON BD.BookID=BO.BookID WHERE E.EmpID=@EmpID
			AND BD.IssueStatus=0
		)
	SELECT BorID,EmpID,BookID,CallNumber,ISBN,Title,AuthName,
	Publisher,DueDate,IssueDate
	FROM Temp
	WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
END
GO
--By EmpName
IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_SearhCheckOutByEmpName' AND TYPE = 'P')
   DROP PROCEDURE sp_SearhCheckOutByEmpName
GO
CREATE PROC sp_SearhCheckOutByEmpName
	(
		@Name VARCHAR(45),
		@PageIndex INT,
		@NumRows INT,
		@TotalPage INT OUTPUT
	)
AS
BEGIN
	SELECT @TotalPage=COUNT(B.BorID) FROM Borrow B JOIN
	BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.BookID=BO.BookID WHERE E.[Name] LIKE '%'+@Name+'%'
	AND BD.IssueStatus=0
	DECLARE @startRowIndex INT
	SET @startRowIndex = (@PageIndex * @NumRows) + 1;
	WITH Temp AS
		(
			SELECT ROW_NUMBER() OVER (ORDER BY B.BorID ASC) as [No],
			B.BorID,E.EmpID,BO.BookID,BO.CallNumber,BO.ISBN,BO.Title,
			BO.AuthName, BO.Publisher,BD.DueDate,BD.IssueDate FROM Borrow B JOIN 
			BorrowDetail BD ON B.BorID=BD.BorID
			JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
			ON BD.BookID=BO.BookID WHERE E.[Name] LIKE '%'+@Name+'%'
			AND BD.IssueStatus=0
		)
	SELECT BorID,EmpID,BookID,CallNumber,ISBN,Title,AuthName,
	Publisher,DueDate,IssueDate
	FROM Temp
	WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
END
GO
/*----------------------------------------------------------------*/

/*CHECK IN*/
---------------------------------------------------------------
IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_CheckIn' AND TYPE = 'P')
   DROP PROCEDURE sp_CheckIn
GO
CREATE PROC sp_CheckIn
	(
		@BorID INT,
		@BookID INT,
		@ReturnDate DATETIME,
		@TotalFee FLOAT		
	)
AS
	BEGIN
		UPDATE BorrowDetail SET ReturnDate=@ReturnDate,
		TotalFee=@TotalFee,IssueStatus=1 WHERE
		BorID=@BorID AND BookID=@BookID

		UPDATE Book SET NoInLib=NoInLib+1 WHERE
		BookID=@BookID
	END
GO
/*------------------------------------------------------*/

/* FEE */
--Procedure get fee
IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_GetFee' AND TYPE = 'P')
   DROP PROCEDURE sp_GetFee
GO
CREATE PROC sp_GetFee
AS
	SELECT * FROM Fee WHERE Fee='Fee'
GO
--Procedure edit fee
IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_EditFee' AND TYPE = 'P')
   DROP PROCEDURE sp_EditFee
GO
CREATE PROC sp_EditFee
	(@BorFee FLOAT,
	@LateFee FLOAT)
AS
	UPDATE Fee SET BorFee=@BorFee,LateFee=@LateFee
	WHERE Fee='Fee'
GO
-----------------------------
/*------------------------------------------*/

/*  ANALYTICS */

--Get top book borrowed

IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_GetTopBook' AND TYPE = 'P')
   DROP PROCEDURE sp_GetTopBook
GO
IF EXISTS (SELECT NAME FROM sys.views WHERE NAME='TopBook')
DROP VIEW TopBook
GO
	CREATE VIEW TopBook AS
	SELECT DISTINCT B.BookID, B.CallNumber,B.ISBN,B.Title,B.AuthName,
	B.Publisher,S.SubName,C.NB FROM Book B JOIN Subject S
	ON B.SubID=S.SubID JOIN BorrowDetail BD ON
	B.BookID=BD.BookID JOIN 
	(SELECT BookID,COUNT(BookID) AS NB
	FROM BorrowDetail GROUP BY BookID) AS C
	ON B.BookID=C.BookID
GO
CREATE PROC sp_GetTopBook
(		
	@PageIndex INT,
	@NumRows INT,
	@TotalPage INT OUTPUT
)
AS
BEGIN
	SELECT @TotalPage=COUNT(DISTINCT B.BookID) 
	FROM Book B JOIN Subject S
	ON B.SubID=S.SubID JOIN BorrowDetail BD ON
	B.BookID=BD.BookID JOIN 
	(SELECT BookID,COUNT(BookID) AS NB
	FROM BorrowDetail GROUP BY BookID) AS C
	ON B.BookID=C.BookID
	DECLARE @startRowIndex INT
	SET @startRowIndex = (@PageIndex * @NumRows) + 1;
	WITH Temp AS
	(
		SELECT ROW_NUMBER() OVER (ORDER BY NB DESC)
		AS [No],* FROM TopBook
	)
	SELECT BookID,CallNumber,ISBN,Title,AuthName,
	Publisher,SubName,NB
	FROM Temp
	WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
END
GO
--Get top employee borrowed

IF EXISTS (SELECT NAME FROM sys.objects
         WHERE NAME = 'sp_GetTopBorrower' AND TYPE = 'P')
   DROP PROCEDURE sp_GetTopBorrower
GO
IF EXISTS (SELECT NAME FROM sys.views WHERE NAME='TopBorrower')
DROP VIEW TopBorrower
GO
CREATE VIEW TopBorrower AS
SELECT E.EmpID,E.[Name],CASE E.Gender WHEN 1 THEN 'Male'
	ELSE 'Female' END AS 'Gender',E.Email,E.Department,E.Phone,
	CASE Permission WHEN 1 THEN 'Librarin' ELSE
	'Employee' END AS 'Permission',T.NB FROM Employee E JOIN
	(	SELECT EmpID,SUM(NB) AS NB FROM
		(
			SELECT E.EmpID,COUNT(C.NB) AS NB FROM Employee E JOIN Borrow B
			ON E.EmpID=B.EmpID JOIN BorrowDetail BD ON
			B.BorID=BD.BorID JOIN 
			(SELECT BorID,COUNT(BorID) AS NB
			FROM BorrowDetail GROUP BY BorID) AS C
			ON B.BorID=C.BorID GROUP BY E.EmpID,C.NB
		) AS D GROUP BY EmpID
	) AS T ON E.EmpID=T.EmpID
GO
CREATE PROC sp_GetTopBorrower
(		
	@PageIndex INT,
	@NumRows INT,
	@TotalPage INT OUTPUT
)
AS
BEGIN
	SELECT @TotalPage=COUNT(E.EmpID) FROM Employee E JOIN
	(	SELECT EmpID,SUM(NB) AS NB FROM
		(
			SELECT E.EmpID,COUNT(C.NB) AS NB FROM Employee E JOIN Borrow B
			ON E.EmpID=B.EmpID JOIN BorrowDetail BD ON
			B.BorID=BD.BorID JOIN 
			(SELECT BorID,COUNT(BorID) AS NB
			FROM BorrowDetail GROUP BY BorID) AS C
			ON B.BorID=C.BorID GROUP BY E.EmpID,C.NB
		) AS D GROUP BY EmpID
	) AS T ON E.EmpID=T.EmpID
	DECLARE @startRowIndex INT
	SET @startRowIndex = (@PageIndex * @NumRows) + 1;
	WITH Temp AS
		(
		SELECT ROW_NUMBER() OVER (ORDER BY NB DESC)
		AS [No],* FROM TopBorrower
		)
	SELECT EmpID,[Name],Gender,Email,Department,Phone,Permission,NB
	FROM Temp
	WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
END
GO

--Get checking out borrow to send alert
IF EXISTS (SELECT NAME FROM sys.objects 
         WHERE NAME = 'sp_GetCheckingOutByDate' AND TYPE = 'P')
   DROP PROCEDURE sp_GetCheckingOutByDate
GO
CREATE PROC sp_GetCheckingOutByDate
	(
		@DueDate DATETIME,
		@PageIndex INT,
		@NumRows INT,
		@TotalPage INT OUTPUT
	)
AS
BEGIN
	SELECT @TotalPage=COUNT(B.BorID) FROM Borrow B JOIN 
	BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.BookID=BO.BookID 
	WHERE BD.IssueStatus=0
	AND CAST(BD.DueDate AS FLOAT) BETWEEN 1 AND CAST(@DueDate AS FLOAT)
	DECLARE @startRowIndex INT
	SET @startRowIndex = (@PageIndex * @NumRows) + 1;
	WITH Temp AS
		(
			SELECT ROW_NUMBER() OVER (ORDER BY B.BorID ASC) AS [No],
			B.BorID,E.EmpID,BO.BookID,E.[Name],BO.CallNumber,BO.Title,
			BD.IssueDate, BD.DueDate FROM Borrow B JOIN 
			BorrowDetail BD ON B.BorID=BD.BorID
			JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
			ON BD.BookID=BO.BookID WHERE BD.IssueStatus=0
			AND CAST(BD.DueDate AS FLOAT)
			BETWEEN 1 AND CAST(@DueDate AS FLOAT)
		)
	SELECT	BorID,EmpID,BookID,[Name],CallNumber,Title,
			IssueDate, DueDate
	FROM Temp
	WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
END
GO
/*****************************************************/

/* DEFAULT VALUE */

--Insert default user with User&Pass [root|root]
sp_AddLib 'root','07/27/1991',1,'cuongnqgc00033@fpt.edu.vn',
'63a9f0ea7bb98050796b649e85481845','Ha Noi','0986948677','GC0502'
GO

--Insert default fee value
INSERT INTO Fee VALUES ('Fee',0,0.1)

/*--------------------------------------------------------------*/
GO
/*		EXAMPLE DATA		*/
/****** Object:  Table [dbo].[Employee]    Script Date: 01/12/2011 18:26:58 ******/
SET IDENTITY_INSERT [dbo].[Employee] ON
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (2, N'Gilbert', CAST(0x67400000 AS SmallDateTime), 1, N'guy1@adventure-works.com', NULL, N'Mozambique', N'3205550195', 0, N'Engineering')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (3, N'Brown', CAST(0x6E750000 AS SmallDateTime), 1, N'kevin0@adventure-works.com', NULL, N'UnitedStates', N'1505550189', 0, N'Tool Design')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (4, N'Tamburello', CAST(0x5CAA0000 AS SmallDateTime), 0, N'roberto0@adventure-works.com', NULL, N'Uruguay', N'2125550187', 0, N'Sales')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (5, N'Walters', CAST(0x5CD30000 AS SmallDateTime), 1, N'rob0@adventure-works.com', NULL, N'Romania', N'6125550100', 0, N'Production')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (6, N'D''Hers', CAST(0x46D90000 AS SmallDateTime), 0, N'thierry0@adventure-works.com', NULL, N'Mozambique', N'1685550183', 0, N'Finance')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (7, N'Bradley', CAST(0x5D290000 AS SmallDateTime), 1, N'david0@adventure-works.com', NULL, N'Malaysia', N'9135550172', 0, N'Executive')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (8, N'Dobney', CAST(0x41CF0000 AS SmallDateTime), 0, N'jolynn0@adventure-works.com', NULL, N'Romania', N'9035550145', 0, N'Executive')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (9, N'Ellerbrock', CAST(0x425B0000 AS SmallDateTime), 1, N'ruth0@adventure-works.com', NULL, N'Italy', N'1455550130', 0, N'Human Resources')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (10, N'Erickson', CAST(0x3D190000 AS SmallDateTime), 0, N'ruth0@adventure-works.com', NULL, N'Italy', N'1455550130', 0, N'Development')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (11, N'Johnson', CAST(0x42150000 AS SmallDateTime), 1, N'barry0@adventure-works.com', NULL, N'Jordan', N'2065550180', 0, N'Executive')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (12, N'Goldberg', CAST(0x464D0000 AS SmallDateTime), 1, N'jossef0@adventure-works.com', NULL, N'UnitedStates', N'1225550189', 0, N'Executive')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (13, N'Duffy', CAST(0x57FB0000 AS SmallDateTime), 0, N'terri0@adventure-works.com', NULL, N'Romania', N'8195550175', 0, N'Sales')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (14, N'Higa', CAST(0x42B20000 AS SmallDateTime), 1, N'sidney0@adventure-works.com', NULL, N'Japan', N'4245550189', 0, N'Engineering')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (15, N'Maxwell', CAST(0x421B0000 AS SmallDateTime), 1, N'taylor0@adventure-works.com', NULL, N'UnitedStates', N'5085550165', 0, N'Development')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (16, N'Ford', CAST(0x42800000 AS SmallDateTime), 1, N'jeffrey0@adventure-works.com', NULL, N'UnitedStates', N'9845550185', 0, N'Research')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (17, N'Hartwig', CAST(0x421E0000 AS SmallDateTime), 0, N'doris0@adventure-works.com', NULL, N'UnitedStates', N'3285550150', 0, N'Purchasing')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (18, N'Campbell', CAST(0x429B0000 AS SmallDateTime), 1, N'john0@adventure-works.com', NULL, N'Nigeria', N'4355550113', 0, N'Finance')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (19, N'Glimp', CAST(0x42180000 AS SmallDateTime), 1, N'diane0@adventure-works.com', NULL, N'Norway', N'2025550151', 0, N'Executive')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (20, N'Selikoff', CAST(0x603C0000 AS SmallDateTime), 1, N'steven0@adventure-works.com', NULL, N'Japan', N'9255550114', 0, N'Production')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (22, N'Krebs', CAST(0x680B0000 AS SmallDateTime), 1, N'peter0@adventure-works.com', NULL, N'Jordan', N'9135550196', 0, N'Research')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (23, N'Munson', CAST(0x4B4F0000 AS SmallDateTime), 0, N'stuart0@adventure-works.com', NULL, N'Nigeria', N'4135550136', 0, N'Purchasing')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (24, N'Alderson', CAST(0x56DC0000 AS SmallDateTime), 1, N'greg0@adventure-works.com', NULL, N'UnitedStates', N'3325550150', 0, N'Sales')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (25, N'Johnson', CAST(0x63C20000 AS SmallDateTime), 1, N'david1@adventure-works.com', NULL, N'UnitedStates', N'1665550162', 0, N'Tool Design')
INSERT [dbo].[Employee] ([EmpID], [Name], [DOB], [Gender], [Email], [Password], [Address], [Phone], [Permission], [Department]) VALUES (26, N'Mu', CAST(0x69700000 AS SmallDateTime), 0, N'zheng0@adventure-works.com', NULL, N'Malaysia', N'1135550173', 0, N'Marketing')
SET IDENTITY_INSERT [dbo].[Employee] OFF
GO
/****** Object:  Table [dbo].[Subject]    Script Date: 01/12/2011 18:26:58 ******/
SET IDENTITY_INSERT [dbo].[Subject] ON
INSERT [dbo].[Subject] ([SubID], [SubName], [Description]) VALUES (1, N'Horror', N'The books in this category include classic horror stories, such as Frankenstein and Dracula, as well as thrillers with a supernatural theme.')
INSERT [dbo].[Subject] ([SubID], [SubName], [Description]) VALUES (2, N'Romance', N'This category includes books, plays, and poems with a romantic theme.')
INSERT [dbo].[Subject] ([SubID], [SubName], [Description]) VALUES (3, N'Mystery & Crime', N'This category includes mystery books and plays, and anything where crime is a central theme.')
INSERT [dbo].[Subject] ([SubID], [SubName], [Description]) VALUES (6, N'Science Fiction & Fantasy', N'This category includes many early examples of science fiction')
INSERT [dbo].[Subject] ([SubID], [SubName], [Description]) VALUES (7, N'History', N'Books in this category focus on the history of a country or a people')
INSERT [dbo].[Subject] ([SubID], [SubName], [Description]) VALUES (8, N'Poetry', N'Poetry Books')
INSERT [dbo].[Subject] ([SubID], [SubName], [Description]) VALUES (9, N'Children', N'Childrens books kids books')
INSERT [dbo].[Subject] ([SubID], [SubName], [Description]) VALUES (10, N'Travel', N'Travel books, travel guide,travel writing')
INSERT [dbo].[Subject] ([SubID], [SubName], [Description]) VALUES (11, N'Entertainment', N'Movie books, music, celebrities ,film ,guides')
SET IDENTITY_INSERT [dbo].[Subject] OFF
GO
/****** Object:  Table [dbo].[Borrow]    Script Date: 01/12/2011 18:26:58 ******/
/****** Object:  Table [dbo].[Book]    Script Date: 01/12/2011 18:26:58 ******/
SET IDENTITY_INSERT [dbo].[Book] ON
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (1, N'FU-SI-001', N'001-0001', 1, N'Full Dark, No Stars', N'Stephen King', N'Simon & Schuster Adult Publishing Group', 68, 68)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (2, N'FR-MA-002', N'001-0002', 1, N'Frankenstein', N'Mary Shelley', N'over Publications', 76, 76)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (3, N'WO-Ma-003', N'001-0003', 1, N'World War Z: An Oral History of the Zombie War', N'Max Brooks', N'Crown Publishing Group', 42, 42)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (4, N'GH-CA-004', N'001-0004', 1, N'Ghost at Work', N'Carolyn G. Hart', N'HarperCollins Publishers', 89, 89)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (5, N'SH-KA-005', N'002-0005', 2, N'Shadowfever ', N'Karen Marie Moning', N'Random House Publishing Group', 19, 19)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (6, N'TH-JE-006', N'002-0006', 2, N'The Land of Painted Caves', N'Jean M. Auel', N'# Crown Publishing Group', 89, 89)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (7, N'AR-NA-007', N'002-0007', 2, N'Archangel''s Consort', N'Nalini Singh', N'Penguin Group', 109, 109)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (8, N'FA-DE-008', N'002-0008', 2, N'Family Affair ', N'Debbie Macomber', N'HarperCollins Publishers', 102, 102)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (9, N'TH-RO-009', N'003-0009', 3, N'The Sentry', N'Robert Crais', N'Penguin Group', 20, 20)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (10, N'TH-ST-010', N'003-0010', 3, N'The Girl with the Dragon Tattoo', N'Stieg Larsson, Reg Keeland', N'Knopf Doubleday Publishing Group', 90, 90)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (11, N'TH-AN-011', N'003-0011', 3, N'Three Seconds', N'Anders Roslund', N'SilverOak', 96, 96)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (12, N'TH-ST-012', N'003-0012', 3, N'The Girl Who Kicked the Hornet''s Nest', N'Stieg Larsson', N'Knopf Doubleday Publishing Group', 63, 63)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (13, N'AR-RO-013', N'006-0013', 6, N'Archibald Zwick And The Eight Towers', N'Robert Leslie Palmer', N'CrossBooks Publishing', 64, 64)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (14, N'TH-NE-014', N'006-0014', 6, N'The Gift', N'Ned Rust', N'Little, Brown Books for Young Readers', 30, 30)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (15, N'TO-BR-015', N'006-0015', 6, N'Towers of Midnight', N'Brandon Sanderson', N'Doherty, Tom Associates, LLC', 16, 16)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (16, N'UN-LN-016', N'007-0016', 7, N'Unbroken: A World War II Story of Survival, Resilience, and Redemption', N'Laura Hillenbrand', N'Random House Publishing Group', 73, 73)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (17, N'CL-ST-017', N'007-0017', 7, N'Cleopatra: A Life', N'Stacy Schiff', N'Little, Brown & Company', 36, 36)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (18, N'TH-RE-018', N'007-0018', 7, N'The Immortal Life of Henrietta Lacks ', N'Rebecca Skloot', N'Crown Publishing Group', 34, 34)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (19, N'TH-HO-019', N'008-0019', 8, N'The Iliad ', N'Homer', N'Penguin Group (USA)', 58, 58)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (20, N'TH-HO-020', N'008-0020', 8, N'The Odyssey', N'Homer', N'Penguin Group (USA', 82, 82)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (21, N'AS-PH-021', N'009-0021', 9, N'A Sick Day for Amos McGee ', N'Philip C. Stead', N'Roaring Brook Press', 76, 76)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (22, N'MO-CL-022', N'009-0022', 9, N'Moon Over Manifest', N'Clare Vanderpool', N'Random House Children''s Books', 12, 12)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (23, N'TH-DA-023', N'010-0023', 10, N'The Lost City of Z: A Tale of Deadly Obsession in the Amazon ', N'David Grann', N'Knopf Doubleday Publishing Group', 52, 52)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (24, N'AM-ST-024', N'010-0024', 10, N'American Casino Guide 2011 Edition', N'Steve Bourie', N'Casino Vacations Press, Inc', 96, 96)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (25, N'IN-HO-025', N'010-0025', 10, N'Into the Wild ', N'Jon Krakauer', N'Knopf Doubleday Publishing Group', 50, 50)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (26, N'LO-JE-026', N'011-0026', 11, N'Love, Lust and Faking It: The Naked Truth About Sex, Lies, and True Romance ', N'Jenny McCarthy', N'HarperCollins Publishers', 44, 44)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (27, N'KA-KO-027', N'011-0027', 11, N'Kardashian Konfidential ', N'Kourtney Kardashian', N'St. Martin''s Press', 56, 56)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (28, N'SH-JU-028', N'011-0028', 11, N'Shit My Dad Says ', N'Justin Halpern', N'HarperCollins Publishers', 24, 24)
INSERT [dbo].[Book] ([BookID], [CallNumber], [ISBN], [SubID], [Title], [AuthName], [Publisher], [NoOfCopy], [NoInLib]) VALUES (29, N'TH-BA-029', N'011-0029', 11, N'The Bro Code', N'Barney Stinson, Matt Kuhn', N'Simon & Schuster Adult Publishing Group', 8, 8)
SET IDENTITY_INSERT [dbo].[Book] OFF
/****** Object:  Table [dbo].[BorrowDetail]    Script Date: 01/12/2011 18:26:58 ******/

/*********************************************************************/

							/*END*/

SELECT  CAST(IssueDate AS FLOAT) AS DueDate FROM BorrowDetail

SELECT B.BorID,E.EmpID,BO.BookID,E.[Name],BO.CallNumber,BO.Title,
BD.IssueDate, BD.DueDate FROM Borrow B JOIN 
BorrowDetail BD ON B.BorID=BD.BorID
JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
ON BD.BookID=BO.BookID WHERE BD.IssueStatus=0
AND CAST(BD.IssueDate AS FLOAT) BETWEEN 1 and 60000
AND CAST(BD.DueDate AS FLOAT) BETWEEN 1 and 99999

