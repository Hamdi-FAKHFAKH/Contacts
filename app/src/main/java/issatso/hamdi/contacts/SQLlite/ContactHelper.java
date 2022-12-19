package issatso.hamdi.contacts.SQLlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContactHelper extends SQLiteOpenHelper {
    public static final String contact  = "contact";
    public static final String id  = "id";
    public static final String nom  = "nom";
    public static final String pre  = "pre";
    public static final String num  = "num";
    String req = " create TABLE "+contact+"("+id+" Integer primary key autoincrement, "+
            nom+" Text not null, "+
            pre+" Text not null, "+
            num+" Text not null )";

    public ContactHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // executer lors de la création de fichier sql
        db.execSQL(req);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table  contact");
        db.execSQL(req);
    }
}
