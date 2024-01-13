package com.gmail.sorin9812;
import com.comsol.model.*; 


public class Coil extends IGeometryComponent {	
	// loop and section diameters
	double coil_loop_diameter; // in cm
	double coil_section_diameter; // in cm
	
	
	public Coil(String name, double x, double y, double z, double loop_diameter, double section_diameter) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.coil_loop_diameter = loop_diameter;
		this.coil_section_diameter = section_diameter;
		
		this.name = name;
	}

	public void AppendGeometry(GeomSequence geometry) {
		this.feature = geometry.create(this.name, "Torus");
		
		this.feature.set("pos", new double[] {x, y, z});
		this.feature.set("rmaj", coil_loop_diameter);
		this.feature.set("rmin", coil_section_diameter);
	}
	
	
}
