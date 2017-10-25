package br.usjt.arqdesis.cadcliente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InserirActivity extends AppCompatActivity {

    public Button inserirBtn;
    public EditText editTextNome, editTextIdade, editTextCpf, editTextTelefone;
    public Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir);

        inserirBtn = (Button)findViewById(R.id.btnInserirLayout);
        inserirBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inserirRegistro();
            }
        });

        cliente = new Cliente();
        editTextNome = (EditText)findViewById(R.id.editTextNome);
        editTextIdade = (EditText)findViewById(R.id.editTextIdade);
        editTextCpf = (EditText)findViewById(R.id.editTextCpf);
        editTextTelefone = (EditText)findViewById(R.id.editTextTelefone);

    }

    public void inserirRegistro() {
        cliente.setNome(editTextNome.getText().toString());
        cliente.setIdade(Integer.parseInt(editTextIdade.getText().toString()));
        cliente.setCpf(editTextCpf.getText().toString());
        cliente.setTelefone(editTextTelefone.getText().toString());
        Cliente.save(cliente);
        Toast.makeText(this, "Registro salvo com sucesso! Reg: " + cliente.getId(), Toast.LENGTH_LONG).show();
    }
}