package com.example.myapplication11.Fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication11.AndroidViewModelTest;
import com.example.myapplication11.Database.WordViewModel;
import com.example.myapplication11.Entity.Word;
import com.example.myapplication11.MyAdapter.MyAdapter;
import com.example.myapplication11.R;
import com.example.myapplication11.databinding.FragmentListStudyAndDatabaseMigrationBinding;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListStudyAndDatabaseMigration#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListStudyAndDatabaseMigration extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    FragmentListStudyAndDatabaseMigrationBinding binding;
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    LiveData<List<Word>> listLiveData;
    WordViewModel wordViewModel;
    // TODO: Rename and change types of parameters
    public ListStudyAndDatabaseMigration() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListStudyAndDatabaseMigration.
     */
    // TODO: Rename and change types and number of parameters
    public static ListStudyAndDatabaseMigration newInstance(String param1, String param2) {
        ListStudyAndDatabaseMigration fragment = new ListStudyAndDatabaseMigration();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_list_study_and_database_migration,container,false);
        //new wordViewModel
        wordViewModel=new ViewModelProvider(this).get(WordViewModel.class);
        //get the live data
        listLiveData=wordViewModel.getAllwordsLive();
        //get recyclerView
        //new Adapter
        myAdapter=new MyAdapter();
        recyclerView=binding.recyclerView;
        //setWords
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        //binding adapter to recyclerView
        recyclerView.setAdapter(myAdapter);
        //set Observe
        wordViewModel.getAllwordsLive().observe(getActivity(), words -> {
            Toast.makeText(getContext(),"Data Changed~",Toast.LENGTH_SHORT).show();
            myAdapter.setWords(words);
            myAdapter.notifyDataSetChanged();
        });
        binding.button8.setOnClickListener(view -> {
            Word word=new Word("hello","你好");
            Word word1=new Word("world","世界");
            wordViewModel.InsertWords(word,word1);
        });
        binding.button9.setOnClickListener(view -> {
            wordViewModel.clearWords();
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

}