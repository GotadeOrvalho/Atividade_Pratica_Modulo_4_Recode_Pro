package crud_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.util.ArrayList;
import java.util.List;

import conector.ConnectionFactory;
import model.Clientes;

public class ClientesDAO {

    public void save(Clientes clientes){
        String sql = "INSERT INTO cliente(telefone, data_nascimento, email, cpf, nome, endereco, senha)" + 
        "VALUES(?, ?, ?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, clientes.getTelefone());
            pstm.setString(2, clientes.getData_nascimento());
            pstm.setString(3, clientes.getEmail());
            pstm.setString(4, clientes.getCpf());
            pstm.setString(5, clientes.getNome());
            pstm.setString(6, clientes.getEndereco());
            pstm.setString(7, clientes.getSenha());

            pstm.execute();
        } catch (Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm != null){
                    pstm.close();
                }

                if (conn != null){
                    conn.close();
                }
            }catch (Exception e){
            e.printStackTrace();
        }
        } 
    }

    public void removeById(int id_cliente){
        String sql = "DELETE FROM cliente  WHERE id_cliente = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id_cliente);
            pstm.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(pstm != null){

                }

                if(conn != null){

                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void update(Clientes clientes){
        String sql = "UPDATE cliente SET telefone = ?, data_nascimento = ?, email = ?, cpf = ?, nome = ?, endereco = ?, senha = ?" 
        + "WHERE id_cliente = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, clientes.getTelefone());
            pstm.setString(2, clientes.getData_nascimento());
            pstm.setString(3, clientes.getEmail());
            pstm.setString(4, clientes.getCpf());
            pstm.setString(5, clientes.getNome());
            pstm.setString(6, clientes.getEndereco());
            pstm.setString(7, clientes.getSenha());

            pstm.setInt(8, clientes.getId_cliente());

            pstm.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(pstm != null){

                }

                if(conn != null){

                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public List<Clientes> getCliente(){
        String sql = "SELECT * FROM cliente";

        List<Clientes> cliente = new ArrayList<Clientes>();

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()){
                Clientes clientes = new Clientes();

                clientes.setId_cliente(rset.getInt("id_cliente"));
                clientes.setNome(rset.getString("nome"));
                clientes.setTelefone(rset.getString("telefone"));
                clientes.setEmail(rset.getString("email"));
                clientes.setCpf(rset.getString("cpf"));
                clientes.setData_nascimento(rset.getString("data_nascimento"));
                clientes.setEndereco(rset.getString("endereco"));
                clientes.setSenha(rset.getString("senha"));
                cliente.add(clientes);
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
                if(rset != null){
                    rset.close();
                }
                if(pstm != null){
                    pstm.close();
                }

                if(conn != null){
                    conn.close();
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        return cliente;
    }

    public Clientes clientesById(int id_cliente) {
		String sql = "SELECT * FROM cliente WHERE id_cliente = ?";

		ResultSet rset = null;

        Connection conn = null;
        PreparedStatement pstm = null;

		Clientes clientes = new Clientes();
		

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_cliente);
			rset = pstm.executeQuery();

			rset.next();
			
			clientes.setId_cliente(rset.getInt("id_cliente"));
            clientes.setNome(rset.getString("nome"));
            clientes.setTelefone(rset.getString("telefone"));
            clientes.setEmail(rset.getString("email"));
            clientes.setCpf(rset.getString("cpf"));
            clientes.setData_nascimento(rset.getString("data_nascimento"));
            clientes.setEndereco(rset.getString("endereco"));
            clientes.setSenha(rset.getString("senha"));
           
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

					pstm.close();
				}

				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		return clientes;
	}

    public String getNomeClienteById(int idCliente) {
        String nome = null;
        String sql = "SELECT nome FROM cliente WHERE id_cliente = ?";
    
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, idCliente);
            ResultSet rset = pstm.executeQuery();
    
            if (rset.next()) {
                nome = rset.getString("nome");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return nome;
    }

	

	
}
