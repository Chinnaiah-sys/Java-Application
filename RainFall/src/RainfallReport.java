import java.util.List;

public class RainfallReport {

	//Write the required business logic as expected in the question description
	public List<AnnualRainfall> generateRainfallReport(String filePath) {
	    
		
	List<AnnualRainfall> list=new ArrayList<AnnualRainfall>();
	ArrayList<String> a1=new ArrayList<>();
	try {
		BufferedReader br=new BufferedReader(new FileReader(filePath));
		BufferedReader a=new BufferedReader(new FileReader(filePath));
	while(br.readLine()!=null)
	{
		a1.add(a.readLine());
	}
	int line=a1.size();
	int temp=0;
	for(int t=0;t<line;t++)
 	{
		String s=a1.get(t);
		String arr[]=s.split(",");
		try
		{ 
			boolean b=false;
			b=validate(arr[0]);
			if(b)
			{
			AnnualRainfall ab=new AnnualRainfall();
			temp=Integer.parseInt(arr[0]);
 			//System.out.println(temp);
			ab.setCityPincode(new Integer(temp)) ;
			ab.setCityName(arr[1]);
 			double count[]=new double [12];
 			for(int g=0;g<arr.length-2;g++)
 			{
 				count[g]=Double.parseDouble(arr[g+2]);
 				//System.out.println(count[g]);
 			}
 			ab.calculateAverageAnnualRainfall(count);
 			list.add(ab);
 			}
 		}	
 		catch(InvalidCityPincodeException e)
 		{
 			System.out.println(e.getMessage());
 		}
 	}
 
 
 	}
 		catch(IOException e)
		{
 			System.out.println(e);
 		}

 		return list;
		
}
	
	public List<AnnualRainfall>  findMaximumRainfallCities() {
	
		
		List<AnnualRainfall> list=new ArrayList<>();
		DBHandler db=new DBHandler();
 
		try
		{
			Connection con=db.establishConnection(); 
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from AnnualRainfall where average_annual_rainfall in(select max(average_annual_rainfall) from AnnualRainfall)");
			while(rs.next())
			{
				AnnualRainfall a=new AnnualRainfall();
				a.setCityPincode(rs.getInt(1));
				a.setCityName(rs.getString(2));
				a.setAverageAnnualRainfall(rs.getDouble(3));
				list.add(a); 
 			}
 		}
		catch(SQLException e)
 		{
 			System.out.println("contact adminstator");
 		}
 
 		catch(Exception e)
 		{
 			System.out.println(e.getMessage());
 		}
 		return list;
		
	}
	
	
	public boolean validate(String cityPincode) throws InvalidCityPincodeException {
	
		
		char k=cityPincode.charAt(0);
 
		 if(cityPincode.length()==5 && k!='0'&& !(cityPincode.equals("00000")))
 		 {
 			return true;
 		 }
 		else{
 			throw new InvalidCityPincodeException("Invalid City Pincode");
 		}
    		
	}

}
