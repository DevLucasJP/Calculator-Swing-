package calculadora.swing.frontend;

public enum KeyboardEvents {
	
	C("C"), SC1("()"), SC2("%"), SC3("/"), N1("1"), N2("2");
	
	private String value;
	
	private KeyboardEvents(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
