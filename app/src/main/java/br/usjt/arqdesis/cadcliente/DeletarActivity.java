package br.usjt.arqdesis.cadcliente;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DeletarActivity extends AppCompatActivity {

    public EditText editTextId, editTextNome, editTextIdade, editTextCpf, editTextTelefone;
    public Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletar);

        editTextId = (EditText)findViewById(R.id.editTextId);
        editTextNome = (EditText)findViewById(R.id.editTextNome);
        editTextIdade = (EditText)findViewById(R.id.editTextIdade);
        editTextCpf = (EditText)findViewById(R.id.editTextCpf);
        editTextTelefone = (EditText)findViewById(R.id.editTextTelefone);
        cliente = new Cliente();
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

    public void deletarRegistro(View view) {
        cliente.delete();
        Toast.makeText(this, "Excluido com sucesso!", Toast.LENGTH_LONG).show();
    }
}
