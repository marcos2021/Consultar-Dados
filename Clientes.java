import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.EventObject;
import java.sql.ResultSet;

public class Clientes extends Janela 
   implements ActionListener{
	
	Connection conexao = Conectar.getConnection() ;
	String status = Conectar.status ;
	
	JLabel     lblCodigo, lblVend, lblValor, lblForma, 
	           lblStatus, txtStatus;
	JTextField txtCodigo, txtVend,txtForma, txtValor;
	JButton    btConsultar, btLimpar; 
	           
	
	public Clientes(){
       super("Clientes" , new Dimension(300,300));
 
       lblCodigo = new JLabel("Código: ");
       lblCodigo.setBounds(30, 30, 70, 20);

       lblVend = new JLabel("Vend: ");
       lblVend.setBounds(30, 60, 70, 20);       

       lblValor = new JLabel("Valor: ");
       lblValor.setBounds(30, 90, 70, 20);       
       
       lblForma = new JLabel("Forma Pag: ");
       lblForma.setBounds(30, 120, 70, 20);   
       
       txtCodigo = new JTextField();
       txtCodigo.setBounds(80,30,60,20);

       txtVend = new JTextField();
       txtVend.setBounds(80,60,150,20);       

       txtValor = new JTextField();
       txtValor.setBounds(80,90,150,20);       
       
       txtForma = new JTextField();
       txtForma.setBounds(100,120,150,20);   
       
       lblStatus = new JLabel("Status: ") ;
       lblStatus.setBounds(30, 150, 70, 20);

       txtStatus = new JLabel(this.status) ;
       txtStatus.setForeground(Color.RED);
       txtStatus.setBounds(80, 150, 700, 20);       

 
       
       btConsultar = new JButton("Consultar") ;
       btConsultar.setBounds(100, 180, 90, 20);
       getContentPane().add(btConsultar) ;
       btConsultar.addActionListener(this);
       
       btLimpar = new JButton("Limpar") ;
       btLimpar.setBounds(100, 220, 90, 20);
       getContentPane().add(btLimpar) ;
       btLimpar.addActionListener(this);
   

     
     
       
       getContentPane().add(lblCodigo) ;
       getContentPane().add(lblVend) ;
       getContentPane().add(lblValor) ;
       getContentPane().add(lblForma) ;
       getContentPane().add(txtCodigo) ;
       getContentPane().add(txtVend) ;
       getContentPane().add(txtValor) ;
       getContentPane().add(txtForma) ;
       getContentPane().add(lblStatus) ;
       getContentPane().add(txtStatus) ;
      
	}
	public static void main(String[] args) {
		   Clientes tela ;
		   tela = new Clientes(); 
		   tela.setVisible(true);
		   

		}

		void limpaCampos(){
			txtCodigo.setText("");
			txtVend.setText("");
			txtValor.setText("");
			txtForma.setText("");
		
		
		}
		
		public void actionPerformed(ActionEvent botao) {

			if(botao.getSource()==btConsultar ){
				boolean ok ;
				ok = consultaClientes();
				if ( ok ){
					txtStatus.setText("");
				}else{
					txtStatus.setText("Código não cadastrado");
					limpaCampos();
				}
			}
			if( botao.getSource()==btLimpar ){
				boolean ok ;
					limpaCampos();
				}
				
			} 
			
		boolean consultaClientes(){
			boolean ok = true ;
			int vCodigo = Integer.parseInt(txtCodigo.getText());
			String sql; 
			
			sql = "SELECT * FROM clientes_java WHERE codigo=" + vCodigo ;
			try{
				Statement st = conexao.createStatement();
				ResultSet rs = st.executeQuery(sql) ;
				if (rs.next()){
					txtCodigo.setText(String.valueOf(rs.getInt("codigo")) ) ;
					txtVend.setText( rs.getString("vend") ) ;
					txtValor.setText( String.valueOf(rs.getFloat("valor")) ) ;
					txtForma.setText( rs.getString("Form") ) ;
				}else{
					ok = false ; 
				}
			}catch(Exception erro){
				ok = false ;
			}
			
			
			return ok ;
		}
	

}