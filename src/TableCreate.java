import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class TableCreate {
  // JDBC driver name and database URL
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
  static final String DB_URL = "jdbc:mysql://localhost/employeemanagementsystem";

  //  Database credentials
  static final String USER = "root";
  static final String PASS = "";
  public static void Create() {
    // CREATE ADMIN AND EMP TABLE 
    Connection conn = null;
    Statement stmt = null;
    try {
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");

      //STEP 4: Execute a query
      System.out.println("Creating table in given database...");
      stmt = conn.createStatement();

      String sql = "CREATE TABLE  emp" +
        "(empid  INTEGER(100) not NULL, " +
        " empname TEXT(100), " +
        " empage INTEGER(20), " +
        " empaddress TEXT(100), " +
        " emptotalpresent INTEGER(20), " +
        " emptotalabsent INTEGER(20), " +
        " emptotalhalfday INTEGER(20), " +
        " empdepartmentid INTEGER(10), " +
        " empdepartment VARCHAR(10), " +
        " empprojectassinetitle VARCHAR(100), " +
        " empprojectassinedis VARCHAR(1000), " +
        " empprojectstartdate VARCHAR(8), " +
        " empprojectenddate VARCHAR(8), " +
        " emptotalcompleteproject INTEGER(10), " +
        " empratting INTEGER(2), " +
        " empsalary INTEGER(10), " +
        " empbonous INTEGER(10), " +
        " PRIMARY KEY ( empid ))";

      stmt.executeUpdate(sql);
      System.out.println("Created table in given database...");

      System.out.println("Employee table creation successfull...");
    } catch (SQLException se) {
      //Handle errors for JDBC
      System.out.println("Employee table already have in database... OR SOMETHING WRONG");
    } catch (Exception e) {
      //Handle errors for Class.forName
      e.printStackTrace();
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
        se.printStackTrace();
      } //end finally try
    } //end try

    try {
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);

      stmt = conn.createStatement();

      String adminsql =
        "CREATE TABLE  admin" +
        "(adminname  VARCHAR(100) not NULL, " +
        " password VARCHAR(100), " +
        " PRIMARY KEY ( adminname ))";

      stmt.executeUpdate(adminsql);
      System.out.println("Admin table creation successfull...");
    } catch (SQLException se) {
      //Handle errors for JDBC
      System.out.println("Admin table already have in database... OR SOMETHING WRONG");
    } catch (Exception e) {
      //Handle errors for Class.forName
      e.printStackTrace();
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
        se.printStackTrace();
      } //end finally try
    } //end try

    try {
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to a selected database...");
      conn = DriverManager.getConnection(DB_URL, USER, PASS);
      System.out.println("Connected database successfully...");

      //STEP 4: Execute a query
      System.out.println("Inserting records into the table...");
      stmt = conn.createStatement();

      String sql = "INSERT INTO admin VALUES ('root', 'admin')";
      stmt.executeUpdate(sql);
      System.out.println("Inserted records into the table... Successfull");

    } catch (SQLException se) {
      //Handle errors for JDBC
      System.out.println("USERNAME ALREADY PESENT TRY ANOTHER");
    } catch (Exception e) {
      //Handle errors for Class.forName
      e.printStackTrace();
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
        se.printStackTrace();
      } //end finally try
    } //end try
    System.out.println("End!");
  } //MAIN

}