package com.example.myapplication11.Fragment;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.example.myapplication11.R;
import com.example.myapplication11.AndroidViewModelTest;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Detail#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Detail extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    AndroidViewModelTest androidViewModelTest;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public Detail() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Detail.
     */
    // TODO: Rename and change types and number of parameters
    public static Detail newInstance(String param1, String param2) {
        Detail fragment = new Detail();
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

        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        androidViewModelTest = new ViewModelProvider(
                requireActivity(),
                new SavedStateViewModelFactory(requireActivity().getApplication(), requireActivity())
        ).get(AndroidViewModelTest.class);
        String name= getArguments().getString("btname");
        Button button=getView().findViewById(R.id.button3);
        button.setText(name);
        TextView textView=getView().findViewById(R.id.textView2);
        textView.setText(getResources().getString(R.string.welcome)+" "+getArguments().getString("name"));
        textView=getView().findViewById(R.id.textView3);
        textView.setText(getResources().getString(R.string.youchoose)+androidViewModelTest.getNameVal().getValue());
        getView().findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController= Navigation.findNavController(view);
                navController.navigate(R.id.action_detail_to_loginPage2);
            }
        });
        Animation scaleRotateAnim = AnimationUtils.loadAnimation(requireContext(), R.anim.scaletest);
        getView().findViewById(R.id.imageView2).startAnimation(scaleRotateAnim);
        super.onViewCreated(view, savedInstanceState);
    }
}