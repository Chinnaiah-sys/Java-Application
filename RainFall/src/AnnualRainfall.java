
public class AnnualRainfall {
	
	
	private int cityPincode;
	private String cityName;
	private double averageAnnualRainfall;

	public int getCityPincode() {
		return cityPincode;
	}

	public void setCityPincode(int cityPincode) {
		this.cityPincode = cityPincode;
	}

	public String getCityName(){
		return cityName;
	}

	public void setCityName(String cityName){
		this.cityName = cityName;
	}


	public double getAverageAnnualRainfall(){
		return averageAnnualRainfall;
	}


	public void setAverageAnnualRainfall(double averageAnnualRainfall){
		this.averageAnnualRainfall = averageAnnualRainfall;
	}


	
	public void calculateAverageAnnualRainfall (double monthlyRainfall [ ]){
	    
		double sum=0;
 		int len=monthlyRainfall.length;

 		for(double d:monthlyRainfall)
 		{
 			sum=sum+d;
 		}
 		setAverageAnnualRainfall((sum/len));
		
	}


}
