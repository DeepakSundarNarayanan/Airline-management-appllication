package edu.neu.csye6200.utils;

public class InternationalFlight implements Flight{
    private String flightID,timeDuration,date,departDestination,landDestination,economySeats,businessSeats,distance;
	public boolean isBooked;
	
	public InternationalFlight(String flightID,String departTime,String landTime,String departDestination,String landDestination,String economySeats,String businessSeats,String distance)
	{
		this.flightID=flightID;
		this.timeDuration=departTime;
		this.date=landTime;
		this.departDestination=departDestination;
		this.landDestination=landDestination;
		this.economySeats=economySeats;
		this.businessSeats=businessSeats;
		this.distance=distance;
	}

	public InternationalFlight(String csvString) {
		String[] fields = csvString.split(",");
		this.flightID=fields[0];
		this.timeDuration=fields[1];
		this.date=fields[2];
		this.departDestination=fields[3];
		this.landDestination=fields[4];
		this.economySeats=fields[5];
		this.businessSeats=fields[6];
		this.distance=fields[7];
	}
	
	public String getTimeDuration() {
		return timeDuration;
	}

	public void setTimeDuration(String timeDuration) {
		this.timeDuration = timeDuration;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isBooked() {
		return isBooked;
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
	
	public void setDepartTime(String departTime)
	{
		this.timeDuration=departTime;
	}
	
	public void setLandTime(String landTime)
	{
		this.date=landTime;
	}
	
	public void setDepartDestination(String departDestination)
	{
		this.departDestination=departDestination;
	}
	
	void setLandDestination(String landDestination)
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
		return timeDuration;
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
