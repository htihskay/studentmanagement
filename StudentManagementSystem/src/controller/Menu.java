package controller;

import java.util.Scanner;
import service.Studservice;
public class Menu {

	public static void main(String[] args) throws Exception{
		
		
		System.out.println("......Please SignIn......");
		Scanner s=new Scanner(System.in);
		String signIn=s.nextLine();
		int go=1;
		while(go==1) {
			
			System.out.println("NEW project Enter the option");
			System.out.println("1)Insert 2)Delete 3)Pagination 4)Update 5)Sort 6)Search");
			int option;
			Scanner ob=new Scanner(System.in);
			option=ob.nextInt();
			
			switch(option) {
			case 1:Studservice.inputData(signIn);
				break;
			case 2:Studservice.deleteData();
				break;
			case 3:Studservice.printPagination();
				break;
			case 4 :Studservice.updateInformation(signIn);
				break;
			case 5:Studservice.sortByNameFun();
				break;
			case 6:Studservice.searchByName();
				break;
				
			default:System.out.println("You have not entered option/Unmatch option");	
				
			}
			System.out.println("To break Enter 0 else 1");
			
			go=ob.nextInt();
			
		}
		
		
		
		System.out.println("***********END**********");
	}

}
