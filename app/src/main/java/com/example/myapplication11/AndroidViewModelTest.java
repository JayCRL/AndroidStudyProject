package com.example.myapplication11;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.SavedStateHandle;
public class AndroidViewModelTest  extends AndroidViewModel {
    //这个是动态代理的的句柄
    private final SavedStateHandle savedStateHandle;
    String key;
    String namekey;
    String shp;
    //本地资源交互的对象 文件名
    SharedPreferences sharedPreferences;
    public LiveData<Integer> getNumber(){
        if(!savedStateHandle.contains(key)){
            savedStateHandle.set(key, R.string.mykeyDefaultValue);
        }
        return  savedStateHandle.getLiveData(key);
    }
    public void setNumVal(String val){
            savedStateHandle.set(namekey,val);
    }
    //返回界面缓存
    public LiveData<String> getNameVal() {
        if (!savedStateHandle.contains(namekey)) {
            String defaultName = getApplication().getResources().getString(R.string.nameval);
            savedStateHandle.set(namekey, defaultName);
        }
        return savedStateHandle.getLiveData(namekey);
    }
    public void add(){
        savedStateHandle.set(key,getNumber().getValue()+1);
    }
    public void load() {
        int defaultNum = getApplication().getResources().getInteger(R.integer.mykeyDefaultValue);
        savedStateHandle.set(key, sharedPreferences.getInt(key, defaultNum));
        String defaultName = getApplication().getResources().getString(R.string.nameval);
        savedStateHandle.set(namekey, sharedPreferences.getString(namekey, defaultName));
    }
    public void save(){
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putInt(key,getNumber().getValue());
        editor.putString(namekey,getNameVal().getValue());
        editor.apply();
    }
    public AndroidViewModelTest(@NonNull Application application,SavedStateHandle savedStateHandle) {
        super(application);
        key= getApplication().getResources().getString(R.string.mykey);
        shp=getApplication().getResources().getString(R.string.name);
        namekey="nameval";
        this.savedStateHandle=savedStateHandle;
        //拿到与本地资源交互的对象
        sharedPreferences=getApplication().getSharedPreferences(shp, Context.MODE_PRIVATE);
    }
}
