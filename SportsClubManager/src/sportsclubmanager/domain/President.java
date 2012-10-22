/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sportsclubmanager.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Markus Mohanty <markus.mo at gmx.net>
 */
@Entity
@Table(name = "President")
@XmlRootElement
public class President implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idMember")
    private Integer idMember;
    @Basic(optional = false)
    @Column(name = "PresidentFrom")
    @Temporal(TemporalType.DATE)
    private Date presidentFrom;
    @Column(name = "PresidentTo")
    @Temporal(TemporalType.DATE)
    private Date presidentTo;
    @JoinColumn(name = "idMember", referencedColumnName = "idMember", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Member1 member1;

    public President()
    {
    }

    public President(Integer idMember)
    {
        this.idMember = idMember;
    }

    public President(Integer idMember, Date presidentFrom)
    {
        this.idMember = idMember;
        this.presidentFrom = presidentFrom;
    }

    public Integer getIdMember()
    {
        return idMember;
    }

    public void setIdMember(Integer idMember)
    {
        this.idMember = idMember;
    }

    public Date getPresidentFrom()
    {
        return presidentFrom;
    }

    public void setPresidentFrom(Date presidentFrom)
    {
        this.presidentFrom = presidentFrom;
    }

    public Date getPresidentTo()
    {
        return presidentTo;
    }

    public void setPresidentTo(Date presidentTo)
    {
        this.presidentTo = presidentTo;
    }

    public Member1 getMember1()
    {
        return member1;
    }

    public void setMember1(Member1 member1)
    {
        this.member1 = member1;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idMember != null ? idMember.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof President))
        {
            return false;
        }
        President other = (President) object;
        if ((this.idMember == null && other.idMember != null) || (this.idMember != null && !this.idMember.equals(other.idMember)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "sportsclubmanager.domain.President[ idMember=" + idMember + " ]";
    }
    
}
