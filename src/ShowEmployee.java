import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ShowEmployee {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost/employeemanagementsystem";
  //  Database credentials
  static final String USER = "root"; //USERNAME
  static final String PASS = ""; //PASSWORD
  public static void Show(int passid) { // DISPLAY THE AVALABLE MOVIE LIST 
    Connection conn = null;
    Statement stmt = null;
    try {

      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("\n\tConnecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("\n\tFetching data from database...\n");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM emp where empid=" + passid;
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
//        int empid = rs.getInt("empid");
        String empname = rs.getString("empname");
        int empage = rs.getInt("empage");
        String empaddress = rs.getString("empaddress");
        int emptotalpresent = rs.getInt("emptotalpresent");
        int emptotalabsent = rs.getInt("emptotalabsent");
        int emptotalhalfday = rs.getInt("emptotalhalfday");
        String empdepartment = rs.getString("empdepartment");
        String empprojectassinetitle = rs.getString("empprojectassinetitle");
        String empprojectassinedis = rs.getString("empprojectassinedis");
        String empprojectstartdate = rs.getString("empprojectstartdate");
        String empprojectenddate = rs.getString("empprojectenddate");
        int emptotalcompleteproject = rs.getInt("emptotalcompleteproject");
        int empratting = rs.getInt("empratting");
        int empsalary = rs.getInt("empsalary");
        int empbonous = rs.getInt("empbonous");

        System.out.print("\n\nWelcome " + empname + " hope you are doing good,\nHere are the informations :- \n");
        System.out.println("Name:- " + empname);
        System.out.println("Address:- " + empaddress);
        System.out.println("Age:- " + empage);
        System.out.println("Mail id:- " + empprojectassinedis);
        System.out.println("Department:- " + empdepartment);
        System.out.println("Total number of present days:- " + emptotalpresent);
        System.out.println("Total number of absent days:- " + emptotalabsent);
        System.out.println("Total number of half days:- " + emptotalhalfday);
        System.out.println("Here are the project info:-");
        System.out.println("Project title:- " + empprojectassinetitle);
        
        System.out.println("Project assined date:- " + empprojectstartdate);
        System.out.println("Project dead line :- " + empprojectenddate);
        if (emptotalcompleteproject == 0) {
          System.out.println("Huhh..!! We see that you complete 0 projet till now . Please be consistance");
        } else if (emptotalcompleteproject <= 10 && emptotalcompleteproject > 0) {
          System.out.println("We see that you complete " + emptotalcompleteproject + " projets till now. Good ");
        } else if (emptotalcompleteproject <= 20 && emptotalcompleteproject > 10) {
          System.out.println("Great !! We see that you complete " + emptotalcompleteproject + " projets till now.");
        } else if (emptotalcompleteproject > 20) {
          System.out.println("Wow you are killing it you complete " + emptotalcompleteproject + " projets till now. Keep it up.");
        }

        System.out.println("\nYour ratting based on your performanced");
        for (int i = 0; i < empratting; i++) {
          System.out.print("*");
        }
        System.out.print("\nYour salary RS " + empsalary + " Ahh you got a bonous RS " + empbonous + "\n Total salary RS " + (empsalary + empbonous));

      }
      rs.close();
      stmt.close();
      conn.close();
      System.out.println("\n\tEND");
    } catch (SQLException se) {
      System.out.println("\n\tSQL ERROR");
    } catch (Exception e) {
      System.out.println("\n\tERROR OCCERS");
    } finally {
      try {
        if (stmt != null)
          stmt.close();
      } catch (SQLException se2) {}
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        System.out.println("\n\tSQL ERROR");
      }
    }
  }

  public static int Check(int passid) { // DISPLAY THE AVALABLE MOVIE LIST 
    Connection conn = null;
    Statement stmt = null;
    int c = 0;
    try {

      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      stmt = conn.createStatement();
      String sql;

      sql = "SELECT * FROM emp where empid=" + passid;
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        c = c + 1;
      }
      rs.close();
      stmt.close();
      conn.close();

    } catch (SQLException se) {
      System.out.println("\n\tSQL ERROR");
    } catch (Exception e) {
      System.out.println("\n\tERROR OCCERS");
    } finally {
      try {
        if (stmt != null)
          stmt.close();
      } catch (SQLException se2) {}
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        System.out.println("\n\tSQL ERROR");
      }
    }
    return c;
  }
  
  
  
  public static boolean CheckPass(String Epass,int passid) { // DISPLAY THE AVALABLE MOVIE LIST 
	    Connection conn = null;
	    Statement stmt = null;
	    String crpass="";
	    try {

	      Class.forName("com.mysql.jdbc.Driver");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      stmt = conn.createStatement();
	      String sql;

	      sql = "SELECT * FROM emp where empid=" + passid;
	      ResultSet rs = stmt.executeQuery(sql);
	      while (rs.next()) {
	    	  String empdepartment = rs.getString("empdepartment");
	          String empaddress = rs.getString("empaddress");
	          empaddress=empaddress.toLowerCase();
	          crpass=crpass+empaddress+empdepartment;
//	          System.out.print(crpass);
	      }
	      rs.close();
	      stmt.close();
	      conn.close();

	    } catch (SQLException se) {
	      System.out.println("\n\tSQL ERROR");
	    } catch (Exception e) {
	      System.out.println("\n\tERROR OCCERS");
	    } finally {
	      try {
	        if (stmt != null)
	          stmt.close();
	      } catch (SQLException se2) {}
	      try {
	        if (conn != null)
	          conn.close();
	      } catch (SQLException se) {
	        System.out.println("\n\tSQL ERROR");
	      }
	    }
	    crpass=crpass.toLowerCase();
	    if (crpass.equals(Epass)) {
	    	return true;
	    }
	    return false;
	  }


}