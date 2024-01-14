import java.io.IOException;

import com.comsol.model.*; 
import com.comsol.model.util.*;

import com.gmail.sorin9812.*;
import com.gmail.sorin9812.Materials.AirMaterial;
import com.gmail.sorin9812.Materials.AluminiumMaterial;
import com.gmail.sorin9812.Materials.CopperMaterial;
import com.gmail.sorin9812.Materials.IronMaterial;

public class Main {
	private static String serverAddress = "localhost";
	private static int serverPort = 2036;
    
   public static void main(String[] args) {
      run(); 
   }
   
   @SuppressWarnings("deprecation")
public static void run() {
	   System.out.println("Starting program");
       ModelUtil.connect(serverAddress, serverPort);
       // generare model cu nume unic
       Model model = ModelUtil.create(Long.toString(System.currentTimeMillis()) + "MetalDetect" + ".mph");
       ModelNode component = model.component().create("ModelFizic");
       GeomSequence geometry = component.geom().create("Geometria", 3);
       
       //Material material = component.material().create("AirMaterial");
       //material.name("Copper");
       
       // Creare componente generale
       IGeometryComponent primaryCoil = new Coil("Primary", 0, 0, 0, 0.11, 0.001);
       IGeometryComponent secondaryCoil = new Coil("Secondary", 0, 0, 0.1, 0.1, 0.001);
       IGeometryComponent boundary = new BoundarySphere("Boundary", 1.0);
       IGeometryComponent target = new MetalObject("MetalObj", 0.1).SetPosition(0,  0,  0.5);
       
       Material airMat = AirMaterial.CreateAtNode(component);
       Material copperMat = CopperMaterial.CreateAtNode(component);
       Material aluminiumMat = AluminiumMaterial.CreateAtNode(component);
       Material ironMat = IronMaterial.CreateAtNode(component);
       
       

       System.out.println("Creating geometry");
       IGeometryComponent[] geometryObjects = { primaryCoil, secondaryCoil, boundary, target};
       Main.ModelCreateGeometry(geometry, geometryObjects );

       
       // assigning materials
       ModelAssignMaterial(airMat, new int[] {1}); // assign to boundary sphere
       ModelAssignMaterial(copperMat, new int[]{2,3}); // assign to primary and secondary coil
       ModelAssignMaterial(aluminiumMat, new int[] {4}); // assign to metal object
       
       
       
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
   } // Model Create Geometry
   
   private static void ModelAssignMaterial(Material material, int[] selection) {
	   material.selection().set(selection);
   }
   
}