package com.example.myapplication11.Fragment;

import android.animation.ObjectAnimator;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication11.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link firstFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class firstFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public firstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment firstFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static firstFragment newInstance(String param1, String param2) {
        firstFragment fragment = new firstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView imageView=requireView().findViewById(R.id.imageView4);
        Button button=requireView().findViewById(R.id.actionBtn1);
        final ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(imageView,"x",0,0);
        final ObjectAnimator objectAnimatorY=ObjectAnimator.ofFloat(imageView,"y",0,0);
        objectAnimator.setObjectValues(500);
        //rotate
        //        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(imageView,"rotation",0,0);
        //scale
//        ObjectAnimator objectAnimatorX=ObjectAnimator.ofFloat(imageView,"scaleX",0,0);
//        ObjectAnimator objectAnimatorY=ObjectAnimator.ofFloat(imageView,"scaleY",0,0);
//        objectAnimatorX.setDuration(500);
//        objectAnimatorY.setDuration(500);
        //Translation
        button.setOnClickListener(view1 -> {
            //rotate
//            objectAnimator.setFloatValues(imageView.getRotation(),imageView.getRotation()+100);
//            objectAnimator.start();
            //scale
//            if(!objectAnimatorX.isRunning()){
//                objectAnimatorX.setFloatValues(imageView.getScaleX()+0.1f);
//                objectAnimatorY.setFloatValues(imageView.getScaleY()+0.1f);
//                objectAnimatorX.start();
//                objectAnimatorY.start();
//            }
            if(!objectAnimator.isRunning()){
                objectAnimator.setFloatValues(imageView.getX()+10,imageView.getY());
                objectAnimatorY.setFloatValues(imageView.getX(),imageView.getY()+10);
                objectAnimator.start();
                objectAnimatorY.start();
            }
        });
    }

}