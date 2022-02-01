import java.util.*;

class Freq{
    private int value;
    private int count;
    public void setValue(int value){this.value=value;}
    public void setCount(int count){this.count=count;}
    public int getValue(){return value;}
    public int getCount(){return count;}
}

class CountComparator implements Comparator<Freq> {
    @Override
    public int compare(Freq a, Freq b) {
        return a.getCount() < b.getCount() ? 1 : a.getCount() == b.getCount() ? 0 : -1;
    }
}
public class Main {
    public static void main(String[] args) {
        int[] arr = {4, 4, 2, 2, 2, 2, 3, 3, 1, 1, 6, 7, 5};
        List<Freq> freq = new ArrayList<>();

        Arrays.sort(arr);
        int count = 1;
        int j = 1;
        for (; j < arr.length; j++) {
            if (arr[j] == arr[j - 1]) count++;
            else {
                Freq a = new Freq();
                a.setValue(arr[j - 1]);
                a.setCount(count);
                freq.add(a);
                count = 1;
            }
        }
        Freq a = new Freq();
        a.setValue(arr[arr.length - 1]);
        a.setCount(count);
        freq.add(a);

        Collections.sort(freq, new CountComparator());
//
//
        int m=0;
        int index = 0;
        for (int k = 0; k < arr.length;) {
            for (m = 0; m < freq.get(index).getCount(); m++) {
                arr[k] = freq.get(index).getValue();
                k++;
            }
            index++;

        }

        for(int ll: arr){
            System.out.print(ll);
            System.out.print(" ");
        }


    }
}
