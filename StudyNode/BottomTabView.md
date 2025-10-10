# BottomTabView

## 1.add the component in the Activity

![](..\preView\BottomTabView1.png)

## 2.Configure in  Activity

![](..\preView\Bnav2.png)

## 3.Create the menu

​	xml: like this Please choose the type:Menu in the As when you create it.

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/firstFragment2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:icon="@android:drawable/ic_menu_edit"
        android:title="旋转" />
    <item
        android:id="@+id/secondFragment2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:icon="@android:drawable/ic_dialog_email"
        android:title="缩放" />
    <item
        android:id="@+id/thirdFragment2"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:icon="@android:drawable/btn_star_big_on"
        android:title="移动" />
</menu>
```

## 4.Binding it in the Activity xml

​	![](..\preView\menu.png)

# Debug

### 	1.The fragment id you set in the menu xml is must be equals to the id in  nav_graph.xml

### 	2.You must use the theme which has the Action Bar

### 		configure it in  the thems.xml	