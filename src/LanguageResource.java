import java.io.Serializable;


public class LanguageResource implements Serializable{

	private static final long serialVersionUID = -550355141840511935L;
	
	private String key;
	
	private String value;
	

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
