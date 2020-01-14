package com.example.myapplication.adapterbind

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapterlist.BaseDataBindAdapter
import com.example.myapplication.model.DataPerson

@BindingAdapter("setListDataPerson","setAdapterBindDataPerson")
fun RecyclerView.setAdapterBindDataPerson(dataList: List<DataPerson>?, dataBindAdapter: BaseDataBindAdapter<DataPerson>?) {
    if(adapter == null){
        layoutManager = LinearLayoutManager(context)
        setHasFixedSize(true)
        adapter = dataBindAdapter
    }
    dataBindAdapter?.dataList = dataList!!
}