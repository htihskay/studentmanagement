package dao;
import java.sql.Connection;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import service.*;
import pojo.Stud;
public class Studdao {
	
		 private static List<Stud> studentList,studentlist;
		 
		 public Connection connectionToDb() throws Exception {
			 Class.forName("com.mysql.cj.jdbc.Driver");
				String url="jdbc:mysql://localhost:3306/stud";
				//table name studentdb
				String uname="root";
				String pword="root";
				Connection con=DriverManager.getConnection(url,uname,pword);
				return con;
		 }
	
		public void insert(Stud[] ob,int n,String signIn) throws Exception{

			
			Studdao o=new Studdao();
			
			Connection con=o.connectionToDb();
			PreparedStatement	ins=con.prepareStatement("insert into studentdb values(?,?,?,?,?,?,?)");
			
//			System.out.println("Enter total number of students");
//			Scanner in=new Scanner(System.in);
//			int n=in.nextInt();
//			int id_;
//			String name_;
//			int age_;
//			Stud[] ob;
//			ob=new Stud[n];
//			for(int i=0;i<n;i++) {
//				System.out.println("ID");
//				id_=in.nextInt();
//				
//				ob[i].setId(id_);
//				System.out.println("Name");
//				name_=in.nextLine();
//				ob[i].setName(name_);
//				
//				System.out.println("Age");
//				age_=in.nextInt();
//				ob[i].setAge(age_);
//				
//			}
			
			for(int i=0;i<n;i++) {
				ins.setInt(1,ob[i].getId() );
				ins.setString(2,ob[i].getName());
				ins.setInt(3,ob[i].getAge());
				ins.setString(4, signIn);
				ins.setString(5, "null"); // will make updated by as null initially
				ins.setTimestamp(7,new Timestamp(new java.util.Date().getTime()));
				ins.setTimestamp(6,null);
				ins.addBatch();
			}
			//here i will try to execute all the sql in a single shot
			ins.executeBatch();
			
//			Integer id=obj.getId();
//			String name=obj.getName();
//			Integer age=obj.getAge();
//			System.out.println(name+" "+age);
//			ins.setInt(1,id );
//			ins.setString(2,name);
//			ins.setInt(3, age);
//			
//			ins.setString(4, "dummy");
//			ins.setString(5, "dummy");
//			ins.setTimestamp(7,new Timestamp(new java.util.Date().getTime()));
//			ins.setTimestamp(6,null);
//			ins.executeUpdate();
//			
//			studentlist= new ArrayList<Stud>();
//			studentlist.add(obj);
//			//System.out.println(studentlist);
		}
		
		public static void delete(int id) throws Exception {

			Studdao o=new Studdao();
			
			Connection con=o.connectionToDb();
			Statement st=con.createStatement();
			//String delete="delete from student where sid=3";
			String delete="delete from studentdb where sid="+id;
			st.executeUpdate(delete);
			st.close();
			System.out.println("Student id of "+id+" deleted ");
		}
		
		public static void pagination(int limit,int offset) throws Exception {
			

			Studdao o=new Studdao();
			Connection con=o.connectionToDb();
			Statement st=con.createStatement();
			System.out.println("******Student Details "+limit+" students details per page from row number-->"+(offset+1)+"******");
			
			String pagi="select * from studentdb limit "+limit+" offset "+offset;
			ResultSet prs=st.executeQuery(pagi);
			studentList = new ArrayList<Stud>();
			while(prs.next()) {
				
				System.out.println(prs.getInt(1)+" "+prs.getString(2)+" "+prs.getInt(3));
				studentList.add(new Stud(prs.getInt(1),prs.getString(2),prs.getInt(3)));
					
			}
			
			//System.out.println(studentList);
		}

		
		public static void updateInfo(int id,String name,String signIn) throws Exception{
			
			Studdao o=new Studdao();
			Connection con=o.connectionToDb();
			
			Statement st=con.createStatement();
			
			
			
			//String update="update student set fname='Rakshith' where sid=2";
			
			String update="update studentdb set updatetimestamp=current_time, sname="+"'"+name+"'"+","+"updatedby="+"'"+signIn+"'"+"where sid="+id;
			st.executeUpdate(update);
			
			System.out.println("DATA UPDATED");
		}
		public static void sort() throws Exception {
			Studdao o=new Studdao();
			Connection con=o.connectionToDb();
			
			Statement st=con.createStatement();
			String sortByName="select * from studentdb order by sname asc";
			ResultSet sortrs=st.executeQuery(sortByName);
			System.out.println("*************Student Details are sorted by NAME******************");
			while(sortrs.next()) {
				System.out.println(sortrs.getInt(1)+" "+sortrs.getString(2)+" "+sortrs.getInt(3));
			}
		}
		
		public static List<Stud> searchByName(String str) throws Exception{
			Studdao o=new Studdao();
			Connection con=o.connectionToDb();
			
			Statement st=con.createStatement();
			
			String srch="select * from studentdb where sname="+"'"+str+"'";
			//System.out.println(srch);
			//String srch="select * from student where fname='Python'";
			studentList = new ArrayList<Stud>();
			ResultSet prs=st.executeQuery(srch);
			while(prs.next()) {
				
				System.out.println(prs.getInt(1)+" "+prs.getString(2)+" "+prs.getInt(3));
				studentList.add(new Stud(prs.getInt(1),prs.getString(2),prs.getInt(3)));
					
			}
			return studentList;
		}
	public static void main(String[] args) {
		

	}

}
