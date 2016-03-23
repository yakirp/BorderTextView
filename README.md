# BorderTextView
BorderTextView

Step 1. .
Add the JitPack repository to your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
```

Step 2. 
Add the dependency
```
dependencies {
	        compile 'com.github.yakirp:BorderTextView:0.0.5'
	}
```

Usage :
``` xml
    <com.yakirp.BorderTextView
        android:id="@+id/shareButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="share"
        android:textSize="7sp"
        android:textColor="@android:color/white"/>
```
