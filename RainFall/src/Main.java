public class Main {
   public static void main(String[] args) { 
   
	   
	List<AnnualRainfall> list1=new ArrayList<AnnualRainfall>();
	RainfallReport rr=new RainfallReport();
 	list1=rr.generateRainfallReport("AllCityMonthlyRainfall.txt");
 
 	//System.out.println(list1.get(0).getCityPincode());
 	for(AnnualRainfall a:list1)
 	{
 	System.out.print(a.getCityPincode()+"---");
 	System.out.print("---"+a.getCityName()+"---");
 	System.out.printf("%.2f \n", a.getAverageAnnualRainfall());
 
 	}
 	List<AnnualRainfall> max_avg=new ArrayList<>();
 	max_avg=rr.findMaximumRainfallCities();
 	for(AnnualRainfall b:max_avg)
 	{
 		System.out.print(b.getCityPincode()+" *** "+b.getCityName()+" *** ");
 		System.out.printf("%.2f \n",b.getAverageAnnualRainfall() );
 }
	   
   }
}
          