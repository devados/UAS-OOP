import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class dataPanel extends JPanel {
    static JTable table = new JTable();
    Database db = new Database();
    public dataPanel(){

        JScrollPane scrollPane = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        table.setEnabled(false);

        setLayout(new GridLayout(1,1));
        setBorder(new EmptyBorder(10, 10, 0, 10));

        add(scrollPane);

        db.show();

    }
}
