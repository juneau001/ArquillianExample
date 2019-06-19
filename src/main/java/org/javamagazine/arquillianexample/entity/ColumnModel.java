/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.javamagazine.arquillianexample.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Juneau
 */
@Entity
@Table(name = "COLUMN_MODEL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ColumnModel.findAll", query = "SELECT c FROM ColumnModel c"),
    @NamedQuery(name = "ColumnModel.findById", query = "SELECT c FROM ColumnModel c WHERE c.id = :id"),
    @NamedQuery(name = "ColumnModel.findByColumnName", query = "SELECT c FROM ColumnModel c WHERE c.columnName = :columnName"),
    @NamedQuery(name = "ColumnModel.findByColumnLabel", query = "SELECT c FROM ColumnModel c WHERE c.columnLabel = :columnLabel")})
public class ColumnModel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 30)
    @Column(name = "COLUMN_NAME")
    private String columnName;
    @Size(max = 150)
    @Column(name = "COLUMN_LABEL")
    private String columnLabel;

    public ColumnModel() {
    }

    public ColumnModel(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnLabel() {
        return columnLabel;
    }

    public void setColumnLabel(String columnLabel) {
        this.columnLabel = columnLabel;
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
        if (!(object instanceof ColumnModel)) {
            return false;
        }
        ColumnModel other = (ColumnModel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.javamagazine.arquillianexample.entity.ColumnModel[ id=" + id + " ]";
    }
    
}
