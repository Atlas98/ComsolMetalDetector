package com.gmail.sorin9812.Materials;
import com.comsol.model.*;


public class IronMaterial {
	private static String name = "Iron";
	
	
	public static String GetName() {
		return name;
	}
	
	
	public static Material CreateAtNode(ModelNode component) {
		Material material = component.material().create(name, "Common");
		
	    material.propertyGroup().create("Enu", "Young's modulus and Poisson's ratio");
	    material.label("Iron");
	    material.set("family", "iron");
	    material.propertyGroup("def").set("relpermeability", new String[]{"4000", "0", "0", "0", "4000", "0", "0", "0", "4000"});
	    material.propertyGroup("def").set("electricconductivity", new String[]{"1.12e7[S/m]", "0", "0", "0", "1.12e7[S/m]", "0", "0", "0", "1.12e7[S/m]"});
	    material.propertyGroup("def").set("thermalexpansioncoefficient", new String[]{"12.2e-6[1/K]", "0", "0", "0", "12.2e-6[1/K]", "0", "0", "0", "12.2e-6[1/K]"});
	    material.propertyGroup("def").set("heatcapacity", "440[J/(kg*K)]");
	    material.propertyGroup("def").set("relpermittivity", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
	    material.propertyGroup("def").set("density", "7870[kg/m^3]");
	    material.propertyGroup("def").set("thermalconductivity", new String[]{"76.2[W/(m*K)]", "0", "0", "0", "76.2[W/(m*K)]", "0", "0", "0", "76.2[W/(m*K)]"});
	    material.propertyGroup("Enu").set("E", "200[GPa]");
	    material.propertyGroup("Enu").set("nu", "0.29");
	    material.set("family", "iron");
	    
		return material;
	}
}
