```java
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
@Table(name = "artists")
@NamedQueries(
{
   @NamedQuery(name = "Artist.findAll", query = "SELECT a FROM Artist a")
})
public class Artist implements Serializable
{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artistid")
    private Integer artistid;

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

    @OneToMany(mappedBy = "artistid")
    private Collection<Book> bookCollection;

    public Artist()
    {
    }

    public Artist(Integer artistid)
    {
        this.artistid = artistid;
    }

    public Artist(Integer artistid, String surname, String firstname, Short yob, String nationality, String biography, Collection<Book> bookCollection)
    {
        this.artistid = artistid;
        this.surname = surname;
        this.firstname = firstname;
        this.yob = yob;
        this.nationality = nationality;
        this.biography = biography;
        this.bookCollection = bookCollection;
    }

    public Integer getArtistid()
    {
        return artistid;
    }

    public void setAuthorid(Integer artistid)
    {
        this.artistid = artistid;
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


```