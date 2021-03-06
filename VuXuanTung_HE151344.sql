USE [master]
GO
/****** Object:  Database [PRJ321_M3]    Script Date: 11/9/2021 2:01:30 PM ******/
CREATE DATABASE [PRJ321_M3]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'PRJ321_M3', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PRJ321_M3.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'PRJ321_M3_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\PRJ321_M3_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [PRJ321_M3] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [PRJ321_M3].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [PRJ321_M3] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [PRJ321_M3] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [PRJ321_M3] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [PRJ321_M3] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [PRJ321_M3] SET ARITHABORT OFF 
GO
ALTER DATABASE [PRJ321_M3] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [PRJ321_M3] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [PRJ321_M3] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [PRJ321_M3] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [PRJ321_M3] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [PRJ321_M3] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [PRJ321_M3] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [PRJ321_M3] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [PRJ321_M3] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [PRJ321_M3] SET  ENABLE_BROKER 
GO
ALTER DATABASE [PRJ321_M3] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [PRJ321_M3] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [PRJ321_M3] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [PRJ321_M3] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [PRJ321_M3] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [PRJ321_M3] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [PRJ321_M3] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [PRJ321_M3] SET RECOVERY FULL 
GO
ALTER DATABASE [PRJ321_M3] SET  MULTI_USER 
GO
ALTER DATABASE [PRJ321_M3] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [PRJ321_M3] SET DB_CHAINING OFF 
GO
ALTER DATABASE [PRJ321_M3] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [PRJ321_M3] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [PRJ321_M3] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [PRJ321_M3] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'PRJ321_M3', N'ON'
GO
ALTER DATABASE [PRJ321_M3] SET QUERY_STORE = OFF
GO
USE [PRJ321_M3]
GO
/****** Object:  Table [dbo].[admin]    Script Date: 11/9/2021 2:01:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[admin](
	[adminID] [int] IDENTITY(1,1) NOT NULL,
	[username] [varchar](30) NULL,
	[password] [varchar](32) NOT NULL,
	[role] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[adminID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 11/9/2021 2:01:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[oID] [varchar](32) NOT NULL,
	[dateCreate] [datetime] NULL,
	[cname] [nvarchar](30) NOT NULL,
	[cphone] [varchar](30) NULL,
	[cAddress] [nvarchar](100) NULL,
	[total] [money] NULL,
	[status] [int] NULL,
	[cid] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[oID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[BillDetail]    Script Date: 11/9/2021 2:01:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[BillDetail](
	[pid] [varchar](30) NOT NULL,
	[oID] [varchar](32) NOT NULL,
	[quantity] [int] NULL,
	[price] [money] NULL,
	[total] [money] NULL,
PRIMARY KEY CLUSTERED 
(
	[pid] ASC,
	[oID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Category]    Script Date: 11/9/2021 2:01:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[cateID] [int] IDENTITY(1,1) NOT NULL,
	[cateName] [nvarchar](50) NULL,
	[status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[cateID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 11/9/2021 2:01:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[cid] [int] IDENTITY(1,1) NOT NULL,
	[cname] [nvarchar](30) NOT NULL,
	[cphone] [varchar](30) NULL,
	[cAddress] [nvarchar](100) NULL,
	[username] [varchar](30) NOT NULL,
	[password] [varchar](32) NOT NULL,
	[status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[cid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 11/9/2021 2:01:31 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[pid] [varchar](30) NOT NULL,
	[pname] [nvarchar](100) NOT NULL,
	[quantity] [int] NULL,
	[price] [money] NULL,
	[image] [varchar](100) NULL,
	[description] [nvarchar](max) NULL,
	[status] [bit] NULL,
	[cateID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[pid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[admin] ON 

INSERT [dbo].[admin] ([adminID], [username], [password], [role]) VALUES (1, N'xtungvu12', N'xtungvu12', N'guest')
INSERT [dbo].[admin] ([adminID], [username], [password], [role]) VALUES (14, N'vanhxinhnay12', N'vanhxinhnayhi', N'admin')
INSERT [dbo].[admin] ([adminID], [username], [password], [role]) VALUES (21, N'chang12', N'changprovip', N'guest')
INSERT [dbo].[admin] ([adminID], [username], [password], [role]) VALUES (23, N'xtungvu', N'xtungvu12', N'admin')
INSERT [dbo].[admin] ([adminID], [username], [password], [role]) VALUES (24, N'huyennguyen', N'123456789', N'guest')
INSERT [dbo].[admin] ([adminID], [username], [password], [role]) VALUES (25, N'HanNa', N'123456789', N'admin')
INSERT [dbo].[admin] ([adminID], [username], [password], [role]) VALUES (28, N'culy12', N'123456789', N'guest')
SET IDENTITY_INSERT [dbo].[admin] OFF
GO
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'1', CAST(N'2021-09-09T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'Hanoi', 30000.0000, 2, 6)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'10', CAST(N'2021-10-17T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'Ha Noi', 159858.0000, -1, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'11', CAST(N'2021-10-17T00:00:00.000' AS DateTime), N'a', N'1', N'a', 5000.0000, 2, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'12', CAST(N'2021-10-19T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'Ha Noi', 20427.0000, -1, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'13', CAST(N'2021-10-19T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'Korean', 14500.0000, 2, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'14', CAST(N'2021-10-19T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'Korean', 5500.0000, -1, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'15', CAST(N'2021-10-19T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'China', 18000.0000, 2, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'16', CAST(N'2021-10-19T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'Ha Noi', 79858.0000, -1, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'17', CAST(N'2021-10-19T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'Korean', 6427.0000, -1, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'18', CAST(N'2021-10-19T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'Korean', 12854.0000, 2, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'19', CAST(N'2021-10-21T00:00:00.000' AS DateTime), N'HanNa', N'0978654125', N'Korean', 84858.0000, 2, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'2', CAST(N'2021-10-14T00:00:00.000' AS DateTime), N'Tung Vu', N'012154212', N'Ha Noi', 86060.0000, -1, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'20', CAST(N'2021-10-21T00:00:00.000' AS DateTime), N'HanNa', N'098654721', N'Korean', 80000.0000, 0, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'21', CAST(N'2021-10-21T00:00:00.000' AS DateTime), N'Luyi', N'0985231145', N'China', 89000.0000, -1, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'22', CAST(N'2021-10-21T00:00:00.000' AS DateTime), N'Kang Han Na', N'0976018301', N'Korean', 6427.0000, 2, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'23', CAST(N'2021-10-22T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'Ha Noi', 85000.0000, -1, 6)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'24', CAST(N'2021-10-25T00:00:00.000' AS DateTime), N'Tung', N'0976018301', N'Korean', 18000.0000, -1, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'25', CAST(N'2021-10-26T00:00:00.000' AS DateTime), N'YangMi', N'0976018301', N'China', 2000.0000, 2, 6)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'26', CAST(N'2021-10-26T00:00:00.000' AS DateTime), N'Luyi', N'098652365', N'Korean', 600.0000, -1, 6)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'27', CAST(N'2021-10-26T00:00:00.000' AS DateTime), N'Krwrowrw', N'056461313', N'HEWU', 79858.0000, 2, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'28', CAST(N'2021-10-28T00:00:00.000' AS DateTime), N'Huyen', N'0976018301', N'Ha Noi', 700.0000, 2, 20)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'29', CAST(N'2021-10-31T00:00:00.000' AS DateTime), N'Hoang ', N'0976018301', N'Hai Phong 16', 80000.0000, 2, 21)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'3', CAST(N'2021-10-16T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'Ha Noi', 68795.0000, -1, 6)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'30', CAST(N'2021-11-02T00:00:00.000' AS DateTime), N'Hoang', N'465411326', N'Hai Phong 16', 480.0000, 2, 21)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'31', CAST(N'2021-11-02T00:00:00.000' AS DateTime), N'Hoang 12', N'1551306546', N'Hai Phong 16', 230.0000, -1, 21)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'32', CAST(N'2021-11-02T00:00:00.000' AS DateTime), N'Hoang', N'0116556566', N'Hai Phong 16', 1090.0000, 2, 21)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'33', CAST(N'2021-11-02T00:00:00.000' AS DateTime), N'euwor', N'45646153', N'wuirweir', 980.0000, 2, 6)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'34', CAST(N'2021-11-04T00:00:00.000' AS DateTime), N'tung', N'02131345', N'Ha Noi', 250.0000, -1, 6)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'35', CAST(N'2021-11-04T00:00:00.000' AS DateTime), N'Decade', N'0976018301', N'Ha Noi', 980.0000, 2, 6)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'36', CAST(N'2021-11-05T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'Ha Noi', 460.0000, -1, 6)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'37', CAST(N'2021-11-08T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'HanOI', 980.0000, -1, 6)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'38', CAST(N'2021-11-08T00:00:00.000' AS DateTime), N'dECADE', N'6749863634', N'Ha noi', 920.0000, -1, 6)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'39', CAST(N'2021-11-09T00:00:00.000' AS DateTime), N'Tung', N'0976018301', N'Ha Noi', 1580.0000, 2, 6)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'4', CAST(N'2021-10-16T00:00:00.000' AS DateTime), N'Tung Vu', N'056545613', N'Ha Noi', 0.0000, 2, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'40', CAST(N'2021-11-09T00:00:00.000' AS DateTime), N'Tung', N'0976018301', N'Ha Noi', 600.0000, 0, 6)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'41', CAST(N'2021-11-09T00:00:00.000' AS DateTime), N'Tung', N'0976018301', N'Ha Noi', 12854.0000, 0, 6)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'5', CAST(N'2021-10-16T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'Ha Noi', 5500.0000, 0, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'6', CAST(N'2021-10-17T00:00:00.000' AS DateTime), N'Cu Ly', N'057465141', N'Hai Phong 16', 5500.0000, -1, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'7', CAST(N'2021-10-17T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'Ha Noi', 9000.0000, 2, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'8', CAST(N'2021-10-17T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'Ha Noi', 5500.0000, 0, 5)
INSERT [dbo].[Bill] ([oID], [dateCreate], [cname], [cphone], [cAddress], [total], [status], [cid]) VALUES (N'9', CAST(N'2021-10-17T00:00:00.000' AS DateTime), N'Tung Vu', N'0976018301', N'Ha Noi', 159858.0000, 2, 5)
GO
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P01', N'1', 10, 43783.0000, 437830.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P01', N'11', 10, 43783.0000, 437830.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P01', N'12', 10, 43783.0000, 437830.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P01', N'13', 10, 43783.0000, 437830.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P01', N'14', 10, 43783.0000, 437830.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P01', N'19', 1, 5000.0000, 84858.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P01', N'2', 10, 43783.0000, 437830.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P01', N'23', 1, 5000.0000, 85000.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P01', N'4', 10, 43783.0000, 437830.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P01', N'5', 10, 43783.0000, 437830.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P01', N'6', 10, 43783.0000, 437830.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P01', N'8', 10, 43783.0000, 437830.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P02', N'1', 70, 7000.0000, 49000.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P02', N'14', 1, 500.0000, 5500.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P02', N'5', 1, 500.0000, 500.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P02', N'6', 1, 500.0000, 500.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P02', N'8', 1, 500.0000, 5500.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P03', N'12', 1, 9000.0000, 20427.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P03', N'15', 2, 9000.0000, 18000.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P03', N'21', 1, 9000.0000, 89000.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P03', N'24', 2, 9000.0000, 18000.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P03', N'5', 10, 500.0000, 550.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P03', N'6', 10, 500.0000, 5000.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P03', N'7', 1, 9000.0000, 9000.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P04', N'10', 1, 79858.0000, 159858.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P04', N'16', 1, 79858.0000, 79858.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P04', N'19', 1, 79858.0000, 84858.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P04', N'27', 1, 79858.0000, 79858.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P04', N'9', 1, 79858.0000, 159858.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P05', N'10', 1, 80000.0000, 159858.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P05', N'20', 1, 80000.0000, 80000.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P05', N'21', 1, 80000.0000, 89000.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P05', N'23', 1, 80000.0000, 85000.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P05', N'29', 1, 80000.0000, 80000.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P05', N'9', 1, 80000.0000, 159858.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P08', N'12', 1, 6427.0000, 20427.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P08', N'17', 1, 6427.0000, 6427.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P08', N'18', 2, 6427.0000, 12854.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P08', N'22', 1, 6427.0000, 6427.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P08', N'41', 2, 6427.0000, 12854.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P09', N'25', 1, 600.0000, 2000.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P09', N'26', 1, 600.0000, 600.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P09', N'40', 1, 600.0000, 600.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P10', N'25', 2, 700.0000, 2000.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P10', N'28', 1, 700.0000, 700.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P11', N'39', 2, 560.0000, 1580.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P12', N'32', 1, 860.0000, 1090.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P13', N'30', 1, 230.0000, 480.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P13', N'31', 1, 230.0000, 230.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P13', N'32', 1, 230.0000, 1090.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P13', N'36', 2, 230.0000, 460.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P14', N'33', 1, 980.0000, 980.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P14', N'35', 1, 980.0000, 980.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P14', N'37', 1, 980.0000, 980.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P15', N'38', 2, 460.0000, 920.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P15', N'39', 1, 460.0000, 1580.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P16', N'30', 1, 250.0000, 480.0000)
INSERT [dbo].[BillDetail] ([pid], [oID], [quantity], [price], [total]) VALUES (N'P16', N'34', 1, 250.0000, 250.0000)
GO
SET IDENTITY_INSERT [dbo].[Category] ON 

INSERT [dbo].[Category] ([cateID], [cateName], [status]) VALUES (1, N'Vanila Cake', 1)
INSERT [dbo].[Category] ([cateID], [cateName], [status]) VALUES (2, N'Cheese Cake', 1)
INSERT [dbo].[Category] ([cateID], [cateName], [status]) VALUES (3, N'CupCake', 1)
INSERT [dbo].[Category] ([cateID], [cateName], [status]) VALUES (4, N'Milk Tea', 1)
INSERT [dbo].[Category] ([cateID], [cateName], [status]) VALUES (5, N'Oreo', 1)
INSERT [dbo].[Category] ([cateID], [cateName], [status]) VALUES (10, N'Cream Cake', 1)
INSERT [dbo].[Category] ([cateID], [cateName], [status]) VALUES (11, N'Chocopie', 1)
SET IDENTITY_INSERT [dbo].[Category] OFF
GO
SET IDENTITY_INSERT [dbo].[Customer] ON 

INSERT [dbo].[Customer] ([cid], [cname], [cphone], [cAddress], [username], [password], [status]) VALUES (5, N'Tung Vu', N'0976018301', N'Hanoi', N'xtungvu12', N'xtungvu12', 1)
INSERT [dbo].[Customer] ([cid], [cname], [cphone], [cAddress], [username], [password], [status]) VALUES (6, N'Tung', N'0976018301', N'Ha Noi', N'xtungvu', N'123456bc', 0)
INSERT [dbo].[Customer] ([cid], [cname], [cphone], [cAddress], [username], [password], [status]) VALUES (7, N'Misa', N'0976018301', N'HCM', N'Vanhxinhnay', N'123456ab', 1)
INSERT [dbo].[Customer] ([cid], [cname], [cphone], [cAddress], [username], [password], [status]) VALUES (8, N'Luyi', N'0976018301', N'China', N'luyi022001', N'123456cd', 1)
INSERT [dbo].[Customer] ([cid], [cname], [cphone], [cAddress], [username], [password], [status]) VALUES (14, N'Han Na', N'0674896479', N'Korean', N'KangHanNa', N'12345678ab', 1)
INSERT [dbo].[Customer] ([cid], [cname], [cphone], [cAddress], [username], [password], [status]) VALUES (16, N'Sama', N'0431324356', N'Ha Noi', N'sama0612', N'sama06121998', 1)
INSERT [dbo].[Customer] ([cid], [cname], [cphone], [cAddress], [username], [password], [status]) VALUES (17, N'Chi Le', NULL, NULL, N'chile12', N'123456789', 1)
INSERT [dbo].[Customer] ([cid], [cname], [cphone], [cAddress], [username], [password], [status]) VALUES (20, N'Huyen Nguyen', N'hii ', N'hii', N'huyennguyen', N'123456789', 1)
INSERT [dbo].[Customer] ([cid], [cname], [cphone], [cAddress], [username], [password], [status]) VALUES (21, N'Cu  Ly', NULL, NULL, N'culy12', N'123456789', 1)
SET IDENTITY_INSERT [dbo].[Customer] OFF
GO
INSERT [dbo].[Product] ([pid], [pname], [quantity], [price], [image], [description], [status], [cateID]) VALUES (N'P01', N'Grape Cake', 7, 5000.0000, N'images/grape.jpg', N'second hand', 1, 1)
INSERT [dbo].[Product] ([pid], [pname], [quantity], [price], [image], [description], [status], [cateID]) VALUES (N'P02', N'Pine Apple Cake', 2, 500.0000, N'images/pine.jpg', N'second hand', 1, 2)
INSERT [dbo].[Product] ([pid], [pname], [quantity], [price], [image], [description], [status], [cateID]) VALUES (N'P03', N'Cheese', 16, 9000.0000, N'images/cheese.jpg', N'Second Hand', 1, 3)
INSERT [dbo].[Product] ([pid], [pname], [quantity], [price], [image], [description], [status], [cateID]) VALUES (N'P04', N'Grape Cheese Cake', 28, 79858.0000, N'images/grapecake.jpg', N'second hand', 1, 1)
INSERT [dbo].[Product] ([pid], [pname], [quantity], [price], [image], [description], [status], [cateID]) VALUES (N'P05', N'Milk Tea', 5, 80000.0000, N'images/milktea.jpg', N'second hand', 1, 4)
INSERT [dbo].[Product] ([pid], [pname], [quantity], [price], [image], [description], [status], [cateID]) VALUES (N'P07', N'Blueberry Cake', 97, 6759.0000, N'images/blueberry.jpg', N'second hand', 1, 1)
INSERT [dbo].[Product] ([pid], [pname], [quantity], [price], [image], [description], [status], [cateID]) VALUES (N'P08', N'Tart', 57, 6427.0000, N'images/tarts.jpg', N'second hand', 1, 3)
INSERT [dbo].[Product] ([pid], [pname], [quantity], [price], [image], [description], [status], [cateID]) VALUES (N'P09', N'Chocolate Cake', 22, 600.0000, N'images/Chocolate.jpg', N'second hand', 1, 2)
INSERT [dbo].[Product] ([pid], [pname], [quantity], [price], [image], [description], [status], [cateID]) VALUES (N'P10', N'Velvet', 56, 700.0000, N'images/velvet.jpg', N'secondhand', 1, 1)
INSERT [dbo].[Product] ([pid], [pname], [quantity], [price], [image], [description], [status], [cateID]) VALUES (N'P11', N' Oreo', 23, 560.0000, N'images/oreo.jpg', N'secondhand', 1, 5)
INSERT [dbo].[Product] ([pid], [pname], [quantity], [price], [image], [description], [status], [cateID]) VALUES (N'P12', N'Cream Oreo', 39, 860.0000, N'images/creamoreo.jpg', N'second hand', 1, 5)
INSERT [dbo].[Product] ([pid], [pname], [quantity], [price], [image], [description], [status], [cateID]) VALUES (N'P13', N'Bluebery Milk Tea', 41, 230.0000, N'images/blueberrymilktea.jpg', N'second hand', 1, 4)
INSERT [dbo].[Product] ([pid], [pname], [quantity], [price], [image], [description], [status], [cateID]) VALUES (N'P14', N'Cream Golden Cake', 9, 980.0000, N'images/creamcake.jpg', N'second hand', 1, 10)
INSERT [dbo].[Product] ([pid], [pname], [quantity], [price], [image], [description], [status], [cateID]) VALUES (N'P15', N'Cream Cheese Cake', 28, 460.0000, N'images/unnamed.jpg', N'second hand', 1, 10)
INSERT [dbo].[Product] ([pid], [pname], [quantity], [price], [image], [description], [status], [cateID]) VALUES (N'P16', N'Chocopie', 21, 250.0000, N'images/LOTTECHOCOPIE.jpg', N'second hand', 1, 11)
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__admin__F3DBC5724125A8C4]    Script Date: 11/9/2021 2:01:31 PM ******/
ALTER TABLE [dbo].[admin] ADD UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Customer__F3DBC5720E514918]    Script Date: 11/9/2021 2:01:31 PM ******/
ALTER TABLE [dbo].[Customer] ADD UNIQUE NONCLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Bill] ADD  DEFAULT (getdate()) FOR [dateCreate]
GO
ALTER TABLE [dbo].[Bill] ADD  DEFAULT ((0)) FOR [status]
GO
ALTER TABLE [dbo].[Category] ADD  DEFAULT ((1)) FOR [status]
GO
ALTER TABLE [dbo].[Customer] ADD  DEFAULT ((1)) FOR [status]
GO
ALTER TABLE [dbo].[Product] ADD  DEFAULT ((1)) FOR [status]
GO
ALTER TABLE [dbo].[Bill]  WITH CHECK ADD FOREIGN KEY([cid])
REFERENCES [dbo].[Customer] ([cid])
GO
ALTER TABLE [dbo].[BillDetail]  WITH CHECK ADD FOREIGN KEY([oID])
REFERENCES [dbo].[Bill] ([oID])
GO
ALTER TABLE [dbo].[BillDetail]  WITH CHECK ADD FOREIGN KEY([pid])
REFERENCES [dbo].[Product] ([pid])
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD FOREIGN KEY([cateID])
REFERENCES [dbo].[Category] ([cateID])
GO
ALTER TABLE [dbo].[admin]  WITH CHECK ADD CHECK  ((len([password])>=(8)))
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD CHECK  ((len([password])>=(8)))
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD CHECK  (([price]>=(0)))
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD CHECK  (([quantity]>=(0)))
GO
USE [master]
GO
ALTER DATABASE [PRJ321_M3] SET  READ_WRITE 
GO
