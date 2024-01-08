import java.io.IOException;

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
	   System.out.println("Starting program");
       ModelUtil.connect(serverAddress, serverPort);
       // generare model cu nume unic
       Model model = ModelUtil.create(Long.toString(System.currentTimeMillis()) + "MetalDetect" + ".mph");
       ModelNode component = model.component().create("ModelFizic");
       GeomSequence geometry = component.geom().create("Geometria", 3);
       
       
       
       // Creare componente generale
       Coil primaryCoil = new Coil("Primary", 0, 0, 0, 3.0, 0.1);
       Coil secondaryCoil = new Coil("Secondary", 1, 1, 1, 1.0, 0.1);
       
       
       IGeometryComponent[] geometryObjects = { primaryCoil, secondaryCoil };
       Main.ModelCreateGeometry(geometry, geometryObjects );

       
       
       
       
       try {
    	   model.save(Long.toString(System.currentTimeMillis()) + "_MetalDetect" + ".mph");
       } catch(IOException e) {
    	   e.printStackTrace();
       }
       ModelUtil.disconnect();
       System.out.println("Done");
   }
   
   // temporar - inlocuire
   private static void ModelCreateGeometry(GeomSequence geometry, IGeometryComponent[] geometries) {
	   for(IGeometryComponent geometryComponent : geometries) {
		   geometryComponent.AppendGeometry(geometry);
	   }
	   
	   geometry.run(); // Aici se construieste geometria cu toate componentele adaugate
   }
   
   
}