package mud;

public class NPC{
	private String id;
	private String username;
	private String place;
	private String message;
	public NPC(String id,String username,String place) {
		this.id=id;
		this.username=username;
		this.place=place;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
