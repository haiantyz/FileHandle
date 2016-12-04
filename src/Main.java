import java.io.*;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by tyz on 2016/11/21.
 */
public class Main {
    static int verticesnumber = 1134890;
    static Vertice[] vertices = new Vertice[verticesnumber];
    static TreeSet verticeSet = new TreeSet(new VerticeComparator());
    public static StringBuilder readFromFile(String filename) throws IOException {
        StringBuilder s = new StringBuilder();
        BufferedInputStream bufferedinput = null;
        byte[] buffer = new byte[1024];
        try{
        bufferedinput = new BufferedInputStream(new FileInputStream(filename));
        int bytesRead = 0;
        while((bytesRead = bufferedinput.read(buffer))!=-1){
            String chunk = new String(buffer,0,bytesRead);
            s.append(chunk);
        }
        } catch (FileNotFoundException e) {
        e.printStackTrace();
     } catch (IOException e) {
        e.printStackTrace();
    }finally {
        if (bufferedinput != null)
            bufferedinput.close();

    }
    return s;
}

    public static void VerticeInitial(){
        for (int i=0;i<verticesnumber;i++){
            vertices[i] = new Vertice();
        }
    }

    public static void getVerticeNeighbor(StringBuilder stringBuilder) throws IOException {
        String[] line = readFromFile(stringBuilder.toString()).toString().split("\n");

        for (int i = 0;i<line.length;i++){
            String[] line33 = line[i].split("\t");
            int j = Integer.parseInt(line33[0])-1;
            int l = Integer.parseInt(line33[1])-1;
            Vertice vertice = new Vertice();
            Vertice vertice1 = new Vertice();
            vertice.setTrueverticeid(j);
            vertice1.setTrueverticeid(l);
            verticeSet.add(vertice);
            verticeSet.add(vertice1);
        }
    }

    public static void resetVerticeNeighbor(StringBuilder stringBuilder) throws IOException {
        String[] line = readFromFile(stringBuilder.toString()).toString().split("\n");
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/tyz/IdeaProjects/FileHandle/src/comyoutubereset");
        PrintStream printStream = new PrintStream(fileOutputStream);
        for (int i = 0;i<line.length;i++){
            String[] line33 = line[i].split("\t");
            int j = Integer.parseInt(line33[0])-1;
            int l = Integer.parseInt(line33[1])-1;
            for (int fi=0;fi<verticesnumber;fi++){
                if (vertices[fi].getTrueverticeid()==j){
                    printStream.print(vertices[fi].getVerticeid()+" ");
                    break;
                }
            }
            for (int fi=0;fi<verticesnumber;fi++){
                if (vertices[fi].getTrueverticeid()==l){
                    printStream.print(vertices[fi].getVerticeid()+"\n");
                    break;
                }
            }
            printStream.flush();
            printStream.close();
        }
    }

    public static void main(String args[]) throws IOException {
        VerticeInitial();
        getVerticeNeighbor(new StringBuilder("/Users/tyz/Downloads/comytb.txt"));
        System.out.println(verticeSet.size());
        Iterator iterator = verticeSet.iterator();
        int i=0;
        while (iterator.hasNext()){
            Vertice vertice = (Vertice) iterator.next();
            vertices[i].setTrueverticeid(vertice.getTrueverticeid());
            vertices[i].setVerticeid(i);
            i++;
        }
        resetVerticeNeighbor(new StringBuilder("/Users/tyz/Downloads/comytb.txt"));
    }
}
