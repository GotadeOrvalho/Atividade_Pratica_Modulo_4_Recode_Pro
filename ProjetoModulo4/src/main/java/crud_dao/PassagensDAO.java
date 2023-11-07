package crud_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.util.ArrayList;
import java.util.List;

import conector.ConnectionFactory;
import model.Clientes;
import model.Destinos;
import model.Passagens;


public class PassagensDAO {

    Connection conn = null;
    PreparedStatement pstm = null;


    public void save(Passagens passagens){
        String sql = "INSERT INTO passagem(assento, num_voo, data_hora, valor, fk_cliente_id_cliente, fk_id_destino)" + 
        "VALUES(?, ?, ?, ?, ?, ?)";

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, passagens.getAssento());
            pstm.setInt(2, passagens.getNum_voo());
            pstm.setString(3, passagens.getData_hora());
            pstm.setFloat(4, passagens.getValor());
            pstm.setInt(5, passagens.getFk_cliente_id_cliente().getId_cliente());
            pstm.setInt(6, passagens.getFk_id_destino().getId_destino());

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

    public void removeById(int id_passagem){
        String sql = "DELETE FROM passagem  WHERE id_passagem = ?";

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id_passagem);
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

    public void update(Passagens passagens){
        String sql = "UPDATE passagem SET assento = ?, num_voo = ?, data_hora = ?, valor = ?, fk_cliente_id_cliente = ?, fk_id_destino = ?" 
        + " WHERE id_passagem = ?";


        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, passagens.getAssento());
            pstm.setInt(2, passagens.getNum_voo());
            pstm.setString(3, passagens.getData_hora());
            pstm.setFloat(4, passagens.getValor());
            pstm.setInt(5, passagens.getFk_cliente_id_cliente().getId_cliente());
            pstm.setInt(6, passagens.getFk_id_destino().getId_destino());

            pstm.setInt(7, passagens.getId_passagem());

            pstm.execute();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try{
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
    }

    public List<Passagens> getPassagem(){
        String sql = "SELECT * FROM passagem";

        List<Passagens> passagem = new ArrayList<Passagens>();

        ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()){
                Passagens passagens = new Passagens();
                Clientes clientes = new Clientes();
                Destinos destinos = new Destinos();

               
                

                passagens.setId_passagem(rset.getInt("id_passagem"));
                passagens.setAssento(rset.getString("assento"));
                passagens.setNum_voo(rset.getInt("num_voo"));
                passagens.setData_hora(rset.getString("data_hora"));
                passagens.setValor(rset.getFloat("valor"));
                clientes.setId_cliente(rset.getInt("fk_cliente_id_cliente"));
                passagens.setFk_cliente_id_cliente(clientes);
                //destinos.setId_destino(rset.getInt("fk_id_destino"));
                //passagens.setFk_id_destino(destinos);
                int destinoId = rset.getInt("fk_id_destino");
                if (destinoId != 0) {
                    destinos.setId_destino(destinoId);
                    passagens.setFk_id_destino(destinos);
                } else {
                    passagens.setFk_id_destino(null);
                }
                
                passagem.add(passagens);
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
        return passagem;
    }

    public Passagens passagensById(int id_passagem) {
		String sql = "SELECT * FROM passagem WHERE id_passagem = ?";

		ResultSet rset = null;

		Passagens passagens = new Passagens();
		Clientes clientes = new Clientes();
        Destinos destinos = new Destinos();
		

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_passagem);
			rset = pstm.executeQuery();

			rset.next();
			
			passagens.setId_passagem(rset.getInt("id_passagem"));
            passagens.setAssento(rset.getString("assento"));
            passagens.setNum_voo(rset.getInt("num_voo"));
            passagens.setData_hora(rset.getString("data_hora"));
            passagens.setValor(rset.getFloat("valor"));

            int clienteId = rset.getInt("fk_cliente_id_cliente");
            int destinoId = rset.getInt("fk_id_destino");

            if (clienteId != 0) {
                // Se o clienteId não for 0, crie o objeto Clientes
                
                clientes.setId_cliente(clienteId);
                passagens.setFk_cliente_id_cliente(clientes);
            }

            if (destinoId != 0) {
                // Se o destinoId não for 0, crie o objeto Destinos
                
                destinos.setId_destino(destinoId);
                passagens.setFk_id_destino(destinos);
            }
           
			

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
		return passagens;
	}

    
}

