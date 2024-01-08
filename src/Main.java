import com.comsol.model.*; 
import com.comsol.model.util.*;

import com.gmail.sorin9812.*;

public class Main {
	private static String serverAddress = "localhost";
	private static int serverPort = 2036;
    
   public static void main(String[] args) {
      run(); 
   }
   
   public static void run() {
       ModelUtil.connect(serverAddress, serverPort);
       
       Coil primaryCoil = new Coil("primary", 1.0, 1.0, 1.0, 1.0, 0.1);
       
       MetalDetector detector = new MetalDetector();
       detector.CreateCoilGeometry();
       detector.saveModel();
   }
   
   /*
   public static void run() {
	   try {
	   // Connect to COMSOL Server
       String serverAddress = "localhost";
       int serverPort = 2036;
       ModelUtil.connect(serverAddress, serverPort);

       // Create a COMSOL model on the server
       Model model = ModelUtil.create("Model3");
       System.out.println("Created model");

       // Define the geometry
       model.geom().create("geom1", 3);
       model.geom("geom1").feature().create("blk1", "Block");
       model.geom("geom1").feature("blk1").set("size", new String[]{"0.1", "0.2", "0.5"});

       // Create a physics (e.g., Heat Transfer)
       model.physics().create("ht", "HeatTransfer", "geom1");

       
       // Create a study (e.g., Stationary study)
       model.study().create("std");
       model.study("std").feature().create("stat", "Stationary");

       
       // Solve the model on the server
       model.sol().create("sol1");
       model.study("std").feature("stat").set("initstudyhide", "on");
       model.study("std").feature("stat").set("initsolhide", "on");
       model.study("std").feature("stat").set("solnumhide", "on");
       model.study("std").feature("stat").set("notsolnumhide", "on");
       
       System.out.println("Running simulation");
       // Run the simulation
       // model.sol("sol1").run(); // am comentat deoarece mai trebuiesc setari
       
       model.save("Model2.mph");
       model.save("Model3.mph");
      

       // Disconnect from COMSOL Server
       ModelUtil.disconnect();
	   } catch(Exception e) {
		   System.out.println("Caught exception");
		   e.printStackTrace();
		   ModelUtil.disconnect();
	   }
	   
       System.out.println("Done");
   } 
   */
   
}