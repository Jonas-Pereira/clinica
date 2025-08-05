/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
 
import Entidades.Medicos;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class MedicosDAO  extends GenericDAO
{

    
    public void getMedicos (int crmMedico) throws SQLException
    {
        
        
        String query = "SELECT * FROM medicos where crm = ?";
        executeQuery(query, crmMedico);
        //rs =  executeQuery("select * from medicos where crm like ?",medicos.getCrm()+"%");
    }
    
    public List<Medicos> getAllMedicos() throws SQLException 
    {
        List<Medicos> medicos = new LinkedList<>();
        
        ResultSet rs;
        rs = executeQuery("SELECT * FROM medicos ");
                
                while(rs.next())
                {
                medicos.add(populateMedico(rs));
                }
                rs.close();
        return medicos;
    }
    
    public List<Medicos> getAllMedicosPorNome(String nome) throws SQLException 
    {
        List<Medicos> medicos = new LinkedList<>();
        
        try ( //ResultSet rs = executeQuery("SELECT * FROM medicos WHERE nome_medico like ?", "%"+nome);
                ResultSet rs = executeQuery("SELECT * FROM medicos WHERE nome_medico like ?",nome+"%")) {
            while(rs.next())
            {
                medicos.add(populateMedico(rs));
            }
        }
        return medicos;
    }
    
    public List<Medicos> getAllMedicosPorCrm(int crm) throws SQLException 
    {
        List<Medicos> medicos = new LinkedList<>();
        
        try ( //ResultSet rs = executeQuery("SELECT * FROM medicos WHERE nome_medico like ?", "%"+nome);
                ResultSet rs = executeQuery("SELECT * FROM medicos WHERE crm like ?",crm+"%")) {
            while(rs.next())
            {
                medicos.add(populateMedico(rs));
            }
        }
        return medicos;
    }
    
    public Integer addMedicos(Medicos medicos ) throws SQLException
    {
        String query = "INSERT INTO medicos(crm, nome_medico, cpf, rg, telefone, endereco, sexo) VALUES (?,?,?,?,?,?,?)";
        executeComand(query, medicos.getCrm(), medicos.getNome_medico(), medicos.getCpf(), medicos.getRg(), medicos.getTelefone(), medicos.getEndereco(), medicos.getSexo());
        return medicos.getId();
        
    }
    
    public void updateMedicos(Medicos medicos) throws SQLException
    {
        String query = "UPDATE medicos SET crm = ?, nome_medico = ?, cpf = ?, rg = ?, telefone = ?, sexo = ? WHERE id =?";
        executeComand(query, medicos.getCrm(), medicos.getNome_medico(), medicos.getCpf(), medicos.getRg(), medicos.getTelefone(), medicos.getSexo(), medicos.getId());        
        
    }
    
    public void deleteMedicos(Medicos medicos ) throws SQLException
    {
        String query = "DELETE FROM medicos WHERE id = ? ";
        executeComand(query, medicos.getId());
    
    }

    private Medicos populateMedico(ResultSet rs) throws SQLException {
        Medicos retorno = new Medicos();
        
        retorno.setId(Integer.valueOf(rs.getString("id")));
        retorno.setNome_medico(rs.getString("nome_medico"));
        retorno.setCrm(rs.getInt("crm"));
        retorno.setRg(rs.getString("rg"));
        retorno.setCpf(rs.getString("cpf"));
        retorno.setTelefone(rs.getString("telefone"));
        retorno.setSexo(rs.getString("sexo"));
        
        
        return retorno;
        
    }

    
}
