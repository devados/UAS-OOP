import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class editPanel extends JPanel {
    static JTextField id = new JTextField();
    static JTextField lapangan = new JTextField();
    static JTextField harga = new JTextField();
    static JTextField tanggal = new JTextField();
    public static JComboBox<String> mulai = new JComboBox<String>(new String[]{"10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00"});
    public static JComboBox<String> selesai = new JComboBox<String>(new String[]{
            "11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00"});
    static JTextField nama = new JTextField();
    static JTextField team = new JTextField();
    static JTextField hp = new JTextField();
    static JTextField dp = new JTextField();

    public editPanel(){
        setLayout(new GridLayout(10, 1));

        add(new JLabel("ID"));
        add(id);

        add(new JLabel("Nama lapangan"));
        add(lapangan);

        add(new JLabel("Harga"));
        add(harga);

        add(new JLabel("Tanggal"));
        add(tanggal);

        add(new JLabel("Jam Mulai"));
        add(mulai);

        add(new JLabel("Jam Selesai"));
        add(selesai);

        add(new JLabel("Nama Pemesan"));
        add(nama);

        add(new JLabel("Nama Team"));
        add(team);

        add(new JLabel("No HP"));
        add(hp);

        add(new JLabel("Uang DP"));
        add(dp);
        //border
        Border etchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        TitledBorder titledBorder = BorderFactory.createTitledBorder(etchedBorder, "Detail Booking");
        titledBorder.setTitleFont(titledBorder.getTitleFont().deriveFont(Font.BOLD));

        setBorder(BorderFactory.createCompoundBorder(new EmptyBorder(10, 10, 10, 10), titledBorder));
    }
}
