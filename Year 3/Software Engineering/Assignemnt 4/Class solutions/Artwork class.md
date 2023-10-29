```java
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

/**
 *
 * @author o_molloy
 */
@Entity
@Table(name = "artworks")
@NamedQueries(
{
    @NamedQuery(name = "Artwork.findAll", query = "SELECT b FROM Artwork b")
})
public class Artswork implements Serializable
{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "artworkid")
    private Integer artworkid;
    
    @Size(max = 255)
    @Column(name = "title")
    private String title;

	@Size(max = 255)
    @Column(name = "description")
    private String description;

	@Size(max = 255)
    @Column(name = "medium")
    private String medium;
    
    @Size(max = 255)
    @Column(name = "imagename")
    private String imagename;
      
    @JoinColumn(name = "artistid", referencedColumnName = "artistid")
    @ManyToOne
    private Artist artistid;

    public Artswork()
    {
    }

    public Artswork(Integer artworkid)
    {
        this.artworkid = artworkid;
    }

    public Artswork(Integer artworkid, String imagename, String title, String coverimage, Artist artistid)
    {
        this.artworkid = artworkid;
        this.title = title;
        this.coverimage = coverimage;
        this.artistid = artistid;
        this.imagename = imagename;
    }



    public Integer getBookid()
    {
        return artworkid;
    }

    public void setBookid(Integer artworkid)
    {
        this.artworkid = artworkid;
    }

    public Short getYear()
    {
        return year;
    }

    public void setYear(Short year)
    {
        this.year = year;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Artist getAuthor()
    {
        return artistid;
    }

    public void setAuthor(Artist artistid)
    {
        this.artistid = artistid;
    }

    public String getCoverimage()
    {
        return coverimage;
    }

    public void setCoverimage(String coverimage)
    {
        this.coverimage = coverimage;
    }


    
}

```