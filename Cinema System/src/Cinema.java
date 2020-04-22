import java.io.BufferedReader;  
import java.io.IOException;
import java.io.InputStreamReader;  
import java.text.DecimalFormat;
import java.util.Scanner;   
    
    
public class Cinema {   
//             Classes 	
    static Scanner input = new Scanner(System.in);   
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static DecimalFormat currency = new DecimalFormat("0.00");
    static boolean isValid = false;
    
//     Data Conversion Variables
    static String name;
    static int age;
    static String email;
    
//          Cinema Settings
    static String[] movies = {"Thor \t", "Steel Fist" , "Star Wars" , "Batman \t" , "IT \t", "Fury \t"};   
    static String[] types = {"Adult", "Child", "Student", "Senior Citizen"};   
    static String[] times = {"12:00" ,"14:00", "15:30", "16:45", "18:00", "20:45"};   
    
 // 		Customer Prices			
    static double adultprice = 10.0;   
    static double childprice = 5.0;   
    static double studentprice = 7.5;   
    static double seniorprice = 7.0;
    static double transactionPrice= 0.00;   
 
 //			Food Prices	
    static double popcornsoda = 4.00;   
    static double hotdogsoda = 3.0;   
    static double crispwater = 1.2;   
    static double burgersoda = 3.5; 
    static double foody=0;
    static double totalPrice=0;
    
 // 		Admin Features   
    static int numTicketSold=0;
    static int psStock=20;
    static int hsStock=30;
    static int cwStock=30;
    static int bsStock=10;
    
   
//         Customer's choice
    static String chosenMovie;   
    static String chosenTime;   
    static String type;   
    static String addfood;
    static String UserChoice;
       
    

   
       
       
       
   
    
       
       
    public static void main(String[] args)    
    {   
        welcome();   //The first method to start the program
    }   
    public static void welcome()   
    {   
        System.out.println("Welcome!");   
        System.out.println("Please Select your Cinema Location");   
        System.out.println("*Type out your desired location and Press Enter*"); 
         
        
      UserChoice = input.next();   
        // Your type desired location will be shown here
        System.out.println("");
        System.out.println("");   
        System.out.println("\t \t      Welcome to " + UserChoice + " Cinema!");   
        System.out.println("");
        System.out.println("");
           
        movies();   
           
    }   
    public static void movies()   
    {   
        System.out.println("\t \t Movies showing on 17th of November");   
        System.out.println("");   
           
        int id = 0;   
           
        for(int i=0; i<movies.length; i++)   // This is For Loop will show the movie 
        {   
            id++;   
            System.out.print(id + "\t" + movies[i] + "\t");   
               
            for(int g=0; g<times.length; g++)// Another For is added to add the time of the movie
            {   
                System.out.print(times[g] + "\t");   
                   
                   
            }   
            System.out.println("");   
        }  
        
     
    System.out.println("");
    System.out.println("");
    System.out.println("Choose movie by ID");
    
    System.out.println("");
       
    int UserChoice = input.nextInt();   
    System.out.println("");
       
    id=0;   
    /*
     * When Customer chooses his movie, the program finds
     *  the movie in the global movie list via chosenMovie
     */
    for(int i=0; i<movies.length; i++)   

    {   
        id++;   
        if(UserChoice==id)   
        {   
            chosenMovie = movies[i];   
        }   
    }   
       
    System.out.println("You have chosen " + chosenMovie);   
    System.out.println("");   
    menu();   
       
    }   
    public static void menu()   
    {   
    	System.out.println();
        System.out.println("Press 1 to Choose Your Time");  
        System.out.println("Press 2 for Type of Ticket");
        System.out.println("Press 3 for Food and Beverages");
        System.out.println("Press 4 for the Final Payment");
        System.out.println("Press 5 to Close Application");
        System.out.println("");
           
        String choice = input.next();
        
        
     
           
        switch(choice)   //switch command allows you a String that will send you to a new method
        {   
        case "1":   
        {   
            time();   
            break;   
        }   
        case "2":   
        {   
        	/*
        	 * A Global Boolean is used to control the pathway of the customer,
        	 * the "isValid" is set to false to deny entry because it must find the "inValid=true" 
        	 * which is in the time() method before it could go any other methods.  
        	 */
        	if(isValid==false)
			{
				System.out.println("Error! Please pick your time first!");
				menu(); 
			}
            type();   //Will direct to the type Method
            break;   
        }   
        case "3":   
        {   
        	if(isValid==false)
			{
				System.out.println("Error! Please pick your time first!");
				menu();
			}
            addi();   // Will direct to the addi() Method
            break;   
        }   
        case "4":   
        {   
        	if(isValid==false)
			{
				System.out.println("Error! Please pick your time first!");
				menu();
			}
            printPayment();   //Will direct to the printPayment Method
            break;   
        }   
        case "5":   
        {   
            System.out.println("Application Closing, See you soon!");   
            System.exit(0); // this closes the program
            
            
        }   
        case "99":   // secret passcode to allow access to admin() menu.
        {   
            password();   //Will direct to the password Method
            break;   
        }   
        default:   
        {   
            System.out.println("Error! Please choose between 1-4");  
            break;   
        }   
        }   
           
     menu();     
    }   
   
/*
 * I created a password method for the admin, to allow the change of setting within the system. it gives
 * the sense of privacy among the Customers and Admin. I used a simple numeric number password (123) to be
 * easily access by the Admin.  
 */
	private static void password()   
    {  
    	System.out.println();
        System.out.println("Enter the Password for Admin");  
        System.out.println();
          
        int pass = input.nextInt();  
        System.out.println();
          
        if(pass==(123)) //the password  
        {  
            admin();  // this direct to the admin() menu.
        }  
        else  
        {  
            System.out.println("Incorrect, Please try again");  
              
        } 
    }  
    private static void admin() // Admin Menu
    {   
    	System.out.println();
        System.out.println("Welcome Admin!");   
        System.out.println("");   
        System.out.println("Press 1 to Change ticket Prices");   
        System.out.println("Press 2 to Change food Prices");    
        System.out.println("Press 3 to view stock for food");
        System.out.println("Press 4 to view number of tickets sold");
        System.out.println("Press 5 to exit Admin Menu");   
        System.out.println();
        String choice = input.next();   
        System.out.println();
           
        switch (choice)   //switch command allows you a String that will send you to a new method
        {   
        case "1":   
        {   
            changeTicketPrice();   //Will direct to the changeTicketPrice Method
            break;   
        }   
        case "2":   
        {   
            changeFoodPrice();   //Will direct to the changeFoodPrice Method
            break;   
        }   
        case"3":   
        {   stockFood();   // Will direct to the stockFood Method

            break;
        }   
        case "4":   
        {   
        	 numTicketSold(); //Will direct to the numTicketSold Method
            break;   
        }   
        case "5":   
        {   
            menu(); //will return to the Customer Menu
            System.out.println("See you again, Admin!");
            System.out.println();
            break;
         
        }  
        default:
        {
        	System.out.println("Error, Please select the 1-5");
        	break;
        }
        }      
        admin();   
    }   
    public static void numTicketSold() 
    {
    	// Shows the number of the tickets sold
    	System.out.println("Number of Tickets of Sold are " + numTicketSold);
    	System.out.println();
    }
    private static void stockFood() 
    {   
    	//Shows the stock of Food 
    	System.out.println("Popcorn with Soda: " + psStock);
    	System.out.println("Hotdog with Soda: " + hsStock);
    	System.out.println("Crisp with Water: " + cwStock);
    	System.out.println("Burger with Soda: " + bsStock);
    	System.out.println();
           
    }   
     
    private static void changeFoodPrice() 
    {
    	// Give you the ability to change the prices of Food form the global price
    	System.out.println();
    	System.out.println("Press 1 to change Popcorn with Soda");
    	System.out.println("Press 2 to change Hotdog with Soda");
    	System.out.println("Press 3 to change Cirsp with Water");
    	System.out.println("Press 4 to change Burger with Soda");
    	System.out.println();
    	String change = input.nextLine();
    	
    	switch(change)
    	{
    	case "1":
    	{
    		System.out.println("Enter new price for Popcorn with Soda, The current price is €" + currency.format(popcornsoda));
			popcornsoda = input.nextDouble();
			System.out.println("New Price of Popcorn with Soda is €" + currency.format(popcornsoda));
			//currency.format are classes that allow the use of currency symbol.
			System.out.println();
    		break;
    	}
    	case "2":
    	{
    		System.out.println("Enter new price for Hotdog with Soda,The current price is €" + currency.format(hotdogsoda));
			hotdogsoda = input.nextDouble();
			System.out.println("New Price of Hotdog with Soda is €" + currency.format(hotdogsoda));
			//currency.format are classes that allow the use of currency symbol.
			System.out.println();
    		break;
    	}
    	case "3":
    	{
    		System.out.println("Enter new price for Crisp with Water,The current price is €" + currency.format(crispwater));
			crispwater = input.nextDouble();
			System.out.println("New Price of Crisp with Water is €" + currency.format(crispwater));
			//currency.format are classes that allow the use of currency symbol.
			System.out.println();
    		break;
    	}
    	case "4":
    	{
    		System.out.println("Enter new price for Burger with Soda,The current price is €" + currency.format(burgersoda));
			burgersoda = input.nextDouble();
			System.out.println("New Price of Burger with Soda is €" + currency.format(burgersoda));
			//currency.format are classes that allow the use of currency symbol.
			System.out.println();
    		break;
    	}
    	default:
    	{
    		System.out.println("Error, Please Select 1-4.");
    		break;
    	}
    	}
 changeFoodPrice(); 
       
           
    }   
    private static void changeTicketPrice() 
    {   
    	// Gives you the ability to change the prices of the types of tickets
    	System.out.println();
    	System.out.println("Press 'A' to change ADULT Price");
    	System.out.println("Press 'S' to change STUDENT Price");
    	System.out.println("Press 'C' to change CHILD Price");
    	System.out.println("Press 'SC' to change SENIOR CITIZEN Price");
    	System.out.println("Press 'R' to return to Admin menu");
    	System.out.println("");
    	
    	String change = input.next();
    	System.out.println();
    	
    	switch(change)
    	{
    	case "A":// added both A and a just in-case the user types capital A 
    	case "a":
    	{
    		System.out.println("Enter new price of ADULT");
			adultprice = input.nextDouble();
			System.out.println("New Price of Adult is €" + currency.format(adultprice));
			System.out.println();
    		break;
    	}
    	case "S":// added both S and s just in-case the user types capital S
    	case "s":
    	{
    		System.out.println("Enter new price of STUDENT");
			studentprice = input.nextDouble();
			System.out.println("New Price of Student is €" + currency.format(studentprice));
			System.out.println();
    		break;
    	}
    	case "C":// added both C and c just in-case the user types capital C
    	case "c":
    	{
    		System.out.println("Enter new price of CHILD");
			childprice = input.nextDouble();
			System.out.println("New Price of Child is €" + currency.format(childprice));
			System.out.println();
    		break;
    	}
    	case "SC":// added both SC and sc just in-case the user types capital SC
    	case "sc":
    	{
    		System.out.println("Enter new price of SENIOR CITIZEN");
			seniorprice = input.nextDouble();
			System.out.println("New Price of Senior Citizen is €" + currency.format(seniorprice));
			System.out.println();
    		break;
    	}
    	case"R":// added both R and r just in-case the user types capital R
    	case"r":
    	{
    		admin();
    		break;
    	}
    	}
           changeTicketPrice();
    }   
    private static void addi()  //     The Food Menu Method 
    {   
        System.out.println("************Cinema Store************");   
        System.out.println("");   
        System.out.println("Press 1 for Popcorn with Soda - €" + currency.format(popcornsoda));   
        System.out.println("Press 2 for Hotdog with Soda - €" + currency.format(hotdogsoda));   
        System.out.println("Press 3 for Crisp with Water - €" + currency.format(crispwater));   
        System.out.println("Press 4 for Burger with Soda - €" + currency.format(burgersoda));   
        System.out.println("");   
        System.out.println("*************************************");   
           
        String food = input.next();   
           
        switch(food)   //switch command allows you a String that will send you to a new method
        {   
        case "1":    
        {   
            addfood = "popcorn";  // this will be directed  to the foodPayment() method
            foodPayment();   
            break;   
        }   
        case "2":   
        {   
            addfood = "hotdog";  // this will be directed  to the foodPayment() method 
            foodPayment();   
            break;   
        }   
        case "3":   
        {   
            addfood = "crisp";   // this will be directed  to the foodPayment() method
            foodPayment();   
            break;   
        }   
        case "4":   
        {       
            addfood = "burger";   // this will be directed  to the foodPayment() method
            foodPayment();   
            break;
        }   
        default:   
        {   
            System.out.println("Error, Please choose 1-4"); 
            break;
        }   
        }   
       
           
        menu();   
    }   
    private static void type()//     Type of Ticket Menu
    {   
    	System.out.println();
        System.out.println("What type of ticket?");   
        System.out.println("**********************");   
        System.out.println("1 Adult - €" + currency.format(adultprice));   
        System.out.println("2 Student  - €" + currency.format(studentprice));   
        System.out.println("3 Child - €" + currency.format(childprice)); 
        System.out.println("4 Senior - €" + currency.format(seniorprice));
        System.out.println("*********************");   
           
        String ticket = input.next();
        System.out.println("");
        
        switch(ticket) //switch command allows you a String that will send you to a new method
        {     
        case "1":   
        {   
            type= "adult";    // this will be directed  to the payment() method
            payment();   
            break;   
        }   
        case "2":   
        {   
            type= "student";    // this will be directed  to the payment() method
            payment();   
            break;   
        }   
        case "3":   
        {   
            type= "child";    // this will be directed  to the payment() method
            payment();   
            break;   
        }   
        case "4" :   
        {   
            type = "senoir";    // this will be directed  to the payment() method
            payment();   
            break;   
        }   
        default:   
        {   
            System.out.println("Error, Please choose 1-4 ");   
            menu(); 
            break;   
               
        }   
        }   
        numTicketSold++;
        add();
           
    }   
    public static void add()
    {
    	//                    Giving the Option to add more tickets
    	  System.out.println("Would you like to add more?" );   
          System.out.println("Yes/No");   
          System.out.println();
          
          String add = input.next();
          
             
          switch(add)   
          {   
          case "Yes":  //added both Yes and yes just in-case the user types capital Y
          case"yes":
          case"YES":
          {  
              type();   
              break;   
          }   
          case "No":  //added both No and no just in-case the user types capital N
          case "no":
          case"NO":
          {   
              menu();   
              break;   
          }   
          default:   
          {   
              System.out.println("Please choose Yes or No.");
              System.out.println();
              add();
              break;
              
          }   
          }   
          
    }
    public static void payment()   
     {   
           
           
        if(type=="adult")   // This catches the adult button from the type() Method 
        {   
            transactionPrice += adultprice;
                       
        }   
        else if (type=="child") // This catches the child button from the type() Method   
        {   
            transactionPrice += childprice;   
        }   
        else if (type=="student")// This catches the student button from the type() Method    
        {   
            transactionPrice += studentprice;   
        }   
        else   // This catches the senior citizen button from the type() Method  
        {   
            transactionPrice += seniorprice;   
        }   
           
       
    }   
    public static void foodPayment()   
    {   
        if(addfood=="popcorn")   // This catches the popcornsoda button from the addi() Method 
        {   
            foody += popcornsoda;   
            psStock--;
        }   
        else if (addfood == "hotdog") // This catches the hotdogsoda button from the addi() Method  
        {   
            foody += hotdogsoda;   
            hsStock--;
        }   
        else if (addfood == "crisp")// This catches the crispwater button from the addi() Method   
        {   
            foody += crispwater;   
            cwStock--;
        }   
        else // This catches the burgersoda button from the addi() Method   
        {   
            foody += burgersoda;   
            bsStock--;
        }   
    }   
    private static void time()   
    {   
         System.out.println("Choose your desired time");   // customer selects their time
         System.out.println("");   
            
            
         int it = 0;   
            
         for(int i=0;i<times.length;i++)  
         {   
             it++;   
             System.out.println(it + ":\t" + times[i]); // prints the times line by line
             
         }   
         System.out.println();
            int UserChoice = input.nextInt();   
               
            it=0;   
               
            for(int i=0; i<times.length; i++)   
            {   
                it++;   
                if(UserChoice==it)   
                {   
                    chosenTime = times[i];   
                } 
              
            } 
            System.out.println();
            System.out.println("You have chosen " + chosenTime);
          
    
    isValid=true;  // after the customer finishes with the time, they could now access the other Methods      
    }   
    
    public static void printPayment()   
    {   
    	//             Data Conversion
    	System.out.println();
    	System.out.println("To Continue, Please enter your name");
    	
    	
    	
		
		try 
		{
			System.out.println();
			name = reader.readLine();
			
			System.out.println("Enter an Email Address");
			System.out.println();
			email = reader.readLine();
			System.out.println();
			
			System.out.println("Also, please enter age");
			System.out.println();
			String ageInput = reader.readLine(); 
			
			age = Integer.parseInt(ageInput);//Use Scanner for number(int, double)
		
		} catch (IOException e) 
		{
			
			System.out.println("Error")	;	
		}
    	
    	
        totalPrice = transactionPrice + foody; // the overall price of the customer
    
        System.out.println("The total cost is €" + currency.format(totalPrice));   
        System.out.println("Enter Payment");   
        System.out.println();
           
        double moneyEntered = input.nextDouble();
        System.out.println();
           
        while(moneyEntered<transactionPrice)   
        {   
            System.out.println("Balance Remaining is  €" + currency.format(totalPrice-moneyEntered));   
            moneyEntered = moneyEntered + input.nextDouble();   
        }   
        if (moneyEntered>=totalPrice)   
        {   
            System.out.println("Transaction Successful! Change is €" + currency.format(moneyEntered-totalPrice)); //this takes away the overall price from what the customer enters  
            System.out.println();   
        }
        System.out.println("Would you like a Recipt?" );   
        System.out.println("Yes/No");   
        System.out.println();
        
        String add = input.next();
        
           
        switch(add)   // switch command if the customer wishes for the receipt
        {   
        case "Yes": 
        case"yes":     
        {   
      	    break;   
        }   
        case "No": 
        case "no": 
        {   
            System.out.println("I hope you enjoy your time in " + UserChoice + "Cinema");   
            System.exit(0);   
        }   
        default:   
        {   
            System.out.println("Please choose Yes or No. ");
            System.out.println();
            add();
            break;
            
        }   
        }//                             Receipt
    
       System.out.println("****************************************");
 	   System.out.println("\t \t" + UserChoice + " Cinema");
 	   System.out.println("");
 	   System.out.println("");
 	   System.out.println(" Name:\t " + name );
 	   System.out.println(" Email:\t " + email);
 	   System.out.println(" Age: \t " + age );
 	   System.out.println("");
 	   System.out.println(" Title:\t" + chosenMovie);
 	   System.out.println(" Time:\t" + chosenTime);
 	   System.out.println(" ");
 	   System.out.println(" Tickets:\t€" + currency.format(transactionPrice));
 	   System.out.println(" Food:\t\t€" + currency.format(foody));
 	   System.out.println();
 	   System.out.println(" Total Price:\t€" + currency.format(totalPrice));
 	   System.out.println();
 	   System.out.println(" Money Recieved:\t€"+ currency.format(moneyEntered));
 	   System.out.println(" Change:\t€" + currency.format(moneyEntered-totalPrice));
 	   System.out.println("");
 	   System.out.println("I hope you enjoy your time in " + UserChoice + " Cinema");
 	   System.out.println("See you Again!");
 	   System.out.println("*****************************************");
 	   
 	   System.exit(0); // Ends the program 
 	   
 	   
 	   
    }   	
   
}   
    
 