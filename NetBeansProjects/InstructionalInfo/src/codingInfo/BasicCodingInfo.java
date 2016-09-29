/*
Code between these can be used to comment out the top where you usually document your file.
*/
package codingInfo;

// This is where your imports usually go. It's more efficient to not
// load a ton of extra stuff that you dont need, but you can use premade code by importing it.
// I'll explain them later on.

public class BasicCodingInfo {
    // ^^^ this is a public class. It is the tab at the top.
    // There are different kinds of classes but it takes a while to get to other kinds
    // so I'll just start you off with this kind of class and then you'll eventually figure out more when you have more of a base knowledge.
    
    // This stuff up here is all reference information, so just look at it later if you'd like. Don't worry about it
    // up until you look through the rest of the stuff in this class. Where you should start is the line
    // where the code says "public static void main(string[] args) {" which is just how every main
    // method starts, and just skip the stuff in between. Main methods are what run your program.
    
    // These just show visibility modifiers.
    public String thisStringCanChange = "because it isn't final";
    private final String THIS_STRING_CANNOT_CHANGE = "because it is final";
    protected String publicPrivateAndProtected = "are visibility modifiers";
    public String publicCanBeSeenAnywhere = "I can be used in different classes besides this one";
    private String privateCanOnlyBeSeenHere = "Only this class can see me";
    protected String protectedCanBeSeenTwoPlaces = "In this class, and classes that inherit this one";
                                                                      // Inheritance comes a bit later,
                                                                      // therefore, protected isn't used
                                                                      // til a bit later.
    
    public void finalExample(){
        
        thisStringCanChange = "Now it is this!";
//        THIS_STRING_CANNOT_CHANGE = "See this error? It won't let me change it.";
        // commented it out because the error messages bother me
    }
    
    
    // This is your boolean reference portion:
    // != is not equals.
    // <=, >= is less than or equals, and then greater than or equals.
    // == is equals. = won't work because = assigns values, == compares what it points at (not the value, and I'll explain the difference real soon).
    // == won't work with strings, because the way memory works, == sees if stuff points at the same spot,
    // so if you have 2 different objects, and they both have a string "HI", but they didn't both get
    // their text from the same place, they won't be equal. How to fix that with strings is you use a
    // specific method. That method is "firstString.equals(stringYouWantToCompareTo)".
    // So let's say you want to compare the strings teacherName and studentsTeacher,
    // they both have a string that looks like "Mrs. Sherman", but teacherName==studentsTeacher won't
    // show up as true because they're looking at different places. What you have to do is do this:
    // (teacherName.equals(studentsTeacher)) which would be all or part of your boolean expression.
    
    
    // START HERE!!
    public static void main(String[] args) {
        
        // Primitives are your building blocks. This is a bit on how they work.
        
        // Primitives: int(integer, numbers w/o decimal), double(numbers w/ decimals), String("text"), boolean(T/F), char('character' which is basically just )
        // Form they're created with: primitiveType name = value ; strings aren't exactly primitives, but they're made of characters and are used so often that
		// it just felt right to include them here.
        int intName = 5;
        double doubleName = 5.0;    // There are also floats, but I use them next to never, as technology has come so far you hardly ever have to be efficient enough to
									// worry that much about amount of memory taken, and doubles are more exact (a double is basically just double the size of a float, therefore "double".
        String stringName = "TEXT!";// This isn't a primitive, but a refernce type; I mentioned that above, but want to make sure you keep that in mind.
                                    // They're used very similarly.
        boolean booleanName = true; // Directly above the main method I explain a bit more about booleans
                                    // than I do through the first run-through of them.
        char charName = 'a';
        // Form to modify primitives: name = value ;
        intName++; // ++ means add one to whatever it was before to get your new value.
                   // intName++ adds one after the entire line of code was calculated, but
                   // ++intName adds one before any other part of the code is calculated.
                   // I myself haven't found much use for the difference, it is just how they're read, but if you use them carelessly it could mess stuff up (like in a loop).
        doubleName = doubleName*1.3*(double)intName; // Since intName is an int and not a double,
                                                     // using (double) allows the two to work together.
                                                     // They would've anyway, but not if you were using
                                                     // more advanced stuff. This is called casting.
													 // Don't worry too much about it now, just know doubles and ints cooperate in Java
        stringName = (stringName + " AND MORE TEXT!"); // This is how you use strings' text together.
        booleanName = false; // Booleans are usually an indicator if something is in a state of being or not (as in yes or no simply stated).
        charName = ('s'); // Char can only hold one character.
        
        
        
        
        
        // Now we move onto loops and conditional statements.
        // These are our tools we use for most of the logic... outside of structuring your program,
        // which will come later.
        
        // There are 3 kinds of conditional statements.
        // They are if(else) statements, switch statements, and conditional statements.
        // I almost only use if statements because switch statements MIGHT make things look barely nicer,
        // but if can do the job just as well and are easier to work with USUALLY.
        // Plain old conditional statements are hardly ever used. they're basically just shorthand
        // ways of using an if statement for very small, very limited if-else code. 
        
        // This is if-else code. it goes in the following format:
        // if(boolean){code} else if (boolean) {code} else if (boolean){code} else {code}
        // There can be as many else ifs as needed in terms of the above format. Here is an example below.
        // There are many ways to manipulate the boolean field without T/F boolean primitives.
        if (booleanName != false){
            System.out.println("This boolean outcome happens if booleanName ISN'T equal to false.\n"
                    + "This is because a ! means 'not' when used somewhere a boolean is needed.\n");
                                    // \n is equivalent to pressing the enter key in microsoft word.
                                    // You don't have to remember the code for 
                                    // System.out.println("");, you just have
                                    // to type sout and then press tab if using Netbeans.
                                    // You can make yourself shortcuts for this kind of stuff as well.
        } else if ((int)doubleName>intName){
            System.out.println("if it isn't the first if statement, then it goes to this one which"
                    + "asks if doubleName is bigger than intName. Again, I use casting here because"
                    + "they aren't the same type of object (double != int)");
        } else { // Else just means that if it reaches here, it does whatever you ask it to do,
                 // but obviously that can be stopped by fulfilling a previous if statement's boolean.
            System.out.println("Really, the else-if is the same as an if, but will check the list of things before "
                    + "instead of just one so that way only one thing will happen if multiple are true..");
        }
        // Here is an example of a switch statement
        // The format is as follows:
        // switch (variable)
        //     case variableValue:
        //           code
        //           break;
        //     case variableValue:
        //           code
        //           break;
        //     default:
        //           code
        //           break;
        switch (charName) {
            case 's':
                System.out.println("code goes here for if charName = 's' ");
                System.out.print("The next line, the 'break;' just tells it to not use the switch"
                        + " statement anymore and hop out to the next bit of code after it.");
                break;
            case 'c':
                System.out.println("HELLO!");
                break;
            default:
                System.out.println("the 'default:' is just if nothing else matches, it does this. "
                        + "It is the same as the else statement for if-elses, basically");
                break;
        }
        // Here is an example of a conditional statement.
        // The format is as follows:
        // variable = (boolean) ? value1 : value2;
        // So you have your variable, and check if something is true, and if it is, its new
        // value is value1, if it isn't true, its new value is value2. So, basically it's a quick
        // if-else statement. I just hardly ever need those so I avoid using them.
        booleanName = (booleanName == true) ? false : true; // This sees if booleanName is true, and
                                                             // if it is, it changes its value to false.
                                                             // Therefore, if it is false, it
                                                             // changes the value to true.
        
        // There are 3 kinds of loops, they are for, do-while, and while loops.
        // For: run the code a set amount of times that you decide upon. used extensively with arrays.
        // Do-while: run the code, and then after each run they check a boolean if it should continue running.
        // While: checks a boolean to see if it should run, and continuously runs until it isn't true.
        
        // For loops are used more than the others from what I've experienced except in more or less infinitely running loops.
        // Do-while loops and while loops are almost the exact same, except do-while runs before it
        // starts to check the boolean, then does what the while does.
        
        // Here is an example of a for loop
        // The format goes as follows:
        // for(what you start with ; boolean to see how long to run ; what update is to be made after each time through the code){code}
        for (int i = 1; i<=intName ;i++){
            System.out.println("This starts with creating a variable 'i' and setting it to 1. "
                    + "Then it runs the code, and every time it runs the code and finishes, "
                    + "it will add 1 to i for as long as i<=intName.\n");
        }
        
        // Here is an example of a while loop
        // The format goes as follows:
        // while(boolean expression){code}
        while (booleanName==true){
            booleanName = false;
        }
        
        // And here is an example of a do-while loop... it's very similar to the one right above
        // the format goes as follows:
        // do{code}while(boolean expression);
        do{
            booleanName = (booleanName == true) ? false : true ; // just grabbed the code from above
            System.out.println("This is how many times the do-while loop ran");
        } while (booleanName==true);
    }
    
    // The output on this really isn't used to show anything, I just used orange text to help separate some stuff,
    // and not have everything in comments.
    
}