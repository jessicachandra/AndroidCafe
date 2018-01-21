package com.example.jessicachandra.androidcafe;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentList extends Fragment {

    @Nullable
    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        Log.v("aldo","1");
    View view = inflater.inflate(R.layout.activity_fragment_list,null);

        Log.v("aldo","2");
    setupRecyclerView(view);

        Log.v("aldo","3");
    return view;
}

    private void setupRecyclerView(View view){

        Log.v("aldo","4");
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);


        Log.v("aldo","8");
        RecyclerAdapter adapter = new RecyclerAdapter(getActivity(),
                MenuData.getListMenu());

        Log.v("aldo","5");
        recyclerView.setAdapter(adapter);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());

        Log.v("aldo","6");
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
    }
}
