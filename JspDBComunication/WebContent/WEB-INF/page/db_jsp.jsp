<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*"%>
  
    <%!
    Connection con;
    PreparedStatement ps1,ps2;
    ResultSet rs;
    public void jspinit(){
    	try{
    		//Access ServletConfig object
    		ServletConfig cg=getServletConfig();
    		String s1= cg.getInitParameter("driver");
    		String s2 = cg.getInitParameter("url");
    		String s3 = cg.getInitParameter("user");
    		String s4 = cg.getInitParameter("pwd");
    		// register jdbc driver
    		Class.forName(s1);
    		con=DriverManager.getConnection(s2,s3,s4);
    		ps1=con.prepareStatement("insert into student values(?,?,?,?)");
    		ps2=con.prepareStatement("select sno,name,add from student");
    	}//try
    	catch(SQLException se){
    		se.printStackTrace();
    	}
    	catch(ClassNotFoundException cnf){
    		cnf.printStackTrace();
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	
    }//jspinit
    
    %>
    
    <% // read s1 req param value
    String pval=request.getParameter("s1");
    if(pval.equalsIgnoreCase("register")){
    	// read form data
    	int no=Integer.parseInt(request.getParameter("tsno"));
         String name=request.getParameter("tname");
         String add=request.getParameter("tadd");
         //set form data as the values to query params
         ps1.setInt(1, no);
         ps1.setString(2, name);
         ps1.setString(3, add);
         //execute the query
         int result = ps1.executeUpdate();
         if(result==0){%>
         <b>Registation Failed</b>
    <%}
         else{%>
         <b>Registation success</b>
    <%}
    }//outer if
    else{
    	//execute the Query
    	ResultSet rs = ps2.executeQuery();
    	//get ResultSetMetaData
    	ResultSetMetaData rsmd=rs.getMetaData();
    %>
    <<table>
  <tr>
    <th>Column 1 Heading</th>
    <th>Column 2 Heading</th>
  </tr>
  <tr>
    <td>Row 1: Col 1</td>
    <td>Row 1: Col 2</td>
  </tr>
</table>

    }
    
    
    
    
    
    
    
    
    
    
    
    %>
    