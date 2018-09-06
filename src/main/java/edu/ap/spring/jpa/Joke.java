package edu.ap.spring.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Joke {

	@Id
    @GeneratedValue
    private Long id;
	
    @Column
	private String joke;
	
	public Joke(String joke) {
		this.joke = joke;
	}

	public String getJoke() {
		return joke;
	}

	public void setJoke(String joke) {
		this.joke = joke;
	}
		   
	@Override
	public String toString() {
	    return "Joke: " + this.getJoke();
	} 
}
