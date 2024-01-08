package com.gmail.sorin9812;

import com.comsol.model.GeomSequence;

// Aceasta interfata descrie functiile pe care un obiect
// trebuie sa le implementeze pentru a putea fi introdus corect intr-un model
public interface IGeometryComponent {
	public void AppendGeometry(GeomSequence geometry);
}
