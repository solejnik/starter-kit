package pl.spring.demo.criteriasearch;

public class BookSearchCriteria {
	private String title; 		//4
	private String author;		//2
	private String libraryName;	//1

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getLibraryName() {
		return libraryName;
	}

	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	protected BookSearchCriteria(){}
	
	public BookSearchCriteria(String title, String author, String libraryName) {
		this.title = title;
		this.author = author;
		this.libraryName = libraryName;
	}

	public int getCriteriaValue(){
		int value = -1;
		if(title != null && !title.equals("") && author != null && !author.equals("") && libraryName != null && !libraryName.equals("")){
			value = 7;
		}else if(title != null && !title.equals("") &&author != null && !author.equals("")){
			value = 6;
		}else if(title != null && !title.equals("") &&libraryName != null && !libraryName.equals("")){
			value = 5;
		}else if(title != null && !title.equals("") ){
			value = 4;
		}else if((author != null && !author.equals(""))&&(libraryName != null && !libraryName.equals(""))){
			value = 3;
		}else if(author != null && !author.equals("")){
			value = 2;
		}else if(libraryName != null && !libraryName.equals("")){
			value = 1;
		}else if((title == null || title.equals("") )&& (author == null || author.equals("")) && (libraryName == null || libraryName.equals(""))){
			value = 0;
		}
		return value;
	}
}
