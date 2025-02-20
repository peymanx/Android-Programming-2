package com.jabarian.adabazi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.icu.text.CaseMap;
import android.net.Uri;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CategoryAdaptor.ItemClickListener {

    CategoryAdaptor categoryAdaptor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // data to populate the RecyclerView with
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1, "گروه علمی","سوالات حوزه علوم",0));
        categories.add(new Category(2, "گروه ادبیات","سوالات حوزه ادبیات فارسی",0));
        categories.add(new Category(3, "گروه فیلم و سریال","درباره فیلم و سریال و کارگردان ها",0));
        categories.add(new Category(4, "گروه عمومی","اطلاعات عمومی",0));
        categories.add(new Category(5, "پیشکسوتان و مشاهیر","همه چیز درباره اشخاص",0));
        categories.add(new Category(6, "حیوانات و اشیا","حیوانات و اشیا با صفت های خاص",0));
        categories.add(new Category(7, "ضرب المثل","شعر و مثل های معروف فارسی",0));
        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.rycCategory);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        categoryAdaptor = new CategoryAdaptor(this, categories);
        categoryAdaptor.setClickListener(this);
        recyclerView.setAdapter(categoryAdaptor);
    }
    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "شما " + categoryAdaptor.getItem(position) + " انتخاب کرده اید " , Toast.LENGTH_SHORT).show();
    }
}