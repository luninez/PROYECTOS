package com.example.inmobiliaria.dialog;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.inmobiliaria.R;
import com.example.inmobiliaria.viewModel.DeleteImgPisoViewModel;

public class DeleteImgPiso extends Fragment {

    private DeleteImgPisoViewModel mViewModel;

    public static DeleteImgPiso newInstance() {
        return new DeleteImgPiso();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.delete_img_piso_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DeleteImgPisoViewModel.class);
        // TODO: Use the ViewModel
    }

}
