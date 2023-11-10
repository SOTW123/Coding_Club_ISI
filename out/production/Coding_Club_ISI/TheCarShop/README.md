Car Class:

# Create a Java class named Car.
- Add instance variables for brand, color, and modelNumber in the Car class.
  
- Implement a constructor that takes parameters for these instance variables and initializes them. Make and use setters as required, getters are not necessary due to their being a getInfo()
method in the Car class already that will get all the info anyways.

- Define two methods in the Car class:
    - getPrice(): This method should calculate and return the price of the car. Price is based on the brand + a flat color fee of 10$, if the color is White or Black the fee is 5$ instead
    - getInfo(): This method should return a formatted string containing all the details of the car, including brand, color, and model number.
 
# Create a Java class named CarLibrary.
- Librarys are classes that soley used as utility classes, their not to be instantiated, basically this means every member is a static member, use what you know about the static keyword to help you contruct this library
These methods are to be used in the Car class.

- Implement the helper methods:
    - isBrandValid(String brand): This method should check if the provided brand is valid according to your criteria.
    - capitalizeInput(String input): Implement a method that capitalizes user input (e.g., converts it to uppercase).
    - isColorValid(String color): Create a method to validate whether the provided color is valid based on your requirements. 

# Create a Java class named Application.
- In this class create one method name run, this method will be public and this is the method that will be called on main  while loop that iterates through a user UI created with strings. The Ui should have these opptions
for the user to type :

  - Buy Car (If the user types this option, you will take their input and make a new car class with the information they give)
  - Car Info (This is the getinfo() method from the car class essentially, if no car has been bought yet display "no car purchased method" or something of the sort
  - Exit (exits the loop and finshes the code)

# Main
instantiate the application class and then use the run method from it and your done
