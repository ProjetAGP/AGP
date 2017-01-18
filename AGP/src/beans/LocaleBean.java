package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

@ManagedBean
@SessionScoped
public class LocaleBean implements Serializable {
	private static final Locale FRENCH = new Locale("fr");
	private static final Locale ENGLISH = new Locale("en");
	private boolean isFrench = true;

	private static final long serialVersionUID = 2445857995867139269L;

	private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void setLanguage(String language) {
		locale = new Locale(language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

	public Locale getLocale() {
		return locale;
	}

	public List<SelectItem> getLocales() {
		System.out.println(locale.getCountry());
		List<SelectItem> items = new ArrayList<SelectItem>();
		
		Application application = FacesContext.getCurrentInstance().getApplication();
		Iterator<Locale> supportedLocales = application.getSupportedLocales();
		while (supportedLocales.hasNext()) {
			Locale locale = supportedLocales.next();
			items.add(new SelectItem(locale.getLanguage(), locale.getDisplayName()));
		}

		return items;
	}

	public void swapLocale(ActionEvent event) {
		isFrench = !isFrench;
		if (isFrench) {
			locale = FRENCH;
		} else {
			locale = ENGLISH;
		}
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}

}
