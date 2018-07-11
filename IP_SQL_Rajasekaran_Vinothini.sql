//Creating table for Person
create table Person(P_SSN integer, P_Name varchar(20), Dob date, Race varchar(20), Gender varchar(7),Profession varchar(20),Address varchar(20),Email varchar(30),Home_phno integer,Work_phno integer, Cell_phno integer,Mailing_list boolean, PRIMARY KEY(P_SSN));
 
//Creating table for Client
create table Client(P_SSN integer, Dname varchar(20),Aname varchar(20), Dphno integer,Aphno integer,Cdate date, FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));
 
//Creating table for Volunteer
create table Volunteer(P_SSN integer, V_date date,T_date date,T_loc varchar(20), FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));
 

//Creating table for Employee
create table Employee(P_SSN integer, Salary float,M_status varchar(8),Hire_date date, FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));
 
//Creating table for Donor
create table Donor(P_SSN integer, Anonymous varchar(3), FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));
 
//Creating table for Emergency_Contact
create table Emergency_Contact(P_SSN integer, E_Name varchar(20),Contact integer,Relation varchar(10), PRIMARY KEY(E_Name,Contact),FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));
 
//Creating table for Needs
create table Needs(P_SSN integer, Type varchar(10),Value integer, FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));
 
//Creating table for Cheque
create table Cheque(P_SSN integer, Ddate date,Amount float,Type varchar(15),Fund_Name varchar(20),Cheque_no integer,PRIMARY KEY(Ddate,Amount,Type,Fund_Name), FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));
 
//Creating table for Card
create table Card(P_SSN integer, Ddate date,Amount float,Type varchar(15),Fund_Name varchar(20),C_no integer,C_type varchar(10),Exp_date date,PRIMARY KEY(Ddate,Amount,Type,Fund_Name), FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));
 
//Creating table for Team
create table Team( T_name varchar(20),T_type varchar(20),T_date date,R_desc varchar(20),R_date date, PRIMARY KEY(T_name));
 
//Creating table for Leads
create table Leads(P_SSN integer, T_name varchar(20),FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));
 
//Creating table for Serves
create table Serves(P_SSN integer, T_name varchar(20),Hours integer,Month varchar(10),Active integer,FOREIGN KEY(T_name) REFERENCES Team(T_name));
 
//Creating table for Cares
create table Cares(P_SSN integer, T_name varchar(20),status integer,FOREIGN KEY(T_name) REFERENCES Team(T_name),FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));
 
//Creating table for External_Organization
create table External_Organization(O_name varchar(20),Address varchar(20),Phno integer,Contact varchar(20), PRIMARY KEY(O_name));
 
//Creating table for Business
create table Business(O_name varchar(20),B_type varchar(20),B_size integer,Website varchar(30),FOREIGN KEY(O_name) REFERENCES External_Organization(O_name));
 
//Creating table for Church
create table Church(O_name varchar(20),Affiliation varchar(20),FOREIGN KEY(O_name) REFERENCES External_Organization(O_name));
 
//Creating table for Affiliated
create table Affiliated(O_name varchar(20),P_SSN integer,FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));
 
//Creating table for Org_donors
create table Org_donors(O_name varchar(20), Anonymous varchar(3),FOREIGN KEY(O_name) REFERENCES External_organization(O_name));
 
//Creating table for Sponsors
create table Sponsors(O_name varchar(20),T_name varchar(20),FOREIGN KEY(O_name) REFERENCES External_Organization(O_name),FOREIGN KEY(T_name) REFERENCES Team(T_name));
 
//Creating table for Org_Cheque
create table Org_Cheque(O_name varchar(20), Org_Date date,Org_Amount float,Org_Type varchar(20),Org_Fund_name varchar(20),Cheque_no integer,PRIMARY KEY(Org_Date,Org_Amount,Org_Type,Org_Fund_name),FOREIGN KEY(O_name) REFERENCES External_organization(O_name));
 
//Creating table for Org_Card
create table Org_Card(O_name varchar(20), Org_Date date,Org_Amount float,Org_Type varchar(20),Org_Fund_name varchar(20),C_no integer,C_type varchar(10),Exp_date date,PRIMARY KEY(Org_Date,Org_Amount,Org_Type,Org_Fund_name),FOREIGN KEY(O_name) REFERENCES External_organization(O_name));
 
//Creating table for Report
create table Report(T_name varchar(20),P_SSN integer,R_desc varchar(30),R_date date, FOREIGN KEY(T_name) REFERENCES Team(T_name));
 

//Creating table for Expense
create table Expense(P_SSN integer,E_date date,E_amount float,E_desc varchar(20), PRIMARY KEY(E_date,E_amount,E_desc),FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));
 
//Creating table for Insurance_policy
create table Insurance_policy(Policy_id integer,P_SSN integer,Provider_id integer,Pr_address varchar(20),P_type varchar(20), PRIMARY KEY(Policy_id),FOREIGN KEY(P_SSN) REFERENCES Person(P_SSN));
 

//Creating indices for tables
create index ssn on Client(P_SSN);
create index ssn1 on Employee(P_SSN);
create index t1 on Serves(T_name);
create index t2 on Serves(Month);
create index needs on Needs(Type,Value);
create index Edate on Expense(E_date);
create index c1 on Cares(P_SSN);
create index c2 on Cares(T_name);
create index ins_type on Insurance_Policy(P_type);
create index oname on Sponsors(O_name);
