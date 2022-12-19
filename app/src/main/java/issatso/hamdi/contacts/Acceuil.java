package issatso.hamdi.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class Acceuil extends AppCompatActivity {
    Button btn_ajout,btn_edit;
    public static ArrayList<Contact> data = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        btn_ajout = findViewById(R.id.btn_ajout_acceuil);
        btn_edit = findViewById(R.id.btn_edit_acceuil);
        btn_ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //redirection vers la page ajout
                Intent i = new Intent(Acceuil.this,Ajout.class);
                startActivity(i);

            }
        });
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Acceuil.this,Edit.class);
                startActivity(i);
            }
        });
    }
}