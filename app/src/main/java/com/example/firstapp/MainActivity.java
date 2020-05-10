package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Spinner spinnerColors;
    TextView textViewDescription;
    FrameLayout colouredZone;
    int position = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinnerColors = findViewById(R.id.chooseColor);
        textViewDescription = findViewById(R.id.showDescription);
        colouredZone = findViewById(R.id.colouredZone);
    }

    public void showDescription(View view) {
        int newPosition = spinnerColors.getSelectedItemPosition();
        String description = getDescriptionBySpinner(newPosition);
        if (newPosition != position) {
            textViewDescription.setText(description);
        } else textViewDescription.setText("уже выбран данный цвет");
        setColouredZone(newPosition);
        position = newPosition;
    }

    public void setColouredZone(int position) {
        String[] colors = getResources().getStringArray(R.array.colors);
        switch (colors[position]) {
            case "Красный":
                colouredZone.setBackgroundResource(R.color.colorRed);
                break;
            case "Жёлтый":
                colouredZone.setBackgroundResource(R.color.colorYellow);
                break;
            case "Зелёный":
                colouredZone.setBackgroundResource(R.color.colorGreen);
                break;
            case "Голубой":
                colouredZone.setBackgroundResource(R.color.colorBlue);
                break;
        }
    }

    public String getDescriptionBySpinner(int position) {
        String[] descriptions = getResources().getStringArray(R.array.description_of_temp);
        return descriptions[position];
    }
}
