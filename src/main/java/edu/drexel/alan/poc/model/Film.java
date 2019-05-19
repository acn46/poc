package edu.drexel.alan.poc.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity(name="Film")
@Table(name="film")
@NamedQuery(name="Film.findAll", query="SELECT f FROM Film f")
public class Film implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="film_id")
	private int filmId;
	
	@Column(name="title")
	private String title;

	@Column(name="description")
	private String description;
	
	@Column(name="release_year")
	private int releaseYear;

	@Column(name="language_id")
	private int languageId;
	
	@Column(name="original_language_id")
	private int originalLanguageId;
	
	@Column(name="rental_duration")
	private int rentalDuration;
	
	@Column(name="rental_rate")
	private double rentalRate;
	
	@Column(name="length")
	private double length;
	
	@Column(name="replacement_cost")
	private double replacementCost;
	
	@Column(name="rating")
	private String rating;
	
	@Column(name="special_features")
	private String specialFeatures;
	
	@Column(name="last_update")
	private Date lastUpdate;

	public int getFilmId() {
		return filmId;
	}

	public void setFilmId(int filmId) {
		this.filmId = filmId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(int releaseYear) {
		this.releaseYear = releaseYear;
	}

	public int getLanguageId() {
		return languageId;
	}

	public void setLanguageId(int languageId) {
		this.languageId = languageId;
	}

	public int getOriginalLanguageId() {
		return originalLanguageId;
	}

	public void setOriginalLanguageId(int originalLanguageId) {
		this.originalLanguageId = originalLanguageId;
	}

	public int getRentalDuration() {
		return rentalDuration;
	}

	public void setRentalDuration(int rentalDuration) {
		this.rentalDuration = rentalDuration;
	}

	public double getRentalRate() {
		return rentalRate;
	}

	public void setRentalRate(double rentalRate) {
		this.rentalRate = rentalRate;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	public double getReplacementCost() {
		return replacementCost;
	}

	public void setReplacementCost(double replacementCost) {
		this.replacementCost = replacementCost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecialFeatures() {
		return specialFeatures;
	}

	public void setSpecialFeatures(String specialFeatures) {
		this.specialFeatures = specialFeatures;
	}

	public Date getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Film [filmId=" + filmId + ", title=" + title + ", description=" + description + ", releaseYear="
				+ releaseYear + ", languageId=" + languageId + ", originalLanguageId=" + originalLanguageId
				+ ", rentalDuration=" + rentalDuration + ", rentalRate=" + rentalRate + ", length=" + length
				+ ", replacementCost=" + replacementCost + ", rating=" + rating + ", specialFeatures=" + specialFeatures
				+ ", lastUpdate=" + lastUpdate + "]";
	}

}
