package com.example.myapplication11.MyAdapter;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication11.Entity.Word;
import com.example.myapplication11.R;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<Word> words=new ArrayList<>();
    public  void setWords(List<Word> allwords){
        this.words = allwords != null ? allwords : new ArrayList<>();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //set inflate  binding fragment
        LayoutInflater layoutInflater=LayoutInflater.from(parent.getContext());
        View itemView=layoutInflater.inflate(R.layout.fragment_list_cell,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    //set each value to show and binding
        Word word=words.get(position);
        holder.number.setText(String.valueOf(word.getId()));
        holder.English.setText(word.getWord());
        holder.Chinese.setText(word.getChineseMeaning());
        //jump to the dictionary
        holder.itemView.setOnClickListener(view -> {
            Uri uri=Uri.parse("https://www.youdao.com/result?word="+word.getWord()+"&lang=en");
            Intent intent=new Intent(Intent.ACTION_VIEW);
            intent.setData(uri);
            holder.itemView.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return words.size();
    }

    class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView number,English,Chinese;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            number=itemView.findViewById(R.id.Textnumber);
            English=itemView.findViewById(R.id.textEnglish);
            Chinese=itemView.findViewById(R.id.textChinese);
        }
    }
}
