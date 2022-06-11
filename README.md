# This is one of my first Java-based console project

* I develop a program to manage the vaccination process of FPT university students. The
vaccination management program allows administrators to manage student vaccination information. In
addition, the program also provides a function for students to view information about the vaccine that they have
been vaccinated. To simplify the application building, I give the following business roles:
	1. Each student can only inject a maximum of 2 injections of the vaccine.
	2. The second dose of vaccine must be given 4 to 12 weeks after the first injection
	3. Two vaccines must be of the same type.
* Injection information is stored in the injection.txt file
* The student.txt file has stored student information including studentID and name fields.
* The vaccine.txt file has stored vaccine information including vaccineID and name fields.
* Upgrade version.2, support more functions: information encryption, search by student name, real-time update
processing

## Version 1.0

#### Function 1: Show information the injection information
+ Show all data in the injection.txt file into the screen.

#### Function 2: Add new injection
+ Create a submenu that allows the doctor add new injection information.o Remember that the constraints must be checked: the 	injectionID’s value cannot duplicate, student and vaccine must be existed and all business role above.
+ Add the new injection to collection. If any information is left blank, it means that the information does not need to be input at the present time (2nd information).
+ Ask to continuous create new injection or go back to the main menu.

#### Function 3: Update Injection information
+ User is required enter the injection id
+ If injection does not exist, the notification “Injection does not exist”. Otherwise, doctor can
	start update 2nd information only (place, place).
+ Remember that new information must be validated.
+ Then, system must print out the result of the updating. If the student has fully injected two
	injections, the system will display the message "Student has completed 2 injections!"
+ After updating, the program returns to the main screen.

#### Function 4: Delete Injection
+ Doctor can delete the Injection in the list.
+ Before the delete system must show confirm message.
+ Show the result of the delete: success or fail.
+ After delete, the program returns to the main screen

#### Function 5: Search injection by studentID
+ The doctor enters search text: studentID
+ The system searches the list, and returns the injection information of the input student.
+ Show result list: injection information.

#### Function 6: Store data to file
+ Store data in collection to injection.txt file


## Updated: version 2.0

#### F.5.1: Search by student name
+ Doctor input student name want to search.
+ The system will search in the list, and return all injection information that has student name
	contain the search string.
+ Show result list: all information of injection

#### Function 7: Real-time update processing 
+ Modify the above functions so that when each function is completed, the system must
	immediately update to the files.

#### Function 8: Information Encryption
+ Injection information is confidential information, so the data needs to be encrypted before
	saving it to the file. You are required to encrypt injection information with the Symmetric Security
	method before saving it to the injection.txt file.