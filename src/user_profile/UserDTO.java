package user_profile;

public class UserDTO {
	private String id;
	private String name;
	private String phone;
	private String birth_date;

	public UserDTO() {
		super();
	}

	public UserDTO(String id, String name, String phone, String birth_date) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.birth_date = birth_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBirth_date() {
		return birth_date;
	}

	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}

	@Override
	public String toString() {
		return "UserDTO [id=" + id + ", name=" + name + ", phone=" + phone + ", birth_date=" + birth_date + "]";
	}

}
