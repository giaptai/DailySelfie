package com.example.todo;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    static List<ImgClass> bitmapList;
    ImgClass itemImg;
    static ImageAdapter arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lst_view);
        bitmapList = new ArrayList<>();
        arrayAdapter = new ImageAdapter(getApplicationContext(), bitmapList);// this, MainActivity.this
        listView.setAdapter(arrayAdapter);
    }
//ok anh yeu crush em T
    //xóa 1 item trong listView
//    public static void RemoveItemAt(int pos) {
//        bitmapList.remove(pos);
//        arrayAdapter.notifyDataSetChanged();
//    }
    public void CrushEmT(){
            System.out.println("ssss");
    }

    // ham goi icon camera de bat chuc nang camera
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.cameraIcon:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 100);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            Bitmap captureImg = (Bitmap) data.getExtras().get("data");
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"); // dinh dang ngay thang nam gio phut giay
            LocalDateTime now = LocalDateTime.now(); // lay ngay thang nam gio phut giay hien tai
            String generatedString = Integer.toString(bitmapList.size());
            itemImg=new ImgClass(captureImg, "anh"+generatedString, dtf.format(now));
            bitmapList.add(itemImg);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

}