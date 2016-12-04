/**
 * Created by tyz on 2016/12/3.
 */
public class Vertice {
    private int verticeid;
    private int trueverticeid;
    public Vertice(int verticeid, int trueverticeid){
        this.verticeid = verticeid;
        this.trueverticeid = trueverticeid;
    }
    public Vertice(){

    }

    public int getVerticeid() {
        return verticeid;
    }

    public void setVerticeid(int verticeid) {
        this.verticeid = verticeid;
    }

    public int getTrueverticeid() {
        return trueverticeid;
    }

    public void setTrueverticeid(int trueverticeid) {
        this.trueverticeid = trueverticeid;
    }
}
