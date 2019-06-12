/**
 *
 */
package com.sukkiri.test2;

import java.util.Date;

/**
 * @author user2
 *
 */
public class Book implements Comparable<Book>, Cloneable {
	private String title;
	private Date publishDate;
	private String comment;

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Book)) {
			return false;
		}
		Book o = (Book) obj;
		if (!(o.getTitle().equals(this.title) && o.getPublishDate().equals(this.publishDate))) {
			return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int result = 47;
		result += this.title.hashCode() + this.publishDate.hashCode() + this.comment.hashCode();
		return result;
	}

	@Override
	public int compareTo(Book obj) {
		//		if (this.publishDate.getTime() < obj.publishDate.getTime()) {
		//			return -1;
		//		} else if (this.publishDate.getTime() > obj.publishDate.getTime()) {
		//			return 1;
		//		}
		//		return 0;
		return this.publishDate.compareTo(obj.publishDate);
	}

	public Book clone() {
		Book book = new Book();
		book.title = this.title;
		book.publishDate = (Date) this.publishDate.clone();
		book.comment = this.comment;

		return book;
	}

	// getter/setter
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
