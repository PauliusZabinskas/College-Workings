# Command line Java

The commands that I used to compile and run the code for the command line demo are as below. Note that my project directory contained a 'src' and 'bin' folder to separate my class and java files. I ran these commands from the main project directory.

**Compile (the 'javac' command):**

In this first line, the '-d' option is used to specify a directory where the class files should be placed. 

> javac -d bin src/Account.java

I went through an example where I needed to make use of the Account class from a different java file, AccountTest.java. In this case, I need to indicate where the Account class file is located by specifying my class path using the '-classpath' option. Otherwise, it's the same as above.

> javac -classpath bin -d bin src/AccountTest.java

**Run (the 'java' command):**

To run, I just need to specify the directory where my class file that I'm running is i.e., my class path, using the '-classpath' option.

> java -classpath bin Account