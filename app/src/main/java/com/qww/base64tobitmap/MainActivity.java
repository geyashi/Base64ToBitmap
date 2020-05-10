package com.qww.base64tobitmap;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.content.res.Resources;
import android.database.DatabaseUtils;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.qww.base64tobitmap.databinding.ActivityMainBinding;

import java.io.ByteArrayOutputStream;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    String content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    /**
     * Base64字符串转Bitmap
     * @param view
     */
    public void click1(View view) {
        Bitmap bitmap = Base64Util.Base64ToBitMap(content);
        binding.img.setImageBitmap(bitmap);
    }

    /**
     * Bitmap转Base64字符串
     * @param view
     */
    public void click2(View view) {
        Resources resources = this.getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(resources, R.mipmap.head);
        content = Base64Util.Bitmap2StrByBase64(bitmap);
        binding.tvString.setText(content);
    }
}

