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
	CONSTRAINT uq_CallNumber UNIQUE (CallNumber,ISBN),
	CONSTRAINT fk_SubID FOREIGN KEY (SubID)
		REFERENCES Subject(SubID),
)
go

--Create Borrow table
CREATE TABLE Borrow
	(
	BorID INT NOT NULL IDENTITY,
	EmpID INT NOT NULL,
	
	CONSTRAINT pk_BorID PRIMARY KEY (BorID),
	CONSTRAINT fk_EmpID FOREIGN KEY (EmpID)
		REFERENCES Employee(EmpID)
	)
go

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
go

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
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_AddEmp' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_AddLib' AND type = 'P')
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
--get an employee with one parameter : name
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetAnEmpWithName' AND type = 'P')
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
	ELSE 'FEMALE' END AS 'Gender',Email,Department,
	CASE Permission WHEN 1 THEN 'Librarin' ELSE
	'Employee' END AS 'Permission'
	FROM Temp
	WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
	END
GO
--get an employee with one parameter : EmpID
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetAnEmpWithEmpID' AND type = 'P')
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
	ELSE 'FEMALE' END AS 'Gender',Email,Department,
	CASE Permission WHEN 1 THEN 'Librarin' ELSE
	'Employee' END AS 'Permission'
	FROM Temp
	WHERE [No] BETWEEN @startRowIndex AND @StartRowIndex+@NumRows-1
	END
GO
--Create Procedure get all field of a Employee
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetEmpInfo' AND type = 'P')
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

IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetEmpBorowInfo' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetAllEmp' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_EditEmp' AND type = 'P')
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

IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_EditLib' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_DelEmp' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_Login' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetSubByName' AND type = 'P')
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

--Create procedure to get subject ID by name
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetSubByID' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetSubName' AND type = 'P')
   DROP PROCEDURE sp_GetSubName
GO
CREATE PROC sp_GetSubName
	(@SubID INT)
AS
	SELECT SubName FROM Subject WHERE SubID=@SubID
GO
--Create procedure to get subject ID by Name
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetSubID' AND type = 'P')
   DROP PROCEDURE sp_GetSubID
GO
CREATE PROC sp_GetSubID
	(@SubName VARCHAR(45))
AS
	SELECT SubID FROM Subject WHERE SubName=@SubName
GO
--Create procedure to get all subject name
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetAllSubName' AND type = 'P')
   DROP PROCEDURE sp_GetAllSubName
GO
CREATE PROC sp_GetAllSubName
AS
	SELECT SubName FROM Subject
GO
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
GO
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
	BEGIN
	UPDATE Subject SET SubName=@SubName,
		Description=@Description
		WHERE SubID=@SubID
	END
GO
--Create procedure to get Subject by SubId
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetSub' AND type = 'P')
   DROP PROCEDURE sp_GetSub
GO
CREATE PROC sp_GetSub
	@SubID INT
AS
	SELECT * FROM Subject
	WHERE  SubID = @SubID
GO
-- DELETE subject
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_DelSub' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_SearchBook' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetNewestBookID' AND type = 'P')
   DROP PROCEDURE sp_GetNewestBookID
GO
CREATE PROC sp_GetNewestBookID
AS
	SELECT TOP 1 BookID FROM BOOK
	ORDER BY BookID DESC
GO
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
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_EditBook' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetBookInfo' AND type = 'P')
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

IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetBookBorInfo' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_DelBook' AND type = 'P')
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
/*-------------------------------------------------------*/

--Create procedure get newest borrow
--IF EXISTS (SELECT name FROM sysobjects 
--         WHERE name = 'sp_GetNewestBorrowID' AND type = 'P')
--   DROP PROCEDURE sp_GetNewestBorrowID
--GO
--CREATE PROC sp_GetNewestBorrowID
--AS
--	SELECT TOP 1 BorID FROM Borrow ORDER BY BorID DESC
--GO
/*---------------------------------------------------------*/

/* Borrow  Manage*/
--get a borrow by CallNumber
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetBorrowByCalNo' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetBorrowByEmpID' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_GetFullBorrowInfo' AND type = 'P')
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
	BO.CallNumber,BO.ISBN,BO.Title,BO.AuthName,BO.Publisher
	FROM Borrow B JOIN BorrowDetail BD ON B.BorID=BD.BorID
	JOIN Employee E ON B.EmpID=E.EmpID JOIN Book BO
	ON BD.BookID=BO.BookID WHERE BD.BorID=@BorID
	AND E.EmpID=@EmpID AND BO.BookID=@BookID
GO
-- DELETE BORROW
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_DelBorrow' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_PrepareCheckOut' AND type = 'P')
   DROP PROCEDURE sp_PrepareCheckOut
GO
CREATE PROC sp_PrepareCheckOut
	(@EmpID INT)
AS
	INSERT INTO Borrow(EmpID) VALUES (@EmpID)
GO
--Check out, add new check out to borrow and borrow detail
IF EXISTS (SELECT name FROM sysobjects 
         WHERE name = 'sp_CheckOut' AND type = 'P')
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
	ON BD.BookID=BO.BookID WHERE B.BorID=@BorID
	AND BD.IssueStatus=0
GO
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
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_SearhCheckOutByEmpID' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_SearhCheckOutByEmpName' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_CheckIn' AND type = 'P')
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
IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetFee' AND type = 'P')
   DROP PROCEDURE sp_GetFee
GO
CREATE PROC sp_GetFee
AS
	SELECT * FROM Fee WHERE Fee='Fee'
GO
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
GO
-----------------------------
/*------------------------------------------*/

/*  ANALYTICS */

--Get top book borrowed

IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetTopBook' AND type = 'P')
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

IF EXISTS (SELECT name FROM sysobjects
         WHERE name = 'sp_GetTopBorrower' AND type = 'P')
   DROP PROCEDURE sp_GetTopBorrower
GO
IF EXISTS (SELECT NAME FROM sys.views WHERE NAME='TopBorrower')
DROP VIEW TopBorrower
GO
CREATE VIEW TopBorrower AS
SELECT E.EmpID,E.[Name],CASE E.Gender WHEN 1 THEN 'Male'
	ELSE 'FEMALE' END AS 'Gender',E.Email,E.Department,E.Phone,
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
/*****************************************************/

/* DEFAULT VALUE */

--Insert default user with User&Pass [root|root]
sp_AddLib 'root','07/27/1991',1,'cuongnqgc00033@fpt.edu.vn',
'63a9f0ea7bb98050796b649e85481845','Ha Noi','0986948677','GC0502'
GO

--Insert default fee value
INSERT INTO Fee VALUES ('Fee',0,0.1)

/*--------------------------------------------------------------*/

							/*END*/

select * from book