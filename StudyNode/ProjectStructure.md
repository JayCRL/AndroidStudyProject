# All in all

This project is aimed at record my android studying progress 

Not only watch the videos: 

[youtube.com/watch?v=6pJqYvge8TY&list=PLPh5-KovAYtFyX5elSTT9wEMt0HxMhR7L](https://www.youtube.com/watch?v=6pJqYvge8TY&list=PLPh5-KovAYtFyX5elSTT9wEMt0HxMhR7L) 

but also add my own question and the knowlege I learned through AI.

also I try to reteach them. So you can also regard this project as a note or study project .

I will also try to use the english as my working language and try to practice it.So welcome to let me know there is any mistakes.

At the same time,I will not use AI to code straightly and try to find out almost every line of my code.

Welcome to follow me to study~

Welcome the author to contact me.Your courses is so good!!!

# Pre Introduction

The Android Project runs depend on the JVM.So It's easier to study Android if you are familer with the Java and it's suitable for people who have the Spring backEnd basics.

## If you are orignaly from backEnd:

As for the database.Android use SqLite.It's make multifing database more easy.It use Dao,Database,Entity three component structure.As for the Dao structure,You will write SQL strightly,it's more easier than using Mybatis-plus 

## If you are orignaly from IOS SwiftUI

Because of I only know the most of the swiftUI. So I can only figure out the differences between Android and SwiftUI.More diffrences were welcome you to add~

##### The whole feeling

IOS is just like the complete machine,You should strictly follow what he want you to do.More automation while less freedom.

##### Security and freedom

At the same time,It's error checking is more strict than Android.Like guard and ! As for android it's easier to throw NullPointException then the app will quit quickly.So you should check your programe more strictly.

##### MVVM 

the mvvm is a designed modle.The view will flash automaticly when finding the data changed.

In android, you should built this stucture by hand, in IOS,SwiftUI.You just need to declare the data kind and the system will action it automaticuly.

## The difficult point to study: 

#### diffucult process to init:

Because it is running above the Android system.So we should coperate with the system and will init so many kinds of object.And you should init through the factory and so many exists method.

Don't be worry, you just need to first write it once ,and know the whole process then everytime when you forget it, You can find what you have wrote quickly and review it. Then you will be more and more familer with it.

Also of primary note is that you should write your own project, I recommaned that you just regard videos as a dictionary to find and check.It will may diffcult to create and just use what you have just learned.So if you are still difficlut to do it. Watch the videos again and again , any questions you can ask AI to answer. I also think it's a better way to use ai to answer the question while let it to code. It's dangerous, and it also not good for you to make a progress."Don't hand in the code skills and depend on Ai so much".

You should be more profession than Ai, only the you can find the job.

# Content

## The whole project struct

#### **mainifests** 

*just like the application.properties:*

​		***define*** 

​		the name of app and the main entrance of the app.

​		the logo of app 

​		also of the activity logo and whether show in the desktop

####  Res

​	*the resourse and value using in use app, manage all of them in one place*

​	support the dark and light mode.

​	support the multify language you just need to add the target language version and the system will use it automatically.

​	If you want to use them just use 

```java
String defaultName = getApplication().getResources().getString(R.string.nameval);
```

   notice: R.string.nameval is just can help us get the id of the resourses if we want to use it we need to add the *getApplication().getResources.getString.*

​	getApplication means get the  object of the app itself . Others is easy to understand. Is a key-value function to get the value.

#### Java

​	*The orignal code.*

###### 	Activity

###### 	Fagment: 

###### 				 layout object container

###### 	Component:

###### 				 component desined by yourself

###### 	ViewModel: 

###### 				the object to manage the multify data

###### 	Entity: 

###### 				just like the entity in spring. a line of data was packaged into a object

###### 	Dao:

###### 				 the object to multify the database;You can write SQL here

######     Database: 

###### 				the object of the database

###### 	shp:

###### 			    sharedPreferences: local data store object and fuction

##### Clarify activity and fagment

###### Activity:

​				A indepent screen model

​				load xml through  setContentView ()

​				manage Activity through Stack

###### 		     LifeCycle:

​				onCreate()   		*init data* 

​				onStart(); 			 *vitualble but can't act with user*

​				onResume();		*can act*

​				onPause(); 		   *been covered*

​				onStop(); 			 *completely can't been seen*

​				onDestory();        *app stop running*

​				onRestart(); onResume();			*change through other app and activity;*

###### Fragment

1. onAttach :	be connected with the activity

2. onCreateView :	ing

3. onViewCreated: have done

4. onDestroyView（）

5. onDetach（）

   ​		Activity start first and destory last

   ​		Activity oncreate->Start()->resume()

​												Fagment->attach()->createview->viewcreated

​																												ActivityCreated

​																																	->start->resume

```plaintext
Activity: onCreate() → setContentView()
  ↓
NavHostFragment: anaylyze nav_graph，create start Fragment
  ↓
Fragment: onAttach() → onCreate() → onCreateView() → onViewCreated() 
  ↓
Activity: onCreate() finished
  ↓
Activity: onStart() → stair up all of the Fragment to into onStart()
  ↓
Activity: onResume() → stair up all of the  Fragment's onResume()
```

## ViewModel

​		a model that can automatically refresh the view

​		just like this

```java
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
```

You can use it in your code

like this use in fagment

```java
MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
binding.setData(MyViewModel);
binding.setLifecycleOwner(this);
```

then when the data change the view will refresh



