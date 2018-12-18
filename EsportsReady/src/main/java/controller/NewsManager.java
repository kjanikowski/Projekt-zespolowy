package controller;

import java.util.ArrayList;
import java.util.List;

import domain.News;

public class NewsManager {
	
	List<News> list = new ArrayList<News>();
	
	public void addNews(News news) {
		list.add(news);
	}
	
	public List<News> getAll() {
		return list;
	}
	
	

}
