package com.revature.data;

public class GenreDAOFactory {
	public GenreDAO getGenreDAO() {
        
        return new GenreHibernate();
    }
}