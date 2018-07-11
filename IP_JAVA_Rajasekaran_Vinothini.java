package testjdbc;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Ip {
	//For reading the input from user for the function input
	static Scanner sc=new Scanner(System.in);
	public static int input() throws SQLException {
		//Creating database connection
		Connection dbc=DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu","raja0004","IRsj1Xj1");
		//Creating statement object
		Statement st=dbc.createStatement();
		//Reading the input from user for person table..
		System.out.println("Enter the Person details first\n");
        System.out.println("Enter the Person SSN");
        int p1=sc.nextInt();
        System.out.println("Enter the Person name");
        String p2=sc.next();
        System.out.println("Enter the Person DOB");
        String p3=sc.next();
        System.out.println("Enter the Person Race");
        String p4=sc.next();
        System.out.println("Enter the Person Gender");
        String p5=sc.next();
        System.out.println("Enter the Person Profession");
        String p6=sc.next();
        System.out.println("Enter the Person Contact details..\n");
        System.out.println("Enter the Person mailing address");
        String p7=sc.next();
        System.out.println("Enter the Person Email");
        String p8=sc.next();
        System.out.println("Enter the Person Home_ph_no");
        int p9=sc.nextInt();
        System.out.println("Enter the Person Work_ph_no");
        int p10=sc.nextInt();
        System.out.println("Enter the Person Cell_ph_no");
        int p11=sc.nextInt();
        System.out.println("Enter 1 for Yes 0 for No whether the person wishes to be in the monthly news letter list ");
        int p12=sc.nextInt();
        //Inserting the values into person table
        st.executeUpdate("insert into Person values('"+p1+"','"+p2+"','"+p3+"','"+p4+"','"+p5+"','"+p6+"','"+p7+"','"+p8+"','"+p9+"','"+p10+"','"+p11+"','"+p12+"')");
       
		return p1;
	}
	public static void main(String[] args) throws IOException {
	 	   //To read the input from user at runtime
	   BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
	   int n;
	   
       //Loading Oracle Driver
	   try {
		   Class.forName("oracle.jdbc.OracleDriver");
		   System.out.println("Connected");
	   }
	   catch(Exception e) {
		   System.out.println("Unable to load driver class");
	   }
	   
	   //Connecting to the Database
	  try {
		   Connection dbc=DriverManager.getConnection("jdbc:oracle:thin:@//oracle.cs.ou.edu:1521/pdborcl.cs.ou.edu","raja0004","IRsj1Xj1");
		   
		   //Creating Statement object
	        Statement st=dbc.createStatement();
	        System.out.println("WELCOME TO THE PAN CLIENT AND DONOR DATABASE SYSTEM!!!\n"
	    	  		+ "1.Enter a new team into the database\n"
	    	  		+ "2.Enter a new client into the database and associate him or her with one or more teams\n"
	    	  		+ "3.Enter a new volunteer into the database and associate him or her with one or more teams\n"
	    	  		+ "4.Enter the number of hours a volunteer worked this month for a particular team\n"
	    	  		+ "5.Enter a new employee into the database and associate him or her with one or more teams\n"
	    	  		+ "6.Enter an expense charged by an employee\n"
	    	  		+ "7.Enter a new organization and associate it to one or more PAN teams\n"
	    	  		+ "8.Enter a new donor and associate him or her with several donations\n"
	    	  		+ "9.Enter a new organization and associate it with several donations\n"
	    	  		+ "10.Retrieve the name and phone number of the doctor of a particular client\n"
	    	  		+ "11.Retrieve the total amount of expenses charged by each employee for a particular period of time. The list should be sorted by the total amount of expenses\n"
	    	  		+ "12.Retrieve the list of volunteers that are members of teams that support a particular client\n"
	    	  		+ "13.Retrieve the names and contact information of the clients that are supported by teams sponsored by an organization whose name starts with a letter between B and K. The client list should be sorted by name\n"
	    	  		+ "14.Retrieve the name and total amount donated by donors that are also employees. The list should be sorted by the total amount of the donations, and indicate if each donor wishes to remain anonymous\n"
	    	  		+ "15.For each team, retrieve the name and associated contact information of the volunteer that has worked the most total hours between March and June\n"
	    	  		+ "16.Increase the salary by 10% of all employees to whom more than one team must report\n"
	    	  		+ "17.Delete all clients who do not have health insurance and whose value of importance for transportation is less than 5\n"
	    	  		+ "18.Import option-Entering Team values from a file\n"
	    	  		+ "19.Export option-Retrieve all data from Team and write to a file\n"
	    	  		+ "20.Exit from program");
	        
	        do{
	        	  System.out.println("Enter your option....");
	    	       n=Integer.parseInt(r.readLine());
	    	  switch(n) {
	    	          //Entering a new team
	    	  case 1: System.out.println("Enter the Team name");
	    	          String s1=(r.readLine());
	    	          System.out.println("Enter the Team type");
	    	          String s2=(r.readLine());
	    	          System.out.println("Enter the Team formed date");
	    	          String s3=(r.readLine());
	    	          st.executeUpdate("insert into Team values('"+s1+"','"+s2+"','"+s3+"')");
	    	          break;
	    	  case 2: //Entering a new client and associating clients to teams
	    		      int ssn=input();
	    	          System.out.println("Now Enter the Client details....");
	    	          System.out.println("Enter the Doctor name");
	    	          BufferedReader re=new BufferedReader(new InputStreamReader(System.in));
	    	          String c2=(re.readLine());
	    	          System.out.println("Enter the Attorney name");
	    	          String c3=(re.readLine());
	    	          System.out.println("Enter the Doctor phone number");
	    	          int c4=Integer.parseInt(re.readLine());
	    	          System.out.println("Enter the Attorney phone number");
	    	          int c5=Integer.parseInt(re.readLine());
	    	          System.out.println("Enter the date client was assigned to organization");
	    	          String c6=(re.readLine());
	    	          st.executeUpdate("insert into Client values('"+ssn+"','"+c2+"','"+c3+"','"+c4+"','"+c5+"','"+c6+"')");
	    	          System.out.println("Now Associating clients to teams");
	    	          System.out.println("Retrieving team names...");
	    	          ResultSet rs=st.executeQuery("select t_name from Team");
	    	          System.out.println("Tname\n");
	    	          while(rs.next()) {
	    	        	  System.out.println(rs.getString(1));
	    	          }
	    	          System.out.println("Enter the number of teams to be linked to");
	    	          int co=Integer.parseInt(re.readLine());
	    	          while(co!=0) {
	    	          System.out.println("Enter the team name to be associated with");
	    	          String tn=(re.readLine());
	    	          int str=0;
	    	          st.executeUpdate("insert into Cares values('"+ssn+"','"+tn+"','"+str+"')");
	    	          co--;}
	    	          break;
	    	          //Entering a new volunteer and associating volunteer to teams
	    	  case 3: int vp=input();
	    		      System.out.println("");
	                  System.out.println("Enter the Volunteer details..");
	                  System.out.println("Enter the Volunteer joining date");
	                  String v1=(r.readLine());
	                  System.out.println("Enter the Volunteer training date");
	                  String v2=(r.readLine());
	                  System.out.println("Enter the Volunteer training location");
	                  String v3=(r.readLine());
	                  st.executeUpdate("insert into Volunteer values('"+vp+"','"+v1+"','"+v2+"','"+v3+"')");
	                  ResultSet rs1=st.executeQuery("select t_name from Team");
	    	          System.out.println("Tname\n");
	    	          while(rs1.next()) {
	    	        	  System.out.println(rs1.getString(1));
	    	          }
	    	          System.out.println("Enter the number of teams to be linked to");
	    	          int vo=Integer.parseInt(r.readLine());
	    	          while(vo!=0) {
	    	          System.out.println("Enter the team name to be associated with");
	    	          String tt=(r.readLine());
	    	          System.out.println("Enter the no of hours he worked");
	    	          int t=Integer.parseInt(r.readLine());
	    	          System.out.println("Enter the value for month");
	    	          String tm=(r.readLine());
	    	          st.executeUpdate("insert into Serves values('"+vp+"','"+tt+"','"+t+"',1,'"+tm+"')");
	    	          vo--;}
	    	           break;
	    	           //Entering no of hours for volunteer data for particular client
	    	  case 4: System.out.println("Displaying Volunteer details...");
	    		      ResultSet rs2=st.executeQuery("select P_SSN,P_Name from Person where P_SSN in (select P_SSN from Volunteer) ");
	                  System.out.println("P_SSN\t\tName\n");
	                     while(rs2.next()) {
	        	             System.out.println(rs2.getString(1)+"\t"+rs2.getString(2));
	                        } 
	                     System.out.println("Displaying team names...");
	    		      ResultSet rs3=st.executeQuery("select t_name from Team");
	                  System.out.println("Tname\n");
	                  while(rs3.next()) {
	        	         System.out.println(rs3.getString(1));
	                     }
	                  System.out.println("Enter the SSN");
	                  int ps=Integer.parseInt(r.readLine());
	                  System.out.println("Enter the team name to be associated with");
	    	          String an=(r.readLine());
	    	          System.out.println("Enter the no of hours he worked");
	    	          int ho=Integer.parseInt(r.readLine());
	    	          System.out.println("Enter the value for month");
	    	          String m=(r.readLine());
	    	          st.executeUpdate("insert into Serves values('"+ps+"','"+an+"','"+ho+"',1,'"+m+"')");
	    		      break;
	    		      //Entering a new employee and associating employees to teams
	    	  case 5: int es=input();
	                  System.out.println("Enter the Employee details");
	                  System.out.println("Enter the salary of Employee");
	                  float sa=Float.parseFloat(r.readLine());
	                  System.out.println("Enter the Marital_status of Employee");
	                  String ms=(r.readLine());
	                  System.out.println("Enter the hire_date of the Employee");
	                  String hd=(r.readLine());
	                  st.executeUpdate("insert into Employee values('"+es+"','"+sa+"','"+ms+"','"+hd+"')");
	                  ResultSet rs4=st.executeQuery("select t_name from Team");
	    	          System.out.println("Tname\n");
	    	          while(rs4.next()) {
	    	        	  System.out.println(rs4.getString(1));
	    	          }
	    	          System.out.println("Enter the number of teams to be linked to");
	    	          int no=Integer.parseInt(r.readLine());
	    	          while(no!=0) {
	    	        	  System.out.println("Enter the team name to be associated with");
	    	              String ro=(r.readLine());
	    	              System.out.println("Enter the report description");
	    	              String r1=(r.readLine());
	    	              System.out.println("Enter the reporting date");
	    	              String r2=(r.readLine());
	    	              st.executeUpdate("insert into Report values('"+ro+"','"+es+"','"+r1+"','"+r2+"')");
	    	              no--;
	    	          }
   		               break;
   		               //Entering the expenses charged by employee
	    	  case 6:  ResultSet rs5=st.executeQuery("select P_SSN from Employee");
	                  System.out.println("Employess SSN\n");
	                  while(rs5.next()) {
	        	          System.out.println(rs5.getString(1));
	                     }
	                  System.out.println("Enter the employee SSN for whom expense to be recorded");
	                  String sn=(r.readLine());
	                  System.out.println("Enter the expense date");
	                  String ed=(r.readLine());
	                  System.out.println("Enter the expense amount");
	                  String ea=(r.readLine());
	                  System.out.println("Enter the expense description");
	                  String de=(r.readLine());
	                  st.executeUpdate("insert into Expense values('"+sn+"','"+ed+"','"+ea+"','"+de+"')");
   		               break;
   		               //Entering a new organization and associating it to teams
	    	  case 7:  System.out.println("Enter the organization name");
	    	           String on=(r.readLine());
	    	           System.out.println("Enter the organization address");
	    	           String oa=(r.readLine());
	    	           System.out.println("Enter the organization phone no");
	    	           String op=(r.readLine());
	    	           System.out.println("Enter the organization contact person");
	    	           String oc=(r.readLine());	
	    	           st.executeUpdate("insert into External_Organization values('"+on+"','"+oa+"','"+op+"','"+oc+"')"); 
	    	           ResultSet rs6=st.executeQuery("select t_name from Team");
		    	          System.out.println("Tname\n");
		    	          while(rs6.next()) {
		    	        	  System.out.println(rs6.getString(1));
		    	          }
		    	          System.out.println("Enter the number of teams to be linked to");
		    	          int o1=Integer.parseInt(r.readLine());
		    	          while(o1!=0) {
		    	          System.out.println("Enter the team name to be associated with");
		    	          String ot=(r.readLine());
		    	          st.executeUpdate("insert into Sponsors values('"+on+"','"+ot+"')"); 
		    	          o1--;}
   		               break;
   		               //Entering a new donor and associating donors to donations
	    	  case 8:  int ds=input();
	    	           System.out.println("Donor details....");
	    	           System.out.println("Enter whether the donor wishes to remain anonymous: yes or no");
	    	           String ano=(r.readLine());
	    	           st.executeUpdate("insert into Donor values('"+ds+"','"+ano+"')"); 
	    	           System.out.println("Donation details..");
	    	           System.out.println("Enter the no of donations");
	    	           int dn=Integer.parseInt(r.readLine());
	    	           while(dn!=0) {
	    	           System.out.println("Enter 1 for cheque and 2 for Card...");
	    	           int ch=Integer.parseInt(r.readLine());
	    	           if(ch==1) {
	    	        	   System.out.println("Enter the date of donantion");
	    	        	   String ddo=(r.readLine());
	    	        	   System.out.println("Enter the donation amount");
	    	        	   float dda=Float.parseFloat(r.readLine());
	    	        	   System.out.println("Enter the type of donation");
	    	        	   String dt=(r.readLine());
	    	        	   System.out.println("Enter the fund name of donation");
	    	        	   String fn=(r.readLine());
	    	        	   System.out.println("Enter the cheque no");
	    	        	   int che=Integer.parseInt(r.readLine());
	    	        	   st.executeUpdate("insert into Cheque values('"+ds+"','"+ddo+"','"+dda+"','"+dt+"','"+fn+"','"+che+"')"); 
	    	           }
	    	           else {
	    	        	   System.out.println("Enter the date of donantion");
	    	        	   String ddo=(r.readLine());
	    	        	   System.out.println("Enter the donation amount");
	    	        	   float dda=Float.parseFloat(r.readLine());
	    	        	   System.out.println("Enter the type of donation");
	    	        	   String dt=(r.readLine());
	    	        	   System.out.println("Enter the fund name of donation");
	    	        	   String fn=(r.readLine());
	    	        	   System.out.println("Enter the card no");
	    	        	   int car=Integer.parseInt(r.readLine());
	    	        	   System.out.println("Enter the card type");
	    	        	   String cty=(r.readLine());
	    	        	   System.out.println("Enter the card expiry date");
	    	        	   String exp=(r.readLine());
	    	        	   st.executeUpdate("insert into Card values('"+ds+"','"+ddo+"','"+dda+"','"+dt+"','"+fn+"','"+car+"','"+cty+"','"+exp+"')"); 
	    	           }dn--;}
	    		       break;
	    		       //Entering a new organization and associating it to donations
	    	  case 9:  System.out.println("Enter the organization name");
	                   String on1=(r.readLine());
	                   System.out.println("Enter the organization address");
	                   String oa1=(r.readLine());
	                   System.out.println("Enter the organization phone no");
	                   String op1=(r.readLine());
	                   System.out.println("Enter the organization contact person");
	                   String oc1=(r.readLine());	
	                   st.executeUpdate("insert into External_Organization values('"+on1+"','"+oa1+"','"+op1+"','"+oc1+"')"); 
	                   System.out.println("Organization Donor details....");
	    	           System.out.println("Enter whether the org_donor wishes to remain anonymous: yes or no");
	    	           String ano1=(r.readLine());
	    	           st.executeUpdate("insert into Org_donors values('"+on1+"','"+ano1+"')"); 
	    	           System.out.println("Org_Donation details..");
	    	           System.out.println("Enter the no of donations");
	    	           int nd=Integer.parseInt(r.readLine());
	    	           while(nd!=0) {
	    	           System.out.println("Enter 1 for cheque and 2 for Card...");
	    	           int ch1=Integer.parseInt(r.readLine());
	    	           if(ch1==1) {
	    	        	   System.out.println("Enter the date of donantion");
	    	        	   String ddo=(r.readLine());
	    	        	   System.out.println("Enter the donation amount");
	    	        	   float dda=Float.parseFloat(r.readLine());
	    	        	   System.out.println("Enter the type of donation");
	    	        	   String dt=(r.readLine());
	    	        	   System.out.println("Enter the fund name of donation");
	    	        	   String fn=(r.readLine());
	    	        	   System.out.println("Enter the cheque no");
	    	        	   int che=Integer.parseInt(r.readLine());
	    	        	   st.executeUpdate("insert into Org_Cheque values('"+on1+"','"+ddo+"','"+dda+"','"+dt+"','"+fn+"','"+che+"')"); 
	    	           }
	    	           else {
	    	        	   System.out.println("Enter the date of donation");
	    	        	   String ddo=(r.readLine());
	    	        	   System.out.println("Enter the donation amount");
	    	        	   float dda=Float.parseFloat(r.readLine());
	    	        	   System.out.println("Enter the type of donation");
	    	        	   String dt=(r.readLine());
	    	        	   System.out.println("Enter the fund name of donation");
	    	        	   String fn=(r.readLine());
	    	        	   System.out.println("Enter the card no");
	    	        	   int car=Integer.parseInt(r.readLine());
	    	        	   System.out.println("Enter the card type");
	    	        	   String cty=(r.readLine());
	    	        	   System.out.println("Enter the card expiry date");
	    	        	   String exp=(r.readLine());
	    	        	   st.executeUpdate("insert into Org_Card values('"+on1+"','"+ddo+"','"+dda+"','"+dt+"','"+fn+"','"+car+"','"+cty+"','"+exp+"')"); 
	    	           } nd--;}
   		               break;
   		               //Retrieving the name and phoneno of the doctor for particular client
	    	  case 10: System.out.println("Displaying Client SSNs..");
	    	           ResultSet rs7=st.executeQuery("select P_SSN from Client");
	                   System.out.println("Clients SSN\n");
	                   while(rs7.next()) {
	        	          System.out.println(rs7.getString(1));
	                   }
	                   System.out.println("Enter the Client SSN to get the doctor details");
		    	          int dssn=Integer.parseInt(r.readLine());
		    	          ResultSet rs8=st.executeQuery("select Dname,Dphno from Client where P_SSN='"+dssn+"'");
		    	          System.out.println("Doctor Name"+"\t"+"Doctor phone_number");
		    	          while(rs8.next()) {
		        	          System.out.println(rs8.getString(1)+"\t"+rs8.getString(2));
		                   }
   		               break;
   		               //Retrieving the total expense charged by employee for a period of time
	    	  case 11: System.out.println("Enter the date range to retrieve the employee expense");
	    	           System.out.println("Enter the starting date");
	    	           String sdate=(r.readLine());
	    	           System.out.println("Enter the ending date");
	    	           String edate=(r.readLine());
	    	           System.out.println("Employee_SSN"+"\t"+"Total expense");
	    	           ResultSet rs9=st.executeQuery("select P_SSN,sum(E_amount) from expense where E_date between '"+sdate+"' and '"+edate+"' group by P_SSN order by sum(E_amount) asc");
	    	           while(rs9.next()) {
		        	          System.out.println(rs9.getString(1)+"\t\t\t"+rs9.getString(2));
		                   }
   		               break;
   		               //Retrieving the list of volunteers that are members of teams that support a particular client
	    	  case 12: System.out.println("Displaying Client SSNs..");
	    	           ResultSet rs10=st.executeQuery("select P_SSN from cares");
	    	           while(rs10.next()) {
		        	          System.out.println(rs10.getString(1));
		                   }
	    	           System.out.println("Enter the Client SSN to retrieve the Volunteer details..");
	    	           int rssn=Integer.parseInt(r.readLine());
	    	           ResultSet rs11=st.executeQuery("select P_SSN,P_Name from Person where P_SSN in (select P_SSN from serves where T_name in (select T_name from cares where P_SSN='"+rssn+"'))");
	    	           System.out.println("PSSN"+"\t"+"Name");
	    	           while(rs11.next()) {
		        	          System.out.println(rs11.getString(1)+"\t"+rs11.getString(2));
		                   }
	    	          
	    	           break;
	    	           //Retrieving the names and contact information of the clients that are supported by teams sponsored by an organization whose name starts with a letter between B and K. The client list should be sorted by name
	    	  case 13: System.out.println("Name"+"\t"+"Address"+"\t\t"+"Email"+"\t\t"+"Homephno"+"\t"+"workphno"+"\t"+"cellphno");
	    	           ResultSet rs12=st.executeQuery("select P_Name,Address, Email, Home_phno, Work_phno, Cell_phno from Person where P_SSN in(select P_SSN from cares where T_name in (select T_name from Sponsors where O_name between 'B%' and 'T%')) order by P_Name asc");
	                   while(rs12.next()) {
       	                  System.out.println(rs12.getString(1)+"\t"+rs12.getString(2)+"\t"+rs12.getString(3)+"\t\t"+rs12.getString(4)+"\t\t"+rs12.getString(5)+"\t\t"+rs12.getString(6));
                         }
   		               break;
	    	  case 14: System.out.println("Retrieving name and total amount donated by donors who are also employees");
	    	           ResultSet rs13=st.executeQuery("select p.P_Name,d.Anonymous,amount from (select am.P_SSN ssn,max(am.Amount) amount from (select c.P_SSN,c.Amount from Cheque c,Employee e where c.P_SSN=e.P_SSN  union all select ca.P_SSN,ca.Amount from Card ca,Employee e where ca.P_SSN=e.P_SSN)am group by am.P_SSN),donor d,Person p where d.P_SSN=ssn and p.P_SSN=ssn");
	    	           System.out.println("Name"+"\t"+"Anonymous"+"\t"+"Total Amount");
	    	           while(rs13.next()) {
		        	          System.out.println(rs13.getString(1)+"\t\t"+rs13.getString(2)+"\t"+rs13.getString(3));
		                   }
   		               break;
   		               //Retrieving name and contact info of volunteers who worked max hours between March and June
	    	  case 15: System.out.println("Retrieving name and contact information of the volunteers...");
	    	           System.out.println("Name"+"\t"+"Address"+"\t\t"+"Email"+"\t\t"+"Homephno"+"\t"+"workphno"+"\t"+"cellphno");
	    	           ResultSet rs14=st.executeQuery("select P_Name,Address,Email,Home_phno,Work_phno,Cell_phno from person,serves where person.P_SSN=serves.P_SSN and (serves.t_name,serves.hours) in (select T_name,max(hours) from serves where Month in ('March','April','May','June') group by T_name);");
	    	           		 while(rs14.next()) {
	       	                  System.out.println(rs14.getString(1)+"\t"+rs14.getString(2)+"\t"+rs14.getString(3)+"\t\t"+rs14.getString(4)+"\t\t"+rs14.getString(5)+"\t\t"+rs14.getString(6));
	                         }
	   		               
	    	           break;
	    	           //Updating the employee salary to whom more than one team is reporting
	    	  case 16: st.executeQuery("update employee set salary=salary+(salary/10) where P_SSN in (select P_SSN from report group by P_SSN having count(P_SSN)>1)");
   		               System.out.println("Salary Updated...");
	    	           ResultSet rs15=st.executeQuery("Select * from employee");
	    	           System.out.println("EmployeeSSN"+"\t"+"Salary"+"\t"+"Marital_status"+"\t"+"Hire_date");
	    	           while(rs15.next()) {
		        	          System.out.println(rs15.getString(1)+"\t\t"+rs15.getString(2)+"\t"+rs15.getString(3)+"\t\t"+rs15.getString(4));
		                   }
	    	          
	    	           break;
	    	           //Deleting client details who don't have health insurance and their need of transportation has value less than 5
	    	  case 17: System.out.println("Before deletion...");
	    	           System.out.println("ClientSSN"+"\t"+"Dname"+"\t"+"Aname"+"\t"+"Dphno"+"\t"+"Aphno"+"\t"+"Date");
	    	           ResultSet rs16=st.executeQuery("Select * from client");
	    	           while(rs16.next()) {
		        	          System.out.println(rs16.getString(1)+"\t\t"+rs16.getString(2)+"\t"+rs16.getString(3)+"\t"+rs16.getString(4)+"\t"+rs16.getString(5)+"\t"+rs16.getString(6));
		                   }
	    	           st.executeQuery("delete from client where P_SSN not in (select P_SSN from insurance_policy where P_type='health') and P_SSN in (select P_SSN from needs where type='transportation' and value<5)");
	    	           System.out.println("Deleting Client data...");
	    	           System.out.println("After deletion...");
	    	           System.out.println("ClientSSN"+"\t"+"Dname"+"\t"+"Aname"+"\t"+"Dphno"+"\t"+"Aphno"+"\t"+"Date");
	    	           ResultSet rs17=st.executeQuery("Select * from client");
	    	           while(rs17.next()) {
		        	          System.out.println(rs17.getString(1)+"\t\t"+rs17.getString(2)+"\t"+rs17.getString(3)+"\t"+rs17.getString(4)+"\t"+rs17.getString(5)+"\t"+rs17.getString(6));
		                   }
	    	           break;
	    	           //Importing data from a file into team table
	    	  case 18: System.out.println("Enter import file name: ");    
				       String import_file_name=r.readLine(); 
				       FileInputStream fstream = new FileInputStream("C:/Users/rvino/Desktop/"+import_file_name); 
				       DataInputStream in = new DataInputStream(fstream);     
				      BufferedReader br18 = new BufferedReader(new InputStreamReader(in)); 
				       String strLine;  
				      while ((strLine = br18.readLine()) != null)
				     {         
					    String a[] = strLine.split(",");        
					    String name = a[0];      
					    String type = a[1];    
					    String date=a[2];
					    st.executeUpdate("insert into team values('"+name+ "','" +type+ "','"+date+"')");  
					    System.out.println(" One row inserted succesfully");		      
				     }       
				     System.out.println("File imported succesfully...");
   		               break;
   		               //Exporting team data to a file
	    	  case 19: System.out.println("Exporting data to a file..");
	    		       ResultSet rs18=st.executeQuery("select * from team");
	    		       System.out.println("Enter output file name: ");    
				       String opt=r.readLine();    
				       BufferedWriter output = new BufferedWriter(new FileWriter("C:/Users/rvino/Desktop/"+opt));     
				       while(rs18.next())
				      {        
					     String str= rs18.getString("T_name");
					     String st1= rs18.getString("T_Type");
					     String st2 =rs18.getString("T_date"); 
					     output.write("\n");
					     output.write(str+"\t");
					     output.write(st1+"\t");
					     output.write(st2+"\t");
					     output.write("\n");  
					      System.out.println(" One Record inserted in a file succesfully!"); 
				      }        
				       System.out.println(" File exported succesfully...");     
				       output.close();        
   		               break;
	    	  case 20: System.out.println("Exiting....");
	    		       System.exit(0);
	    	           break;
	    	  }
	      }while(n<20);
	      
       
	       
	        dbc.close();
	   }
	   catch(SQLException e) {
		   e.printStackTrace();
	   }
	  	  } 


}
