package com.hanprojects.testswipe;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by humayun on 2/12/2017.
 */

public class Fragment1 extends Fragment {

    ArrayAdapter<String> millItems;
    public Fragment1(){
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String[] data = {
                "Item 1",
                "Item 2",
                "Item 3"
        };

        List<String> testlist = new ArrayList<String>(Arrays.asList(data));

        millItems = new ArrayAdapter<String>(getActivity(), R.layout.list_item_mill,R.id.list_view_mill,testlist);

        View rootview = inflater.inflate(R.layout.fragment1,container, false);

        ListView listView = (ListView) rootview.findViewById(R.id.listview_mill);
        listView.setAdapter(millItems);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String product = millItems.getItem(position);
                Intent intent = new Intent(getActivity(),DetailActivity.class).putExtra(Intent.EXTRA_TEXT,product);
                startActivity(intent);
            }
        });
        return rootview;

//        return inflater.inflate(R.layout.fragment1, container, false);
    }
}
