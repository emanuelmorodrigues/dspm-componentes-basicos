package br.ufc.quixada.atividade_1_varios_componentes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private ToggleButton toggleBtn1, toggleBtn2;
    private Button displayBtn;

    private Spinner spnr;
    private String[] drpdwn = {"C", "Javascript", "Rust", "Elixir", "PHP", "GO"};

    private Button showPopup;

    private TextView longPress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Toggle Buttons
        addListenerOnButton();

        // Autocomplete
        String[] str = {"Abajur", "Bolo de Chocolate", "Casa de Praia", "Data Science",
                        "Escola de Líderes"};

        AutoCompleteTextView t1 = (AutoCompleteTextView) findViewById(R.id.autoComplete);
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this,
                        android.R.layout.simple_dropdown_item_1line, str);

        t1.setThreshold(1);
        t1.setAdapter(adp);

        // Dropdown Menu
        spnr = (Spinner) findViewById(R.id.spinnerDropDown);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                        this, android.R.layout.simple_spinner_item, drpdwn);

        spnr.setAdapter(adapter);
        spnr.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        Toast.makeText(getApplicationContext(), "Voce selecionou " + drpdwn[+position], Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                }
        );

        // Dropdown/Popup Menu
        showPopup = (Button) findViewById(R.id.showPopup);
        showPopup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Criando instancia do PopupMenu
                PopupMenu popup = new PopupMenu(getApplicationContext(), showPopup);
                // Inflando o Popup usando arquivo xml
                popup.getMenuInflater()
                        .inflate(R.menu.popup_menu, popup.getMenu());

                // Registrando popup com OnMenuItemCLickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getApplicationContext(), "Você clicou "+ item.getTitle(), Toast.LENGTH_SHORT).show();
                        return true;
                    }
                });
                popup.show();
            }
        }); // fim do setOnclickListener

        // Long Press
        longPress = (TextView) findViewById(R.id.longPress);
        longPress.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), "Você pressionou por muito tempo!", 2000).show();
                return true;
            }
        });
        longPress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Não foi longo o suficiente!", 1000).show();
            }
        });

    }

    // Toggle Buttons
    public void addListenerOnButton(){
        toggleBtn1 = (ToggleButton) findViewById(R.id.toggleButton1);
        toggleBtn2 = (ToggleButton) findViewById(R.id.toggleButton2);
        displayBtn = (Button) findViewById(R.id.btnDisplay);

        displayBtn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){

                StringBuffer result = new StringBuffer();
                result.append("Btn 1: ").append(toggleBtn1.getText());
                result.append("\nBtn 2: ").append(toggleBtn2.getText());

                Toast.makeText(MainActivity.this, result.toString(),
                        Toast.LENGTH_SHORT).show();
            }
        });

    }

    // Options Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    // MainActivity2
    public void proximaTela(View view){
        Intent prxTela = new Intent(this, MainActivity2.class);
        startActivity(prxTela);
    }

}