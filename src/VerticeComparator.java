import java.util.Comparator;

/**
 * Created by tyz on 2016/12/3.
 */
public class VerticeComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Vertice vertice = (Vertice) o1;
        Vertice vertice1 = (Vertice) o2;
        if (vertice.getTrueverticeid()==vertice1.getTrueverticeid())
            return 0;

        return vertice.getTrueverticeid()-vertice1.getTrueverticeid();
    }
}
