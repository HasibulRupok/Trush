import java.util.*;

public class QUEQE {
    public static void main(String[] args) {
//        Queue<Integer> q = new LinkedList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>();     // Ascending order
//        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());     // Descending order
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);

//        System.out.println(q);

        PriorityQueue<students> pQueue = new PriorityQueue<>(new studentComparator());
        pQueue.add(new students(2.50, "Matlob"));
        pQueue.add(new students(3.5, "Anonymus"));
        pQueue.add(new students(3.99, "Rupok"));

        Iterator i =  pQueue.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }

        for (Object x: pQueue){
            System.out.println(x.toString());
        }
    }
}

class studentComparator implements Comparator<students>{

    @Override
    public int compare(students o1, students o2) {
        if (o1.cgpa > o2.cgpa) return -1;
        else if (o2.cgpa > o1.cgpa) return 1;
        return 0;
    }
}

class students{
    public double cgpa;
    public String name;

    public students(double cgpa, String name) {
        this.cgpa = cgpa;
        this.name = name;
    }
    public void getName(){
        System.out.println(name);
    }
}
