import java.lang.Math;
import java.util.Scanner;
public class Employee {

  public static void main(String[] args) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    while (true) {
      System.out.print("\nEnter your ID number:- ");
      String s = in .next();
      s = s.toLowerCase();
      s = s.trim();

      if (s.equals("0")) {
        break;
      } else if (s.equals("admin")) {
    	  
    	  System.out.print("\n Enter username -");
          String un = in .next();
    	  System.out.print("\n Enter password -");
          String pass = in .next();
    	  if(Admin.AdminCheck(un, pass)) {
        System.out.println("\n\t WELCOME TO ADMIN PANAL (Double check before do anything this panal is sensitive)");

        while (true) {
          System.out.print("\n\tADMIN\n\t1.Add a new employee \n\t2.Remove employee\n\t3.Search with ID\n\t4.Update employee details\n\t5.Display all employee\n\t0.Exit");
          try {
            System.out.print("\n Enter your interest -");
            int AoptionCh = in .nextInt();
            if (AoptionCh == 1) {
              int random_id = (int)(1000 * Math.random());
              //HOW TO INSERT 
              //Admin.AddEmp(random_id, FRIST NAME , AGE , CITY, NO OF PRESENT DAY , NO OF ABSENT DAY , NO OF HALF DAY , DEPARTMENT NAME ,PROJECT TITLE,PROJECT DISCRIPTION , STARTING DATE OF PROJECT , ENDING DAT OF PROJECT, TOTAL NO OF PROJECT COMPLETE , RATTING , SALARY , BONOUS )
              System.out.print("\n Enter Employee information");
              System.out.print("\n Enter the name -");
              String name=in.next();
              System.out.print("\n Enter the age  -");
              int age = in .nextInt();
              System.out.print("\n Enter the city -");
              String address=in.next();
              System.out.print("\n Enter the total present day  -");
              int tp = in .nextInt();
              System.out.print("\n Enter the total absent day  -");
              int ta = in .nextInt();
              System.out.print("\n Enter the Total half day  -");
              int phone = in .nextInt();
              System.out.print("\n Enter the department name -");
              String dpname=in.next();
              System.out.print("\n Enter the project name -");
              String projectname=in.next();
              in.nextLine();
              System.out.print("\n Enter the mail id -");
              String email=in.next();
              in.nextLine();
              System.out.print("\n Enter the project start date -");
              String sd=in.next();
              in.nextLine();
              System.out.print("\n Enter the project deadline -");
              String ed=in.next();
              System.out.print("\n Enter the total project complete  -");
              int tpc = in .nextInt();
              System.out.print("\n Enter the ratting out of 10 -");
              int ratting = in .nextInt();
              System.out.print("\n Enter the salary  -");
              int salary = in .nextInt();
              System.out.print("\n Enter the bonous  -");
              int bonous = in .nextInt();
              Admin.AddEmp(random_id,name,age,address,tp,ta,phone,dpname,projectname,email,sd,ed,tpc,ratting,salary,bonous);
            } else if (AoptionCh == 2) {
              try {
                System.out.print("\nEnter the id of employee you want to delete - ");
                int checksts = in .nextInt();
                Admin.Delete(checksts);
              } catch (Exception e) {
                System.out.println("\n\tINVALID...");
                break;
              }
            } else if (AoptionCh == 3) {
              System.out.print("\nEnter the id of employee you want to check - ");
              int checksts = in .nextInt();
              if (ShowEmployee.Check(checksts) == 1) {
                Admin.SearchEmp(checksts);
              } else {
                System.out.println("NO EMPLOYEE FOUND ");
              }
            } else if (AoptionCh == 4) {
              try {
                System.out.print("\nEnter the id of employee you want to update - ");
                int checksts = in .nextInt();
                Admin.Update(checksts);
              } catch (Exception e) {
                System.out.println("\n\tINVALID...");
                break;
              }
            }  else if (AoptionCh == 5) {
                try {
                    Admin.ShowAllEmp();
                  } catch (Exception e) {
                    System.out.println("\n\tINVALID...");
                    break;
                  }
                }
            else if (AoptionCh == 0) {
              System.out.print("\n \tExiting from admin panel. ");
              break;
            } else {
              System.out.print("\nMaybe you enter wrong choice.");
            }
          } catch (Exception e) {
            System.out.println("\n\tINVALID...");
            break;
          }
        }}
    	
      } //for admin else
      else if (s.equals("createtable")) {
        TableCreate.Create();
      } //for table crea else
      else {
        try {
          int ch = Integer.parseInt(s);
          if (ShowEmployee.Check(ch) == 1) {
        	  System.out.print("Enter Your Password - ");
        	  String cp=in.next();
        	  cp=cp.toLowerCase();
        	  cp=cp.trim();
        	  if(ShowEmployee.CheckPass(cp, ch)) {
        		  ShowEmployee.Show(ch);  
        	  }
        	  else {
        		  System.out.println("\nWRONG PASSWORD");
        	  }
          } else {
            System.out.println("NO EMPLOYEE FOUND ");
          }
        } catch (Exception e) {
          System.out.print("NOT SUPPORTED");
        }
      } // for else 
    }

  }

private static void nextLine() {
	// TODO Auto-generated method stub
	
}

}