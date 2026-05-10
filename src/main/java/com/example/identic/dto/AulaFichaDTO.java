package com.example.identic.dto;

public class AulaFichaDTO {

    private Long aulaId;
    private Long fichaId;

    public AulaFichaDTO() {
    }

    public AulaFichaDTO(Long aulaId, Long fichaId) {
        this.aulaId = aulaId;
        this.fichaId = fichaId;
    }

    public Long getAulaId() {
        return aulaId;
    }

    public void setAulaId(Long aulaId) {
        this.aulaId = aulaId;
    }

    public Long getFichaId() {
        return fichaId;
    }

    public void setFichaId(Long fichaId) {
        this.fichaId = fichaId;
    }
}