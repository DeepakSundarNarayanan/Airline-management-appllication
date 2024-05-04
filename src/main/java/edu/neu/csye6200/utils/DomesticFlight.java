package edu.neu.csye6200.utils;

public class DomesticFlight implements Flight {
    
    private String flightID,timeInterval,date,departDestination,landDestination,economySeats,businessSeats,distance;
	boolean isBooked;
	
	public DomesticFlight(String flightID, String timeInterval, String date, String departDestination, String landDestination, String economySeats, String businessSeats, String distance)
	{
		this.flightID=flightID;
		this.timeInterval=timeInterval;
		this.date=date;
		this.departDestination=departDestination;
		this.landDestination=landDestination;
		this.economySeats=economySeats;
		this.businessSeats=businessSeats;
		this.distance=distance;
	}

	public DomesticFlight(String csvString) {
		String[] fields = csvString.split(",");
		this.flightID=fields[0];
		this.timeInterval=fields[1];
		this.date=fields[2];
		this.departDestination=fields[3];
		this.landDestination=fields[4];
		this.economySeats=fields[5];
		this.businessSeats=fields[6];
		this.distance=fields[7];
	}
	
	@Override
	public void setFlightID(String flightID)
	{
		this.flightID=flightID;
	}
	
	@Override
	public String getFlightID()
	{
		return flightID;
	}
	
	public void setDepartTime(String timeInterval)
	{
		this.timeInterval=timeInterval;
	}
	
	public void setLandTime(String date)
	{
		this.date=date;
	}
	
	public void setDepartDestination(String departDestination)
	{
		this.departDestination=departDestination;
	}
	
	public void setLandDestination(String landDestination)
	{
		this.landDestination=landDestination;
	}
	
	public void setEconomySeats(String economySeats)
	{
		this.economySeats=economySeats;
	}
	
	public void setBusinessSeats(String businessSeats)
	{
		this.businessSeats=businessSeats;
	}
	
	public String getDepartTime()
	{
		return timeInterval;
	}
	
	public String getLandTime()
	{
		return date;
	}
	
	public String getDepartDestination()
	{
		return departDestination;
	}
	
	public String getLandDestination()
	{
		return landDestination;
	}
	
	public String getEconomySeats()
	{
		return economySeats;
	}
	
	public String getBusinessSeats()
	{
		return businessSeats;
	}
	
	public void setDistance(String distance)
	{
		this.distance=distance;
	}
	
	public String getDistance()
	{
		return distance;
	}
	
	public void setBooked(boolean isBooked)
	{
		this.isBooked=isBooked;
	}
	
	public boolean getBooked()
	{
		return isBooked;
	}
    
}
