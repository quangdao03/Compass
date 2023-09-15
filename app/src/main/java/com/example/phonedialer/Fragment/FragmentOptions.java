package com.example.phonedialer.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonedialer.adapter.CompassAdapter;
import com.example.phonedialer.databinding.FragmentOptionsBinding;


public class FragmentOptions extends Fragment {
    FragmentOptionsBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentOptionsBinding.inflate(getLayoutInflater());
        CompassAdapter compassAdapter = new CompassAdapter(getContext());
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2, RecyclerView.VERTICAL, false);
        binding.rcyCompass.setLayoutManager(gridLayoutManager);
        binding.rcyCompass.setHasFixedSize(true);
        binding.rcyCompass.setAdapter(compassAdapter);
        return binding.getRoot();

    }
}
