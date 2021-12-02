# TAA_Servlet - Run the Project

1. First you may want to initiate the database. 
    If you want to connect your own database, be my guess. 
    
    Otherwise we have some scripts that link a database to our ServletServer

2. run run-hsqldb-server.sh to launch the database
    and show-hsqldb.sh if you want to have an UI interface

3. Then you'll have to run the `ServletServer` main class 

4. And finally if you want to persist some data in database, run `MainJPA` class

Now the project has started, you can work with by accessing `http://localhost:8080/api/users`.

Repeat the step 3 and 4 as long as you will restart the project. 

# TAA_Servlet - What it does

To resume, this project work with Servlet. We wrote a doPost servlet and a doGet.

The doGet is the one that you already access to if you follow all 
the instructions to run the project. 

Basically it displays all the users from the `Individual` table and from the `Profesionnal`.

Access to `localhost:8080/api/myform.html`, there you will be allowed to use the DoPost
servlet and also add users to the app.

Enter information of the new user and click to 'send', it will launch you to the 
USerInfo servlet to resume all the information that you just fill.

Then go back to `localost:8080/api/users` to see the new user.






