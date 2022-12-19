package issatso.hamdi.contacts.SQLlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.contentcapture.ContentCaptureCondition;

import java.util.ArrayList;

import issatso.hamdi.contacts.Contact;

public class ContactManger {
    Context con ;
    SQLiteDatabase db ;

    public ContactManger(Context con) {
        this.con = con;
    }

    public void ouvrirContactDb(){
        ContactHelper helper = new ContactHelper(con,"Contact.db",null,2);
        db = helper.getWritableDatabase();
    }
    public long insertContact (String nom , String pre , String num) {
        ContentValues values = new ContentValues();
        values.put(ContactHelper.nom,nom);
        values.put(ContactHelper.pre,pre);
        values.put(ContactHelper.num,num);
        return db.insert(ContactHelper.contact,null,values);
    }
    public ArrayList<Contact> getAllContact(){
        ArrayList<Contact> l = new ArrayList<>();
        Cursor c =  db.query(ContactHelper.contact,
                new String[]{
                        ContactHelper.id,
                        ContactHelper.nom,
                        ContactHelper.pre,
                        ContactHelper.num},null,null,null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            l.add(new Contact ( c.getInt(0),
            c.getString(1),
            c.getString(2),
            c.getString(3))
            );
            c.moveToNext();
        }
        return l;
    }
    public ArrayList<Contact> getContactBySelect(String rech){
        ArrayList<Contact> l = new ArrayList<>();
        Cursor c =  db.query(ContactHelper.contact,
                new String[]{
                        ContactHelper.id,
                        ContactHelper.nom,
                        ContactHelper.pre,
                        ContactHelper.num},rech, new String[]{"nom = ?"},null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            l.add(new Contact ( c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3))
            );
            c.moveToNext();
        }
        return l;

    }
    public int deleteContact(Contact c){
        return db.delete(ContactHelper.contact,ContactHelper.id + " = " + c.id,null);

    }
    public Contact getContact(){
        Cursor c =  db.query(ContactHelper.contact,
                new String[]{
                        ContactHelper.id,
                        ContactHelper.nom,
                        ContactHelper.pre,
                        ContactHelper.num},null,null,null,null,null);
        c.moveToLast();
        return new Contact ( c.getInt(0),
                c.getString(1),
                c.getString(2),
                c.getString(3));
    }
    public int updateContact(Contact c, Contact old){
        ContentValues values = new ContentValues();
        values.put(ContactHelper.nom,c.nom);
        values.put(ContactHelper.pre,c.pre);
        values.put(ContactHelper.num,c.num);
        return db.update(ContactHelper.contact,values,"id = "+old.id,null);

    }
    public ArrayList<Contact> getAllContactbyname(String name){
        ArrayList<Contact> l = new ArrayList<>();
        Cursor c =  db.query(ContactHelper.contact,
                new String[]{
                        ContactHelper.id,
                        ContactHelper.nom,
                        ContactHelper.pre,
                        ContactHelper.num},ContactHelper.nom + " = " + name,null,null,null,null);
        c.moveToFirst();
        while (!c.isAfterLast()) {
            l.add(new Contact ( c.getInt(0),
                    c.getString(1),
                    c.getString(2),
                    c.getString(3))
            );
            c.moveToNext();
        }
        return l;
    }
}
