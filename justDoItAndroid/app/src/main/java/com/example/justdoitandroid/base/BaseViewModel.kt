package com.example.justdoitandroid.base

import android.util.Log
import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

    /** 进入页面时调用（进入组合树） */
    open fun onPageEnter() {
        //打印进入页面
        Log.d("BaseViewModel", "进入页面")
    }

    /** 离开页面时调用（离开组合树） */
    open fun onPageLeave() {
        Log.d("BaseViewModel", "离开页面")
    }
}
