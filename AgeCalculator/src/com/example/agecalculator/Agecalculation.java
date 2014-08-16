package com.example.agecalculator;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.net.ParseException;
import android.text.format.DateFormat;

public class Agecalculation {

	private int start_year;
	private int start_month;
	private int start_day;
	
	private int end_year;
	private int end_month;
	private int end_day;
	
	private int pre_year;
	private int pre_month;
	private int pre_day;
	
	private int tD,rm,rd;
	long dDay,dif;
	String horscop;
	private Calendar c;
	private Calendar p;

	
	public String getCurrentDate()
	   {
	    c=Calendar.getInstance();
		end_year=c.get(Calendar.YEAR);
		end_month=c.get(Calendar.MONTH);
		end_month++;
		end_day=c.get(Calendar.DAY_OF_MONTH);
		return "Current Date: "+ end_day+"/"+end_month+"/"+ end_year ;
		
	  }
	
	public void setDOB(int sYear,int sMonth,int sDay){
		  p=Calendar.getInstance();
		
		start_year=sYear;
		 p.set(Calendar.YEAR, start_year);
		start_month=sMonth;
		
		
		 p.set(Calendar.MONTH, start_month);
		 start_month++;
		start_day=sDay;
		
	 p.set(Calendar.DAY_OF_MONTH, start_day);
		
		
	}
	
	public void CalculateYear(){
		
		if(end_year>start_year)
		{
		pre_year=end_year-start_year;
		}
		else if(end_year==start_year)
		{
			pre_year=0;
		}
		
	}
	public void CalculateMonth(){
		if(end_month>start_month){
			pre_month=end_month-start_month;
			;
		}else if(end_month==start_month){
			pre_month=0;
		}
		
		else{
			pre_month= end_month-start_month;
			pre_month= 12+pre_month;
			
			pre_year--;
		}
	}
	
	public void CaluculateDay(){
		if(end_day>start_day){
			pre_day=end_day-start_day;
			
		}else if(end_day==start_day){
			pre_day=0;
		}
		else{
			pre_day=end_day-start_day;
			pre_day=30+pre_day;
			
			pre_month--;
		}
	}
	
	
	public String getResut(){
		return "Your Age is: " + pre_year + " Years " + pre_month + " Months " + pre_day + " Days ";
	}
	

public void calculateTotalDay(){
		
	  dif=c.getTimeInMillis()-p.getTimeInMillis();
	 
	 
	 dDay=dif/(24*60*60*1000);
	 dDay++;
	 
	 
	 
		
	}
  public String getDayResult(){
	
	return "Total Days: " + dDay + " days ";
}
  public void Calrem_month(){
	  if(end_month>=start_month){
			pre_month=end_month-start_month;
			rm=12-pre_month;
			
		}else{
			pre_month= end_month-start_month;
			pre_month= 12+pre_month;
			rm=12-pre_month;
			
		}
	  
	  
  }
  
  public void Calrem_day(){
	  if(end_day>=start_day){
			pre_day=end_day-start_day;
			 rd=30-pre_day;
			 rm--;
		}else{
			pre_day=end_day-start_day;
			pre_day=30+pre_day;
			 rd=30-pre_day;
		
		}
	  
  }
  
  public String getNextBirthday(){
	  return "Next Birthday in: "+ rm + " months " + rd + " days ";
  }
  
  public void horoscop(){
	  if((start_month==12 && start_day>=22)||(start_month==1&&start_day<=19))
	  {
		  horscop="Capricorn";
	  }
	  else if((start_month==1 && start_day>=20)||(start_month==2&&start_day<=18)){
		  
		  horscop="Aquarius";
	  }
	  else if((start_month==2 && start_day>=19)||(start_month==3 &&start_day<=20)){
		  
		  horscop="Pisces";
	  }
	  else if((start_month==3 && start_day>=21)||(start_month==4&&start_day<=19)){
		  
		  horscop="Aries";
	  }
	  else if((start_month==4 && start_day>=20)||(start_month==5&&start_day<=20)){
		  
		  horscop="Taurus";
	  }
	  else if((start_month==5 && start_day>=21)||(start_month==6&&start_day<=20)){
		  
		  horscop="Gemini";
	  }
	  else if((start_month==6 && start_day>=21)||(start_month==7&&start_day<=22)){
		  
		  horscop="Cancer";
	  }
	  else if((start_month==7 && start_day>=23)||(start_month==8&&start_day<=22)){
		  
		  horscop="Leo";
	  }
	  else if((start_month==3 && start_day>=23)||(start_month==9&&start_day<=22)){
		  horscop="Virgo";
		  
	  }
	  else if((start_month==9 && start_day>=22)||(start_month==10&&start_day<=22)){
		  
		  horscop="Libra";
	  }
	  else if((start_month==10 && start_day>=23)||(start_month==11&&start_day<=22)){
		  horscop="Scorpio";
	  }
	
	  else if((start_month==11&&start_day>=22)||(start_month==12&&start_day<=21))
	  {
		   horscop="Sagitarious";
		
	  }
	  else{
		  horscop="false";
	  }
	 // return horscop;
  }
	
  public String gethoroscopresult(){
	  return "Your Horoscop is: " + horscop;
  }
}
