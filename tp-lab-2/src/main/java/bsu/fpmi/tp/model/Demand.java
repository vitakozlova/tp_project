package bsu.fpmi.tp.model;

import bsu.fpmi.tp.util.TPLabContract;

import javax.persistence.*;

/**
 * @author Vadim Chugunov
 * @since 04.12.2014
 */
@Entity
@Table(name = TPLabContract.DB.Demands.TABLE_NAME)
public class Demand {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = TPLabContract.DB.Demands.ID)
    private Integer id;

    @Column(name = TPLabContract.DB.Demands.CLIENT_NAME, nullable = false)
    private String clientName;

    @Column(name = TPLabContract.DB.Demands.CLIENT_PHONE, nullable = false)
    private String clientPhone;

    @Column(name = TPLabContract.DB.Demands.CLIENT_ADDRESS, nullable = false)
    private String clientAddress;

    @Column(name = TPLabContract.DB.Demands.CLIENT_EMAIL, nullable = false)
    private String clientEmail;

    @Column(name = TPLabContract.DB.Demands.DEMAND_STATE, nullable = false)
    private boolean demandState;

    @Column(name = TPLabContract.DB.Demands.DEMAND_EXECUTE_STATE, nullable = false)
    private boolean demandExecState;

    public Demand() {
    }

    public Demand(boolean demandExecState, boolean demandState, String clientEmail,
                  String clientAddress, String clientPhone, String clientName) {
        this.demandExecState = demandExecState;
        this.demandState = demandState;
        this.clientEmail = clientEmail;
        this.clientAddress = clientAddress;
        this.clientPhone = clientPhone;
        this.clientName = clientName;
    }

    public Integer getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientPhone() {
        return clientPhone;
    }

    public String getClientAddress() {
        return clientAddress;
    }

    public String getClientEmail() {
        return clientEmail;
    }

    public boolean isDemandState() {
        return demandState;
    }

    public boolean isDemandExecState() {
        return demandExecState;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setClientPhone(String clientPhone) {
        this.clientPhone = clientPhone;
    }

    public void setClientAddress(String clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public void setDemandState(boolean demandState) {
        this.demandState = demandState;
    }

    public void setDemandExecState(boolean demandExecState) {
        this.demandExecState = demandExecState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Demand demand = (Demand) o;

        if (demandExecState != demand.demandExecState) return false;
        if (demandState != demand.demandState) return false;
        if (!clientAddress.equals(demand.clientAddress)) return false;
        if (!clientEmail.equals(demand.clientEmail)) return false;
        if (!clientName.equals(demand.clientName)) return false;
        if (!clientPhone.equals(demand.clientPhone)) return false;
        if (!id.equals(demand.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + clientName.hashCode();
        result = 31 * result + clientPhone.hashCode();
        result = 31 * result + clientAddress.hashCode();
        result = 31 * result + clientEmail.hashCode();
        result = 31 * result + (demandState ? 1 : 0);
        result = 31 * result + (demandExecState ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Demand{" +
                "id=" + id +
                ", clientName='" + clientName + '\'' +
                ", clientPhone='" + clientPhone + '\'' +
                ", clientAddress='" + clientAddress + '\'' +
                ", clientEmail='" + clientEmail + '\'' +
                ", demandState=" + demandState +
                ", demandExecState=" + demandExecState +
                '}';
    }
}
