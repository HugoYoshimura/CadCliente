package br.usjt.arqdesis.cadcliente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AlterarActivity extends AppCompatActivity {

    public EditText editTextId, editTextNome, editTextIdade, editTextCpf, editTextTelefone;
    public Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        cliente = new Cliente();

        editTextId = (EditText)findViewById(R.id.editTextId);
        editTextNome = (EditText)findViewById(R.id.editTextNome);
        editTextIdade = (EditText)findViewById(R.id.editTextIdade);
        editTextCpf = (EditText)findViewById(R.id.editTextCpf);
        editTextTelefone = (EditText)findViewById(R.id.editTextTelefone);
    }

    public void consultarRegistro(View view) {
        int id = Integer.parseInt(editTextId.getText().toString());
        if(id > 0) {
            cliente = Cliente.findById(Cliente.class, id);
            if(cliente != null) {
                editTextNome.setText(cliente.getNome());
                editTextCpf.setText(cliente.getCpf());
                editTextIdade.setText(cliente.getIdade()+"");
                editTextTelefone.setText(cliente.getTelefone());
            }
        } else {
            Toast.makeText(this, "ID inválido!", Toast.LENGTH_LONG).show();
        }
    }

    public void alterarRegistro(View view){
        cliente.setNome(editTextNome.getText().toString());
        cliente.setIdade(Integer.parseInt(editTextIdade.getText().toString()));
        cliente.setCpf(editTextCpf.getText().toString());
        cliente.setTelefone(editTextTelefone.getText().toString());
        cliente.save();
        Toast.makeText(this, "Alterado com sucesso!", Toast.LENGTH_LONG).show();
        consultarRegistro(view);


    }
}
