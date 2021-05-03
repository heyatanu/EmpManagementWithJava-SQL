import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class Admin {
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost/employeemanagementsystem";
  static final String USER = "root";
  static final String PASS = "";

  public static void AddEmp(int empid, String empname, int empage, String empaddress, int emptotalpresent,
    int emptotalabsent, int emptotalhalfday, String empdepartment, String empprojectassinetitle,
    String empprojectassinedis, String empprojectstartdate, String empprojectenddate, int emptotalcompleteproject,
    int empratting, int empsalary, int empbonous) {
    Connection conn = null;
    Statement stmt = null;
    try {

      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("\n\tConnecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("\n\tTry to add this to database...");

      //STEP 4: Execute a query
      stmt = conn.createStatement();

      String sql = "INSERT INTO emp " +
        "VALUES (" + empid + ",'" + empname + "'," + empage + ",'" + empaddress + "'," + emptotalpresent + "," +
        emptotalabsent + "," + emptotalhalfday + ",'" + empdepartment + "','" + empprojectassinetitle + "','" +
        empprojectassinedis + "','" +
        empprojectstartdate + "','" + empprojectenddate + "'," +
        emptotalcompleteproject + "," + empratting + "," + empsalary + "," + empbonous + ")";

      stmt.executeUpdate(sql);
      System.out.println("\n\tEmployee ID " + empid + " inserted into the table Successfull..");

    } catch (SQLException se) {

      //         System.out.println("\n\tSQL ERROR");
      System.out.println("\n\tEmployee Id is already present or you pass wrong input please check------Insert Failed");
    } catch (Exception e) {
      //Handle errors for Class.forName
      System.out.println("\n\tERROR OCCERS");
      //         System.out.println("2");
    } finally {
      //finally block used to close resources
      try {
        if (stmt != null)
          conn.close();
      } catch (SQLException se) {} // do nothing
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        System.out.println("\n\tSQL ERROR");
      }
    }
  }

  public static void Delete(int passid) {
    Connection conn = null;
    Statement stmt = null;
    try {

      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("\n\tConnecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("\n\tTry to delete this from database.....");

      stmt = conn.createStatement();
      String sql = "DELETE FROM emp " +
        "WHERE empid = " + passid;
      stmt.executeUpdate(sql);
      System.out.println("\n\tEmployee ID " + passid + " delete from database successfull.....");
      // Now you can extract all the records
      // to see the remaining records
    } catch (SQLException se) {

      System.out.println("\n\tSQL ERROR");
    } catch (Exception e) {
      //Handle errors for Class.forName
      System.out.println("\n\tERROR OCCERS");
    } finally {
      //finally block used to close resources
      try {
        if (stmt != null)
          conn.close();
      } catch (SQLException se) {} // do nothing
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        System.out.println("\n\tSQL ERROR");
      }
    }
  }

  public static void Update(int passid) {
    @SuppressWarnings("resource")
    Scanner in = new Scanner(System.in);
    Connection conn = null;
    Statement stmt = null;
    try {

      Class.forName("com.mysql.jdbc.Driver");

      System.out.println("\n\tConnecting to database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("\n\tTry to update this from database.....");
      try {
        //STEP 4: Execute a query
        System.out.print("\n\t1.Update the employee name\n\t2.Update the employee age\n\t3.Update the employee address" +
          "\n\t4.Update the employee total no of present day\n\t5.Update the employee total no of absent day\n\t6.Update the employee total no of half day" +
          "\n\t7.Update the employee department\n\t8.Update the employee project title\n\t9.Update the employee project discription" +
          "\n\t10.Update the employee projest assine date\n\t11.Update the employee project deadline" +
          "\n\t12.Update the employee number of completed projects\n\t13.Update the employee ratting\n\t14.Update the employee salary\n\t15.Update the employee bonous");
        System.out.print("\nUpdate records into the table...\nEnter the upate value no-");
        int ch = in .nextInt();
        String val;
        int a;
        if (ch == 1) {
          System.out.print("Enter employee name for update-");
          val = in .next();
          stmt = conn.createStatement();
          String sql = "UPDATE emp SET empname = '" + val + "' WHERE empid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tEmployee name for employee id " + passid + " updated to " + val + "   Successfull...");
        } else if (ch == 2) {
          System.out.print("Enter employee age for update-");
          val = in .next();
          a = Integer.parseInt(val);
          stmt = conn.createStatement();
          String sql = "UPDATE emp SET empage = '" + a + "' WHERE empid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tEmployee age for employee id " + passid + " updated to " + a + "   Successfull...");
        } else if (ch == 3) {
          System.out.print("Enter employee address for update-");
          val = in .next();
          stmt = conn.createStatement();
          String sql = "UPDATE emp SET empaddress = '" + val + "' WHERE empid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tEmployee address for employee id " + passid + " updated to " + val + "   Successfull...");
        } else if (ch == 4) {
          System.out.print("Enter employee total present day for update-");
          val = in .next();
          a = Integer.parseInt(val);
          stmt = conn.createStatement();
          String sql = "UPDATE emp SET emptotalpresent = '" + a + "' WHERE empid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tEmployee total present day for employee id " + passid + " updated to " + a + "   Successfull...");
        } else if (ch == 5) {
          System.out.print("Enter employee total absent day for update-");
          val = in .next();
          a = Integer.parseInt(val);
          stmt = conn.createStatement();
          String sql = "UPDATE emp SET emptotalabsent = '" + a + "' WHERE empid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tEmployee total absent day for employee id " + passid + " updated to " + a + "   Successfull...");
        } else if (ch == 6) {
          System.out.print("Enter employee half day for update-");
          val = in .next();
          a = Integer.parseInt(val);
          stmt = conn.createStatement();
          String sql = "UPDATE emp SET emptotalhalfday = '" + a + "' WHERE empid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tEmployee total half day for employee id " + passid + " updated to " + a + "   Successfull...");
        } else if (ch == 7) {
          System.out.print("Enter employee department for update-");
          val = in .next();
          stmt = conn.createStatement();
          String sql = "UPDATE emp SET empdepartment = '" + val + "' WHERE empid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tEmployee department for employee id " + passid + " updated to " + val + "   Successfull...");
        } else if (ch == 8) {
          System.out.print("Enter employee project title for update-");
          val = in .next();
          stmt = conn.createStatement();
          String sql = "UPDATE emp SET empprojectassinetitle = '" + val + "' WHERE empid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tEmployee project title for employee id " + passid + " updated to " + val + "   Successfull...");
        } else if (ch == 9) {
          System.out.print("Enter employee project discription for update-");
          val = in .next();
          stmt = conn.createStatement();
          String sql = "UPDATE emp SET empprojectassinedis = '" + val + "' WHERE empid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tEmployee project discription for employee id " + passid + " updated to " + val + "   Successfull...");
        } else if (ch == 10) {
          System.out.print("Enter employee project start date for update-");
          val = in .next();
          stmt = conn.createStatement();
          String sql = "UPDATE emp SET empprojectstartdate = '" + val + "' WHERE empid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tEmployee project start date for employee id " + passid + " updated to " + val + "   Successfull...");
        } else if (ch == 11) {
          System.out.print("Enter employee project dead line for update-");
          val = in .next();
          stmt = conn.createStatement();
          String sql = "UPDATE emp SET empprojectenddate = '" + val + "' WHERE empid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tEmployee project dead line date for employee id " + passid + " updated to " + val + "   Successfull...");
        } else if (ch == 12) {
          System.out.print("Enter employee total complete project for update-");
          val = in .next();
          a = Integer.parseInt(val);
          stmt = conn.createStatement();
          String sql = "UPDATE emp SET emptotalcompleteproject = '" + val + "' WHERE empid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tEmployee total complete project for employee id " + passid + " updated to " + a + "   Successfull...");
        } else if (ch == 13) {
          System.out.print("Enter employee ratting for update-");
          val = in .next();
          a = Integer.parseInt(val);
          stmt = conn.createStatement();
          String sql = "UPDATE emp SET empratting = '" + val + "' WHERE empid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tEmployee ratting for employee id " + passid + " updated to " + a + "   Successfull...");
        } else if (ch == 14) {
          System.out.print("Enter employee salary for update-");
          val = in .next();
          a = Integer.parseInt(val);
          stmt = conn.createStatement();
          String sql = "UPDATE emp SET empsalary = '" + val + "' WHERE empid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tEmployee salary for employee id " + passid + " updated to " + a + "   Successfull...");
        } else if (ch == 15) {
          System.out.print("Enter employee bonous for update-");
          val = in .next();
          a = Integer.parseInt(val);
          stmt = conn.createStatement();
          String sql = "UPDATE emp SET empbonous = '" + val + "' WHERE empid=" + passid;
          stmt.executeUpdate(sql);
          System.out.println("\n\tEmployee bonous for employee id " + passid + " updated to " + a + "   Successfull...");
        } else {
          System.out.println("\n\tWrong Input Cheak Menu Once");
        }
      } catch (Exception e) {
        System.out.println("\n\tINVALID...");
      }
    } catch (SQLException se) {

      System.out.println("\n\tSQL ERROR");
    } catch (Exception e) {
      //Handle errors for Class.forName
      System.out.println("\n\tERROR OCCERS");
    } finally {
      //finally block used to close resources
      try {
        if (stmt != null)
          conn.close();
      } catch (SQLException se) {} // do nothing
      try {
        if (conn != null)
          conn.close();
      } catch (SQLException se) {
        System.out.println("\n\tSQL ERROR");
      }
    }
  }

  public static void SearchEmp(int passid) { // DISPLAY THE AVALABLE MOVIE LIST 
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
        int empid = rs.getInt("empid");
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

        System.out.println("\n\tID:- " + empid);
        System.out.println("Name:- " + empname);
        System.out.println("Address:- " + empaddress);
        System.out.println("Age:- " + empage);
        System.out.println("Department:- " + empdepartment);
        System.out.println("Total number of present days:- " + emptotalpresent);
        System.out.println("Total number of absent days:- " + emptotalabsent);
        System.out.println("Total number of half days:- " + emptotalhalfday);
        System.out.println("Here are the project info:-");
        System.out.println("Project title:- " + empprojectassinetitle);
        System.out.println("Project discription:- " + empprojectassinedis);
        System.out.println("Project assined date:- " + empprojectstartdate);
        System.out.println("Project dead line :- " + empprojectenddate);
        System.out.println("Total project complete :- " + emptotalcompleteproject);
        System.out.println("Ratting");
        for (int i = 0; i < empratting; i++) {
          System.out.print("*");
        }
        System.out.println("\nEmployee Salary :- " + empsalary);
        System.out.println("Employee Bonous:- " + empbonous + "\n\n");

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

} //ADMIN CLASS