package com.example.bubblesort

import android.widget.ProgressBar

fun bubbleSort(list: ArrayList<Int>, bar: ProgressBar) : ArrayList<Int> {
    var swap = true

    while(swap){
        swap = false
        for(i in 0 until list.size-1) {
            bar.progress += list.size/bar.max
            if(list[i] > list[i+1]) {
                val temp = list[i]
                list[i] = list[i+1]
                list[i + 1] = temp
                swap = true
            }
        }
    }
    return list
}
