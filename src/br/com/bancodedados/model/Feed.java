package br.com.bancodedados.model;

public class Feed {
	private long id;
	private String title;
	private String subtitle;
	private String content;
	
	public Feed() {}
	
	public Feed(long id, String title, String subtitle, String content) {
		super();
		this.id = id;
		this.title = title;
		this.subtitle = subtitle;
		this.content = content;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getSubtitle() {
		return subtitle;
	}
	
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
}
