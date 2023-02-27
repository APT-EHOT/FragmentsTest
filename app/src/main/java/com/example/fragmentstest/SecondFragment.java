package com.example.fragmentstest;

import static com.example.fragmentstest.FragmentColors.BLUE;
import static com.example.fragmentstest.FragmentColors.GREEN;
import static com.example.fragmentstest.FragmentColors.RED;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentstest.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);

        // Берем значение цвета из бандла в аргументах, переданных с первого фрагмента
        FragmentColors colorEnum = (FragmentColors) getArguments().getSerializable("color");
        String colorCode = "";

        switch (colorEnum) {
            case RED:
                colorCode = "#FF0000"; // HEX-код нужного нам цвета (здесь это красный)
                break;
            case BLUE:
                colorCode = "#00FF00";
                break;
            case GREEN:
                colorCode = "#0000FF";
                break;
        }
        binding.secondFragmentContainer.setBackgroundColor(Color.parseColor(colorCode));

        return binding.getRoot();
    }
}
