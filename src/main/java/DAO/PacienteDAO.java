/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Paciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class PacienteDAO extends GenericDAO{
    
    
    public List<Paciente> getAllPaciente() throws SQLException 
    {
        List<Paciente> paciente = new LinkedList<>();
        
        try (ResultSet rs = executeQuery("SELECT * FROM paciente ")) {
            while(rs.next())
            {
                paciente.add(populatePaciente(rs));
            }
        }
        return paciente;
    }
    
    public List<Paciente> getAllPacientePorNome(String nome) throws SQLException 
    {
        List<Paciente> paciente = new LinkedList<>();
        
        try ( //ResultSet rs = executeQuery("SELECT * FROM medicos WHERE nome_medico like ?", "%"+nome);
                ResultSet rs = executeQuery("SELECT * FROM paciente WHERE nome like ?",nome+"%")) {
            while(rs.next())
            {
                paciente.add(populatePaciente(rs));
            }
        }
        return paciente;
    }
    
    public List<Paciente> getAllPacientesPorCpf(String cpf) throws SQLException 
    {
        List<Paciente> paciente = new LinkedList<>();
        
        try ( //ResultSet rs = executeQuery("SELECT * FROM medicos WHERE nome_medico like ?", "%"+nome);
                ResultSet rs = executeQuery("SELECT * FROM paciente WHERE cpf like ?",cpf+"%")) {
            while(rs.next())
            {
                paciente.add(populatePaciente(rs));
            }
        }
        return paciente;
    }
    
    public Integer addPaciente(Paciente paciente) throws SQLException
    {
        String query = "INSERT INTO paciente(nome, telefone, cpf, rg, endereco, sexo, convenio) VALUES (?,?,?,?,?,?,?)";
        executeComand(query,  paciente.getNome(), paciente.getTelefone(), paciente.getCpf(), paciente.getRg(), paciente.getEndereco(), paciente.getSexo(), paciente.getConvenio());        
        return paciente.getId();
        
    }
    
    public void updatePaciente(Paciente paciente) throws SQLException
    {
        String query = "UPDATE paciente SET nome = ?, telefone = ?, cpf = ?, rg = ?, endereco = ?, sexo = ?, convenio = ? WHERE id =?";
        executeComand(query,  paciente.getNome(), paciente.getTelefone(), paciente.getCpf(), paciente.getRg(), paciente.getEndereco(), paciente.getSexo(), paciente.getConvenio(), paciente.getId());        
        
    }
    
    public void deletePaciente(Paciente paciente) throws SQLException{
        String query = "DELETE FROM paciente WHERE id = ? ";
        executeComand(query, paciente.getId());
        
        
    }
    
        private Paciente populatePaciente(ResultSet rs) throws SQLException {
        Paciente retorno = new Paciente();
        
        retorno.setId(Integer.valueOf(rs.getString("id")));
        retorno.setNome(rs.getString("nome"));
        retorno.setTelefone(rs.getString("telefone"));
        retorno.setCpf(rs.getString("cpf"));
        retorno.setRg(rs.getString("rg"));
        retorno.setEndereco(rs.getString("endereco"));
        retorno.setSexo(rs.getString("sexo"));
        retorno.setConvenio(rs.getString("convenio"));
        
        
        return retorno;
        
    }
    
    
}
