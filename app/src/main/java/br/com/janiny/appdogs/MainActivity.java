package br.com.janiny.appdogs;

import android.content.Intent;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;


import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvProdutos;
    private List<Produto> listaDeProdutos;
    private ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,FormularioActivity.class);
                intent.putExtra("acao", "inserir");
                startActivity(intent);
            }
        });
        lvProdutos = findViewById(R.id.lvProdutos);


        lvProdutos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this,FormularioActivity.class);
                intent.putExtra("acao", "editar");
                startActivity(intent);
            }
        });
        carregarLista();
    }

    private void carregarLista(){

        Produto p1 = new Produto("Coca-Cola 2L","Bebidas");
        Produto p2 = new Produto("Pepsi 1,5L","Bebidas");
        Produto p3 = new Produto("Trakinas Meio a Meio","Alimentos");
        listaDeProdutos = new ArrayList<>();
        listaDeProdutos.add(p1);
        listaDeProdutos.add(p2);
        listaDeProdutos.add(p3);

        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,listaDeProdutos);
        lvProdutos.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}