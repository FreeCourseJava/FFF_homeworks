package tenth;

import java.util.Arrays;

public class SexDemo {
    public static void main(String[] args) {

        Sex genderArray = new Sex();
        SexEnum[] genderEnum;
        String[] genderString;

        genderString = genderArray.getGenders();
        genderEnum = SexEnum.values();

        System.out.println(Arrays.toString(genderString));
        System.out.println(Arrays.toString(genderEnum));

    }
}
