package board;

public class BoardVO {
	private	String no;
	private	String poster;
	private	String subject;
	private	String contents;
	private	String lastpost;
	private	String views;
	private	String filename;
	
	
	
	@Override
	public String toString() {
		return "boardVO [no=" + no + ", poster=" + poster + ", subject=" + subject + ", contents=" + contents
				+ ", lastpost=" + lastpost + ", views=" + views + ", filename=" + filename + "]";
	}
	
	
	public BoardVO(String no, String poster, String subject, String contents, String lastpost, String views,
			String filename) {
		super();
		this.no = no;
		this.poster = poster;
		this.subject = subject;
		this.contents = contents;
		this.lastpost = lastpost;
		this.views = views;
		this.filename = filename;
	}
	public BoardVO() {
		super();
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getLastpost() {
		return lastpost;
	}
	public void setLastpost(String lastpost) {
		this.lastpost = lastpost;
	}
	public String getViews() {
		return views;
	}
	public void setViews(String views) {
		this.views = views;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	
	
}
