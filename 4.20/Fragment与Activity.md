Fragment                                      

1. 界面打开                 
    onCreate() 方法执行！                
    onCreateView() 方法执行！             
    onActivityCreated() 方法执行！   
    onStart() 方法执行！
    onResume() 方法执行！

2. 按下主屏幕键/锁屏        
    onPause() 方法执行！
    onStop() 方法执行！

3. 重新打开
    onStart() 方法执行！
    onResume() 方法执行！

4. 按下后退键
    onPause() 方法执行！
    onStop() 方法执行！
    onDestroyView() 方法执行！
    onDestroy() 方法执行！
    onDetach() 方法执行！

Activity
    1. 打开应用
    onCreate() 方法执行！
    onStart() 方法执行！
    onResume() 方法执行！

    2. 按下主屏幕键/锁屏
    onPause() 方法执行！
    onStop() 方法执行！

    3. 重新打开应用
    onRestart() 方法执行！
    onStart() 方法执行！
    onResume() 方法执行！

    4. 按下后退键
    onPause() 方法执行！ 
    onStop() 方法执行！  
    onDestroy() 方法执行！

在Activity中加入Fragment,对应的生命周期
1. 打开
Fragment onCreate() 方法执行！
Fragment onCreateView() 方法执行！
Activity onCreate() 方法执行！
Fragment onActivityCreated() 方法执行！
Activity onStart() 方法执行！
Fragment onStart() 方法执行！
Activity onResume() 方法执行！
Fragment onResume() 方法执行！

2. 按下主屏幕键/锁屏
Fragment onPause() 方法执行！
Activity onPause() 方法执行！
Fragment onStop() 方法执行！
Activity onStop() 方法执行！

3. 再次打开
Activity onRestart() 方法执行！
Activity onStart() 方法执行！
Fragment onStart() 方法执行！
Activity onResume() 方法执行！
Fragment onResume() 方法执行！

4. 按下后退键
Fragment onPause() 方法执行！
Activity onPause() 方法执行！
Fragment onStop() 方法执行！
Activity onStop() 方法执行！
Fragment onDestroyView() 方法执行！
Fragment onDestroy() 方法执行！
Fragment onDetach() 方法执行！
Activity onDestroy() 方法执行！

https://blog.csdn.net/ash_zheng/article/details/51405354
