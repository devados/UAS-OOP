import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class Database {
    private static Connection connect;
    static DefaultTableModel dtm;
    public Database() {
        try{
            String jdbcDriver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/badminton?autoReconnect=true&useSSL=false";
            String user = "root";
            String pass = "";

            Class.forName(jdbcDriver);
            connect = DriverManager.getConnection(url,user,pass);

            if(connect!=null){
                System.out.println("Is Connected");
            }else{
                System.out.println("Connection Failed");
            }
        }catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
    }

    public static void show(){

        try{
            Object[] column = { "id", "lapangan", "harga", "tanggal", "mulai", "selesai", "nama", "team", "hp", "dp" };
            dtm = new DefaultTableModel(null,column);
            dataPanel.table.setModel(dtm);
            try{
                String sql = "SELECT * FROM booking";
                Statement st = connect.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    Object[] row = {
                            rs.getString("id"),
                            rs.getString("lapangan"),
                            rs.getInt("harga"),
                            rs.getDate("tanggal"),
                            rs.getString("mulai"),
                            rs.getString("selesai"),
                            rs.getString("nama"),
                            rs.getString("team"),
                            rs.getInt("hp"),
                            rs.getInt("dp"),
                    };
                    dtm.addRow(row);
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insert(){
        String id = editPanel.id.getText();
        String lapangan = editPanel.lapangan.getText();
        int harga = Integer.parseInt(editPanel.harga.getText());
        String tanggal = editPanel.tanggal.getText();
        String mulai = editPanel.mulai.getSelectedItem().toString();
        String selesai = editPanel.selesai.getSelectedItem().toString();
        String nama = editPanel.nama.getText();
        String team = editPanel.team.getText();
        int hp = Integer.parseInt(editPanel.hp.getText());
        int dp = Integer.parseInt(editPanel.dp.getText());

        try{
            String sql = "INSERT INTO booking VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connect.prepareStatement(sql);
            ps.setString(1, id);
            ps.setString(2, lapangan);
            ps.setInt(3, harga);
            ps.setString(4, tanggal);
            ps.setString(5, mulai);
            ps.setString(6, selesai);
            ps.setString(7, nama);
            ps.setString(8, team);
            ps.setInt(9, hp);
            ps.setInt(10, dp);
            ps.execute();
            show();
            JOptionPane.showMessageDialog(null,"Data berhasil diinput");
        }catch (Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Failed");
        }
    }

    public void update(){
        try{
            String sql = "UPDATE booking SET lapangan=?, harga=?, tanggal=?, mulai=?, selesai=?, nama=?, team=?, hp=?, dp=? WHERE id="+editPanel.id.getText();
            PreparedStatement st = connect.prepareStatement(sql);
            try{
                st.setString(1, editPanel.lapangan.getText());
                st.setInt(2,Integer.parseInt(editPanel.harga.getText()));
                st.setString(3, editPanel.tanggal.getText());
                st.setString(4, editPanel.mulai.getSelectedItem().toString());
                st.setString(5, editPanel.selesai.getSelectedItem().toString());
                st.setString(6, editPanel.nama.getText());
                st.setString(7, editPanel.team.getText());
                st.setInt(8,Integer.parseInt(editPanel.hp.getText()));
                st.setInt(9,Integer.parseInt(editPanel.dp.getText()));

                st.execute();
                show();
                JOptionPane.showMessageDialog(null,"Data berhasil diupdate");
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Update Fail");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void delete(){
        try{
            String sql = "DELETE FROM booking WHERE id = '"+ editPanel.id.getText()+"'";
            PreparedStatement stmt = connect.prepareStatement(sql);

            stmt.execute();
            show();
            JOptionPane.showMessageDialog(null,"Data berhasil didelete");
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Delete Fail");
        }
    }
}
