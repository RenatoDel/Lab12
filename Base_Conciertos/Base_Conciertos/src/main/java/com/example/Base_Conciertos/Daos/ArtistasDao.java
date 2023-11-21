package com.example.Base_Conciertos.Daos;

import com.example.Base_Conciertos.Beans.Artistas;

import java.sql.*;
import java.util.ArrayList;

public class ArtistasDao extends DaoBase {


    public ArrayList<Artistas> listaArtistas() {
        ArrayList<Artistas> listaArtistas = new ArrayList<>();

        String sql= "SELECT * FROM artistas";

        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                Artistas artistas = new Artistas();
                artistas.setIdArtistas(rs.getInt(1));
                artistas.setNombre_Grupo(rs.getString(2));

                listaArtistas.add(artistas);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaArtistas;
    }
    public Artistas obtenerArtistas(int IdArtistas) {

        Artistas artistas = null;

        String sql = "SELECT * FROM employees e \n"
                + "left join jobs j ON (j.job_id = e.job_id) \n"
                + "left join departments d ON (d.department_id = e.department_id)\n"
                + "left  join employees m ON (e.manager_id = m.employee_id)\n"
                + "WHERE e.employee_id = ?";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, IdArtistas);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    artistas = new Artistas();
                    fetchEmployeeData(artistas, rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return artistas;
    }
    public void actualizarEmpleado(Artistas artistas) throws SQLException {

        String sql = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, phone_number = ?, "
                + "hire_date = ?, job_id = ?, salary = ?, commission_pct = ?, "
                + "manager_id = ?, department_id = ? WHERE employee_id = ?";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            setEmployeeParams(pstmt, artistas);
            pstmt.setInt(11, artistas.getIdArtistas());
            pstmt.executeUpdate();
        }
    }

    public void borrarArtistas(int idArtistas) {

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM employees WHERE employee_id = ?")) {

            pstmt.setInt(1, idArtistas);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    private void setEmployeeParams(PreparedStatement pstmt, Artistas artistas) throws SQLException {
        pstmt.setString(1, artistas.getNombre_Grupo());
        pstmt.setString(2, artistas.getFecha_creacion());
        pstmt.setString(3, artistas.getTipo_musica());
    }
    private void fetchEmployeeData(Artistas artistas, ResultSet rs) throws SQLException {
        artistas.setIdArtistas(rs.getInt(1));
        artistas.setNombre_Grupo(rs.getString(2));
        artistas.setFecha_creacion(rs.getString(3));
        artistas.setTipo_musica(rs.getString(4));
    }
}
