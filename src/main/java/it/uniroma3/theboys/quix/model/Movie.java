package it.uniroma3.theboys.quix.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity	
public class Movie { //con @Entity il framework sa che a Movie bisogna associare una tabella nel database
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	//ogni volta che viene inserita un'entità 'Movie' nella tabella deve esserci la chiave 'id'
	private Long id;	//chiave primaria	
	
	private String title;
	private Integer year;
	private String urlImage;

	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return this.id;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setYear(Integer year) {
		this.year = year;
	}
	
	public Integer getYear() {
		return this.year;
	}
	
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
	public String getUrlImage() {
		return this.urlImage;
	}

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Movie other = (Movie) obj;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        return true;
    }


}