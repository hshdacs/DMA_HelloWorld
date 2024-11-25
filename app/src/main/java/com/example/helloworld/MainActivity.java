package com.example.helloworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText editURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        Button btnWebSide = findViewById(R.id.btnWebSite);
        editURL = findViewById(R.id.editURL);
        btnWebSide.setOnClickListener(this::btnWebSideClick);
    }

    public void btnWebSideClick(View view) {
        String url = editURL.getText().toString();
        if (url.isBlank()) {
            Toast.makeText(this, "No URL defined", Toast.LENGTH_LONG).show();
            return;
        }
        Intent iWebView = new Intent( Intent.ACTION_VIEW );
        iWebView.setData( Uri.parse(url) );
        startActivity(iWebView);
    }

    public void showToastMessage(View view) {
        Toast.makeText(this, "Toast is really ready", Toast.LENGTH_LONG).show();
    }
}