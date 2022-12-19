package issatso.hamdi.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import issatso.hamdi.contacts.SQLlite.ContactManger;

public class Ajout extends AppCompatActivity {
     EditText ed_name,ed_lastname,ed_phone;
     Button btn_ajout,btn_cancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
        btn_ajout = findViewById(R.id.btn_ajout_ajout);
        btn_cancel = findViewById(R.id.btn_cancel_ajout);
        ed_name = findViewById(R.id.ed_name_ajout);
        ed_lastname = findViewById(R.id.ed_lastname_ajout);
        ed_phone = findViewById(R.id.ed_phone_ajout);
        btn_ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ed_name.getText().toString();
                String lastname = ed_lastname.getText().toString();
                String num = ed_phone.getText().toString();
                // *----------------------------------sql database---------------------------------------/
                ContactManger cm = new ContactManger(Ajout.this);
                cm.ouvrirContactDb();
                long fff = cm.insertContact(name,lastname,num);
                System.out.println(fff);
                // afiche une notification
                Toast.makeText(Ajout.this, cm.getContact().toString(), Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}