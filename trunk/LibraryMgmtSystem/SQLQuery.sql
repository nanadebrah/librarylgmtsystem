--Create database
CREATE DATABASE Library
--Use database
USE Library
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
--Create Subject table
CREATE TABLE Subject(
	SubID INT NOT NULL IDENTITY,
	SubName VARCHAR(45) NOT NULL,
	Description VARCHAR(200),
	CONSTRAINT pk_SubID PRIMARY KEY (SubID)
)
--Create Book table
CREATE TABLE Book(
	CallNumber VARCHAR(9) NOT NULL,
	ISBN VARCHAR(8) NOT NULL,
	SubID INT NOT NULL,
	Title VARCHAR(100) NOT NULL,
	AuthName VARCHAR(30) NOT NULL,
	Publisher VARCHAR(45) NOT NULL,
	NoOfCopy TINYINT,
	CONSTRAINT pk_CallNumber PRIMARY KEY (CallNumber),
	CONSTRAINT fk_SubID FOREIGN KEY (SubID)
		REFERENCES Subject(SubID),
)
--Create Borrow table
CREATE TABLE Borrow(
	BorID INT NOT NULL IDENTITY,
	CallNumber VARCHAR(9) NOT NULL,
	EmpID INT NOT NULL,
	IssueStatus BIT NOT NULL,
	ChkOutDate DATETIME NOT NULL,
	DueDate DATETIME NOT NULL,
	ChkInDate DATETIME NOT NULL,
	TotalFee FLOAT,
	CONSTRAINT pk_BorID PRIMARY KEY (BorID),
	CONSTRAINT fk_EmpID FOREIGN KEY (EmpID)
		REFERENCES Employee(EmpID),
	CONSTRAINT fk_CallNo FOREIGN KEY (CallNumber)
		REFERENCES Book(CallNumber)
)
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
--Create Procedure get all field Employee
CREATE PROC sp_GetEmp(@EmpID INT)
AS
	BEGIN
		SELECT * FROM Employee
		WHERE EmpID=@EmpID
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
-----------------------------
sp_InsLib 'root','07/27/1991',0,'cuongnqgc00033@fpt.edu.vn',
'63a9f0ea7bb98050796b649e85481845','Ha Noi','0986948677','GC0502'

select * from Employee

sp_GetEmp 4

sp_Login 'root','root'

DELETE FROM Employee