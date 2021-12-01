/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package solent_campers.Modal;

/**
 *
 * @author asus
 */
public class camper_vans {

    public int getCv_id() {
        return cv_id;
    }

    public void setCv_id(int cv_id) {
        this.cv_id = cv_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

int cv_id=0;
String type="";
String status="";

public camper_vans(int id, String tp, String sts)
{
    cv_id=id;
    type=tp;
    status=sts;
}

public camper_vans getData()
{
    return new camper_vans(this.cv_id,this.type, this.status);
}
}

