package com.gmail.sorin9812;

import com.comsol.model.*; 
import com.comsol.model.util.*;

public class Coil {
	Model parentModel; // the parent model file of this coil
	
	// Coil data -- unique id
	String name;
	
	// Coil data -- coordinates
	double x;
	double y;
	double z;
	
	// loop and section diameters
	double coil_loop_diameter; // in cm
	double coil_section_diameter; // in cm
	
	public Coil() {
		
	}
	
	public Coil(String name, double x, double y, double z, double loop_diameter, double section_diameter) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.coil_loop_diameter = loop_diameter;
		this.coil_section_diameter = section_diameter;
		
		this.name = name;
	}
	
	
}
