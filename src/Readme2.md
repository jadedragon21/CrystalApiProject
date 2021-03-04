Working with the IntelliJ IDE select the build.gradle file and open with IntelliJ to 
build your file.

A window should open with your project.

Press Alt+1 to open your project directory. 

Make sure to open your CrystalApiProject by double clicking it.

Check to make sure all the files are there as it is in the github files.

Before running the application:
Seed the database first by uncommenting the Runner.java file.

(Don't run this just yet!)
A few things to know before you do run this app:

To run the application if you are a beginner:

Press Alt+1 to open your project directory. 
Right click on the file called CrystalApiProjectApplication.
Either scroll down the list till you see a green arrow that says 
run CrystalApiProj main()' Ctrl+Shift+F10. Then either click on it
or press the Ctrl+Shift+F10 in that order.
A comment signified by these --> // means you can leave comments/notes in the app
for other devs/users/self. It also means that when you uncomment your comments it will
be visible to the IDE which you are viewing this app on.You can re-comment something in
case of accidental uncommenting by pressing ctrl+ / . It works both ways.
You can hide bits of code that don't work or that you want to implement late or
even code that isn't playing nice with other code.

(Ok now you can run the app! Yay!)

Run the application once then re-comment the Runner.java file back out
using the Ctrl + / on your keyboard.  

After re-commenting out the Runner.java file, run the app again.

To see the Swagger page go to an internet browser then type this in the bar at the top:
http://localhost:8080/swagger-ui/index.html

Get,Post, Put, and Delete functions enabled on the swagger page.
First get option isn't working fully atm.

For a view of the swagger json info go here:

For a Crystals List:
http://localhost:8080/swagger-ui/index.html?urls.primaryName=Version%201
http://localhost:8080/v2/api-docs?group=Version 1
http://localhost:8080/v1/crystals

For a Crystal & Gems List:
http://localhost:8080/swagger-ui/index.html?urls.primaryName=Version%202
http://localhost:8080/v2/api-docs?group=Version 2
http://localhost:8080/v2/crystals

Have fun adding to your gem or crystal collection!

