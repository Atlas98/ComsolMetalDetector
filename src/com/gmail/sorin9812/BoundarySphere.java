package com.gmail.sorin9812;
import com.comsol.model.GeomSequence;


public class BoundarySphere extends IGeometryComponent {
	double radius;
	
	public BoundarySphere(String name, double radius) {
		this.name = name;
		this.radius = radius;
	}

	@Override
	public void AppendGeometry(GeomSequence geometry) {
		this.feature = geometry.create(this.name, "Sphere");
		
		this.feature.set("pos", new double[] {x, y, z});
		this.feature.set("r", this.radius);
	}

}
