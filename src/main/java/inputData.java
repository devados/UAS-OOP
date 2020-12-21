import javax.swing.*;

public class inputData extends JFrame {

    public inputData(){
        setTitle("Booking Lapangan");
        setSize(800,550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new dataPanel());
        add(new editPanel());
        add(new Button());

        setVisible(true);
    }
}
