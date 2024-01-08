package com.gmail.sorin9812;
import com.comsol.model.*; 
import com.comsol.model.util.*;

import com.gmail.sorin9812.*;

public class MetalDetector {
	Model model; // comsol model file
	
	// input information
	Coil primaryCoil = new Coil();
	Coil secondaryCoil = new Coil();
	
	// output info
	float inductance; // in mH -- static conditions

	
	
	public MetalDetector() {
		this.model = ModelUtil.create(Long.toString(System.currentTimeMillis()) + Integer.toString(this.hashCode()) + ".mph");
	}
	
	
	// Assign primary coil object
	public void SetPrimaryCoil(Coil coil) {
		this.primaryCoil = coil;
		this.primaryCoil.parentModel = model;
	}
	// Assign secondary coil object
	public void SetSecondaryCoil(Coil coil) {
		this.secondaryCoil = coil;
	}
	
	
	// builds the geometry with the available coil data;
	public void CreateCoilGeometry() {
		model.component().create("PrimaryCoilComponent");
		GeomSequence primaryCoil = model.component("PrimaryCoilComponent").geom().create("primaryGeom", 3);
		GeomFeature torusFeature = primaryCoil.create("torusFeature", "Torus");
		
		torusFeature.set("pos", new double[] {1.0, 1.0, 1.0});
		torusFeature.set("rmaj", 1);
		torusFeature.set("rmin", 0.1);
		
		
	}
	
	
	public void saveModel() {
		try {
			model.save("MetalDetector.mph");
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
} // class
