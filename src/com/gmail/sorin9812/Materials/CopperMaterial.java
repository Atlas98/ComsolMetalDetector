package com.gmail.sorin9812.Materials;
import com.comsol.model.*; 

// todo: think how to add existing materials from the material library
public class CopperMaterial {
	private static String name = "Copper";
	
	
	public static String GetName() {
		return name;
	}
	
	
	public static Material CreateAtNode(ModelNode component) {
		Material material = component.material().create(name, "Common");
		
		material.propertyGroup().create("Enu", "Young's modulus and Poisson's ratio");
	    material.propertyGroup().create("linzRes", "Linearized resistivity");
	    material.label("Copper");
	    material.set("family", "copper");
	    material.propertyGroup("def").set("relpermeability", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
	    material.propertyGroup("def").set("electricconductivity", new String[]{"5.998e7[S/m]", "0", "0", "0", "5.998e7[S/m]", "0", "0", "0", "5.998e7[S/m]"});
	    material.propertyGroup("def").set("thermalexpansioncoefficient", new String[]{"17e-6[1/K]", "0", "0", "0", "17e-6[1/K]", "0", "0", "0", "17e-6[1/K]"});
	    material.propertyGroup("def").set("heatcapacity", "385[J/(kg*K)]");
	    material.propertyGroup("def").set("relpermittivity", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
	    material.propertyGroup("def").set("density", "8960[kg/m^3]");
	    material.propertyGroup("def").set("thermalconductivity", new String[]{"400[W/(m*K)]", "0", "0", "0", "400[W/(m*K)]", "0", "0", "0", "400[W/(m*K)]"});
	    material.propertyGroup("Enu").set("E", "110[GPa]");
	    material.propertyGroup("Enu").set("nu", "0.35");
	    material.propertyGroup("linzRes").set("rho0", "1.72e-8[ohm*m]");
	    material.propertyGroup("linzRes").set("alpha", "0.0039[1/K]");
	    material.propertyGroup("linzRes").set("Tref", "298[K]");
	    material.propertyGroup("linzRes").addInput("temperature");
	    material.set("family", "copper");
	    
		return material;
	}
}
