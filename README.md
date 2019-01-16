# Setup and launch project using maven 

    
###Install and Setup Java
 
1. Install Java 8 on your local machine. To download Java 8 jdk click on that and install java according to yours PC OS. 
1. To test the installation of Java on your machine, open cmd.exe and at the command line write ‘java -version’ and send key ‘Enter’ from your keyboard. If Java installed successfully you should see a message on your command line as java version
1. To set up JAVA_HOME follow next steps:
    1. Click left button of the mouse on the 'My computer' icon and choose 'Settings' in the drop-down list;      
    1. In the 'System' window click 'Additional parameters of the system';
    1. Click on button 'Environment variables';
    1. In the modal window 'System variables' click button 'Add';
    1. In the field 'Variable name' fill 'JAVA_HOME';
    1. In the field 'Variable value' fill <path to jdk>;
    1. Click 'OK' button;
    1. Open 'PATH' in the 'System variables'; 
    1. In the bottom of the list add %JAVA_HOME%\lib, %JAVA_HOME%\bin and %JAVA_HOME%\jre;
    1. To check the acceptance of changes, open the command line of your machine and run the following 'path' command, at the end of the change you need to set <path to jdk>\lib,<path to jdk>\bin and <path to jdk>\jre
    1. If path not show in the command line. Restart you work PC, if that not be helpful delete java and repeat steps i-x
    
###Install and Setup Git
    
1. Download and install Git
1. Open cmd.exe in PC
1. Copy command from main page of project remote repository
1. Wait that project cloning to local machine

###Install and Setup Maven
1. 

###Start test project
1. Open cmd.exe in PC
1. Go to the dir of the project using command line
1. Start test using command 'mvn clean test'
