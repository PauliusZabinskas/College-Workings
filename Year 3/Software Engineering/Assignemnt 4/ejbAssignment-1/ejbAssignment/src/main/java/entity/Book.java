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
@Table(name = "books")
@NamedQueries(
{
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
})
public class Book implements Serializable
{

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "bookid")
    private Integer bookid;
    
    @Column(name = "year")
    private Short year;
    
    @Size(max = 255)
    @Column(name = "title")
    private String title;
    
    @Size(max = 255)
    @Column(name = "coverimage")
    private String coverimage;
      
    @JoinColumn(name = "authorid", referencedColumnName = "authorid")
    @ManyToOne
    private Author authorid;

    public Book()
    {
    }

    public Book(Integer bookid)
    {
        this.bookid = bookid;
    }

    public Book(Integer bookid, Short year, String title, String coverimage, Author authorid)
    {
        this.bookid = bookid;
        this.year = year;
        this.title = title;
        this.coverimage = coverimage;
        this.authorid = authorid;
    }



    public Integer getBookid()
    {
        return bookid;
    }

    public void setBookid(Integer bookid)
    {
        this.bookid = bookid;
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

    public Author getAuthor()
    {
        return authorid;
    }

    public void setAuthor(Author authorid)
    {
        this.authorid = authorid;
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
