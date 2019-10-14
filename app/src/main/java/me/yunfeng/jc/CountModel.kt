package me.yunfeng.jc

import androidx.compose.Model

@Model
class CountModel {
    var cnt: Int = 0;
    fun add() {
        cnt++;
    }
}