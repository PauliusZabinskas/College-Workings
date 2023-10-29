## Last updated: 26-10-2023

1. delete PAYARA server
2. Install Glass Fish server
3. In NetBeans  
	1. Select Services tab  
	2. Right-click on Databases  
	3. Select ‘New Connection’  
	4. Select Driver: MySQL  
	5. You will need to select the ‘Add’ button to  add the driver file
	6. Fillout all fields to connect to database hosted on  mysql1.it.nuigalway.ie
	7. Then add useSSL: false
	8. Can be tested by selecting Execute Command 'SELECT * From actors'
4. At location `C:\Users\zabin\GlassFish_Server\bin`
	- run `asadmin.bin` file
	- Then in terminal run `add-library` command
	- In my case the jar file is located in `C:\Program Files\NetBeans-19\mysql-connector-java-8.0.30`
	- NOTE: make sure that Glass Fish server is running using NetBeans
5. Open Glass Fish admin pool.
6. ![[Pasted image 20231026120013.png]]
7. I moved on without logging server set up details. might need to go back to PDF `4 JPA`, page `4` 
8. ![[Pasted image 20231026120759.png]]
9. ![[Pasted image 20231026120731.png]]
10. Then add new resource:
![[Pasted image 20231026121300.png]]

11. If everything works. add new Persistence Unit or modify existing one.
	1. add intended jdbc resource to Persistence Unit
	2. upload SQL table to database
	3. should work.


Set up is completed.

Next [[Assessment 4 Challenge]]

