package com.example.justdoitandroid.ui.screens.home

import android.util.Log
import com.example.justdoitandroid.base.BaseViewModel

class HomeViewModel : BaseViewModel() {

    override fun onPageEnter() {
        super.onPageEnter()
        Log.d("HomeViewModel", "========== 进入首页 ==========")
    }

    override fun onPageLeave() {
        super.onPageLeave()
        Log.d("HomeViewModel", "========== 离开首页 ==========")
    }
}
