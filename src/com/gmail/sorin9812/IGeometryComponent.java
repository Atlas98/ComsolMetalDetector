package com.gmail.sorin9812;

import com.comsol.model.GeomSequence;
import com.comsol.model.*; 

// Aceasta interfata descrie functiile pe care un obiect
// trebuie sa le implementeze pentru a putea fi introdus corect intr-un model
public abstract class IGeometryComponent {
	protected Material material;
	protected GeomFeature feature;
	// Coil data -- unique id
	protected String name;
	
	// Coil data -- coordinates
	protected double x;
	protected double y;
	protected double z;
	
	
	public abstract void AppendGeometry(GeomSequence geometry);
	
	public GeomFeature GetFeature() {
		return this.feature;
	}
	
	public IGeometryComponent SetPosition(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
		
		return this;
	}
	
	public void AssignMaterial(GeomFeature feature, Material material) {
		//feature.getInt(name)
		//material.selection().set(null);
	}
}
