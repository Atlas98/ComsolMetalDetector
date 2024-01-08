package com.gmail.sorin9812;
import com.comsol.model.*; 
import com.comsol.model.util.*;

import com.gmail.sorin9812.*;

public class MetalDetector {
	// Variable specifice COMSOL pentru a manipula modelul
	ModelNode component;
	GeomSequence geometry;
	
	
	Coil primaryCoil;
	Coil secondaryCoil;
	
	
	
	public MetalDetector(ModelNode componentNode, GeomSequence geometryNode) {
		this.component = componentNode; // atribuire componenta pentru a putea adauga fizica bobinelor si materialele
		this.geometry = geometryNode;	// atribuire geometrie
	}
	
	
	
	public void SetPrimaryCoil(Coil coil) {
		this.primaryCoil = coil;
	}
	
	public void SetSecondaryCoil(Coil coil) {
		this.secondaryCoil = coil;
	}
	
	
	
	public void CreateCoilGeometry() {
		this.primaryCoil.AppendGeometry(geometry);
		this.secondaryCoil.AppendGeometry(geometry);
		
		geometry.run(); // o sa mut de aici, intentia este sa fie run dupa ce toate obiectele sunt introduse in model
	}
	
	
} // class
