package crud_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.util.ArrayList;
import java.util.List;

import conector.ConnectionFactory;
import model.Destinos;

public class DestinosDAO {

    public void save(Destinos destinos){
        String sql = "INSERT INTO destino(cidade, estado, pais, aeroporto, promocao)" + 
        "VALUES(?, ?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, destinos.getCidade());
            pstm.setString(2, destinos.getEstado());
            pstm.setString(3, destinos.getPais());
            pstm.setString(4, destinos.getAeroporto());
            pstm.setFloat(5, destinos.getPromocao());

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

    public void removeById(int id_destino){
        String sql = "DELETE FROM destino  WHERE id_destino = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id_destino);
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

    public void update(Destinos destinos){
        String sql = "UPDATE destino SET cidade = ?, estado = ?, pais = ?, aeroporto = ?, promocao = ?" 
        + "WHERE id_destino = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, destinos.getCidade());
            pstm.setString(2, destinos.getEstado());
            pstm.setString(3, destinos.getPais());
            pstm.setString(4, destinos.getAeroporto());
            pstm.setFloat(5, destinos.getPromocao());

            pstm.setInt(6, destinos.getId_destino());

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

    public List<Destinos> getDestino(){
        String sql = "SELECT * FROM destino";

        List<Destinos> destino = new ArrayList<Destinos>();
        Connection conn = null;
        PreparedStatement pstm = null;
		ResultSet rset = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()){
                Destinos destinos = new Destinos();

                destinos.setId_destino(rset.getInt("id_destino"));
                destinos.setCidade(rset.getString("cidade"));
                destinos.setEstado(rset.getString("estado"));
                destinos.setPais(rset.getString("pais"));
                destinos.setAeroporto(rset.getString("aeroporto"));
                destinos.setPromocao(rset.getFloat("promocao"));
                destino.add(destinos);
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
        return destino;
    }

    public Destinos destinosById(int id_destino) {
		String sql = "SELECT * FROM destino WHERE id_destino = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
		ResultSet rset = null;

		Destinos destinos = new Destinos(); 

		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id_destino);
			rset = pstm.executeQuery();

			rset.next();
			
			destinos.setId_destino(rset.getInt("id_destino"));
            destinos.setCidade(rset.getString("cidade"));
            destinos.setEstado(rset.getString("estado"));
            destinos.setPais(rset.getString("pais"));
            destinos.setAeroporto(rset.getString("aeroporto"));
            destinos.setPromocao(rset.getFloat("promocao"));
           
			

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
		return destinos;
	}

   
    public String getDestinoNomeById(int idDestino) {
        String destinoNome = null;
        String sql = "SELECT cidade, estado, pais, aeroporto FROM destino WHERE id_destino = ?";
    
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            pstm.setInt(1, idDestino);
            ResultSet rset = pstm.executeQuery();
    
            if (rset.next()) {
                String cidade = rset.getString("cidade");
                String estado = rset.getString("estado");
                String pais = rset.getString("pais");
                String aeroporto = rset.getString("aeroporto");
                
                // Construa o nome completo do destino com as informações obtidas
                destinoNome = cidade + " - " + estado + ", " + pais + " - Aeroporto " + aeroporto;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
        return destinoNome;
    }
}

