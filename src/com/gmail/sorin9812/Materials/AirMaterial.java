package com.gmail.sorin9812.Materials;
import com.comsol.model.*; 
import com.comsol.model.util.*;

// todo: think how to add existing materials from the material library
public class AirMaterial {
	private static String name = "Air";
	
	
	public static String GetName() {
		return name;
	}

	
	public static Material CreateAtNode(ModelNode component) {
		Material material = component.material().create(name, "Common");
		
	    material.propertyGroup("def").func().create("eta", "Piecewise");
	    material.propertyGroup("def").func().create("Cp", "Piecewise");
	    material.propertyGroup("def").func().create("rho", "Analytic");
	    material.propertyGroup("def").func().create("k", "Piecewise");
	    material.propertyGroup("def").func().create("cs", "Analytic");
	    material.propertyGroup("def").func().create("an1", "Analytic");
	    material.propertyGroup("def").func().create("an2", "Analytic");
	    material.propertyGroup().create("RefractiveIndex", "Refractive index");
	    material.propertyGroup().create("NonlinearModel", "Nonlinear model");
	    material.propertyGroup().create("idealGas", "Ideal gas");
	    material.propertyGroup("idealGas").func().create("Cp", "Piecewise");
	    material.label("Air");
	    material.set("family", "air");
	    material.propertyGroup("def").func("eta").set("arg", "T");
	    material.propertyGroup("def").func("eta").set("pieces", new String[][]{{"200.0", "1600.0", "-8.38278E-7+8.35717342E-8*T^1-7.69429583E-11*T^2+4.6437266E-14*T^3-1.06585607E-17*T^4"}});
	    material.propertyGroup("def").func("eta").set("argunit", "K");
	    material.propertyGroup("def").func("eta").set("fununit", "Pa*s");
	    material.propertyGroup("def").func("Cp").set("arg", "T");
	    material.propertyGroup("def").func("Cp").set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
	    material.propertyGroup("def").func("Cp").set("argunit", "K");
	    material.propertyGroup("def").func("Cp").set("fununit", "J/(kg*K)");
	    material.propertyGroup("def").func("rho").set("expr", "pA*0.02897/R_const[K*mol/J]/T");
	    material.propertyGroup("def").func("rho").set("args", new String[]{"pA", "T"});
	    material.propertyGroup("def").func("rho").set("fununit", "kg/m^3");
	    material.propertyGroup("def").func("rho").set("argunit", new String[]{"Pa", "K"});
	    material.propertyGroup("def").func("rho").set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "293.15"}});
	    material.propertyGroup("def").func("k").set("arg", "T");
	    material.propertyGroup("def").func("k").set("pieces", new String[][]{{"200.0", "1600.0", "-0.00227583562+1.15480022E-4*T^1-7.90252856E-8*T^2+4.11702505E-11*T^3-7.43864331E-15*T^4"}});
	    material.propertyGroup("def").func("k").set("argunit", "K");
	    material.propertyGroup("def").func("k").set("fununit", "W/(m*K)");
	    material.propertyGroup("def").func("cs").set("expr", "sqrt(1.4*R_const[K*mol/J]/0.02897*T)");
	    material.propertyGroup("def").func("cs").set("args", new String[]{"T"});
	    material.propertyGroup("def").func("cs").set("fununit", "m/s");
	    material.propertyGroup("def").func("cs").set("argunit", new String[]{"K"});
	    material.propertyGroup("def").func("cs").set("plotargs", new String[][]{{"T", "273.15", "373.15"}});
	    material.propertyGroup("def").func("an1").set("funcname", "alpha_p");
	    material.propertyGroup("def").func("an1").set("expr", "-1/rho(pA,T)*d(rho(pA,T),T)");
	    material.propertyGroup("def").func("an1").set("args", new String[]{"pA", "T"});
	    material.propertyGroup("def").func("an1").set("fununit", "1/K");
	    material.propertyGroup("def").func("an1").set("argunit", new String[]{"Pa", "K"});
	    material.propertyGroup("def").func("an1").set("plotargs", new String[][]{{"pA", "101325", "101325"}, {"T", "273.15", "373.15"}});
	    material.propertyGroup("def").func("an2").set("funcname", "muB");
	    material.propertyGroup("def").func("an2").set("expr", "0.6*eta(T)");
	    material.propertyGroup("def").func("an2").set("args", new String[]{"T"});
	    material.propertyGroup("def").func("an2").set("fununit", "Pa*s");
	    material.propertyGroup("def").func("an2").set("argunit", new String[]{"K"});
	    material.propertyGroup("def").func("an2").set("plotargs", new String[][]{{"T", "200", "1600"}});
	    material.propertyGroup("def").set("thermalexpansioncoefficient", "");
	    material.propertyGroup("def").set("molarmass", "");
	    material.propertyGroup("def").set("bulkviscosity", "");
	    material.propertyGroup("def").set("thermalexpansioncoefficient", new String[]{"alpha_p(pA,T)", "0", "0", "0", "alpha_p(pA,T)", "0", "0", "0", "alpha_p(pA,T)"});
	    material.propertyGroup("def").set("molarmass", "0.02897[kg/mol]");
	    material.propertyGroup("def").set("bulkviscosity", "muB(T)");
	    material.propertyGroup("def").set("relpermeability", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
	    material.propertyGroup("def").set("relpermittivity", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
	    material.propertyGroup("def").set("dynamicviscosity", "eta(T)");
	    material.propertyGroup("def").set("ratioofspecificheat", "1.4");
	    material.propertyGroup("def").set("electricconductivity", new String[]{"0[S/m]", "0", "0", "0", "0[S/m]", "0", "0", "0", "0[S/m]"});
	    material.propertyGroup("def").set("heatcapacity", "Cp(T)");
	    material.propertyGroup("def").set("density", "rho(pA,T)");
	    material.propertyGroup("def").set("thermalconductivity", new String[]{"k(T)", "0", "0", "0", "k(T)", "0", "0", "0", "k(T)"});
	    material.propertyGroup("def").set("soundspeed", "cs(T)");
	    material.propertyGroup("def").addInput("temperature");
	    material.propertyGroup("def").addInput("pressure");
	    material.propertyGroup("RefractiveIndex").set("n", new String[]{"1", "0", "0", "0", "1", "0", "0", "0", "1"});
	    material.propertyGroup("NonlinearModel").set("BA", "(def.gamma+1)/2");
	    material.propertyGroup("idealGas").func("Cp").label("Piecewise 2");
	    material.propertyGroup("idealGas").func("Cp").set("arg", "T");
	    material.propertyGroup("idealGas").func("Cp").set("pieces", new String[][]{{"200.0", "1600.0", "1047.63657-0.372589265*T^1+9.45304214E-4*T^2-6.02409443E-7*T^3+1.2858961E-10*T^4"}});
	    material.propertyGroup("idealGas").func("Cp").set("argunit", "K");
	    material.propertyGroup("idealGas").func("Cp").set("fununit", "J/(kg*K)");
	    material.propertyGroup("idealGas").set("Rs", "R_const/Mn");
	    material.propertyGroup("idealGas").set("heatcapacity", "Cp(T)");
	    material.propertyGroup("idealGas").set("ratioofspecificheat", "1.4");
	    material.propertyGroup("idealGas").set("molarmass", "0.02897");
	    material.propertyGroup("idealGas").addInput("temperature");
	    material.propertyGroup("idealGas").addInput("pressure");
	    material.materialType("nonSolid");
	    material.set("family", "air");
		
		return material;
	}
	
} // AirMaterial
