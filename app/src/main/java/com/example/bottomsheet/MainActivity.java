package com.example.bottomsheet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcView;
    private ItemAdapter itemAdapter;
    private TextView textClick;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textClick = (TextView) findViewById(R.id.textClick);
        textClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateBottomSheet();
            }
        });
    }

    private void onCreateBottomSheet() {
        BottomSheetDialog bottomSheetDialog =
                new BottomSheetDialog(MainActivity.this);
///view o day
       View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.bottom_sheet, null);
        //set adapter trong day luon
        rcView =  view.findViewById(R.id.rcView);
        //các thành phần giao diện của file bottom_sheet.xml muốn tham chiếu vào phải có view.findViewYid
        itemAdapter = new ItemAdapter(getAllItems(),MainActivity.this);
        rcView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rcView.setAdapter(itemAdapter);
        bottomSheetDialog.setContentView(view);
        bottomSheetDialog.show();

    }

    private List<Item> getAllItems() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(1,"item1"));
        list.add(new Item(2,"it3em12"));
        list.add(new Item(2,"1"));
        list.add(new Item(3,"ite33m1"));
        list.add(new Item(31,"it2em13"));
        list.add(new Item(121,"item41"));
        list.add(new Item(23,"item1"));
        list.add(new Item(123,"i4tem41"));
        list.add(new Item(133,"item1"));
        list.add(new Item(123,"item441"));
        list.add(new Item(143,"ite41"));
        return list;
    }

}