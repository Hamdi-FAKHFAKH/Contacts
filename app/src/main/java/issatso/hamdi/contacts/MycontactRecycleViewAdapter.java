package issatso.hamdi.contacts;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import issatso.hamdi.contacts.SQLlite.ContactManger;

public class MycontactRecycleViewAdapter extends RecyclerView.Adapter<MycontactRecycleViewAdapter.MyViewHolder> {
    public static Contact c;
    Context con;
    ArrayList<Contact> data;

    public MycontactRecycleViewAdapter(Context con, ArrayList<Contact> data) {
        this.con = con;
        this.data = data;
    }

    @NonNull
    @Override
    public MycontactRecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // renvoi la view a afficher
        //creation d'un vue
        // v est le context de view_contact
        LayoutInflater inf = LayoutInflater.from(con);
        View v =  inf.inflate(R.layout.view_contact,null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MycontactRecycleViewAdapter.MyViewHolder holder, int position) {
    // action lorsque on scroll
        // recuperation des holders (les input)
        holder.tvnom.setText("nom : " + data.get(position).nom);
        holder.tvpre.setText("prénom : " +data.get(position).pre);
        holder.tvnum.setText("numéro : "+data.get(position).num);



    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvnom,tvpre,tvnum;
        ImageButton btn_call,btn_update,btn_delete;
        public MyViewHolder(@NonNull View v) {
            super(v);
             tvnom = v.findViewById(R.id.tv_nom);
             tvpre = v.findViewById(R.id.tv_pre);
             tvnum = v.findViewById(R.id.tv_num);
             btn_call = v.findViewById(R.id.btn_call);
             btn_update = v.findViewById(R.id.btn_update);
             btn_delete = v.findViewById(R.id.btn_delete);

            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int indice = getAdapterPosition();// retourne l'indice de l'element selectionné
                    ContactManger cm = new ContactManger(con);
                    cm.ouvrirContactDb();
                    cm.deleteContact(data.get(indice));
                    data.remove(indice);
                    notifyDataSetChanged();

                }
            });
            btn_update.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int indice = getAdapterPosition();
                    c = data.get(indice);
                    Intent i = new Intent(con,Update_contact.class);
                    con.startActivity(i);

                }
            });

        }
    }
}
