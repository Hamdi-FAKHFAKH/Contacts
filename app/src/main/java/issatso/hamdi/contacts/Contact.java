package issatso.hamdi.contacts;

public class Contact {
    public String nom, pre, num;
    public int id ;

    public Contact() {

    }

    public Contact(int id , String nom, String pre, String num) {
        this.id = id;
        this.nom = nom;
        this.pre = pre;
        this.num = num;

    }

    @Override
    public String toString() {
        return "Contact{" +
                ", id=" + id +
                "nom='" + nom + '\'' +
                ", pre='" + pre + '\'' +
                ", num='" + num + '\'' +
                '}';
    }
}

