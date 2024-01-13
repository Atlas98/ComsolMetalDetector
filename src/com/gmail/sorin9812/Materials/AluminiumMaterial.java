package com.gmail.sorin9812.Materials;
import com.comsol.model.*; 

// todo: think how to add existing materials from the material library
public class AluminiumMaterial {
	private static String name = "Aluminium";
	
	
	public static String GetName() {
		return name;
	}
	
	
	public static Material CreateAtNode(ModelNode component) {
		Material material = component.material().create(name, "Common");
		
	    material.propertyGroup().create("Enu", "Young's modulus and Poisson's ratio");
	    material.propertyGroup().create("Murnaghan", "Murnaghan");
	    material.label("Aluminum");
	    material.set("family", "aluminum");
	    material.propertyGroup("def").set("relpermeability", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
	    material.propertyGroup("def").set("heatcapacity", "900[J/(kg*K)]");
	    material.propertyGroup("def").set("thermalconductivity", new String[]{"238[W/(m*K)]", "0", "0", "0", "238[W/(m*K)]", "0", "0", "0", "238[W/(m*K)]"});
	    material.propertyGroup("def").set("electricconductivity", new String[]{"3.774e7[S/m]", "0", "0", "0", "3.774e7[S/m]", "0", "0", "0", "3.774e7[S/m]"});
	    material.propertyGroup("def").set("relpermittivity", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
	    material.propertyGroup("def").set("thermalexpansioncoefficient", new String[]{"23e-6[1/K]", "0", "0", "0", "23e-6[1/K]", "0", "0", "0", "23e-6[1/K]"});
	    material.propertyGroup("def").set("density", "2700[kg/m^3]");
	    material.propertyGroup("Enu").set("E", "70[GPa]");
	    material.propertyGroup("Enu").set("nu", "0.33");
	    material.propertyGroup("Murnaghan").set("l", "-250[GPa]");
	    material.propertyGroup("Murnaghan").set("m", "-330[GPa]");
	    material.propertyGroup("Murnaghan").set("n", "-350[GPa]");
	    material.set("family", "aluminum");
	    
		return material;
	}
	
}
