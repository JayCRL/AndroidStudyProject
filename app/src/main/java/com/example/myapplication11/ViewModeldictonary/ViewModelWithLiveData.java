package com.example.myapplication11.ViewModeldictonary;
import static com.example.myapplication11.Fragment.LoginPage.numberName;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class ViewModelWithLiveData  extends ViewModel {
    private SavedStateHandle savedStateHandle;
    public ViewModelWithLiveData(SavedStateHandle handle){
        this.savedStateHandle=handle;
    }
    public  MutableLiveData<Integer> getNumber(){
        if(!savedStateHandle.contains("number")){
            savedStateHandle.set(numberName,0);
        }
        return  savedStateHandle.getLiveData(numberName);
    }
    public  boolean setNumber(Integer integer){
      savedStateHandle.set(numberName,integer);
      return true;
    }
    public void addNumber(){
        savedStateHandle.set(numberName,getNumber().getValue()+1);
    }
}
