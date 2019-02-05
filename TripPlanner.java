package main;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.TimeZone;

public class TripPlanner {
	
	/*OVO JE FORMULA ZA DECIMALNO FORMATIRANJE DOUBLE VREDNOSTI
	 * double no=12.786;
	DecimalFormat dec = new DecimalFormat("#0.00");
	System.out.println(dec.format(no)); - 
	PREUZETO SA SAJTA https://stackoverflow.com/questions/14845937/java-how-to-set-precision-for-double-value
	*/
	
	
	public static void main(String[] args) {
  //Main		
   System.out.println("Welcome to vacation planner!");
   greetings();
   travelTimeAndBudget();
   timeDifference();
   countryArea();
   hackersProblem();
  
		
	}
// 1 Greetings
public static void greetings (){
	Scanner input = new Scanner(System.in);
	System.out.print("What is your name?");
	String ime = input.next();
	
	System.out.print("Nice to meet you " + ime + "," + "where are you travelling to ?");	
	String grad = input.next();
	System.out.print("Great! " + grad + " sounds like a great trip");
	System.out.print("\n*******************");
}
// 2 Travel time and budget
public static void travelTimeAndBudget (){
	Scanner input = new Scanner(System.in);
	System.out.print("\nHow many days are you going to spend travelling? ");
	int dani = input.nextInt();
	System.out.print("How much money, in USD , are u planning to spend on your trip? ");
	int novac = input.nextInt();
	System.out.print("What is the three letter currency symbol for your travel destination? ");
	String valuta = input.next();
	System.out.println("How many "+ valuta + " are there in 1 USD ?");
	double valuta2 = input.nextDouble();
//Racunjane rezultata sati i minuta potrebno za odredjeni broj dana
	int satiDana = dani * 24;
	int minutiDana = satiDana * 60;
	
  System.out.println("If u are travelling for "+ dani + " days " + "that is the same as " + satiDana + " hours or " + minutiDana + " minutes");
  
  //Racunjanje budzeta po danima USD
  double budzetPoDanima = novac / dani;
   System.out.println("If u are going to spend " + "$" + novac + " that means per day you can spend " + "$" + budzetPoDanima + " USD");
  
  //Totalni budzet po valuti
  double budzet = novac * valuta2;
  //Totalni budzet po danima po valuti
  double budzetPoDanuValute = budzet / dani;
  DecimalFormat dec = new DecimalFormat("#0.00");
  System.out.println("Your total budget in " + valuta + " is " + budzet + " " + valuta + ", which per day is " + dec.format(budzetPoDanuValute) + " " + valuta );
  System.out.print("\n*******************");
    
}
   //3 Time diff
public static void timeDifference(){
    Scanner input = new Scanner(System.in);
    System.out.print("\nWhat is the time difference, in hours, between your home and your destination? ");
    int timeDiff = input.nextInt();
    int midnight = 0+timeDiff;  //0 + jer se krece od ponoci
    
    //Uslov ukoliko je unos negativan
    if(timeDiff<0){
    	midnight = 24 + timeDiff;
    }
        
    System.out.println("That means that when it is midnight at home it will be " + midnight + ":00 in your travel destination");

    int noon = (12+timeDiff)%24; //12 + jer se krece od podneva a %24 daje ostatak znaci sve preko 24 sati je ostatak
    System.out.println("and when it is noon at home it will be " + noon + ":00 ");
    System.out.println("\n***********");
}
	//4 Country Area
public static void countryArea (){
	Scanner input = new Scanner(System.in);
	System.out.print("What is the square area of your destination country in km2? ");
	double regijaKm = input.nextDouble();
	double regijaM = regijaKm / 1.609;
	DecimalFormat dec = new DecimalFormat("#0.00");
	System.out.println("In miles2 that is " + dec.format(regijaM));
	System.out.println("\n*******************");
}
//5 Hackers problem
public static void hackersProblem(){
	//Po formuli hacersina izracunavamo latitude i longtitude destinacije1 i destinacije2 
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the latitude of your home - "); 
    double latHome = input.nextDouble();
    System.out.print("Enter the longitude of your home - ");
    double longHome = input.nextDouble();
    System.out.print("Enter the latitude of your destination - ");
    double latDest = input.nextDouble();
    System.out.print("Enter the longitude of your destination - ");
    double longDest = input.nextDouble();

    double distLat = Math.toRadians(latDest - latHome);
    double distLong = Math.toRadians(longDest - longHome);

    double haversine = Math.pow(Math.sin(distLat / 2), 2) + Math.cos(latHome) * Math.cos(latDest) * Math.pow(Math.sin(distLong / 2), 2);

    double rad = 6371;
    double distance = 2 * rad * Math.asin(Math.sqrt(haversine));
    double roundDist = (int)(distance*100)/100.0;

    System.out.println("Distance between your home and travel destination is " + roundDist + "km");

}
	
}


