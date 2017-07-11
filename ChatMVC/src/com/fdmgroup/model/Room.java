package com.fdmgroup.model;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name ="C_ROOM")
@NamedQueries({
	@NamedQuery(name = "room.findAll", query = "SELECT r FROM Room r"),
	@NamedQuery(name = "room.findById", query = "SELECT r FROM Room r WHERE r.id= :rid "),
	@NamedQuery(name = "room.findByRoomname", query = "SELECT r FROM Room r WHERE r.title= :rtitle "),
	@NamedQuery(name = "room.findByStatus", query = "SELECT r FROM Room r WHERE UPPER(r.status)= :status ")
})
public class Room implements IStorable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
//	@Column(nullable =false, unique=true)
//	private String roomUrl;
	
	@Column
	private String title;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Calendar dateCreated;
	
	@Column
	private String status;
	
	@ManyToOne
	private User owner;
	
	@ManyToMany
	@JoinTable(
		      name="C_ROOM_USERS",
		      joinColumns=
		      @JoinColumn(name="ROOM_ID", referencedColumnName="ID"),
		      inverseJoinColumns=@JoinColumn(name="USER_ID", referencedColumnName="ID"))
	private List<User> usersInvited;

	
	@OneToOne
	private Chat chat;
	
	public Room() {
		super();
	}

	public Room(String title, Calendar dateCreated, String status) {
		this();
		this.title = title;
		this.dateCreated = dateCreated;
		this.status = status;
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

	public Calendar getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Calendar dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public List<User> getUsersInvited() {
		return usersInvited;
	}

	public void setUsersInvited(List<User> usersInvited) {
		this.usersInvited = usersInvited;
	}
	
	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", title=" + title + ", dateCreated=" + dateCreated + ", status=" + status + "]";
	}
	
	

	
	

}
