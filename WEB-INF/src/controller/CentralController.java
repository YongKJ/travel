
public class CentralController{
    
    public TestController test;
    public BackgroundManagementController backgroundManagement;

    public CentralController(){
        test = new TestController();
        backgroundManagement = new BackgroundManagementController();
    }

}

//javac -d ../classes/ -cp ../../../../lib/*:../lib/*:controller/:service/:dao/:entity/ controller/CentralController.java