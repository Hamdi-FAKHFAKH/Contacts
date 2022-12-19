package issatso.hamdi.contacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import issatso.hamdi.contacts.SQLlite.ContactHelper;
import issatso.hamdi.contacts.SQLlite.ContactManger;

public class Edit extends AppCompatActivity {
EditText ed_rech;
RecyclerView rv;
//ListView lv;
ArrayList<Contact> res ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        /************************************ connextion au SQL lite **********************************/
        ContactManger cm = new ContactManger(Edit.this);
        cm.ouvrirContactDb();
        /************************************ methode en utisent le view par defaut *******************/
        //parcours le data et crée a chaque data un view
        //ArrayAdapter ad = new ArrayAdapter(Edit.this, android.R.layout.simple_list_item_1,Acceuil.data);
        //setContentView(R.layout.activity_edit);
        //lv= findViewById(R.id.lv_edit);
        //lv.setAdapter(ad);
        /************************************ methode de listview ****************************************/
        //MyListViewAdapter ad = new MyListViewAdapter(Edit.this,Acceuil.data);
        //lv= findViewById(R.id.lv);
        //lv.setAdapter(ad);
        /*********************************** methode de recycle view *************************************/
        rv = findViewById(R.id.rv);
        res = cm.getAllContact();
        MycontactRecycleViewAdapter  ad = new MycontactRecycleViewAdapter(Edit.this,res);
        GridLayoutManager ma = new GridLayoutManager(Edit.this,1,GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(ma);
        rv.setAdapter(ad);
        /*********************************************************************************************/
        ed_rech = findViewById(R.id.ed_rech_edit);
        ed_rech.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ContactManger cm = new ContactManger(Edit.this);
                cm.ouvrirContactDb();
                res = cm.getContactBySelect(ed_rech.getText().toString());
                ad.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }


        });

    }
}