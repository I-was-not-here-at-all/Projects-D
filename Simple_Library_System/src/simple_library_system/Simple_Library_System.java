/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simple_library_system;

/**
 *
 * @author MARK
 */
import java.util.Scanner;
import java.time.LocalDate; //imports current date

public class Simple_Library_System {
    //Global Variables

    public static String Occupation;
    public static String[][] Accounts
            = {
                {"Amber Diaz", "amber.dz@bpsu.edu.ph", "LoveISinBLOOM_@!", "09218053142", "BSIT", "NW1D", "Student"},
                {"Aurette Lauretta", "aurette.laur@bpsu.edu.ph", "HgihHsrmv21897820", "09262053024", "BSIT", "NW3D", "Student"},
                {"Basil Dela Fuente", "basil.df@bpsu.edu.ph", "Basil_Latt3000", "09092624442", "BSIT", "NW1A", "Student"},
                {"June Santos", "june.snts@bpsu.edu.ph", "09547509460Heart!!", "09420111607", "BSIT", "NW1A", "Student"},
                {"Adam Tungol", "adam.tngl@bpsu.edu.ph", "Ad4mizAwsome_xxX", "09396094307", "BSIT", "NW1D", "Student"},
                {"Finley Kingsley", "finley.k@bpsu.edu.ph", "kamahalanx3MAJESTY!!!", "09093906766", "BSIT", "NW3A", "Student"},
                {"Itia Rodriguez", "itia.rod@bpsu.edu.ph", "1233345678910!!", "09805213898", "BSIT", "NW1F", "Student"},
                {"Mika Ramos", "mika.rms@bpsu.edu.ph", "RarityBestPonyXoxOXO0", "09932034000", "BSIT", "NW2D", "Student"},
                {"Steph Sanchez", "steph.snchz@bpsu.edu.ph", "09102004QueSerasera", "09720344955", "BSIT", "NW2E", "Student"},
                {"Sid Buensuceso", "sid.bscs@bpsu.edu.ph", "DearlyBelovedangel03", "09762906385", "BSIT", "NW4A", "Student"},
                {"Tala De Leon", "tala.dln@bpsu.edu.ph", "h0p3les5lYD3v0tED", "09017356224", "BSIT", "NW3C", "Student"},
                {"Evelyn Bautista", "evelyn.bts@bpsu.edu.ph", "L1Ght24681013579!", "09146154607", "BSIT", "NW1D", "Student"},
                {"Winnie Revillame", "winnie.rvlm@bpsu.edu.ph", "SunflowerW!97", "09709750767", "BSIT", "NW1A", "Student"},
                {"Gabriel Francisco", "gabriel.frn@bpsu.edu.ph", "GryphonG$4307", "09433040779", "BSIT", "NW4C", "Student"},
                {"Sebastian Perez", "seb.perez@bpsu.edu.ph", "S3b@stianP!92", "09031837292", "BSIT", "NW2E", "Student"},
                {"Viktor Lopez", "viktor.lpz@bpsu.edu.ph", "V!ktorShadow481", "09506701481", "BSIT", "NW4D", "Student"},
                {"Aima Ri Gonzales", "aima.ri@bpsu.edu.ph", "V3n0m!R@pt0rX#9qZ2bL", "09048202323", "BSIT", "NW3D", "Student"},
                {"Clement Torres", "clement.trs@bpsu.edu.ph", "C1emTor42!", "09400924623", "BSIT", "NW2E", "Student"},
                {"Kael Nate Langit", "kael.langit@bpsu.edu.ph", "GusT0kUmAGsmb0ng", "09119688280", "BSIT", "NW1D", "Student"},
                {"Lain dela Cruz", "lain.dc@bpsu.edu.ph", "LdCruz_654", "09178065453", "BSIT", "NW2D", "Student"},
                {"Adeleine Anne May", "adeleine.may@bpsu.edu.ph", "BakingMuse_19!", "09032882747", "N/A", "N/A", "Staff"},
                {"Eden Aquino", "eden.aq@bpsu.edu.ph", "Eden.FrostRune_91$", "09064358613", "N/A", "N/A", "Staff"},
                {"Eirlys de Guzman", "eirlys.dg@bpsu.edu.ph", "0123456790!", "09952484703", "N/A", "N/A", "Staff"},
                {"Charlie Domingo", "charlie.dmg@bpsu.edu.ph", "VerdantSoul333", "09197602688", "N/A", "N/A", "Staff"},
                {"Sage Fernandez", "sage.frnz@bpsu.edu.ph", "SageMindThryv33", "09079839776", "N/A", "N/A", "Staff"},
                {"Virgil Venture", "virgil.vnt@bpsu.edu.ph", "Password098765!", "09410790278", "N/A", "N/A", "Staff"},
                {"Willow Reyes", "willow.rsy@bpsu.edu.ph", "Mindbl0Om_!0110", "09062501587", "N/A", "N/A", "Staff"},
                {"Stetson Will Castillo", "stetson.wc@bpsu.edu.ph", "unt0uch3dr1zz$$$", "09408741804", "N/A", "N/A", "Staff"},
                {"Deidre Flores", "deidre.flr@bpsu.edu.ph", "softbreezeechoeS0123", "09139229807", "N/A", "N/A", "Staff"},
                {"Neri Rivera", "neri.rvr@bpsu.edu.ph", "X9v!pR7q$Lm3#zT8", "09916022058", "N/A", "N/A", "Staff"},
                {"Admin", "Admin", "123", "N/A", "N/A", "N/A", "Staff"},
                {"Student Admin", "Student-Admin", "123", "N/A", "BSIT", "NW1D", "Student"}

            };

    public static String[][] Books
            = {
                {"Atomic Habits", "PSC-33", "Available", "Psychology", "04"},
                {"Thinking, Fast and Slow", "PSC-42", "Available", "Psychology", "05"},
                {"Start With Why", "BN-11", "Available", "Business", "02"},
                {"Good Strategy, Bad Strategy", "BN-14", "Available", "Business", "02"},
                {"Functional Analysis", "MM-16", "Available", "Mathematics", "02"},
                {"Smooth Manifolds", "MM-40", "Available", "Mathematics", "05"},
                {"The Rise and Fall of The Third Reich", "HS-35", "Available", "History", "04"},
                {"The Ancient City", "HS-38", "Available", "History", "04"},
                {"Critique of Pure Reason", "PS-08", "Available", "Philosophy", "01"},
                {"Plato's Republic", "PS-28", "Available", "Philosophy", "03"},
                {"Stuff Matters", "SC-17", "Available", "Science", "02"},
                {"Entangled Life", "SC-25", "Available", "Science", "03"},
                {"The Essential Rumi", "PT-03", "Not Available", "Poetry", "01"},
                {"The Wild Iris", "PT-07", "Available", "Poetry", "01"},
                {"Color and Light", "AT-05", "Available", "Arts", "01"},
                {"Design and Invention", "AT-06", "Available", "Arts", "01"},
                {"Why Art Cannot Be Taught", "AT-09", "Available", "Arts", "01"},
                {"Pride and Prejudice", "RN-12", "Available", "Romance", "02"},
                {"It Ends With Us", "RN-32", "Available", "Romance", "04"},
                {"The Lord of The Rings", "FT-10", "Available", "Fantasy", "01"},
                {"Narnia", "FT-21", "Available", "Fantasy", "03"},
                {"The Iliad", "ML-01", "In Process", "Mythology", "01"},
                {"The Odyssey", "ML-02", "Not Available", "Mythology", "01"},
                {"Pandora's Star", "SF-33", "Available", "Science Fiction", "04"},
                {"The Mote in God's Eye", "SF-29", "Available", "Science Fiction", "03"},
                {"The Murder of Roger Ackroyd", "MT-43", "Available", "Mystery", "05"},
                {"Broadchurch", "MT-49", "Available", "Mystery", "05"},
                {"Station Eleven", "DT-13", "Available", "Dystopian", "02"},
                {"The Stand", "DT-19", "Available", "Dystopian", "02"},
                {"Fahrenheit 451", "DT-28", "Available", "Dystopian", "03"}

            };
    public static String[][] In_Process = new String[Books.length + 1][6];

    public static String[][] Borrowed_Books = new String[Books.length + 1][6];

    public static String[] User_Information = new String[2]; //takes Current user Information
    //functions
    
    //account checker - finds a matching email and password in the system
    public static boolean Account_Found(String[][] Account, String email, String password) {
        int row = 1;
        while (row <= Account.length) { //loops everthing until found a match account
            if (email.equals(Account[row - 1][1].toLowerCase()) && password.equals(Account[row - 1][2])) {
                // the ".equals()" works the same way as "==" but used for objects like arrays
                System.out.println("\nWelcome " + Account[row - 1][0] + "\n");
                User_Information[0] = Account[row - 1][0]; //takes user name
                User_Information[0] = Account[row - 1][1]; //takes user email
                Occupation = Account[row - 1][6];

                return true;  // returns true and breaks the whole loop if found a match
            }
            row++;
        }
        return false; // in case there is no match the function will return false
    }
    
    //takes the current_row that data can be placed. mainly used in In_Process and Borrowed_Books to add it to an null value in the array
    public static int Current_Row(int total_row, String[][] Array) {
        int current_row = 0;
        for (int i = 0; i < total_row; i++) {
            if (Array[i][0] != null) {
                current_row++;
            } else {
                break;
            }
        }
        return current_row;

    }

    // displays all the books from the system
    public static void Display_Books(String[][] Book) {
        System.out.println("========================================================================");
        System.out.println("                             Available Books                            ");
        System.out.println("========================================================================");
        System.out.println("=============Book Name===============|===Book_Code===|==Availability===|");
        // Loop to display each book row
        for (int i = 0; i < Book.length; i++) {
            System.out.printf("%-36s | %-13s | %-15s |%n", Book[i][0], Book[i][1], Book[i][2]);
        }
        System.out.println("========================================================================");
    }
    
    //Displays Process books and Borrowed Books
    public static void Display_In_Process_And_Borrowed_Books(String[][] Book, String Title) {
        System.out.println("=========================================================================================================================================================");
        System.out.println("                                                                  " + Title);
        System.out.println("=========================================================================================================================================================");
        System.out.println("=============Book Name===============|====Book_Code===|==========Borrower Name=========|==============Email=============|=Date_Borrowed=|==Date_Return==|");
        // Loop to display each book row
        for (int i = 1; i <= Book.length; i++) {
            if (Book[i - 1][0] == null) {
                break;
            }
            System.out.printf("%-36s | %-14s | %-30s | %-30s | %-13s | %-13s |%n", Book[i - 1][0], Book[i - 1][1], Book[i - 1][2], Book[i - 1][3], Book[i - 1][4], Book[i - 1][5]);
        }
        System.out.println("=========================================================================================================================================================");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // Main System       
        //Pre Defined Vaalues for In Process and Borrowed Books
        In_Process[0][0] = "The Iliad"; //book name
        In_Process[0][1] = "ML-01"; //book code
        In_Process[0][2] = "Basil Dela Fuente"; //user name
        In_Process[0][3] = "basil.df@bpsu.edu.ph"; //user email
        In_Process[0][4] = LocalDate.now().toString(); //date book taken
        In_Process[0][5] = "2025-25-11"; //date expected return
        Borrowed_Books[0][0] = "The Essential Rumi";
        Borrowed_Books[0][1] = "PT-03";
        Borrowed_Books[0][2] = "Amber Diaz";
        Borrowed_Books[0][3] = "amber.dz@bpsu.edu.ph";
        Borrowed_Books[0][4] = "2025-10-10";
        Borrowed_Books[0][5] = "2025-14-11";
        Borrowed_Books[1][0] = "The Odyssey";
        Borrowed_Books[1][1] = "ML-02";
        Borrowed_Books[1][2] = "June Santos";
        Borrowed_Books[1][3] = "june.snts@bpsu.edu.ph";
        Borrowed_Books[1][4] = "2025-10-10";
        Borrowed_Books[1][5] = "2025-13-11";

        do { // Loops The whole System infinitely.
            //Variables and Scanners
            Scanner ui = new Scanner(System.in);
            boolean User_Logout = false;
            String email, password;

            System.out.println("Welcome To The SNHS(ANNEX) Library System \n");
            //Login System
            while (true) { // loops the login system till the user successfully login
                //header of the login system.
                System.out.println("+++++++++++++++++++++Login++++++++++++++++++++");
                System.out.println("==============================================");
                //user input for email
                System.out.print("Email: ");
                email = ui.nextLine().toLowerCase();
                System.out.println("==============================================");
                //user input for password
                System.out.print("Password: ");
                password = ui.nextLine();
                System.out.println("==============================================");
                System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");

                //condition for login system
                if (Account_Found(Accounts, email, password)) {

                    break;
                } else if (password.length() < 8) {
                    System.out.println("\n -Password Must Be Atleaast 8 Characters Long-\n");
                } else {
                    System.out.println("\n---------- WRONG PASSWORD OR EMAIL ------------\n");
                }
            }// end of while loop
            //loops the book process till the user decided to logout
            do {
                //loops all the process
                while (true) {
                    //borrowing process if the user wants to borrow a book
                    if (Occupation.equalsIgnoreCase("student")) {
                        //displays the interface for Student Account
                        Display_Books(Books); //displays all book in the database / array
                        System.out.println("\nPlease Type the Book Code That You want to borrow:");
                        System.out.println("separate each book code with space");
                        System.out.println("Ex. CP-01 SC-01");
                        System.out.print("Book Codes: ");
                        String[] Chosen_Book_Codes = ui.nextLine().split(" "); //takes user input of book code to process it
                        System.out.println("\nPleased Type the Return Date With The Following Format \nYYYY-DD-MM ex. 2025-11-12");
                        System.out.print("Return Date: ");
                        String Return_Date = ui.nextLine();

                        //Variables for Student System
                        boolean Proceed = true;
                        int Avail_col = 0;
                        int Unavail_col = 0;
                        String[] Available_Book_Codes = new String[Books.length];
                        String[] Unavailable_Book_Codes = new String[Books.length];
                        for (String Book_Code : Chosen_Book_Codes) {
                            int row = 0;
                            //loops in array to see if there is a match of book code
                            while (row < Books.length) {
                                if (Book_Code.equalsIgnoreCase(Books[row][1])) {
                                    //if found a matching book it will check whether the book is available or not
                                    if (Books[row][2].equalsIgnoreCase("Available")) {
                                        //once it is available it will store it in a array for available books to use later
                                        Available_Book_Codes[Avail_col] = Books[row][1];
                                        Avail_col++;
                                    } else {
                                        // if it is not available it will store it in an array of unavailable books to use later
                                        Unavailable_Book_Codes[Unavail_col] = Books[row][1];
                                        Unavail_col++;
                                    }
                                    break; //stops finding once it saw a match
                                }
                                row++;
                            }
                        }

                        if (Unavailable_Book_Codes[0] != null) {
                            System.out.println("\nThe Following Books:");

                            for (int i = 1; i < Unavailable_Book_Codes.length; i++) {
                                if (Unavailable_Book_Codes[i - 1] == null) { //breaks the loop once it find the content of the array is null
                                    break;
                                }
                                System.out.println(Unavailable_Book_Codes[i - 1]);
                            }
                            System.out.println("Is Currently Not Available\n");
                        }
                        //in case the user picks all books that are not available it will not proceed to the process
                        if (Available_Book_Codes[0] == null) {
                            Proceed = false;
                        } else {
                            System.out.println("\n\nProceeding With The Following Books:");
                            for (int i = 1; i < Available_Book_Codes.length; i++) {
                                if (Available_Book_Codes[i - 1] == null) { //stops looping once it detects null
                                    break;
                                }
                                System.out.println(Available_Book_Codes[i - 1]);
                            }
                        }

                        if (Proceed) {
                            while (true) {
                                int process_row = Current_Row(In_Process.length, In_Process);
                                System.out.println("\nAre you sure you want to Borrow the listed books?:");
                                System.out.print("Y/N:");
                                String User_Confirmation = ui.nextLine();

                                if (User_Confirmation.equalsIgnoreCase("y") || User_Confirmation.equalsIgnoreCase("yes")) {
                                    for (String bookcode : Available_Book_Codes) {
                                        //this loop search for a match in bookcodes
                                        if (bookcode == null) {
                                            break;
                                        }
                                        for (int i = 1; i <= Books.length; i++) {
                                            //if bookcode saw a matching data in the array

                                            if (bookcode.equalsIgnoreCase(Books[i - 1][1])) {
                                                System.out.println("\n\n\n");
                                                System.out.printf("For %s(%s): \nGo To Shelf %s On %s Section\n",
                                                        Books[i - 1][0], Books[i - 1][1], Books[i - 1][4], Books[i - 1][3]);
                                                In_Process[process_row][0] = Books[i - 1][0]; //book name
                                                In_Process[process_row][1] = Books[i - 1][1]; //book code
                                                In_Process[process_row][2] = User_Information[0]; //user name
                                                In_Process[process_row][3] = User_Information[1]; //user email
                                                In_Process[process_row][4] = LocalDate.now().toString(); //date book taken
                                                In_Process[process_row][5] = Return_Date; //date expected return
                                                process_row++;
                                                Books[i - 1][2] = "In Process";
                                                Thread.sleep(1000);
                                                break;
                                            }
                                        }
                                    }
                                    System.out.println("\nthen proceed to counter to process it.\nThank you!");
                                    break;
                                } else if (User_Confirmation.equalsIgnoreCase("n") || User_Confirmation.equalsIgnoreCase("no")) {
                                    System.out.println("Process Canceled");
                                    break;
                                } else {
                                    System.out.println("Response Not Available Pleased Try Again");

                                }

                            }
                            break;
                        } else {
                            System.out.println("\n\n\n\nNo Chosen Books Are Available");

                        }

                    } else {
                        //Displays the Interface for Staff Account
                        //Ask the user if what the user wants to do
                        System.out.println("\n\n\n\n\nChoose What you want to do:");
                        System.out.println("Type `1` to Process Books");
                        System.out.println("Type `2` to See Borrowed Books");
                        System.out.println("Type `3` to see List of All Books");
                        System.out.print("To Do: ");
                        String Todo = ui.nextLine();
                        
                        if (Todo.equals("1")) {//if 1 shows the currently in process books where a staff can confirm its process
                            Display_In_Process_And_Borrowed_Books(In_Process,"Processing Books");//Displays In_Process Books
                            System.out.println("Enter The Book Code you want to Confirm");
                            System.out.print("Book Codes: ");
                            String[] Confirm_Book_Code = ui.nextLine().split(" ");
                            int Borrow_row = Current_Row(Borrowed_Books.length, Borrowed_Books);

                            for (String bookcode : Confirm_Book_Code) {

                                for (int i = 1; i < In_Process.length; i++) {
                                    if (i == 30) {
                                        break;
                                    }
                                    //System for COnfirming In_Process Books to make it Unavailable
                                    if (bookcode.equalsIgnoreCase(In_Process[i - 1][1])) {
                                        //inputs Current Book in the borrowed_books Array
                                        Borrowed_Books[Borrow_row][0] = In_Process[i - 1][0];
                                        Borrowed_Books[Borrow_row][1] = In_Process[i - 1][1];
                                        Borrowed_Books[Borrow_row][2] = In_Process[i - 1][2];
                                        Borrowed_Books[Borrow_row][3] = In_Process[i - 1][3];
                                        Borrowed_Books[Borrow_row][4] = In_Process[i - 1][4];
                                        Borrowed_Books[Borrow_row][5] = In_Process[i - 1][5];
                                        //finds the same book in the Books Array to declare it as not available
                                        for (int row = 1; row < Books.length; row++) {
                                            if (In_Process[i - 1][1].equals(Books[row - 1][1])) {
                                                Books[row - 1][2] = "Not Available";
                                                break;
                                            }
                                        }
                                        System.out.println("The Book Name " + In_Process[i-1][0] + " Has Been Confirmed Successfully");
                                        //removes Curent Book in the array
                                        In_Process[i - 1][0] = null;
                                        In_Process[i - 1][1] = null;
                                        In_Process[i - 1][2] = null;
                                        In_Process[i - 1][3] = null;
                                        In_Process[i - 1][4] = null;
                                        In_Process[i - 1][5] = null;
                                        break;
                                    }
                                }

                            }

                        } else if (Todo.equals("2")) {//if 2 Displays the Borrowed Books List where a staff can make a book available once the book is returned
                            Display_In_Process_And_Borrowed_Books(Borrowed_Books, "Borrowed Books"); //displays the borrowed books
                            System.out.println("Enter The Book Code That is Currently In Return");
                            System.out.print("Book Codes: ");
                            String[] Confirm_Book_Code = ui.nextLine().split(" "); //takes user input for bookcode to make it available

                            for (String bookcode : Confirm_Book_Code) {
                                int i = 1;
                                while (i < Books.length){
                                    if (i == 30) {
                                        break;
                                    }
                                    
                                    //System for Making Un Available Books Available
                                    if (bookcode.equalsIgnoreCase(Borrowed_Books[i - 1][1])) {
                                        //finds the same book in the Books Array to declare it as Available and remove it from the borrowed book
                                        for (int row = 1; row < Books.length; row++) {
                                            if (Borrowed_Books[i - 1][1].equals(Books[row - 1][1])) {
                                                System.out.println("The Book " + Borrowed_Books[i-1][0] + " Is Now Available");
                                                Borrowed_Books[i - 1][0] = null;
                                                Borrowed_Books[i - 1][1] = null;
                                                Borrowed_Books[i - 1][2] = null;
                                                Borrowed_Books[i - 1][3] = null;
                                                Borrowed_Books[i - 1][4] = null;
                                                Borrowed_Books[i - 1][5] = null;
                                                Books[row - 1][2] = "Available";
                                                break;
                                            }
                                        }

                                        break;
                                    }
                                    i++;
                                }

                            }
                        } else if (Todo.equals("3")) {
                            Display_Books(Books); //Displays Borrowed Book
                        } else {
                            System.out.println("Invalid Response!");
                        }
                        //ask the staff if it like to end the session
                        System.out.println("\nWould Like to end?");
                        System.out.print("Y/N: ");
                        String stop = ui.nextLine();
                        
                        if (stop.equalsIgnoreCase("y") || stop.equalsIgnoreCase("yes") ) {
                            break;
                        } else if (stop.equalsIgnoreCase("n") || stop.equalsIgnoreCase("no")) {

                        } else {
                            System.out.println("Invalid Response");
                            break;
                        }

                    }
                   
                }
                
                 //Logout System
                System.out.print("\n\n\n\nLoging You Out of the System");
                
                //Threaf.Sleep - Delays the code by 1000 millisecond or 1 seconds
                for (int i = 0; i < 3; i++) {
                    Thread.sleep(1000); 
                    System.out.print(".");
                }
                Thread.sleep(1000);
                System.out.println();
                System.out.println("Thank You For Using SNHS(Annex) Library System\n\n\n\n\n\n");
                User_Logout = true; 
                Thread.sleep(1000);
                
            } while (!User_Logout);
        } while (true);
    }// end of main

}
