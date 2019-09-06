/**
 * @author Ling
 * Created on 2019/9/6
 */
interface GenderDesc{
    void info();
}


public enum Gender implements GenderDesc{
    MALE("男"){
        public void info(){
            System.out.println("这赛季对男性化的描述。");
        }
    },
    FEMALE("女"){
        public void info(){
            System.out.println("这是对女性的描述。");
        }
    };
    private final String name;
    private Gender(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

    public static void main(String[] args) {
        Gender g = Enum.valueOf(Gender.class, "FEMALE");
        g.info();
    }
}
