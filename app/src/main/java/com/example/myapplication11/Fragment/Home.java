package com.example.myapplication11.Fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication11.Dao.WordDao;
import com.example.myapplication11.Database.WordDatabase;
import com.example.myapplication11.Entity.Word;
import com.example.myapplication11.R;
import com.example.myapplication11.Database.WordViewModel;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    WordDao wordDao;
    WordDatabase wordDatabase;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    LiveData<List<Word>> listLiveData;
    WordViewModel wordViewModel;
    public Home() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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
        //新写法
       wordViewModel = new ViewModelProvider(this).get(WordViewModel.class);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getLifecycle().addObserver(getView().findViewById(R.id.button2));
        //获取列表
        listLiveData = wordViewModel.getAllwordsLive();
        listLiveData.observe(getActivity(), new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                StringBuilder text = new StringBuilder();
                for (int i = 0; i < words.size(); i++) {
                    Word word = words.get(i);
                    text.append(word.getId()).append(":").append(word.getWord()).append("=").append(word.getChineseMeaning()).append("\n");
                }
                TextView textView = getView().findViewById(R.id.textView4);
                textView.setText(text.toString());
            }
        });
        getView().findViewById(R.id.button2).setOnClickListener(view1 -> {
            Bundle bundle = new Bundle();
            bundle.putString("btname", "返回");
            // 第三步：用「Home 到 Detail 的 Action ID」跳转（关键！）
            NavController controller = Navigation.findNavController(view1);
            controller.navigate(R.id.action_home2_to_loginPage);
        });
        Button buttonInsert, buttonDelete, buttonClear, buttonUpdate;

        buttonInsert = getView().findViewById(R.id.InsertButton);
        buttonInsert.setOnClickListener(view12 -> {
            Word word = new Word("Hello", "你好");
            Word word2 = new Word("World", "世界");
            wordViewModel.InsertWords(word,word2);
        });

        buttonClear = getView().findViewById(R.id.ClearButton);
        buttonClear.setOnClickListener(view13 -> wordViewModel.clearWords());

        buttonDelete = getView().findViewById(R.id.DeleteButton);
        buttonDelete.setOnClickListener(view14 -> {
            Word word=new Word("hello","新数据");
            word.setId(118);
            wordViewModel.deleteWords(word);
        });

        buttonUpdate = getView().findViewById(R.id.UpdateButton);
        buttonUpdate.setOnClickListener(view15 -> {
            Word word=new Word("hello","新数据");
            word.setId(118);
            wordViewModel.upDateWords(word);
        });
    }
}