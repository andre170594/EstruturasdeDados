package testemoodle2;

import java.util.Date;

public class Organizacao {
    int numQueixas;
    Date dataUltimaAuditoria;

    public Organizacao(int numQueixas, Date dataUltimaAuditoria) {
        this.numQueixas = numQueixas;
        this.dataUltimaAuditoria = dataUltimaAuditoria;
    }

    public int getNumQueixas() {
        return numQueixas;
    }

    public void setNumQueixas(int numQueixas) {
        this.numQueixas = numQueixas;
    }

    public Date getDataUltimaAuditoria() {
        return dataUltimaAuditoria;
    }

    public void setDataUltimaAuditoria(Date dataUltimaAuditoria) {
        this.dataUltimaAuditoria = dataUltimaAuditoria;
    }
}
