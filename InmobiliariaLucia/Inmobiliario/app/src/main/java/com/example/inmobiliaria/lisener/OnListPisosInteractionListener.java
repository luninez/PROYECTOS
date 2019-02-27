package com.example.inmobiliaria.lisener;

import com.example.inmobiliaria.models.Piso;

public interface OnListPisosInteractionListener {

    public void onFavoritePisoClick(Piso p);

    public void onCallPisoClick(Piso p);

    public void onInfoPisoClick(Piso p);

    public void onEditPisoClick(Piso p);

    public void onAddPsioClick(Piso p);

    public void onDeletePisoClick(Piso p);

}
