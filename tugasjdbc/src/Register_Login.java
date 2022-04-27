import javax.swing.*;  
import java.awt.*;  
import java.awt.event.*;  
import java.lang.Exception;  
import java.sql.ResultSet;

public class Register_Login
{  
    public static void main(String arg[])  
    {  
        KoneksiDB koneksiDb = new KoneksiDB(); 

        loginForm lf = new loginForm();  
        lf.pack(); 
        lf.setVisible(true);
        lf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        daftarForm df = new daftarForm();
        df.pack();
        df.setVisible(true);
        df.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }  
}

class loginForm extends JFrame
{  
    JButton login, cancel;  
    JPanel panel;  
    JLabel uname, pass;  
    final JTextField textFieldUsername, textFieldPassword;  
      
    loginForm()  
    {     
        KoneksiDB koneksiDb = new KoneksiDB(); 

        uname = new JLabel();  
        uname.setText("Username : "); 
        textFieldUsername = new JTextField(15); 
  
        pass = new JLabel();  
        pass.setText("Password : ");          
        textFieldPassword = new JTextField(15);
          
        login = new JButton("LOGIN");
        cancel = new JButton("CANCEL");
       
        panel = new JPanel(new GridLayout(3, 1));  
        panel.add(uname);
        panel.add(textFieldUsername);
        panel.add(pass);
        panel.add(textFieldPassword);
        panel.add(login);
        panel.add(cancel);
        
        add(panel, BorderLayout.CENTER);  
        setTitle("Login");
        
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                   try {
            String qUname = "SELECT * FROM users WHERE username = '"+getUsername()+"'";
            koneksiDb.statement = koneksiDb.koneksi.createStatement();
            ResultSet unameBenar = koneksiDb.statement.executeQuery(qUname);
            
            if(unameBenar.next()){
                int id = unameBenar.getInt("id");
                String qPass = "SELECT * FROM users WHERE password = '"+getPassword()+"' AND id = '"+id+"'";
                ResultSet passBenar = koneksiDb.statement.executeQuery(qPass);
                if(passBenar.next()){
                JOptionPane.showMessageDialog(null,"Login Berhasil.");
                }
                else{
 JOptionPane.showMessageDialog(null,"Password Salah.");
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Username Tidak Ditemukan.");
            }
            System.out.println("Insert Berhasil");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
            }
        });
        
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);            
            } 
        });
    }
    
    public String getUsername(){
        return textFieldUsername.getText();
    }
    
    public String getPassword() {
        return textFieldPassword.getText();
    }
}

class daftarForm extends JFrame
{  
    JButton daftar, cancel;  
    JPanel panel;  
    JLabel uname, pass;  
    final JTextField textFieldUsername, textFieldPassword;  
      
    daftarForm()  
    {     
        KoneksiDB koneksiDb = new KoneksiDB(); 

        uname = new JLabel();  
        uname.setText("Username: "); 
        textFieldUsername = new JTextField(15); 

        pass = new JLabel();  
        pass.setText("Password: ");          
        textFieldPassword = new JTextField(15);
          
        daftar = new JButton("DAFTAR");
        cancel = new JButton("CANCEL");
        
        panel = new JPanel(new GridLayout(3, 1));  
        panel.add(uname);
        panel.add(textFieldUsername);
        panel.add(pass);
        panel.add(textFieldPassword);
        panel.add(daftar);
        panel.add(cancel);
        
        add(panel, BorderLayout.CENTER);  
        setTitle("Daftar");
        
        daftar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                   try {
            String qUname = "SELECT * FROM users WHERE username = '"+getUsername()+"'";
            koneksiDb.statement = koneksiDb.koneksi.createStatement();
            ResultSet isUname = koneksiDb.statement.executeQuery(qUname);
            if(isUname.next()){
                JOptionPane.showMessageDialog(null,"Username Sudah Terdaftar.");
            }
            else{
                String qPass = "INSERT INTO users (`username`, `password`) VALUES ('"+getUsername()+"','"+getPassword()+"')";
                koneksiDb.statement = koneksiDb.koneksi.createStatement();
                koneksiDb.statement.executeUpdate(qPass);
                JOptionPane.showMessageDialog(null,"Pendaftaran Berhasil.");
            }
            System.out.println("Insert Berhasil");
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
            }
        });
        
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                System.exit(0);            
            } 
        });
    }
    
    public String getUsername(){
        return textFieldUsername.getText();
    }
    
    public String getPassword() {
        return textFieldPassword.getText();
    }
}