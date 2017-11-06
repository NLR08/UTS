package com.example.user.utskalkulatorgeometrinlr;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Spinner pilih;
    EditText text1,text2;
    TextView textLuas, textKeliling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1=(EditText)findViewById(R.id.txtBil1);
        text2=(EditText)findViewById(R.id.txtBil2);
        textLuas = (TextView)findViewById(R.id.txt_luas);
        textKeliling = (TextView)findViewById(R.id.txt_keliling);
        pilih = (Spinner) findViewById(R.id.spinPilihan);


        List<String> list = new ArrayList<String>();

        list.add("Persegi Panjang");

        list.add("Lingkaran");

        list.add("Segitiga Siku - Siku");

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        pilih.setAdapter(dataAdapter);

        Button btnHitung=(Button)findViewById(R.id.btnHitungBangun);

        btnHitung.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                String panjang =text1.getText().toString();

                String lebar =text2.getText().toString();

                double p = Double.parseDouble(panjang);
                double l = Double.parseDouble(lebar);
                double luas = 0;
                double keliling = 0;

                String pilihan=pilih.getSelectedItem().toString();

                if(pilihan.equalsIgnoreCase("Persegi Panjang")){

                    luas = p * l;
                    keliling = (2 * p) + (2 * l);

                }

                else if(pilihan.equalsIgnoreCase("Lingkaran")){

                    luas = Math.PI * (p * p);
                    keliling = Math.PI * (2 * p);

                }

                else if(pilihan.equalsIgnoreCase("Segitiga Siku - Siku")){

                    luas = (p * l) / 2;
                    keliling = (p + l + ( Math.sqrt((p * p) + (l * l))));

                }

                textLuas.setText("Luas dari bangun datar : " + luas);
                textKeliling.setText("Keliling dari bangun datar : " + keliling);

            }
        });
    }
}
