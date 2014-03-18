import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


public class SortedResourceBundle {
	private  List<LanguageResource> languageResourceList = new ArrayList<LanguageResource>();
	private  ResourceBundle resourceBundle;
	private  String propBaseName;
	private  Collator collator;
	
	public SortedResourceBundle(String propBaseName){
		this.propBaseName = propBaseName;
		collator = Collator.getInstance();
		resourceBundle = ResourceBundle.getBundle(propBaseName);
	}
	
	public SortedResourceBundle(String propBaseName,Locale locale){
		this.propBaseName = propBaseName;
		collator = Collator.getInstance(locale);
		resourceBundle = ResourceBundle.getBundle(propBaseName, locale);
	}

	public  List<LanguageResource> getList(){
		for (Enumeration<String> e = this.resourceBundle.getKeys(); e.hasMoreElements();){
			LanguageResource lr = new LanguageResource();
			String key = e.nextElement();
			lr.setKey(key);
			lr.setValue(resourceBundle.getString(key));
			languageResourceList.add(lr);
		}
		return this.languageResourceList;
	}
	
	public  void sort(){
		ResourceBundleComparator comp = new ResourceBundleComparator();
		comp.setCollator(this.collator);
		Collections.sort(languageResourceList, comp);
	}
	
	public static String getValue(String key){
		return null;
	}
	
	public List<LanguageResource> getSortList(){
		this.getList();
		this.sort();
		return this.languageResourceList;
	}


	public List<LanguageResource> getLanguageResourceList() {
		return languageResourceList;
	}

	public void setLanguageResourceList(List<LanguageResource> languageResourceList) {
		this.languageResourceList = languageResourceList;
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
	}

	public String getPropBaseName() {
		return propBaseName;
	}

	public void setPropBaseName(String propBaseName) {
		this.propBaseName = propBaseName;
	}

	public Collator getCollator() {
		return collator;
	}

	public void setCollator(Collator collator) {
		this.collator = collator;
	}
	
}
