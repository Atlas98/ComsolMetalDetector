package com.gmail.sorin9812;
import com.comsol.model.*; 


public class MetalObject extends IGeometryComponent {
	double lungime_latura;
	
	// Pentru moment, obiectul metalic va fi de tip cub
	public MetalObject(String name, double latura) {
		this.lungime_latura = latura;
		this.name = name;
	}
	
	
	@Override
	public void AppendGeometry(GeomSequence geometry) {
		this.feature = geometry.create(this.name, "Block");
		
		this.feature.set("pos", new double[] {x, y, z});
		this.feature.set("base", "center"); // pozitia va fi in centru
		this.feature.set("size", new double[] {this.lungime_latura, this.lungime_latura, this.lungime_latura});
	}

}
