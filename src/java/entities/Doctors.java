/*
 * Лабораторна робота 3
 * ORM для таблиці doctors
 * Використання анотацій @Entityб @Table, @NamedQuery
 *  @GeneratedValue, @Basic, @Column
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "doctors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Doctors.findAll", query = "SELECT d FROM Doctors d")
    , @NamedQuery(name = "Doctors.findById", query = "SELECT d FROM Doctors d WHERE d.id = :id")
    , @NamedQuery(name = "Doctors.findBySpec", query = "SELECT d FROM Doctors d WHERE d.spec = :spec")
    , @NamedQuery(name = "Doctors.findByName", query = "SELECT d FROM Doctors d WHERE d.name = :name")})
public class Doctors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 32)
    @Column(name = "spec")
    private String spec;
    @Size(max = 128)
    @Column(name = "name")
    private String name;

    public Doctors() {
    }

    public Doctors(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(object instanceof Doctors)) {
            return false;
        }
        Doctors other = (Doctors) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Doctors[ id=" + id + " ]";
    }
    
}
