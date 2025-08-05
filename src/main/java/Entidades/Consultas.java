/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author Jonas Pereira
 */
public class Consultas {
    int idConsulta;
    int idPaciente;
    int idDoctor;
    String data;
    String hora;

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idAgenda) {
        this.idConsulta = idAgenda;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    
}
