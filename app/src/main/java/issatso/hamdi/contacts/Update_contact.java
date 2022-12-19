package issatso.hamdi.contacts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import issatso.hamdi.contacts.SQLlite.ContactManger;

public class Update_contact extends AppCompatActivity {
    Button btn_cancel , btn_update;
    EditText tv_nom,tv_pre,tv_num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);
        btn_cancel = findViewById(R.id.btn_cancel_up);
        btn_update = findViewById(R.id.btn_up_up);
        tv_nom = findViewById(R.id.tv_name_up);
        tv_pre = findViewById(R.id.tv_pre_up);
        tv_num = findViewById(R.id.tv_num_up);


        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contact old =  MycontactRecycleViewAdapter.c;
                ContactManger cm = new ContactManger(Update_contact.this);
                cm.ouvrirContactDb();
                cm.updateContact(new Contact(old.id, tv_nom.getText().toString(),tv_pre.getText().toString(),tv_num.getText().toString()),old);
                Intent i = new Intent(Update_contact.this,Edit.class);
                startActivity(i);
            }
        });
    }
}