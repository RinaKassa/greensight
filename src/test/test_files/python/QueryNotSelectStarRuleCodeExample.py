import mysql.connector

mydb = mysql.connector.connect(
    host="localhost",
    user="username",
    password="password",
    database="mydatabase"
)

mycursor = mydb.cursor()

mycursor.execute("SELECT * FROM Customers") # Noncompliant
q1 = "SELECT lastName, firstName FROM Customers WHERE Snum = 2001"
q2 = "select * from Customers WHERE Snum = 2001" # Noncompliant
q3 = "SELECT C.pname, P.* FROM Customers C LEFT JOIN Product P ON C.cid = P.cid" # Noncompliant
array = ["SELECT * FROM Customers", "SELECT lastName FROM Customers"] # Noncompliant
