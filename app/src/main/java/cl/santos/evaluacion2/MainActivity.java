package cl.santos.evaluacion2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //se inicializan las diferentes variables a utilizar
    EditText longuna, latuna, longdos, latdos, longtres, lattres;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //las variables se asignan a su respectivo valor desde la interfaz
        longuna = findViewById(R.id.elong1);
        latuna = findViewById(R.id.elat1);
        longdos = findViewById(R.id.elong2);
        latdos = findViewById(R.id.elat2);
        longtres = findViewById(R.id.elong3);
        lattres = findViewById(R.id.elat3);

        //el boton (tres errores antes de notar su falta)
        agregar = findViewById(R.id.bagregar);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getApplicationContext(),
                        mapa.class
                );

                //se pasan los valores a int para no dejarlos como string
                double primeralong = Double.parseDouble(longuna.getText().toString());
                double primeralati = Double.parseDouble(latuna.getText().toString());
                double segundalong = Double.parseDouble(longdos.getText().toString());
                double segundalati = Double.parseDouble(latdos.getText().toString());
                double terceralong = Double.parseDouble(longtres.getText().toString());
                double terceralati = Double.parseDouble(lattres.getText().toString());

                //se mandan al activity del mapa
                intent.putExtra("lo1", primeralong);
                intent.putExtra("la1", primeralati);
                intent.putExtra("lo2", segundalong);
                intent.putExtra("la2", segundalati);
                intent.putExtra("lo3", terceralong);
                intent.putExtra("la3", terceralati);

                startActivity(intent);
            }
        });
    }
}