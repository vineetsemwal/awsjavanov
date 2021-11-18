package stringex;

import java.util.Random;

public class RandomIdGenerator {

    Random random = new Random();

    public static void main(String args[]){
        RandomIdGenerator generator=new RandomIdGenerator();
        for (int i=0;i<10;i++){
           String id= generator.generateId();
            System.out.println(id);
        }
    }

    String generateId(){
        StringBuilder builder=new StringBuilder();
        for(int i=0;i<5;i++){
           int num =random.nextInt(100);
           builder.append(num);
        }
        String id=builder.toString();
        return id;
    }

}
