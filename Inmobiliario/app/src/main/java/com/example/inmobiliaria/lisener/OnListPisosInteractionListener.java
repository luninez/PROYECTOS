package com.example.inmobiliaria.lisener;

import com.example.inmobiliaria.models.Piso;

public interface OnListPisosInteractionListener {

    public void onFavoritePisoClick(Piso p);

    public void onCallPisoClick(Piso p);

    public void onEmailPisoClick(Piso p);

    public void onInfoPisoClick(Piso p);

}
