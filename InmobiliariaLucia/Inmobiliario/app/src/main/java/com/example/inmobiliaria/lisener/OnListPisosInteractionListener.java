package com.example.inmobiliaria.lisener;

import com.example.inmobiliaria.models.Property;

public interface OnListPisosInteractionListener {

    public void onFavoritePisoClick(Property p);

    public void onCallPisoClick(Property p);

    public void onInfoPisoClick(Property p);

    public void onEditPisoClick(Property p);

    public void onAddPsioClick(Property p);

    public void onDeletePisoClick(Property p);

}
