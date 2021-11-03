package equalsdemo;

public class Employee {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *  Employee e1=new Employee();
     *  e1.setId(1)
     *  e1.setName("prachi");
     *  Employee e2= new Employee();
     *  e1.equals(e2)
     *
     */
    @Override
    public boolean equals(Object that) {
        if(that==this){
            return true;
        }
        if(that==null || !(that instanceof Employee)){
            return false;
        }
        Employee thatEmp=(Employee)that;
        boolean flag= this.id == thatEmp.id;
        return flag;
    }
}
