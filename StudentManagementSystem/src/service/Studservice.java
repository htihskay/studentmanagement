package service;

import java.sql.ResultSet;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import pojo.*;
import dao.*;

public class Studservice {
	
	public static void inputData(String signIn) throws Exception {
//		Stud obj=new Stud();
//		Scanner s=new Scanner(System.in);
//		System.out.println("Enter the id");
//		String ids=s.nextLine();
//		int id=Integer.parseInt(ids);
//		System.out.println("Enter the name");
//		String name=s.nextLine();
//		System.out.println("Enter the age");
//		int age=s.nextInt();
//		
//		obj.setId(id);
//		obj.setName(name);
//		obj.setAge(age);
		
		System.out.println("Enter total number of students");
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int id_;
		String name_;
		int age_;
		Stud[] ob=new Stud[n];
		for(int i=0;i<n;i++) {
			System.out.println("ID");
	
			id_=in.nextInt();
			
			in.nextLine();
			
			
			System.out.println("Name");
			name_=in.nextLine();
			
			
			System.out.println("Age");
			age_=in.nextInt();
			//id_=Integer.parseInt(ids);
			ob[i]=new Stud(id_,name_,age_);
			
		}

		Studdao o=new Studdao();
		o.insert(ob,n,signIn);
		
	}
	
	public static void deleteData() throws Exception {
		System.out.println("Enter the student ID you want to delete");
		Scanner s=new Scanner(System.in);
		int id=s.nextInt();
		Studdao.delete(id);
	}
	
	public static void printPagination() throws Exception {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the page limit");
		int limit=s.nextInt();
		System.out.println("Enter the page offset");
		int offset=s.nextInt();
		
		Studdao.pagination(limit, offset);
	}

	public static void updateInformation(String signIn) throws Exception {
		System.out.println("Enter the studentId you wanted to update");
		Scanner s=new Scanner(System.in);
		String input;
		input=s.nextLine();
		int id=Integer.parseInt(input);
		System.out.println("Enter the first name to be updated");
		String name=s.nextLine();
		Studdao.updateInfo(id,name,signIn);
	}
	public static void sortByNameFun() throws Exception{
		//pending
		Studdao.sort();
	}
	public static void searchByName() throws Exception {
		//pending
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the student name you want to search=");
		String str=s.nextLine();
		
		
		List<Stud> result=Studdao.searchByName(str);
		System.out.println("******Student Deatils******");
		for(Stud res:result) {
			System.out.println(res.getId()+" "+res.getName()+" "+res.getAge());
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		//inputData();
		//deleteData();
		//printPagination();
		//updateInformation();
//		int go=1;
//		while(go==1) {
//			
//			System.out.println("NEW project Enter the option");
//			System.out.println("1)Inser 2)Delete 3)Pagination 4)Update 5)Sort 6)Search");
//			int option;
//			Scanner ob=new Scanner(System.in);
//			option=ob.nextInt();
//			
//			switch(option) {
//			case 1:inputData();;
//				break;
//			case 2:deleteData();
//				break;
//			case 3:printPagination();
//				break;
//			case 4 :updateInformation();
//				break;
//			case 5:sortByNameFun();
//				break;
//			case 6:searchByName();
//				break;
//				
//			default:System.out.println("You have not entered option/Unmatch option");	
//				
//			}
//			System.out.println("To break Enter 0 else 1");
//			
//			go=ob.nextInt();
//			
//		}
//		
//		
//		
//		System.out.println("***********END**********");
		

	}

}
