package com.example.todo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class ImageAdapter extends BaseAdapter {
    Context context;
    int layoutt;
    List<ImgClass> photoImg;

    public ImageAdapter(Context context, List<ImgClass> photoImg) {
        this.context = context;
        this.photoImg = photoImg;
    }
    // trả về số dòng để hiển thị listview, return về list.size() để nó luôn trả về số lượng item của List<ImgClass> photoImg
    @Override
    public int getCount() {
        return photoImg.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        convertView = layoutInflater.inflate(R.layout.layout_list_img, parent, false);

        //tìm ImgaeView, TextView theo id
        ImageView imageView = convertView.findViewById(R.id.img_view);
        TextView txtview=(TextView) convertView.findViewById(R.id.text);
        TextView txtview2=(TextView) convertView.findViewById(R.id.text2);
        //tìm ImgaeView, TextView theo id

        ImgClass imgclassItem= photoImg.get(position); // lấy vị trí của item trong mảng List<ImgClass> photoImg;
        Bitmap captureImg = (Bitmap) imgclassItem.getImageItem(); // lấy giá trị ảnh từ class ImgClass.java chuyển sang dữ liệu Bitmap
        imageView.setImageBitmap(captureImg); // hiện ảnh ra ImageView
        txtview.setText(imgclassItem.getName());    // lấy tên ảnh từ class ImgClass.java, gán vô txtview
        txtview2.setText(imgclassItem.getBytee());

        //tạo button xóa 1 item trong ListView
        Button btn=convertView.findViewById(R.id.dele); //tìm button xóa

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"Xóa thành công",Toast.LENGTH_SHORT).show();// hiện thông báo ssssssss
                //MainActivity.RemoveItemAt(position);// xóa tại vị trí position
                MainActivity.bitmapList.remove(position);
                MainActivity.arrayAdapter.notifyDataSetChanged();
            }
        });

        return convertView;
    }
}
