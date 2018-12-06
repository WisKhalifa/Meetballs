package com.example.wis.meetballs;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;


public class SettingsFragment extends Fragment {

    int blueColor = 2131230878;
    int bigSize = 2131230876;
    int redColor = 2131230882;
    int greenColor = 2131230880;
    int mediumSize = 2131230881;
    int blackColor = 2131230877;
    int smallSize = 2131230884;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_settings, container, false);


        final RadioGroup radioColorGroup = view.findViewById(R.id.radioColor);
        final RadioGroup radioSizeGroup = view.findViewById(R.id.radioSize);

        Button mSetButton = view.findViewById(R.id.setButton);
        mSetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedColor = radioColorGroup.getCheckedRadioButtonId();
                int selectedSize = radioSizeGroup.getCheckedRadioButtonId();


                if (selectedColor == blueColor) {
                    setTextColorBlue();
                    CreateFragment.colorText = Color.BLUE;
                    RecyclerAdapter.colorText = Color.BLUE;
                }
                if (selectedColor == redColor) {
                    setTextColorRed();
                    CreateFragment.colorText = Color.RED;
                    RecyclerAdapter.colorText = Color.RED;
                }
                if (selectedColor == greenColor) {
                    setTextColorGreen();
                    CreateFragment.colorText = Color.GREEN;
                    RecyclerAdapter.colorText = Color.GREEN;
                }
                if (selectedColor == blackColor) {
                    setTextColorBlack();
                    CreateFragment.colorText = Color.BLACK;
                    RecyclerAdapter.colorText = Color.BLACK;
                }
                if (selectedSize == smallSize) {
                    setTextSizeSmall();
                    CreateFragment.sizeText = 12;
                    RecyclerAdapter.sizeText = 12;

                }
                if (selectedSize == mediumSize) {
                    setTextSizeMedium();
                    CreateFragment.sizeText = 26;
                    RecyclerAdapter.sizeText = 26;
                }
                if (selectedSize == bigSize) {
                    setTextSizeBig();
                    CreateFragment.sizeText = 35;
                    RecyclerAdapter.sizeText = 35;
                }


            }
        });


        return view;
    }

    public void setTextColorBlue() {
        TextView t1 = getActivity().findViewById(R.id.setColor);
        TextView t2 = getActivity().findViewById(R.id.setSize);
        t1.setTextColor(Color.BLUE);
        t2.setTextColor(Color.BLUE);
    }

    public void setTextColorRed() {
        TextView t1 = getActivity().findViewById(R.id.setColor);
        TextView t2 = getActivity().findViewById(R.id.setSize);
        t1.setTextColor(Color.RED);
        t2.setTextColor(Color.RED);
    }

    public void setTextColorGreen() {
        TextView t1 = getActivity().findViewById(R.id.setColor);
        TextView t2 = getActivity().findViewById(R.id.setSize);
        t1.setTextColor(Color.GREEN);
        t2.setTextColor(Color.GREEN);
    }

    public void setTextColorBlack() {
        TextView t1 = getActivity().findViewById(R.id.setColor);
        TextView t2 = getActivity().findViewById(R.id.setSize);
        t1.setTextColor(Color.BLACK);
        t2.setTextColor(Color.BLACK);
    }

    public void setTextSizeSmall() {
        TextView t1 = getActivity().findViewById(R.id.setColor);
        TextView t2 = getActivity().findViewById(R.id.setSize);
        t1.setTextSize(12);
        t2.setTextSize(12);
    }

    public void setTextSizeMedium() {
        TextView t1 = getActivity().findViewById(R.id.setColor);
        TextView t2 = getActivity().findViewById(R.id.setSize);
        t1.setTextSize(26);
        t2.setTextSize(26);
    }

    public void setTextSizeBig() {
        TextView t1 = getActivity().findViewById(R.id.setColor);
        TextView t2 = getActivity().findViewById(R.id.setSize);
        t1.setTextSize(35);
        t2.setTextSize(35);
    }


}
