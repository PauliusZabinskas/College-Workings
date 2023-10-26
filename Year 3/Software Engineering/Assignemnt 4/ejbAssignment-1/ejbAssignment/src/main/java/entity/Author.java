/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

/**
 *
 * @author o_molloy
 */
@Entity
@Table(name = "authors")
@NamedQueries(
{
   @NamedQuery(name = "Author.findAll", query = "SELECT a FROM Author a")
})
public class Author implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "authorid")
    private Integer authorid;

    @Size(max = 255)
    @Column(name = "surname")
    private String surname;

    @Size(max = 255)
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "yob")
    private Short yob;

    @Size(max = 255)
    @Column(name = "nationality")
    private String nationality;

    @Lob
    @Size(max = 2147483647)
    @Column(name = "biography")
    private String biography;

    @OneToMany(mappedBy = "authorid")
    private Collection<Book> bookCollection;

    public Author()
    {
    }

    public Author(Integer authorid)
    {
        this.authorid = authorid;
    }

    public Author(Integer authorid, String surname, String firstname, Short yob, String nationality, String biography, Collection<Book> bookCollection)
    {
        this.authorid = authorid;
        this.surname = surname;
        this.firstname = firstname;
        this.yob = yob;
        this.nationality = nationality;
        this.biography = biography;
        this.bookCollection = bookCollection;
    }

    public Integer getAuthorid()
    {
        return authorid;
    }

    public void setAuthorid(Integer authorid)
    {
        this.authorid = authorid;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getFirstname()
    {
        return firstname;
    }

    public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }

    public Short getYob()
    {
        return yob;
    }

    public void setYob(Short yob)
    {
        this.yob = yob;
    }

    public String getNationality()
    {
        return nationality;
    }

    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }

    public String getBiography()
    {
        return biography;
    }

    public void setBiography(String biography)
    {
        this.biography = biography;
    }

    public Collection<Book> getBookCollection()
    {
        return bookCollection;
    }

    public void setBookCollection(Collection<Book> bookCollection)
    {
        this.bookCollection = bookCollection;
    }

    
    
    
}
