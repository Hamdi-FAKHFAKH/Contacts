package issatso.hamdi.contacts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListViewAdapter extends BaseAdapter {

    ArrayList<Contact> data ;
    Context context;

    public MyListViewAdapter(Context context,ArrayList<Contact> data) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        //return le nombre de elements(view) a créer
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        //renvois la données dans la position i
        return null;
    }

    @Override
    public long getItemId(int i) {
        //return l id de item
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // renvoi la view a afficher
        //creation d'un vue
        // v est le context de view_contact
        LayoutInflater inf = LayoutInflater.from(context);
        View v =  inf.inflate(R.layout.view_contact,null);
        // recuperation des holders (les input)
        TextView tvnom = v.findViewById(R.id.tv_nom);
        TextView tvpre = v.findViewById(R.id.tv_pre);
        TextView tvnum = v.findViewById(R.id.tv_num);
        ImageButton btn_call = v.findViewById(R.id.btn_call);
        ImageButton btn_contact = v.findViewById(R.id.btn_update);
        ImageButton btn_delete = v.findViewById(R.id.btn_delete);
        tvnom.setText("nom : " + data.get(i).nom);
        tvpre.setText("prénom : " +data.get(i).pre);
        tvnum.setText("numéro : "+data.get(i).num);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(i);
                notifyDataSetChanged();
            }
        });
        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(Intent.ACTION_DIAL);
                in.setData(Uri.parse("tel:" + data.get(i).num));
                context.startActivity(in);
            }
        });
        return v;
    }
}
