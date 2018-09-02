package Files;

import java.util.Map;

public abstract class File {
	private String Name;
	private String Route;
	
	public String getName() {
		return Name;
	}
	public void setName(String pName) {
		Name = pName;
	}
	public String getRoute() {
		return Route;
	}
	public void setRoute(String pRoute) {
		Route = pRoute;
	}
	public abstract Map<String, Integer> parse(File file);

}
