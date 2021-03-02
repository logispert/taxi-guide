package taxiguider.util;

import taxiguider.TaxiassignCompleted;

public class Assigner {
	
	private static String[][] driverBank = 
	{
		{"백영곤", "010-2345-6789", "34가4567"},
		{"안채우", "010-3345-7789", "44나4567"},
		{"임광현", "010-4345-8789", "54다4567"},
		{"장윤정", "010-5345-9789", "64라4567"},
		{"옥준삼", "010-6345-0789", "74마4567"},
		{"유승오", "010-7345-1789", "84사4567"}
	};
	
	public static TaxiassignCompleted getTaxiassign됨() {
		TaxiassignCompleted taxiassignCompleted = new TaxiassignCompleted();
		
		int randDriver = (int)(Math.random() * 6);
		TaxiassignCompleted.setDriver(driverBank[randDriver][0]);
		TaxiassignCompleted.setDrivertel(driverBank[randDriver][1]);
        TaxiassignCompleted.setTaxiid(driverBank[randDriver][2]);
        return TaxiassignCompleted;
	}

}
