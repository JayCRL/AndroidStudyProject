package com.example.myapplication11.Fragment;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import com.example.myapplication11.AndroidViewModelTest;
import com.example.myapplication11.R;
import com.example.myapplication11.databinding.FragmentLoginPageBinding;
public class LoginPage extends Fragment {
    public static final String numberName = "number";
    FragmentLoginPageBinding binding;
    String Tag = "MyTag";
    AndroidViewModelTest androidViewModelTest;
    //依附上Activity
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
    //初始化
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login_page, container, false);
        return binding.getRoot();
    }
    @SuppressLint("NewApi")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(Tag, "onViewCreated");
        androidViewModelTest= new ViewModelProvider(this).get(AndroidViewModelTest.class);
        //must setData after view create finished
        binding.setData(androidViewModelTest);
        binding.setLifecycleOwner(this);
        binding.ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) -> {
            Toast.makeText(requireContext(), "评分成功：" + rating, Toast.LENGTH_SHORT).show();
        });
        //lambda: more clear way
        binding.button.setOnClickListener(view1->{
                NavController navController= Navigation.findNavController(view);
                if(!binding.editTextText2.getText().toString().isEmpty()) {
                    if (androidViewModelTest.getNameVal().getValue().equals("cat")) {
                        navController.navigate(R.id.action_loginPage_to_home2);
                    } else if (androidViewModelTest.getNameVal().getValue().equals("android")) {
                        Bundle bundle=new Bundle();
                        bundle.putString("myid","jspv");
                        bundle.putString("name",binding.editTextText2.getText().toString());
                        navController.navigate(R.id.action_loginPage_to_detail, bundle);
                    } else {
                        Toast.makeText(requireContext(), "选择错误！！！只有cat和android", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(requireContext(), "记得输入姓名呀", Toast.LENGTH_SHORT).show();
                }
            }
        );
    }
    @SuppressLint({"SetTextI18n", "ResourceAsColor"})
    @Override
    public void onStart() {
        super.onStart();
        androidViewModelTest.load();
        // 6. 设置默认值
        binding.editTextText.setText("2025106");
        binding.editTextTextPassword.setText("12345678");
        binding.button.setText("登录");
        binding.switch1.setChecked(androidViewModelTest.getNameVal().getValue().equals("cat"));
        binding.imageView.setImageResource(androidViewModelTest.getNameVal().getValue().equals("cat")?R.drawable.cat:R.drawable.android);
        binding.switch1.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked) {
                binding.imageView.setImageResource(R.drawable.cat);
                binding.button.setBackgroundColor(Color.CYAN);
                androidViewModelTest.setNumVal("cat");
            } else {
                binding.imageView.setImageResource(R.drawable.android);
                binding.button.setBackgroundColor(R.color.Orange);
                androidViewModelTest.setNumVal("android");
            }
        });
        binding.button.setBackgroundColor(androidViewModelTest.getNameVal().getValue().equals("apple")?Color.BLACK:R.color.Orange);
        Log.d(Tag, "onStart");
    }
    @Override
    public void onStop() {
        super.onStop();
        androidViewModelTest.save();
        Log.d(Tag, "onStop");
    }

}