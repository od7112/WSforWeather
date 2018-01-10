package weatherPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

@Path("/book")
public class Weather {

	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHelloXML(){
		
		
			  
	
		  Client client =  ClientBuilder.newClient();

	      StringBuilder sb = new StringBuilder();
	      
	      
	      sb.append("http://api.openweathermap.org/data/2.5/weather?APPID=c6e09557f19c9c5b6f42a4bd64563f88&lat=");
	      sb.append("39,919868");  
	      sb.append("&lon=");
	      sb.append("32,854271");     

	      WebTarget target = client.target(sb.toString());
	      
	      System.out.println(target.request().get(String.class));
		String x=target.request().get(String.class);
	      //return target.request().get(String.class);
		
		String [] array=x.split(":");
		//temp,humidity,pressure
		
		
		String  temp = array[11];
		String []temp1 = temp.split(",");
		
		String humidity = array[13];
		String []humidity1 = humidity.split(",");
		
		String pressure = array[12];
		String []pressure1 = pressure.split(",");
		
		String location = array[31];
		String []location1 = location.split(",");
		
		/*try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sys","root","root");  
			//here sonoo is database name, root is username and password  
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("INSERT INTO sehir,temperature,humidity,pressure,location VALUES temp1[0],humidity1[0],pressure1[0],location1[0]");  
			//while(rs.next())  
			//System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
			con.close();  
			}catch(Exception e){ System.out.println(e);}  */
		
		
		String response="<?xml version='1.0'?>"
				+ "<hello>" + "Temperature: " + temp1[0]
						+ "\n\nHumidity: " + humidity1[0] 
						+ "\n\nPressure: " + pressure1[0] 
						+"Location: " + location1[0] + "</hello>";
		return response;
	}//sayHello metod bitis
	

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJSON(){
		
		String response=null;
		return response;
	}//sayHello metod bitis
	
	
	
	
	

}//Book class bitis
