/*
 * Лабораторна робота 3
 * ORM для таблиці jrnl
 * Використання анотацій @Entityб @Table, @NamedQuery
 *  @GeneratedValue, @Basic, @Column
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "jrnl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Jrnl.findAll", query = "SELECT j FROM Jrnl j")
    , @NamedQuery(name = "Jrnl.findById", query = "SELECT j FROM Jrnl j WHERE j.id = :id")
    , @NamedQuery(name = "Jrnl.findByIdDoctor", query = "SELECT j FROM Jrnl j WHERE j.idDoctor = :idDoctor")
    , @NamedQuery(name = "Jrnl.findByIdClient", query = "SELECT j FROM Jrnl j WHERE j.idClient = :idClient")
    , @NamedQuery(name = "Jrnl.findByDt", query = "SELECT j FROM Jrnl j WHERE j.dt = :dt")})
public class Jrnl implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_doctor")
    private Integer idDoctor;
    @Column(name = "id_client")
    private Integer idClient;
    @Column(name = "dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dt;

    public Jrnl() {
    }

    public Jrnl(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(Integer idDoctor) {
        this.idDoctor = idDoctor;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public Date getDt() {
        return dt;
    }

    public void setDt(Date dt) {
        this.dt = dt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Jrnl)) {
            return false;
        }
        Jrnl other = (Jrnl) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Jrnl[ id=" + id + " ]";
    }
    
}
