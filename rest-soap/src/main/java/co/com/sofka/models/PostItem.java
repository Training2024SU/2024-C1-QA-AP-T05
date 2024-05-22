package co.com.sofka.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PostItem {
	private int userId;
	private int id;
	private String title;

	public PostItem(int userId, int id, String title) {
		this.userId = userId;
		this.id = id;
		this.title = title;
	}

	public PostItem() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "PostItem{" +
				"userId=" + userId +
				", id=" + id +
				", title='" + title + '\'' +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		PostItem postItem = (PostItem) o;
		return userId == postItem.userId && id == postItem.id && Objects.equals(title, postItem.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userId, id, title);
	}
}
