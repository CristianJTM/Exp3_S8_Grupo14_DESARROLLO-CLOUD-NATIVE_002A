package com.duoc.transportmanagement.dto;

public class TransportistaMessageDTO {
    private String operacion;

    private Long id;

    private TransportistaDTO transportista;

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TransportistaDTO getTransportista() {
        return transportista;
    }

    public void setTransportistaDTO(TransportistaDTO transportista) {
        this.transportista = transportista;
    }
}
