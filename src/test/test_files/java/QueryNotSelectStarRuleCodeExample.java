
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@SuppressWarnings("all")
class QueryNotSelectStarRuleCodeExample {
  public static void main(String[] args) throws SQLException {

    String url = "jdbc:msql://200.210.220.1:1114/Demo";
    Statement stmt = DriverManager.getConnection(url,"","").createStatement();
    ResultSet rs = stmt.executeQuery("SELECT * FROM Customers WHERE Snum = 2001"); // Noncompliant
    String q1 = "SELECT lastName, firstName FROM Customers WHERE Snum = 2001";
    String q2 = "select * from Customers WHERE Snum = 2001"; // Noncompliant
    String q3 = "SELECT C.pname, P.* FROM Customers C LEFT JOIN Product P ON C.cid = P.cid"; // Noncompliant

    rs = stmt.executeQuery(q1);
    rs = stmt.executeQuery(q2);
    rs = stmt.executeQuery(q3);

    rs = stmt.executeQuery("SELECT *FROM Customers"); // Noncompliant
  }
}