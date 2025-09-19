import java.util.Scanner;

public class Main{
    static Teacher[] teachers = null;

    public static void main(String[] args) {
        while (true){
             showMenu();
        }
    }

    public static void showMenu(){

        System.out.println("Hansi Emeliyyati etmek isteyirsiniz? :");
        System.out.println("0.Muellimleri ilk defe yaratmaq 1.yenisini create etmek \n 2.Yenilemek(Update) \n 3.Silmek(delete) \n 4.axtarmaq \n 5.Hamisini goster");
        int action = new Scanner(System.in).nextInt();
        if (action == 0){
            teachers = initializeteachers();
        }else if (action == 1){
            teachers = initializenewteachers(teachers);
        }else if (action == 3) {
            deleteteacher(teachers);
        } else if (action == 5) {
            printallinfo(teachers);
        } else if (action == 4) {
            finder(teachers);
        } else if (action == 2) {
            updateTeacher(teachers);
        }
    }


    public static Teacher[] initializeteachers(){
        System.out.println("Nece nefer muellim haqqinda melumat daxil edilecek: ");
        int count = new Scanner(System.in).nextInt();
        Teacher[] teachers = new Teacher[count];

        for(int i = 0; i < count ; i++){
            System.out.println("Qeydiyyatin nomresi: " + (i +1));
            teachers[i] = requireandcreate();
        }
        printallinfo(teachers);
        return teachers;
    }

    public static Teacher[] initializenewteachers(Teacher[] oldTeacher){
        System.out.println("Nece eded muellim daxil edilecek");
        int additionalnumber = new Scanner(System.in).nextInt();
        Teacher[] teachers1 = new Teacher[oldTeacher.length + additionalnumber];
        for (int i = 0; i<oldTeacher.length; i++){
            teachers1[i] = oldTeacher[i];
        }
        for (int i = oldTeacher.length; i < oldTeacher.length + additionalnumber; i++){
            teachers1[i] = requireandcreate();
        }
        return teachers1;
    }

    public static void deleteteacher(Teacher[] teachers){
        System.out.println("Hansi nomreli muellimi silmek isteyirsiniz ? : ");
        int removableteacher = new Scanner(System.in).nextInt();
        teachers[removableteacher - 1] = null;
    }

    public static void printallinfo(Teacher[] teachers){
        System.out.println("Qeydiyyatdan kecen muellimler : ");
        for (int i = 0; i < teachers.length; i++){
            if (teachers[i] == null) {
                continue;
            }
            System.out.println( (i+1) + "." + teachers[i].getName() + " " + teachers[i].getSurname() + " " + teachers[i].getAge());
        }
    }

    public static void finder(Teacher[] teachers){
        Teacher teacher1 = new Teacher();
        System.out.println("Bir deyisenini daxil edin : ");
        String findbyfield = new Scanner(System.in).nextLine();
        for (int i = 0; i < teachers.length; i++) {
            if (teacher1 == null){
                continue;
            }
            if (findbyfield.equals(teachers[i].getName()) || findbyfield.equals(teachers[i].getSurname())) {
                System.out.println(teachers[i].getName() + " " + teachers[i].getSurname() + " " + teachers[i].getAge());
            }
        }
    }

    public static void updateTeacher(Teacher[] teachers){
        System.out.println("Hansi nomreli muellimde deyisiklik etmek isteyirsiniz? : ");
        int indexofteacher = new Scanner(System.in).nextInt();
        System.out.println("hansi deyisikliyi etmek isteyirsiniz \n 1.Ad \n 2.Soyad \n 3.Yas \n 4.Maas");
        String updatefields = new Scanner(System.in).nextLine();
        Teacher teacher2 = teachers[indexofteacher-1];
        if (updatefields.equals("Ad")){
            System.out.println("Muellime qoyulacaq yeni adi yazin: ");
            teacher2.setName(new Scanner(System.in).nextLine());
        } else if (updatefields.equals("Soyad")) {
            System.out.println("Muellime qoyulacaq yeni soyadi yazin: ");
            teacher2.setSurname(new Scanner(System.in).nextLine());
        } else if (updatefields.equals("Yas")) {
            System.out.println("Muellimin qoyulacaq yeni yasi yazin: ");
            teacher2.setAge(new Scanner(System.in).nextInt());
        } else if (updatefields.equals("Maas")) {
            System.out.println("Muellimin qoyulacaq yeni Maasi yazin: ");
            teacher2.setSalary(new Scanner(System.in).nextInt());
        }
    }

    public static Teacher requireandcreate(){
        Teacher teacher = new Teacher();

        System.out.println("Muellimin adini daxil edin: ");
        teacher.setName(new Scanner(System.in).nextLine());

        System.out.println("Muellimin soyadini daxil edin: ");
        teacher.setSurname(new Scanner(System.in).nextLine());

        System.out.println("Muellimin yasini daxil edin: ");
        teacher.setAge(new Scanner(System.in).nextInt());

        System.out.println("Muellimin maasini daxil edin: ");
        teacher.setSalary(new Scanner(System.in).nextInt());

        return teacher;
    }


}