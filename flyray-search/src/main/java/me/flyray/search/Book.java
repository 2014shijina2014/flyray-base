package me.flyray.search;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldIndex;
import org.springframework.data.elasticsearch.annotations.FieldType;


@Document(indexName= "book", type= "book", indexStoreType = /*"fs"*/"memory", shards = 1, replicas = 0, refreshInterval = "-1")
public class Book{

	@Id
	private Integer id;
	private String name;
	private String desc;
	private String url;
	private String pubdate;
	private String pubinfo;
	@Field(type=FieldType.Nested)
	private Author author;
	private Double price;
	
	public Book() {
		
	}
	
	public Book(Integer id, String name, String desc, String url, String pubdate,
			String pubinfo, Author author, Double price) {
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.url = url;
		this.pubdate = pubdate;
		this.pubinfo = pubinfo;
		this.author = author;
		this.price = price;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPubdate() {
		return pubdate;
	}
	public void setPubdate(String pubdate) {
		this.pubdate = pubdate;
	}
	
	public String getPubinfo() {
		return pubinfo;
	}

	public void setPubinfo(String pubinfo) {
		this.pubinfo = pubinfo;
	}

	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", desc=" + desc
				+ ", url=" + url + ", pubdate=" + pubdate + ", pubinfo="
				+ pubinfo + ", author=" + author + ", price=" + price + "]";
	}
	
	
	
}
