package resources;

import java.util.ArrayList;
import java.util.List;

import POJO.AddPlace;

public class TestDataBuild {

public AddPlace addPlacePayload(String name, String language, String address)
{
	AddPlace  p = new AddPlace();
	p.setAccuracy(50);
	p.setName(name);
	p.setPhone_number("(+91) 983 893 3937");	
	p.setAddress(address);
	p.setWebsite("https://rahulshettyacademy.com");	
	p.setLanguage(language);
	
	List<String> mylist = new ArrayList<String>();
	mylist.add("shoe park");
	mylist.add("shop");
	p.setTypes(mylist);

	POJO.Location l = new POJO.Location();
	l.setLat(-38.383494);
	l.setLng(33.427362);
	p.setLocation(l);
    return p;	
}
	
}
