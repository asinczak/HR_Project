package pl.com.ttpsc.kursjava.data;

import pl.com.ttpsc.kursjava.services.FileService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement (name = "Employees")
@XmlAccessorType (XmlAccessType.FIELD)
public class Employees {

    @XmlElement (name = "Employee")
   private List<Employee> list = FileService.getInstance().readObject();

    public List<Employee> getList () {
        return list;
    }

    public void setList (List <Employee> list){
        this.list = list;
    }
}
