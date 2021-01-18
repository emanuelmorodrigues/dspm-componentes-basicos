package br.ufc.quixada.atividade_1_varios_componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void retornar(View view){
        Intent retornar = new Intent(this, MainActivity.class);
        startActivity(retornar);
    }
}